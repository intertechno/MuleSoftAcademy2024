import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class MyHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange t) throws IOException {

        Main.logger.info("MyHandler was called.");

        Date now = new Date();
        String response = now.toString();
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();

        Main.logger.info("MyHandler completed.");
    }
}
