public class Display {
    public static void inf(String s) {
        synchronized (Display.class) {
            System.out.println("\033[0;32m" + "[ OK ] " + "\033[0m" + s);
        }
    }

    public static void errinfo(String s) {
        System.out.println("\033[0;31m" + "[ERROR] " + "\033[0m" + s);
    }

    public static void warninfo(String s) {
        System.out.println("\033[0;33m" + "[WARNING] " + "\033[0m" + s);
    }

}
