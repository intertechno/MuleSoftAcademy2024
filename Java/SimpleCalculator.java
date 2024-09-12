import java.util.Scanner;

public class SimpleCalculator {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the first number:");
        int num1 = scanner.nextInt();

        System.out.println("Please enter the second number:");
        int num2 = scanner.nextInt();
        scanner.nextLine();

        // System.out.println(num1);
        // System.out.println(num2);

        System.out.println("Please enter the operation (+, -, *, /):");
        String mathOperation = scanner.nextLine();
        scanner.close();

        float result = 0;

        switch (mathOperation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = (float) num1 / num2;
                break;
            default:
                System.out.println("Invalid operation!");
                break;
        }

        System.out.println("Result: " + result);        
    }
}
