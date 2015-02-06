public interface NonPublicDefaultMethod {
	/*
	* Compile time error.
	* Default method must be public.
	*/
	protected default void print() {
		System.out.println("Hello world");
	}

	/**
	 * No error.
	 * Default methods are implicitly public.
	 */
	default void doStuff() {
		System.out.println("Default method");
	}
}