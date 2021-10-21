package de.dhbwka.java.exercise.strings;

import java.util.Scanner;

/**
 * @author DHBW lecturer
 * @version 1.0
 *
 *          Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 *          Cooperative State University.
 *
 *          (C) 2015 by J. Sidler, T. Schlachter, C. Schmitt, W. Süß
 */
public class Palindrome {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Bitte Wort eingeben: ");
		String word = scan.nextLine();
		StringBuilder reverse = new StringBuilder(word).reverse(); // RTFM!
		System.out.println("Umgekehrt: " + reverse);
		System.out.println(word + " ist " + (word.equalsIgnoreCase(reverse.toString()) ? "" : "k") + "ein Palindrom.");
		scan.close();
	}
}