/**
 * Publication super class used to explain the inheritance.
 * 
 * @version 2.0
 * @author L.Gobinath
 */
public class Publication {
    // Title of the publication.
    private String title;
    // Price of the publication.
    private double price;

    /**
     * Get the title.
     * @return The title of the publication.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Set the title.
     * @param title The title of the publication.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set the price.
     * @param price Price of the publication.
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
     * @return Price of the publication.
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