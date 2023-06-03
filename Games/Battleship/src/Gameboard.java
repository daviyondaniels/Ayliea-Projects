public class Gameboard {

	// Creates an copy of game board
	public static void copyGameBoard(char[][] array1, char[][] array2) {
		for (int r = 0; r < array1.length; ++r) {
			for (int c = 0; c < array1.length; ++c) {
				array2[r][c] = array1[r][c];
			}
		}
	}

	// Prints desired game board
	static void printGameBoard(char[][] gameBoard) {
		for (int r = 0; r < gameBoard.length; r++) {
			for (int c = 0; c < gameBoard.length; c++) {
				System.out.print(gameBoard[r][c] + " ");
			}
			System.out.println();
		}
	}

	// Creates the Battleship game board
	public static char[][] startUserGameBoard(int gameboardLength, char water, char[] rows, char[] columns) {
		int r;
		int c;

		// 10th row and column omitted because the two integers of 10 displace the game
		// board.

		char[][] gameBoard = new char[gameboardLength][gameboardLength];

		for (r = 0; r < gameBoard.length; r++) {
			for (c = 0; c < gameBoard.length; c++) {
				if (r == 0) {
					gameBoard[r][c] = columns[c];
				} else if (c == 0) {
					gameBoard[r][c] = rows[r];
				} else {
					gameBoard[r][c] = '-';
				}
			}
		}

		return gameBoard;

	}
}
