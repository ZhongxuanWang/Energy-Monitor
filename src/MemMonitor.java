public class MemMonitor implements Monitor {

    @Override
    public double getUsage() {
        String op = Display.getTerminalOutput("free -ht");
        if (op.length() == 0) {
            return ERROR_CODE;
        } else {
            Display.inf(op);
            return 0.0;
        }
    }
}
