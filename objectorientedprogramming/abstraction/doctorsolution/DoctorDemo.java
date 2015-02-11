/**
 * Sample code used to explain Object Oriented Programming.
 * 1.0  -   The orginal source code.
 * 1.1  -   All the properties of Animals have been encapsulated.
 * 1.2  -   Inheritance is applied by introducing a super class Animal.
 * 1.3  -   The treatment logic has been moved to the Animals.
 * 1.4  -   Abstraction is applied to the Animal class and the treatment method.
 *
 * @version 1.4
 * @author L.Gobinath
 */
public class DoctorDemo {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        VeterinaryDoctor doctor = new VeterinaryDoctor();
        cat.setAge(4);
        dog.setAge(2);
        doctor.giveTreatment(cat);
        doctor.giveTreatment(dog);
    }
}

class VeterinaryDoctor {
    /**
     * Give treatment to any Animals.
     * @param animal The animal.
     */
    public void giveTreatment(Animal animal) {
        animal.treatment();
    }
}
/**
 * Super class Animal.
 * Animal is an abstract class.
 */
abstract class Animal {
    private int age;

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Abstract method.
     * Sub classes must override this method.
     */
    public abstract void treatment();
}

class Cat extends Animal {
    @Override
    public void treatment() {
        if (getAge() < 3) {
            System.out.println("Treatment C1");
        } else {
            System.out.println("Treatment C2");
        }
    }
}

class Dog extends Animal {
    @Override
    public void treatment() {
        if (getAge() < 5) {
            System.out.println("Treatment D1");
        } else {
            System.out.println("Treatment D2");
        }
    }
}