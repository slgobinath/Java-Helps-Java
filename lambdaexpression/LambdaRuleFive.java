public class LambdaRuleFive {
	public static void main(String[] args) {
		Printable printable = (x, y) -> System.out.println(x + " : " + y);
		doStuff(printable);
	}

	private static void doStuff(Printable printer) {
		printer.print("Hello", 5);
	}
}

interface Printable {
	public void print(String msg, int count);
}