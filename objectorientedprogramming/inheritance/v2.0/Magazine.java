/**
 * Magazine class used to explain the inheritance.
 * Magazine is a sub class of Publication.
 * 
 * @version 2.0
 * @author L.Gobinath
 */
public class Magazine extends Publication {
    // Author of the magazine.
    private String issue;

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
}