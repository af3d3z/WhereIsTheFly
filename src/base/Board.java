package base;

import java.util.ArrayList;

import base.board.items.BoardItems;

/**
 * Class that simulates the board where the flies are gonna be, the unofficial
 * "base" of the game
 * 
 * @author DragonaEileen
 * @author nestor
 */
public class Board {

	/* Fields */
	/**
	 * Bidimensional array where all the flies and power ups and downs are going to
	 * be placed
	 */
	protected BoardItems[][] gameBoard;

	/**
	 * 1-dimensional array list with dinamic length to access the flies on the board
	 * quickly
	 */
	protected ArrayList<Fly> flyArray = new ArrayList<Fly>();

	/**
	 * Hit radius of the flycatcher
	 */
	protected int areaRadius = 0;

	/**
	 * Hit damage of the flycatcher
	 */
	protected int hitDamage = 1;

	/* Constructors */
	/**
	 * Constructor with parameters
	 * 
	 * @param difficulty Difficulty of the game that affects the size of the board
	 */
	public Board(int difficulty) {

		/* Base of Axis I */
		int randomPowerAxisI = (int) (Math.random() * 2 + 2);

		/* Size of Axis I */
		int randomAxisI = (int) Math.pow(randomPowerAxisI, difficulty);

		/* Base of Axis J */
		int randomPowerAxisJ = (int) (Math.random() * 2 + 2);

		/* Size of Axis I */
		int randomAxisJ = (int) Math.pow(randomPowerAxisJ, difficulty);

		// Now we set the size
		this.gameBoard = new BoardItems[randomAxisI][randomAxisJ];

		// Lets generate the flies
		this.generateFlies();

		// Now lets fill the board with'em
		this.fillBoard();

	}// Fin Constructor With Parameters

	/* Setter */
	/**
	 * We ought to fill the cells with something
	 * 
	 * @param item Some kind of board item to fill the cell with
	 * @param posI The position of the cell on the I axis
	 * @param posJ The position of the cell on the J axis
	 */
	public void setBoardCell(BoardItems item, int posI, int posJ) {

		gameBoard[posI][posJ] = item;

	}// Fin setBoardCell()

	/* Methods */
	/**
	 * Method that returns true if there's a fly int the given position Method made
	 * by Eileen
	 * 
	 * @param posI The position of the cell on the I axis
	 * @param posJ The position of the cell on the J axis
	 * @return thereIsFly True if there's indeed a fly or false if not
	 */
	public boolean isThereFlyHere(int posI, int posJ) {

		/* PCC */
		/* Boolean to return */
		boolean thereIsFly = false;

		/* Checking */
		/*
		 * Lets go through the Fly Array seeking if the fly on the array is equal to the
		 * one at the position
		 */
		for (Fly flutter : this.flyArray) {

			// If to seek similarity
			if (flutter.equals(gameBoard[posI][posJ])) {

				thereIsFly = true;

			} // Fin IF --> Checking if equals

		} // Fin FOR --> Flies running through

		/* Return Statement */
		return thereIsFly;

	}// Fin isThereFlyHere?

	/**
	 * Filling method, it generates the flies and inserts them into the board Method
	 * made by Eileen
	 * 
	 * @param difficulty Difficulty of the Game
	 */
	protected void fillBoard() {

		/* Random position on the I axis */
		int randPosI;

		/* Random position on the J axis */
		int randPosJ;

		/* Size of axis I */
		int sizeI = this.gameBoard.length;

		/* Size of axis J */
		int sizeJ = this.gameBoard[0].length;

		/* Flag to continue the loop */
		boolean flag;

		/* Let's go through the flyArray inserting flies */
		for (Fly flutter : flyArray) {

			// Reset of the flag
			flag = true;

			while (flag) {

				// Random asignation of position
				randPosI = (int) (Math.random() * sizeI);
				randPosJ = (int) (Math.random() * sizeJ);

				// Lets see if there is a fly already there
				if (!this.isThereFlyHere(randPosI, randPosJ)) {

					// Let's insert it!!!
					this.gameBoard[randPosI][randPosJ] = flutter;

					// Flag goes weeee
					flag = false;

				} // Fin IF --> Checking for flies already there

			} // Fin WHILE --> Inserting loop

		} // Fin FOR --> Going through the flies

	}// Fin fillBoard()

	/**
	 * Method to generate the flies Method made by Eileen
	 */
	protected void generateFlies() {

		/* PCC */
		/*
		 * Number of flies that are gonna be inserted It's gonna be equal to 25% of the
		 * total of cells
		 */
		int totalFlies = (int) (this.gameBoard.length * this.gameBoard[0].length * 0.25);

		/* Fly to add declaration */
		Fly flutter;

		/* Lets fill first the fly array */
		for (int i = 0; i < totalFlies; i++) {

			// Let's construct the fly
			flutter = new Fly();

			// And add it to the array
			this.flyArray.add(flutter); // here you add the fly

		} // Fin FOR --> Stuffing fly array

	}// Fin generateFlies()

	/**
	 * Method to catch a fly given the position Method made by Nestor and Eileen
	 * 
	 * @param posI: position I from the array
	 * @param posJ: position J from the array
	 * @return catched If a fly has been catched or not
	 */
	public boolean catchFly(int posI, int posJ) {

		// Boolean catched: indicates if the fly has been hit or not
		boolean caught = false;

		/* Fly declaration */
		Fly flutter;

		// Check if the fly has been catched or not
		caught = this.isThereFlyHere(posI, posJ);

		// If: if the fly has been catched:
		if (caught) {

			flutter = (Fly) this.gameBoard[posI][posJ];

			flutter.hitFly(hitDamage);

			// If: if the health points are 0, the fly will be removed.
			if (flutter.getHealthPoints() < 1) {
				gameBoard[posI][posJ] = null;
				flyArray.remove(flutter);
			} // End If

			this.gameBoard[posI][posJ] = flutter;

		} // End If

		// Return the variable catched
		return caught;

	}

	// PRINT METHODS

	/**
	 * Method to print the board Method made by Nestor and Eileen
	 */
	public void printingBoard() {

		/* String to print */
		String toPrint = "";

		/* Lets go through the I axis */
		for (int i = 0; i < this.gameBoard.length; i++) {

			/* Now, through the J axis */
			for (int j = 0; j < this.gameBoard[i].length; j++) {

				toPrint += "[" + i + "," + (char) ('a' + j) + "]";

			} // Fin FOR --> Axis J

			toPrint += "\n";

		} // Fin FOR --> Axis I

		// Printing
		System.out.println(toPrint);

	}// Fin printingBoard()

}