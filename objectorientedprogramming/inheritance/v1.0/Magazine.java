/**
 * Magazine class used to explain the inheritance.
 *
 * @version 1.0
 * @author L.Gobinath
 */
public class Magazine {
    // Title of the magazine.
    private String title;
    // Author of the magazine.
    private String issue;
    // Price of the magazine.
    private double price;

    /**
     * Get the title.
     * @return The title of the magazine.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Set the title.
     * @param title The title of the magazine.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the issue of the magazine.
     * @return The issue of the magazine.
     */
    public String getIssue() {
        return this.issue;
    }

    /**
     * Set the issue of the magazine.
     * @param issue The issue of the magazine.
     */
    public void setIssue(String issue) {
        this.issue = issue;
    }

    /**
     * Set the price.
     * @param price Price of the magazine.
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
     * @return Price of the magazine.
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