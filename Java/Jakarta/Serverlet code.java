import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class NumberArray {
    private int[] numbers;

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
}


@WebServlet("/parseNumbers")
public class JsonParsingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the content type of the response
        response.setContentType("application/json");

        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Parse the JSON from the request body into a NumberArray object
        NumberArray numberArray = objectMapper.readValue(request.getInputStream(), NumberArray.class);

        // Process the numbers as needed
        int[] numbers = numberArray.getNumbers();

        // Example: Calculate the sum of the numbers
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        // Respond with the result
        response.getWriter().write("{\"sum\": " + sum + "}");
    }
}
