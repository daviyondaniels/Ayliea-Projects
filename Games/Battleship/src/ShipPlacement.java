
import java.util.Random;
import java.util.Scanner;

class ShipPlacement {
	public static char[][] userShipsLoc(char[][] originalGameBoard, char[] columns, char[] rows) {
		Scanner scnr = new Scanner(System.in);
		char ship = 'S';
		int placedShips = 5;
		char[][] userShips = new char[originalGameBoard.length][originalGameBoard.length];
		int placementRow = 0;
		int placementColumn = 0;

		Gameboard.copyGameBoard(originalGameBoard, userShips);

		// Prompts user to place ships in desired locations
		for (int i = 1; i <= placedShips; ++i) {

			System.out.println("\nEnter a location for ship " + i + ".\n");

			System.out.print("Row: ");
			char userRow = scnr.next().charAt(0);

			if (Character.isLetter(userRow)) {
				System.out.print("Input is not a number. Please enter a row number: ");
				--i;
			}

			else if (Character.getNumericValue(userRow) <= 0) {
				System.out.println("Input is too low. Please enter a row number: ");
				--i;
			} else if (Character.getNumericValue(userRow) >= originalGameBoard.length) {
				System.out.println("\n Input is too high. Please enter a row number: ");
				--i;
			} else if (Character.isDigit(userRow)) {
				for (int r = 0; r <= rows.length - 1; ++r) {
					if (userRow == rows[r]) {
						placementRow = r;

						System.out.print("\nColumn: ");
						char userColumn = scnr.next().charAt(0);
						if (userColumn >= 'a' && userColumn <= 'z') {
							System.out.println(
									"You entered a lowercase letter. Please enter an uppercase column letter :");
							--r;

						} else if (Character.isDigit(userColumn)) {
							System.out.println("Input is a number. Please enter a column letter: ");
							--r;

						}

						else if (!(userColumn >= 'A' && userColumn <= 'E')) {
							System.out.println("Input is out of range. Please enter a column letter: ");
							--r;

						} else {
							for (int c = 0; c <= columns.length - 1; ++c) {
								if (userColumn == columns[c]) {
									placementColumn = c;

								}
							}

						}
					}
				}
			}
			if (userShips[placementRow][placementColumn] == ship) {
				System.out.println("You have already placed as ship in this location. Try again.");
				--i;
				continue;
			}
			userShips[placementRow][placementColumn] = ship;
			Gameboard.printGameBoard(userShips);
		}
		return userShips;

	}

	public static char[][] enemyShipsLoc(char[][] originalGameBoard, char[] columns, char[] rows) {
		Random randGen = new Random();
		int placedShips = 5;
		char[][] enemyShips = new char[originalGameBoard.length][originalGameBoard.length];
		char ship = 'S';

		// Copies originalGameBoard to enemyShipsLoc
		Gameboard.copyGameBoard(originalGameBoard, enemyShips);

		// Places ships on enemy game board
		for (int i = 1; i <= placedShips; ++i) {
			int randomRow = randGen.nextInt(enemyShips.length - 1) + 1;
			int randomColumn = randGen.nextInt(enemyShips.length - 1) + 1;
			if (enemyShips[randomRow][randomColumn] == ship) {
				--i;

			} else {
				enemyShips[randomRow][randomColumn] = ship;
			}
		}
		return enemyShips;
	}

}
