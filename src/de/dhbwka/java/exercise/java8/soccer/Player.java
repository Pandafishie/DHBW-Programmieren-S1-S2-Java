package de.dhbwka.java.exercise.java8.soccer;

/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg Cooperative
 * State University.
 *
 * (C) 2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.0
 */
public class Player {
	/**
	 * Number of player
	 */
	private final int number;
	/**
	 * Name of player
	 */
	private final String name;
	/**
	 * Position of player
	 */
	private final String position;
	/**
	 * Birthday of player
	 */
	private final String birthday;
	/**
	 * Club of player
	 */
	private final String club;
	/**
	 * Games of player
	 */
	private final int games;
	/**
	 * Goals of player
	 */
	private final int goals;

	/**
	 * Create player
	 *
	 * @param number   number of the player
	 * @param name     name of the player
	 * @param position position of the player
	 * @param birthday birthday of the player
	 * @param club     club of the player
	 * @param games    games of the player
	 * @param goals    goals of the player
	 */
	public Player(int number, String name, String position, String birthday, String club, int games, int goals) {
		super();
		this.number = number;
		this.name = name;
		this.position = position;
		this.birthday = birthday;
		this.club = club;
		this.games = games;
		this.goals = goals;
	}

	/**
	 * Get the number of the player
	 * 
	 * @return number of the player
	 */
	public int getNumber() {
		return this.number;
	}

	/**
	 * Get the name of the player
	 * 
	 * @return name of the player
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get the position of the player
	 * 
	 * @return position of the player
	 */
	public String getPosition() {
		return this.position;
	}

	/**
	 * Get the birthday of the player
	 * 
	 * @return birthday of the player
	 */
	public String getBirthday() {
		return this.birthday;
	}

	/**
	 * Get the club of the player
	 * 
	 * @return club of the player
	 */
	public String getClub() {
		return this.club;
	}

	/**
	 * Get the games of the player
	 * 
	 * @return games of the player
	 */
	public int getGames() {
		return this.games;
	}

	/**
	 * Get the goals of the player
	 * 
	 * @return goals of the player
	 */
	public int getGoals() {
		return this.goals;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return String.format("%3d", this.number) + " | " + this.name + ", " + this.position + ", " + this.birthday
				+ ", " + this.club + ", " + this.games + " games, " + this.goals + " goals";
	}
}
