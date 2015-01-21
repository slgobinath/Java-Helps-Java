public interface DefaultWithoutBody {
	/*
	* Compile time error.
	* No method body for the default method.
	*/
	default void doStuff();
}