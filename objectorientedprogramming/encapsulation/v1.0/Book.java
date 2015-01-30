/**
 * Book class used to explain the encapsulation.
 *
 * @version 1.0
 * @author L.Gobinath
 */
public class Book {
    // Title of the book.
    String title;
    // Author of the book.
    String author;
    // Price of the book.
    double price;

    /**
     * Print the total amount for given quantity.
     * @param qty The quantity
     */
    public void sell(int qty) {
        System.out.println("Total: $" + (qty * price));
    }
}