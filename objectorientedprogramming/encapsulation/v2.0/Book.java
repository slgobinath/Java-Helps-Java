/**
 * Book class used to explain the encapsulation.
 *
 * @version 2.0
 * @author L.Gobinath
 */
public class Book {
    // Title of the book.
    private String title;
    // Author of the book.
    private String author;
    // Price of the book.
    private double price;

    /**
     * Get the title.
     * @return The title of the book.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Set the title.
     * @param title The title of the book.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the author of the book.
     * @return The author of the book.
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Set the author of the book.
     * @param author The author of the book.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Set the price.
     * @param price Price of the book.
     */
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Invalid price");
        }
    }

    /**
     * Get the price.
     * @return Price of the book.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Print the total amount for given quantity.
     * @param qty The quantity
     */
    public void sell(int qty) {
        System.out.println("Total: $" + (qty * price));
    }
}