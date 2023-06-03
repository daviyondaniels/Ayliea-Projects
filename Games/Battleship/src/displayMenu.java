
import java.util.Scanner;

class displayMenu {

	public static void startMenu(int gameboardLength, char water, char[] rows, char[] columns) {
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		char userInput;

		String menuOptions = "Menu\n\n" + "1. Start\n" + "2. Credits\n" + "3. End Game\n";

		System.out.println(menuOptions + "\nMake a Selection: ");
		userInput = scnr.next().charAt(0);

		if (userInput == '1') {
			Gameboard.startUserGameBoard(gameboardLength, water, rows, columns);
		} else if (userInput == '2') { // This else-if code block might decrease performance
			Credits.startCredits();
			System.out.print("\n\n1. Back " + "\n\nMake a selection: ");
			userInput = scnr.next().charAt(0);
			if (userInput == '1') {
				System.out.println();
				startMenu(gameboardLength, water, rows, columns);
			}
		} else if (userInput == '3') {
			System.out.print("Thanks for playing!");
			System.exit(0);
		}
	}
}
