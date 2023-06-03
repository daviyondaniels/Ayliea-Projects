//Prompts user and computer to guess a location

public class StartTurn {
	static char[] columns = { ' ', 'A', 'B', 'C', 'D', 'E' };
	static char[] rows = { ' ', '1', '2', '3', '4', '5' };

	// Starts user's turn
	public static char[][] startUserTurn(char[][] userBoard, char[][] enemyShips) {
		char[][] updatedUserBoard;

		int[] userCoordinates = UserSelection.guessEnemyShipsLoc(userBoard, columns, rows);
		int rowGuess = userCoordinates[0];
		int columnGuess = userCoordinates[1];
		updatedUserBoard = UserSelection.userHitOrMiss(enemyShips, userBoard, rowGuess, columnGuess);
		if (userBoard != updatedUserBoard) {
			Gameboard.copyGameBoard(updatedUserBoard, userBoard);
		}
		return updatedUserBoard;

	}

	// Starts computer turn
	public static char[][] startCOMTurn(char[][] enemyBoard, char[][] userShips) {
		char[][] updatedEnemyBoard;
		int[] enemyCoordinates;

		enemyCoordinates = EnemySelection.guessUserShipsLoc();
		int randRow = enemyCoordinates[0];
		int randColumn = enemyCoordinates[1];
		updatedEnemyBoard = EnemySelection.enemyHitOrMiss(userShips, enemyBoard, randRow, randColumn);
		if (enemyBoard != updatedEnemyBoard) {
			Gameboard.copyGameBoard(updatedEnemyBoard, enemyBoard);

		}
		return updatedEnemyBoard;

	}
}
