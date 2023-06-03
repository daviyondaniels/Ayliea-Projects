import java.util.Scanner;

public class UserSelection {
	static int numEnemyShips = 5;
	static char[] columns = { ' ', 'A', 'B', 'C', 'D', 'E' };
	static char[] rows = { ' ', '1', '2', '3', '4', '5' };

	static int[] guessEnemyShipsLoc(char[][] originalGameBoard, char[] columns, char[] rows) {
		Scanner scnr = new Scanner(System.in);

		char userNum;
		char userLetter;
		int[] userCoordinates = new int[2];

		// Prompts user to input a valid character for each field.
		System.out.print("\nEnter a row number: ");
		userNum = scnr.next().charAt(0);
		for (int r = 0; r <= rows.length - 1; ++r) {
			if (Character.isLetter(userNum)) {
				System.out.println("Input is not a number. Please enter a row number: ");

			} else if (userNum == rows[r] && r >= originalGameBoard.length) {
				System.out.println("Input too high. Please enter a row number: ");

			} else if (userNum == rows[r] && r <= 0) {
				System.out.println("Input too low. Please enter a row number: ");

			} else if (userNum == rows[r]) {
				userCoordinates[0] = r;
				System.out.print("\nEnter a column letter: ");
				userLetter = scnr.next().charAt(0);
				if (!Character.isLetter(userLetter) || (userLetter < 'A' || userLetter > 'I')) {
					System.out.println("Input is invalid. Please enter a column letter: ");

				} else if (userLetter >= 'a' && userLetter <= 'z') {
					System.out.println("Input is lowercase. Please enter uppercase letter: ");
				} else {
					for (int c = 0; c < columns.length; ++c) {
						if (columns[c] == userLetter) {
							userCoordinates[1] = c;

						}
					}
				}
			}
		}
		return userCoordinates;

	}

	// Determines if the user's coordinates hit one of computer's ships
	static char[][] userHitOrMiss(char[][] enemyShipsLoc, char[][] originalGameBoard, int rowGuess, int columnGuess) {

		char[][] updatedUserBoard = new char[originalGameBoard.length][originalGameBoard.length];

		Gameboard.copyGameBoard(originalGameBoard, updatedUserBoard);
		if (updatedUserBoard[rowGuess][columnGuess] == 'X' || updatedUserBoard[rowGuess][columnGuess] == 'O') {
			System.out.print("You've guessed these coordinates already.\n");
			StartTurn.startUserTurn(updatedUserBoard, enemyShipsLoc);

		} else if (enemyShipsLoc[rowGuess][columnGuess] == '-') {
			updatedUserBoard[rowGuess][columnGuess] = 'O';
			Gameboard.printGameBoard(updatedUserBoard);
			System.out.println("MISS!\n");
		} else if (enemyShipsLoc[rowGuess][columnGuess] == 'S') {
			updatedUserBoard[rowGuess][columnGuess] = 'X';
			Gameboard.printGameBoard(updatedUserBoard);
			System.out.print("HIT!\n");
			--numEnemyShips;
			System.out.println("Ships remaining: " + numEnemyShips);
			if (numEnemyShips == 0) {
				System.out.println("YOU WIN!\n" + "\nThanks for playing!");
				System.exit(0);
			}
		}

		return updatedUserBoard;
	}

}
