
public class Main {

	public static void main(String[] args) {
		// Get the start time
		long startTime = System.currentTimeMillis();

		Board chessBoard = new Board();

		// Get the end time
		long endTime = System.currentTimeMillis();

		System.out.println("Time taken to create a board: " + (endTime - startTime) + " millis");

		// Print the board
		chessBoard.print();

		System.out.println();

		// Get the start time
		startTime = System.currentTimeMillis();

		Board checkersBoard = (Board) chessBoard.clone();

		// Get the end time
		endTime = System.currentTimeMillis();

		System.out.println("Time taken to clone a board: " + (endTime - startTime) + " millis");

		checkersBoard.print();
	}

}
