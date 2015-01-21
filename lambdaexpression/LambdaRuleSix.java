public class LambdaRuleSix {
	public static void main(String[] args) {
		TaxCalculator calculator = x -> x * 0.02;
		doStuff(calculator);
	}

	private static void doStuff(TaxCalculator calc) {
		double tax = calc.calculate(100.00);
		System.out.println("TAX: " + tax);
	}
}

interface TaxCalculator {
	public double calculate(double amount);
}