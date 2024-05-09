package base;

import java.util.Scanner;

/**
 * MainCode class
 * 
 * @author Group5
 */
public class Main {

	/**
	 * Main function
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final String TITLE = "\u001B[1m\u001B[35m _ _ _ _                  _     \n"
				+ "| | | | |_ ___ ___ ___   |_|___ \n" + "| | | |   | -_|  _| -_|  | |_ -|\n"
				+ "|_____|_|_|___|_| |___|  |_|___|\n" + " _____ _          _____ _       \n"
				+ "|_   _| |_ ___   |   __| |_ _   \n" + "  | | |   | -_|  |   __| | | |  \n"
				+ "  |_| |_|_|___|  |__|  |_|_  |  \n" + "                         |___|  \n\u001B[0m";

		/* Fields */
		/**
		 * Main object of the game, it basically starts it
		 */
		Board game;

		/**
		 * Difficulty of the game, an integer from 1 to X?
		 */
		int difficulty = 1;

		/**
		 * Flag if a fly has been caught
		 */
		boolean caught;

		/**
		 * First Axis position
		 */
		int posI;

		/**
		 * Second Axis position
		 */
		int posJ;

		/* Scanner */
		Scanner scMain = new Scanner(System.in);

		/**
		 * Ask the player if they want to play
		 */
		String response = "";

		/* Build */
		game = new Board(difficulty);

		// Print the title and ask the player if they want to play
		System.out.println(TITLE);
		System.out.println("Welcome player!");
		System.out.println("Are you ready to catch some flies? [Y/n]");
		response = scMain.nextLine();

		// If they want to play
		if (!response.equalsIgnoreCase("n")) {
			// "clear terminal"
			System.out.println("\n\n\n");

			/* Main game loop */
			do {
				// Print game board
				game.printingBoard();

				// Ask next hit position
				System.out.println("Where would you want to hit?: ");

				System.out.println("I axis:");
				posI = scMain.nextInt();

				System.out.println("J axis:");
				posJ = scMain.nextInt();

				// Try to catch a fly
				caught = game.catchFly(posI, posJ);

				// If a fly gets caught
				if (caught) {
					System.out.println("Fly caught !!!");
				} else {
					System.out.println("You missed !");
				}

				// While there are still flies in the board
			} while (game.getFliesAlive() > 0);
		}

		System.out.println("You caught all the flies ฅ^•.•^ฅ !!");
		scMain.close();
	}

}
