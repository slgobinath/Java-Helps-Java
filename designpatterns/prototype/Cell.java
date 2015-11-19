public class Cell implements Cloneable {
	private String color;

	public Cell(String color) {
		this.color = color;

		// Make it time consuming task.
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return color.substring(0, 1);
	}

	@Override
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
