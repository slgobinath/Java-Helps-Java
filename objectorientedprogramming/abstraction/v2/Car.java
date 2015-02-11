/**
 * Car class is a subclass of Vehicle.
 *
 * @version 2.0
 * @author L.Gobinath
 */
public class Car extends Vehicle {
    /**
     * Car class is a non-abstract sub class of Vehicle.
     * Must override the drive method.
     */
    public void drive() {
        System.out.println("Use steering wheel");
    }
}