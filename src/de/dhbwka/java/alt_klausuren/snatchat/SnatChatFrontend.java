package de.dhbwka.java.alt_klausuren.snatchat;

public interface SnatChatFrontend {

	public void receiveMessage (Message msg);
	public void receiveMessage (String text);
	public Account getAccount();
	public SnatChatRoom getRoom();
}
