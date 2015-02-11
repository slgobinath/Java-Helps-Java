/**
 * private and abstract cannot be used together.
 * WARNING:
 *      Compile time error due to private abstract method.
 *
 * @author L.Gobinath
 */
public abstract class AbstractWithPrivate {
    private abstract void doStuff();
}