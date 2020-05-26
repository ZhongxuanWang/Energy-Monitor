import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Display {
    public static void inf(Object s) {
        System.out.println("\033[0;32m" + "[ OK ] " + "\033[0m" + s);
    }

    public static void errinfo(Object s) {
        System.out.println("\033[0;31m" + "[ERROR] " + s + "\033[0m");
    }

    public static void warninfo(Object s) {
        System.out.println("\033[0;33m" + "[WARNING] " + "\033[0m" + s);
    }

    public static String getTimeNow() {
        return java.time.format.DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
                .format(java.time.LocalDateTime.now());
    }

    public static String getTerminalOutput(String com) {
        String re = "";
        try {
            re = new BufferedReader(
                    new InputStreamReader(
                            Runtime.getRuntime().exec(com).getInputStream()
                    )
            ).readLine();
            if (re.length() == 0) throw new Exception();
        } catch (Exception e) {
            Display.errinfo("Unable to get command output at " + Display.getTimeNow() + ". Content: " + com);
        }
        return re;
    }
}
