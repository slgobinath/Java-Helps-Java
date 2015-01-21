public class DiamondSolutionOne {
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
* The overridden method will get selected
*/
class D implements B, C {
	@Override
	public void print() {
		System.out.println("D");
	}
}