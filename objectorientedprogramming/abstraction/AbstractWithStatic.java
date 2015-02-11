/**
 * static and abstract cannot be used together.
 * WARNING:
 *      Compile time error due to static abstract method.
 *
 * @author L.Gobinath
 */
public abstract class AbstractWithStatic {
    public static abstract void doStuff();
}