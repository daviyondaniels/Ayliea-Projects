import java.util.Random;

public class EnemySelection {
	static int numUserShips = 5;

	// Prompts computer to input random coordinates
	static int[] guessUserShipsLoc() {
		Random random = new Random();
		int rowGuess;
		int columnGuess;

		int[] enemyCoordinates = new int[2];

		rowGuess = random.nextInt(5) + 1;
		columnGuess = random.nextInt(5) + 1;
		enemyCoordinates[0] = rowGuess;
		enemyCoordinates[1] = columnGuess;
		return enemyCoordinates;

	}

	// Determines if the computer's coordinates hit one of user's ships
	static char[][] enemyHitOrMiss(char[][] userShipsLoc, char[][] originalGameBoard, int randRow, int randColumn) {
		char[][] updatedEnemyBoard = new char[originalGameBoard.length][originalGameBoard.length];

		Gameboard.copyGameBoard(originalGameBoard, updatedEnemyBoard);

		if (userShipsLoc[randRow][randColumn] == 'X' || userShipsLoc[randRow][randColumn] == 'O') {

		} else if (userShipsLoc[randRow][randColumn] == '-') {
			updatedEnemyBoard[randRow][randColumn] = 'O';
			Gameboard.printGameBoard(updatedEnemyBoard);
			System.out.print("\nENEMY MISSED!\n");

		} else if (userShipsLoc[randRow][randColumn] == 'S') {
			updatedEnemyBoard[randRow][randColumn] = 'X';
			Gameboard.printGameBoard(updatedEnemyBoard);
			--numUserShips;
			System.out.print("ENEMY DESTROYED A SHIP!\n" + "\nPlayer ships remaining: " + numUserShips);

			if (numUserShips == 0) {
				System.out.print("ENEMY WINS!!!\n" + "Thanks for playing!");
				System.exit(0);
			}
		}

		return updatedEnemyBoard;

	}

}
