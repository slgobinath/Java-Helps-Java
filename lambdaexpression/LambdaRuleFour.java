public class LambdaRuleFour {
	public static void main(String[] args) {
		Printable printable = x -> {System.out.println(x);};
		doStuff(printable);
	}

	private static void doStuff(Printable printer) {
		printer.print("Hello");
	}
}

interface Printable {
	public void print(String msg);
}