public class DiamondSolutionTwo {
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

class P {
	public void print() {
		System.out.println("P");
	}
}

/*
* Super class provides the implementation of print() method
*/
class D extends P implements B, C {
	
}