package SingletonDesignPattern;

public class Logger {
    //private static instance
    private static Logger instance;

    //private constructor
    private Logger() {}

    public static Logger getInstance() {
        //lazy initialization
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
