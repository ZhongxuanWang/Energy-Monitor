public class Display {
    public static void inf(Object s) {
        System.out.println("\033[0;32m" + "[ OK ] " + "\033[0m" + s);
    }

    public static void errinfo(Object s) {
        System.out.println("\033[0;31m" + "[ERROR] " + "\033[0m" + s);
    }

    public static void warninfo(Object s) {
        System.out.println("\033[0;33m" + "[WARNING] " + "\033[0m" + s);
    }

    public static String getTimeNow() {
        return java.time.format.DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
                .format(java.time.LocalDateTime.now());
    }
}
