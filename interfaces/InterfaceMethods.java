/**
 * An interface can have default methods and static methods.
 * Any other methods are public and abstract by default.
 *
 * @author L.Gobinath
 */
public class InterfaceMethods {
    public static void main(String[] args) {
        Super obj = new Base();
        obj.print();
        obj.doStuff();
        Super.sayHello();
    }
}

interface Super {
    /**
     * An abstract method. By default it is public and abstract.
     */
    void print();

public default void doStuff() {
        System.out.println("Hello world");
    }

    public static void sayHello() {
        System.out.println("Hello");
    }
}

class Base implements Super {
    /**
     * Override the abstract method.
     */
    @Override
    public void print() {
        System.out.println("Base");
    }
}