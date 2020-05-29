
public class Main{

//    Don't forget to not leave this variable blank otherwise you won't be able to receive email notifications
    public static final String deviceName = "My Pi";
    public static final String email_address = "cndanielwang@gmail.com";

    public static void main(String[] args) {
        Display.inf("Welcome to eMonitor! System is deploying and it will display a message when it's ready.");

        CPUMonitor tm = new CPUMonitor();
        Display.inf("Deployed CPU Temperature Monitor. Temp now: " + tm.getTempt());

        MemMonitor mm = new MemMonitor();
        Display.inf("Deployed Memory Monitor...");

        Display.inf(mm.getUsage());

        DiskMonitor dm = new DiskMonitor();
        Display.inf("Deployed Disk Monitor...");
        Display.inf(dm.getUsage());

        sendEmail("eMonitor Deployment ready at " + Display.getTimeNow()
                + " and at system " + System.getProperty("os.name"));
    }
//FIXME UNABLE TO SEND EMAIL FOR NO REASONS NOW. I have changed mailgun api in email.java. check txt record in host
//    records to see if the previous record has been removed (accidentally)
    public static void sendEmail(String con) {
        Email email = new Email(email_address);
        if (!email.send("A Message from eMonitor on your device " + deviceName, con)) {
            Display.warninfo("Your email didn't send successfully. Content: " + con);
        } else {
            Display.inf("An Email Sent. Content: " + con);
        }
    }
}