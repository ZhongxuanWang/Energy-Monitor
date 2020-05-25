

public class Main {

//    Don't forget to not leave this variable blank otherwise you won't be able to receive email notifications
    public static final String deviceName = "My Pi";
    public static final String email_address = "cndanielwang@gmail.com";

    public static void main(String[] args) {
        Display.inf("Welcome to eMonitor! System is deploying and it will display a message when it's ready.");
    }

    public static void sendEmail(String sub, String con) {
        Email email = new Email(email_address);
        if (!email.send("A Message from eMonitor on your device" + deviceName, con)) {
            Display.errinfo("Error while sending the message.");
        }
    }
}