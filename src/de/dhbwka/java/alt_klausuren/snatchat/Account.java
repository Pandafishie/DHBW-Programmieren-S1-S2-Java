package de.dhbwka.java.alt_klausuren.snatchat;

import java.awt.Color;
import java.util.Random;

public class Account {

	private String name;
	private State state;
	private Color color;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public Account(String name) {
		this.name = name;
		this.state = State.AVAILABLE;
		
		Random rnd = new Random();
		int r = rnd.nextInt(201);
		int g = rnd.nextInt(201);
		int b = (int)(Math.random()*201);
		this.color = new Color(r,g,b);
		
	}
	
}
