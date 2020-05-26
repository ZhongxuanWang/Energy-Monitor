
public class Main{

//    Don't forget to not leave this variable blank otherwise you won't be able to receive email notifications
    public static final String deviceName = "My Pi";
    public static final String email_address = "cndanielwang@gmail.com";

    public static void main(String[] args) {
        Display.inf("Welcome to eMonitor! System is deploying and it will display a message when it's ready.");

        Display.inf("Deploying CPU Temperature Monitor...");
        CPUMonitor tm = new CPUMonitor();

        Display.inf("Deploying Memory Monitor...");
        MemMonitor mm = new MemMonitor();
        Display.inf(mm.getUsage());

//        sendEmail("eMonitor Deployment ready at " + Display.getTimeNow());
    }

    public static void sendEmail(String con) {
        Email email = new Email(email_address);
        if (!email.send("A Message from eMonitor on your device " + deviceName, con)) {
            Display.warninfo("You email didn't send successfully. Content: " + con);
        } else {
            Display.inf("An Email Sent. Content: " + con);
        }
    }
}