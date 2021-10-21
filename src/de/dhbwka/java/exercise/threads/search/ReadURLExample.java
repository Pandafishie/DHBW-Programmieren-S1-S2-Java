package de.dhbwka.java.exercise.threads.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg Cooperative
 * State University.
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1
 */
public class ReadURLExample {
	public static String getStringContentFromUrl(String url, String encoding) {
		StringBuilder buffer = new StringBuilder();
		String line = null;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream(), encoding))) {
			while ((line = br.readLine()) != null) {
				buffer.append(line).append(System.lineSeparator());
			}
		} catch (IOException ex) {
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		System.out.println(ReadURLExample.getStringContentFromUrl("https://www.tagesschau.de", "UTF-8"));
	}
}
