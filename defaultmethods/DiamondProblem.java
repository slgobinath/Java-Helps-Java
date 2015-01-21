public class DiamondProblem {
	public static void main(String[] args) {
		A obj = new D();
		obj.print();
	}
}

interface A {
	default void print() {
		System.out.println("A");
	}
}

interface B extends A {
	default void print() {
		System.out.println("B");
	}
}

interface C extends A {
	default void print() {
		System.out.println("C");
	}
}
/*
* Compile time error.
* Diamond problem since there is a clash in the print() methods.
*/
class D implements B, C {

}