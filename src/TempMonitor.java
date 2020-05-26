import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TempMonitor extends Thread {

    public double getTempt() {
        ProcessBuilder pb = new ProcessBuilder();
        String re = "";
        try {
            re = new BufferedReader(
                    new InputStreamReader(
                            Runtime.getRuntime().exec("vcgencmd measure_temp").getInputStream()
                    )
            ).readLine();
        } catch (Exception e) {
            Display.errinfo("Unable to get the temperature at " + Display.getTimeNow());
        }

        if (re.length() == 0) return -1;
        return Double.parseDouble(
                re
                        .split("=")[1]
                        .split("'")[0]
        );
    }
}
