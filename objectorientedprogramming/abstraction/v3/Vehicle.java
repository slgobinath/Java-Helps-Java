/**
 * Sample abstract Vehicle class with a constructor.
 *
 * @version 2.0
 * @author L.Gobinath
 */
public abstract class Vehicle {
    private int noOfWheels;

    /**
     * Abstract class can have constructor.
     * @param  noOfWheels Number of wheels of this Vehicle
     */
    public Vehicle(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }

    /**
     * Implementation of drive method is unknown for Vehicle.
     * Notice that the method is terminated with a semicolon.
     */
    public abstract void drive();
}