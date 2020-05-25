import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Email {
    private final String email;
    private final String psw;
    private final String smtp;

    public Email(String email_address, String password, String smtp_server) {
        this.email = email_address;
        this.psw = password;
        this.smtp = smtp_server;
    }

    public boolean send() {
        String to = "sonoojaiswal1988@gmail.com";//change accordingly
        String from = "sonoojaiswal1987@gmail.com";
        String host = "localhost";

        //Get the session object
        Properties properties = System.getProperties();
        properties.setProperty(smtp, host);

        Session session = Session.getDefaultInstance(properties);

        //compose the message
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
            message.setSubject("Ping");
            message.setText("Hello, this is example of sending email  ");
            Transport.send(message);
            System.out.println("Message sent successfully.");
        }catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }
        return true;
    }
}
