/**
 * Testing class for Book class.
 *
 * @version 1.2
 * @author L.Gobinath
 */
public class BookShop {
	public static void main(String[] args) {
		Book book = new Book();
		book.title = "Hamlet";
		book.author = "William Shakespeare";
		book.setPrice(-5.95);	// Error message
		book.setPrice(5.95);

		System.out.println("Title: " + book.title);
		// System.out.println("Price: $" + book.price);
		System.out.println("Price: $" + book.getPrice());
		book.sell(2);
	}
}