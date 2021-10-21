package de.dhbwka.java.exams.snatchat;

public interface SnatChatFrontend {
	public void receiveMessage(String text);

	public void receiveMessage(Message msg);

	public Account getAccount();
}