public interface StaticDefaultMethod {
	/*
	* Compile time error.
	* static and default cannot be used together.
	*/
	public static default void print() {
		System.out.println("Hello world");
	}
}