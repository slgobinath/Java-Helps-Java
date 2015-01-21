public class LambdaRuleOne {
	public static void main(String[] args) {
		Printable printable = (String x, int y) -> {
			for(int i = 1; i <= y; i++) {
				System.out.println(x);
			}
		};
		doStuff(printable);
	}

	private static void doStuff(Printable printer) {
		printer.print("Hello", 5);
	}
}

interface Printable {
	public void print(String msg, int count);
}