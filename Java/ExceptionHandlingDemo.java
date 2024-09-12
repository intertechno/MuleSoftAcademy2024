import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingDemo {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the first number:");
            float num1 = scanner.nextFloat();

            System.out.println("Please enter the second number:");
            float num2 = scanner.nextFloat();
            scanner.nextLine();

            if (num2 == 0) {
                throw new ArithmeticException("Division by zero.");
            }

            float result = num1 / num2;

            System.out.println("Result: " + result);
            scanner.close();
        } catch (InputMismatchException iex) {
            System.out.println("Invalid input, please enter valid numbers!");
        } catch (ArithmeticException aex) {
            System.out.println("Calculation error!");
        } catch (Exception ex) {
            System.out.println("Generic exception!");
        }
    }
}
