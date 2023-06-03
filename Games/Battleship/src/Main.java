// Location of Main method

import java.util.Scanner;

public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		Scanner scnr = new Scanner(System.in);
		char hit = 'X';
		char miss = 'O';
		char ship = 'S';
		char water = '-';
		int gameboardLength = 6;
		char[] columns = { ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };
		char[] rows = { ' ', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		boolean gameIncomplete = true;
		char turn = 'P';
		int enemyRemaining = 5;
		int userRemaining = 5;
		int i = 0;

		String ruleCall = "Rules: \nEnter a row number and column letter to attack the location."
				+ " \nIf the game returns an \"O\", then you've missed a target. "
				+ "\nIf the game returns an \"X\", then you've hit a target.\n";

		System.out.println("Welcome to Battleship!\n\n" + ruleCall);

		// Calls on displayMenu() class to display menu at startup
		displayMenu.startMenu(gameboardLength, water, rows, columns);

		char[][] originalGameBoard = Gameboard.startUserGameBoard(gameboardLength, water, rows, columns);
		Gameboard.printGameBoard(originalGameBoard);

		// Prompts user to place ships and assigns
		char[][] userShips = ShipPlacement.userShipsLoc(originalGameBoard, columns, rows);
		char[][] enemyShips = ShipPlacement.enemyShipsLoc(originalGameBoard, columns, rows);

		// Initializes user and enemy boards for use
		char[][] userBoard = new char[gameboardLength][gameboardLength];
		char[][] enemyBoard = new char[gameboardLength][gameboardLength];
		Gameboard.copyGameBoard(originalGameBoard, userBoard);
		Gameboard.copyGameBoard(originalGameBoard, enemyBoard);

		while (i == 0) {
			if (turn == 'P') {
				System.out.println("\n\nYour turn...");
				StartTurn.startUserTurn(userBoard, enemyShips);
				turn = 'C';
			} else if (turn == 'C') {
				// Pause for 3 seconds before starting Computer turn
				System.out.println("\nEnemy is making their move...\n");
				Thread.sleep(4000);
				StartTurn.startCOMTurn(enemyBoard, userShips);

				turn = 'P';
			}
		}

	}

}
