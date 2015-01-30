/**
 * Sample code used to explain Object Oriented Programming.
 *
 * @version 1.0
 * @author L.Gobinath
 */
public class DoctorDemo {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        VeterinaryDoctor doctor = new VeterinaryDoctor();
        cat.age = 4;
        dog.age = 2;
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
        if (cat.age < 3) {
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
        if (dog.age < 5) {
            System.out.println("Treatment D1");
        } else {
            System.out.println("Treatment D2");
        }
    }
}

class Cat {
    int age;
}

class Dog {
    int age;
}