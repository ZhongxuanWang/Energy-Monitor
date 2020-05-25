import javax.swing.*;

public class Main {

//    Don't forget to not leave this variable blank otherwise you won't be able to receive email notifications
    public static final String deviceName = "My Pi";
    public static final String email_address = "cndanielwang@gmail.com";

    public static void main(String[] args) {
        Display.inf("Welcome to eMonitor! System is deploying and it will display a message when it's ready.");

        sendEmail("eMonitor Deployment ready at " + java.time.format.DateTimeFormatter.ofPattern("yyyy/MM/dd " +
                "HH:mm:ss").format(java.time.LocalDateTime.now()));
    }

    public static void sendEmail(String con) {
        Email email = new Email(email_address);
        if (!email.send("A Message from eMonitor on your device " + deviceName, con)) {
            Display.errinfo("Error while sending the message.");
        } else {
            Display.inf("Email Sent. Content:" + con);
        }
    }
}