import java.net.InetSocketAddress;
import java.util.logging.*;
import com.sun.net.httpserver.HttpServer;

public class Main {

    public static Logger logger = Logger.getLogger("webserver-main");

    public static void main(String[] args) {

        try {
            Handler fh = new FileHandler("HTTP-Server.log");
            fh.setLevel(Level.ALL);
            logger.addHandler(fh);
            logger.setLevel(Level.ALL);
            logger.info("Starting the HTTP web server demo.");
        }
        catch (Exception ex) {
            logger.severe(ex.getMessage());
        }

        try {
            HttpServer server = HttpServer.create(
                    new InetSocketAddress(8000), 0);
            server.createContext("/datetime", new MyHandler());
            server.setExecutor(null); // creates a default executor
            logger.info("About to start the HTTP server.");
            server.start();
        } catch (Exception ex) {
            logger.severe("Could not start the HTTP server.");
        }
    }
}
