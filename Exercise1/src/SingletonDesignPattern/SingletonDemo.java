package SingletonDesignPattern;

public class SingletonDemo {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("User logged in.");
        logger2.log("Data saved successfully.");

        System.out.println("Are both loggers same? " + (logger1 == logger2));
    }
}
