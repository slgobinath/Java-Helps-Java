/**
 * Book class used to explain the encapsulation.
 * 
 * @version 1.2
 * @author L.Gobinath
 */
public class Book {
    // Title of the book.
    String title;
    // Author of the book.
    String author;
    // Price of the book.
    private double price;

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