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
		final String TITLE = " _ _ _ _                  _     \n" + "| | | | |_ ___ ___ ___   |_|___ \n"
				+ "| | | |   | -_|  _| -_|  | |_ -|\n" + "|_____|_|_|___|_| |___|  |_|___|\n"
				+ " _____ _          _____ _       \n" + "|_   _| |_ ___   |   __| |_ _   \n"
				+ "  | | |   | -_|  |   __| | | |  \n" + "  |_| |_|_|___|  |__|  |_|_  |  \n"
				+ "                         |___|  \n";
		

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
		 * State of the game flag, it is true while the game continues
		 */
		boolean flag = true;

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

		/* Build */
		game = new Board(difficulty);
		
		String position = "";
		String response = "";
		
		System.out.println(TITLE);
		System.out.println("Welcome player!");
		System.out.println("Are you ready to catch some flies? [Y/n]");
		response = scMain.nextLine();
		
		if (!response.equalsIgnoreCase("n") ) {
			System.out.println("\n\n\n"); // "clear terminal"
			
			/* Main game loop */
			do {

				game.printingBoard();
				
				System.out.println("Where would you want to hit?: ");// Todo: tell the user that the format is <<I,J>>
				position = scMain.nextLine();
				posI = Integer.parseInt(response.split(",")[0]);
				posJ = Integer.parseInt(response.split(",")[1]) - 65;
				

				System.out.println("Golpe I?");
				posI = scMain.nextInt();

				System.out.println("Golpe J?");
				posJ = scMain.nextInt();

				caught = game.catchFly(posI, posJ);

				if (caught) {
					System.out.println("Fly Hit");
				} else {
					System.out.println("Miss");
				}

				System.out.println("Seguir?");
				flag = scMain.nextBoolean();

			} while (flag);
		}
		
		scMain.close();
	}

}
