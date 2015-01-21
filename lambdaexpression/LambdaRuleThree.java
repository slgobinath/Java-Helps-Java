public class LambdaRuleThree {
	public static void main(String[] args) {
		Printable printable = () -> {System.out.println("Hello world");};
		doStuff(printable);
	}

	private static void doStuff(Printable printer) {
		printer.print();
	}
}

interface Printable {
	public void print();
}