public class DefaultInClass {
	/*
	* Compile time error.
	* Cannot have default method inside a class.
	*/
	default void doStuff() {
		System.out.println("Hello world");
	}
}