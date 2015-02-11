/**
 * Testing class for Vehicle class.
 *
 * @version 2.0
 * @author L.Gobinath
 */
public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle motorbike = new Motorbike();
        doDrive(car);   // Use steering wheel
        doDrive(motorbike); // Use handlebars
    }

    public static void doDrive(Vehicle vehicle) {
        vehicle.drive();
    }
}