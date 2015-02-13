/**
 * OOP supports multiple inheritance, but Java supports through interfaces only.
 * This code is an example of multiple inheritance.
 *
 * @author L.Gobinath
 */
public class MultipleInheritance {
    public static void main(String[] args) {
        Bat bat = new Bat();
        doFly(bat);
        doFeed(bat);
    }

    public static void doFly(WingedAnimal ani) {
        ani.flap();
    }

    public static void doFeed(Mammal ani) {
        ani.breastFeed();
    }
}

interface Animal {
    void eat();
}

interface Mammal extends Animal {
    void breastFeed();
}

interface WingedAnimal extends Animal {
    void flap();
}

/**
 * Multiple inheritance:
 * Bat implements both Mammal and WingedAnimal.
 */
class Bat implements Mammal, WingedAnimal {
    @Override
    public void eat() {
        System.out.println("Eating");
    }

    @Override
    public void breastFeed() {
        System.out.println("Feeding");
    }

    @Override
    public void flap() {
        System.out.println("Flying");
    }
}