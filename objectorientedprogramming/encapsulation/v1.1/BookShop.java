/**
 * Testing class for Book class.
 *
 * @version 1.1
 * @author L.Gobinath
 */
public class BookShop {
	public static void main(String[] args) {
		Book book = new Book();
		book.title = "Hamlet";
		book.author = "William Shakespeare";
		// Still directly assigning the value.
		// I am a rule breaker.
		book.price = -5.95;

		System.out.println("Title: " + book.title);
		System.out.println("Price: $" + book.price);
		book.sell(2);
	}
}