/**
 * Testing class for Book class.
 *
 * @version 1.0
 * @author L.Gobinath
 */
public class BookShop {
    public static void main(String[] args) {
        Book book = new Book();
        book.setTitle("Hamlet");
        book.setAuthor("William Shakespeare");
        book.setPrice(5.95);

        Magazine magazine = new Magazine();
        magazine.setTitle("TIME");
        magazine.setIssue("Feb. 2, 2015");
        magazine.setPrice(0.58);

        book.sell(2);
        magazine.sell(52);
    }
}