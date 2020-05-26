public class CPUMonitor extends Thread implements Monitor {

    @Override
    public double getUsage() {
        return ERROR_CODE;
    }

    public double getTempt() {
        String re = Display.getTerminalOutput("vcgencmd measure_temp");

        if (re.length() == 0) return ERROR_CODE;
        return Double.parseDouble(
                re
                        .split("=")[1]
                        .split("'")[0]
        );
    }
}
