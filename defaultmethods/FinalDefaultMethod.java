public interface FinalDefaultMethod {
	/*
	* Compile time error.
	* final and default cannot be used together.
	*/
	public final default void print() {
		System.out.println("Hello world");
	}
}