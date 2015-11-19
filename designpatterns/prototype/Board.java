public class Board implements Cloneable {
	public static final int NO_OF_ROWS = 8;
	public static final int NO_OF_COLUMNS = 8;

	private final Cell[][] board;

	public Board() {
		this.board = new Cell[NO_OF_ROWS][NO_OF_COLUMNS];

		for (int row = NO_OF_ROWS - 1; row >= 0; row--) {
			for (int col = NO_OF_COLUMNS - 1; col >= 0; col--) {
				if ((row + col) % 2 == 0) {
					board[row][col] = new Cell("WHITE");
				} else {
					board[row][col] = new Cell("BLACK");
				}
			}
		}
	}

	public void print() {
		for (int row = 0; row < NO_OF_ROWS; row++) {
			for (int col = 0; col < NO_OF_COLUMNS; col++) {
				System.out.print(board[row][col] + " ");
			}
			System.out.println();
		}
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
