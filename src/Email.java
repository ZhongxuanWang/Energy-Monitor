import java.io.File;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class Email {
    private final String smtp_server = "in-v3.mailjet.com";
    private final String add;

    public Email(String add) {
        this.add = add;
    }

    public boolean send(String subject, String content) {
        try {
            return sendSimpleMessage(subject, content).toString().contains("Thank you.");
        } catch (UnirestException e) {
            return false;
        }
    }

    /**     Here I used mailgun API to send emails. However,
     *      the delay is sometimes very big. To ensure your
     *      devices are OK, please consider using other ways. PLEASE CHECK YOUR PROMOTION/SPAM/UPDATE FOLDER!!!!!! */

    private JsonNode sendSimpleMessage(String subject, String content) throws UnirestException {

        String YOUR_DOMAIN_NAME = "mail.dlearninglab.com";
        String API_KEY = "b2f4ca60d3cfe7c678312870317e3b08-7fba8a4e-ef956365";

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