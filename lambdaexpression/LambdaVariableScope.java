public class LambdaVariableScope {
	public static void main(String[] args) {
		String name = "Java Helps";
		Thread validLambda = new Thread(() -> System.out.println(name));
		/*Thread invalidLambda = new Thread(() -> {
			name = "Something else";	// Cannot change the value
			System.out.println(name);
		});*/
		validLambda.start();
	}
}