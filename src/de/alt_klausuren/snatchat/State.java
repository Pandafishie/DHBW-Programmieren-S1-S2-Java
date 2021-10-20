package de.z_klausuren.snatchat;

public enum State {
	AVAILABLE("Available"),
	AWAY("Away"),
	DND("Do not distrub");
	
	private String label;

	private State(String label) {
		this.label = label;
	}

	String getLabel() {
		return label;
	}
	
}
