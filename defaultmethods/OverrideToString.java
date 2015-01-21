public interface OverrideToString {
	/*
	* Compile time error.
	* Cannot override any methods of java.lang.Object class.
	*/
	public default String toString() {
		return "Hello";
	}
}