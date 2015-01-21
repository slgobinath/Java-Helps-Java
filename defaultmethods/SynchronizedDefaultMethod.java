public interface SynchronizedDefaultMethod {
	/*
	* Compile time error.
	* synchronized and default cannot be used together.
	*/
	public synchronized default void print() {
		System.out.println("Hello world");
	}
}