import java.util.logging.*;

public class LoggingDemo {
    
    private static Logger logger = Logger.getLogger("my-demo-logger");

    public static void main(String[] args) {

        System.out.println("Starting the logging demo.");

        try {
            Handler fh = new FileHandler("LoggingDemo.log");
            logger.addHandler(fh);
            logger.info("Hello, log!");
        }
        catch (Exception ex) {
            logger.severe(ex.getMessage());
        }
    }
}
