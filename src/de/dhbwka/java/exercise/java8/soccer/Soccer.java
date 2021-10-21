package de.dhbwka.java.exercise.java8.soccer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg Cooperative
 * State University.
 *
 * (C) 2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.0
 */
public class Soccer {
	/**
	 * Application entry point
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		try {
			Path path = Paths.get("33_Java8_Aufgaben_TeamDE.txt");
			List<Player> players = Files.readAllLines(path, StandardCharsets.UTF_8).stream().map(Soccer::parsePlayer)
					.filter(Objects::nonNull).collect(Collectors.toList());
			System.out.println("Players sorted by number:");
			players.stream().sorted(Soccer::comparePlayerByNumber).forEach(System.out::println);
			System.out.println("-----");
			System.out.println("Players with more than 50 games, sorted by name:");
			players.stream().filter(p -> p.getGames() > 50).sorted(Soccer::comparePlayerByName)
					.forEach(System.out::println);

			System.out.println("-----");
			System.out.println("All clubs of the players:");
			players.stream().map(Player::getClub).distinct().forEach(System.out::println);
			System.out.println("-----");
			System.out.println("Count of players with less than 5 goals: "
					+ players.stream().filter(p -> p.getGoals() < 5).count());
			System.out.println("Count of goals of all players: " + players.stream().mapToInt(Player::getGoals).sum());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// continued on next page
	/**
	 * Parse player from CSV line
	 *
	 * @param line line to parse
	 * @return created player instance
	 */
	public static Player parsePlayer(String line) {
		String[] p = line.split(";");
		if (p.length == 7) {
			return new Player(Integer.parseInt(p[0]), p[1], p[2], p[3], p[4], Integer.parseInt(p[5]),
					Integer.parseInt(p[6]));
		} else {
			return null;
		}
	}

	/**
	 * Compare player by number
	 *
	 * @param p1 player 1
	 * @param p2 player 2
	 * @return result for {@link Comparator#compare(Object, Object) comparison} of
	 *         number of the players
	 */
	public static int comparePlayerByNumber(Player p1, Player p2) {
		return p1.getNumber() - p2.getNumber();
	}

	/**
	 * Compare player by name
	 *
	 * @param p1 player 1
	 * @param p2 player 2
	 * @return result for {@link Comparator#compare(Object, Object) comparison} of
	 *         name of the players
	 */
	public static int comparePlayerByName(Player p1, Player p2) {
		return p1.getName().compareTo(p2.getName());
	}
}
