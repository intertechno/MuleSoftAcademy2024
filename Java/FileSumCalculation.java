import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

public class FileSumCalculation {

    public static void main(String[] args) {

        int totalSum = 0;
        try {
            Path filePath = Paths.get("Numbers.txt");
            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                // System.out.println(line);
                totalSum += Integer.parseInt(line);
            }
        } catch (Exception ex) {
            System.out.println("Error occurred: " + ex.getMessage());
        }

        System.out.println("File sum: " + totalSum);

        // write the results to the file
        try {
            FileWriter myWriter = new FileWriter("Result.txt");
            String text = new Integer(totalSum).toString();
            myWriter.write(text);
            myWriter.close();
            System.out.println("Successfully wrote the result to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the result file.");
        }
    }
}
