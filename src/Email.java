import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class Email {
    private final String add;

    public Email(String add) {
        this.add = add;
    }

    /**
     * Send email
     * @param subject the subject of the email
     * @param content the content of the email
     * @return whether the email sent
     */
    public boolean send(String subject, String content) {
        try {
            return sendSimpleMessage(subject, content).toString().contains("Thank you.");
        } catch (UnirestException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**     Here I used mailgun API to send emails. However,
     *      the delay is sometimes very big. To ensure your
     *      devices are OK, please consider using other ways. PLEASE CHECK YOUR PROMOTION/SPAM/UPDATE FOLDER!!!!!! */

    private JsonNode sendSimpleMessage(String subject, String content) throws UnirestException {

        String YOUR_DOMAIN_NAME = "mail.dlearninglab.com";
        String API_KEY = "";

        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + YOUR_DOMAIN_NAME + "/messages")
			.basicAuth("api", API_KEY)
                .queryString("from", "eMonitor@example.com")
                .queryString("to", add)
                .queryString("subject", subject)
                .queryString("text", content)
                .asJson();
        return request.getBody();
    }
}