/**
 * Sample code used to explain Object Oriented Programming.
 * Version History:
 * 1.0  -   The orginal source code.
 * 1.1  -   All the properties of Animals have been encapsulated.
 *
 * @version 1.1
 * @author L.Gobinath
 */
public class DoctorDemo {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        VeterinaryDoctor doctor = new VeterinaryDoctor();
        cat.setAge(4);
        dog.setAge(2);
        doctor.treatCat(cat);
        doctor.treatDog(dog);
    }
}

class VeterinaryDoctor {
    /**
     * Give treatment to a cat.
     * @param cat The cat.
     */
    public void treatCat(Cat cat) {
        if (cat.getAge() < 3) { // Changed to getAge()
            System.out.println("Treatment C1");
        } else {
            System.out.println("Treatment C2");
        }
    }

    /**
     * Give treatment to a dog.
     * @param dog The dog.
     */
    public void treatDog(Dog dog) {
        if (dog.getAge() < 5) { // Changed to getAge()
            System.out.println("Treatment D1");
        } else {
            System.out.println("Treatment D2");
        }
    }
}

/**
 * Encapsulated Cat.
 */
class Cat {
    private int age;

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

/**
 * Encapsulated Dog.
 */
class Dog {
    private int age;

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}