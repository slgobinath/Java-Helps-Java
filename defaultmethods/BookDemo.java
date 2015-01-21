import java.util.*;

public class BookDemo {
    public static void main(String[] args) {
        Book book = new Book();
        book.add(new Chapter("Chapter 1"));
        book.add(new Chapter("Chapter 2"));
        book.add(new Chapter("Chapter 3"));
        for(Chapter ch : book) {
            System.out.println(ch);
        }
    }
}

class Book implements Iterable<Chapter> {
    private List<Chapter> chapters = new ArrayList<>();

    public void add(Chapter chapter) {
        this.chapters.add(chapter);
    }

    @Override
    public Iterator<Chapter> iterator() {
        return chapters.iterator();
    }
}

class Chapter {
    private String title;

    public Chapter(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}