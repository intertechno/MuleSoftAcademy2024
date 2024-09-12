public class DivisionDemo {
    
    public static void main(String[] args) {

        // integers
        int a = 100;
        int b = 3;
        int result = a / b;

        // floats
        float a2 = 100;
        float b2 = 3;
        float result2 = a2 / b2;
        
        System.out.println(result);
        System.out.println(result2);

        // integers, with float division
        int a3 = 100;
        int b3 = 3;
        float result3 = (float) a3 / b3;
        System.out.println(result3);
    }
}
