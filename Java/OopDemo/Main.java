public class Main {

    public static void main(String[] args) {

        System.out.println("Starting the OOP demo.");

        Car myCar = new Car();
        myCar.make = "Toyota";
        myCar.model = "Corolla";
        myCar.topSpeed = 180;

        try {
            myCar.accelerate();
            myCar.accelerate();
            myCar.accelerate();
            System.out.println(myCar.getCurrentSpeed());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // myCar.decelerate();
        // myCar.decelerate();
        // myCar.decelerate();
        // myCar.stopEngine();
        // System.out.println(myCar.getCurrentSpeed());
        // myCar.currentSpeed = -100;

        // Car otherCar = new Car();
        // otherCar.make = "Ford";
        // otherCar.model = "Mustang";
        // otherCar.startEngine();
        // otherCar.accelerate();
    }
}
