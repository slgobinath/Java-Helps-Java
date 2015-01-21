public class OverrideDemo {
	public static void main(String[] args) {
		Note note = new Note("Hello world");
		note.read();
	}
}

interface Readable {
	default void read() {
		System.out.println("Read");
	}
}


class Note implements Readable {
	private String content;

	public Note(String content) {
		this.content = content;
	}

	@Override
	public void read() {
		System.out.println(content);
	}
}