public class Car {

    // fields
    public String make;
    public String model;
    public int topSpeed;

    private boolean engineRunning;
    private int currentSpeed;

    // methods
    public void startEngine() {
        engineRunning = true;
    }

    public void stopEngine() {
        engineRunning = false;
    }

    public void accelerate() throws Exception {
        if (engineRunning) {
            currentSpeed += 10;

            if (currentSpeed > topSpeed) {
                currentSpeed = topSpeed;
            }
        }
        else {
            // System.out.println("Cannot accelerate if the "+
            //     "engine is not running. Please call the startEngine() method.");
            throw new Exception("Cannot accelerate if the "+
                "engine is not running. Please call the startEngine() method.");
        }
    }

    public void decelerate() {
        currentSpeed -= 10;

        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }
}
