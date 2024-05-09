package base;

import base.board.items.BoardItems;

/**
 * Class that represents a Fly. It contains healthpoints and name attributes.
 * 
 * @author Alonso
 * @author Nestor
 */
public class Fly extends BoardItems {
	/**
	 * List of possible names for the flies
	 */
	private String[] nameList = { "Gaga", "Lindsay", "Eusebio", "Kafka", "Jeff Goldbloom", "Jennifer", "Ana L.M.",
			"Pepa the fool", "Flygon" };

	/**
	 * Health points of the fly
	 */
	private int healthPoints;

	/**
	 * Name of the fly
	 */
	private String name = "";

	/**
	 * modifies the healthpoints of the fly
	 * 
	 * @param hp number of health points to assign to the fly
	 */
	public void setHealthPoints(int hp) {
		if (hp > 0) {
			this.healthPoints = hp;
		}
	}

	/**
	 * returns the fly health points
	 * 
	 * @return Fly's health points
	 */
	public int getHealthPoints() {
		return this.healthPoints;
	}

	/**
	 * Modifies the name of the fly
	 * 
	 * @param name Name for the fly
	 */
	public void setName(String name) {
		if (!name.trim().equals("")) {
			this.name = name;
		}
	}

	/**
	 * Returns the name of the fly
	 * 
	 * @return name of the fly
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets a random name from nameList
	 * 
	 * @return Random name
	 */
	public String getRandomName() {
		return nameList[(int) Math.random() * nameList.length];
	}

	/**
	 * Give random health points to the fly
	 * 
	 * @return
	 */
	public int getRandomHealthPoints() {
		int hp = 1 + ((int) Math.random() * 2);
		return hp;
	}

	/**
	 * Constructor con nombres y puntos de vida aleatorios
	 */
	public Fly() {
		this.name = getRandomName();
		this.healthPoints = getRandomHealthPoints();
	}

	/**
	 * Method hitFly: decreases the health points of a fly
	 * 
	 * @param hp
	 */
	public void hitFly(int hp) {
		this.healthPoints = this.healthPoints - hp;
	}
}