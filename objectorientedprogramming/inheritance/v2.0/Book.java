/**
 * Book class used to explain the encapsulation.
 * Book is a sub class of Publication.
 * 
 * @version 2.0
 * @author L.Gobinath
 */
public class Book extends Publication {
    // Author of the book.
    private String author;

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
}