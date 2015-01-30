/**
 * Testing class for Book class.
 *
 * @version 2.0
 * @author L.Gobinath
 */
public class BookShop {
    public static void main(String[] args) {
        Book book = new Book();
        book.setTitle("Hamlet");
        book.setAuthor("William Shakespeare");
        book.setPrice(5.95);

        System.out.println("Title: " + book.getTitle());
        System.out.println("Price: $" + book.getPrice());
        book.sell(2);
    }
}