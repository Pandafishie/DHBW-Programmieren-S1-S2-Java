package de.dhbwka.java.exercise.xml;

/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg Cooperative
 * State University.
 *
 * (C) 2016 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.0
 */
public class Bounds {
	public double south, north, west, east;

	public Bounds() {
	}

	public Bounds(String east, String north, String west, String south) {
		this(Double.parseDouble(east), Double.parseDouble(north), Double.parseDouble(west), Double.parseDouble(south));
	}

	public Bounds(double east, double north, double west, double south) {
		this.east = east;
		this.north = north;
		this.west = west;
		this.south = south;
	}

	@Override
	public String toString() {
		return "Bounds: (east=" + east + ", north=" + north + ", west=" + west + ", south=" + south + ")";
	}
}