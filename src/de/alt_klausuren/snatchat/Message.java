package de.z_klausuren.snatchat;

public class Message {

	private String text;
	private Account sender;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Account getSender() {
		return sender;
	}

	public void setSender(Account sender) {
		this.sender = sender;
	}

	public Message(String text, Account sender) {
		this.text = text;
		this.sender = sender;
	}
	
	public static String rot13(String msg) {
		char[] msgChars = msg.toCharArray();
		
		for (int i = 0; i < msgChars.length; i++) {
			char c = msgChars[i];
			if (c >= 'A' && c <= 'M' || c >= 'a' && c <= 'm') {
				msgChars[i] += 13;
			}
			else if (c >= 'A' && c <= 'M' || c >= 'a' && c <= 'm') {
				
			}
		}
		return msg;
	}
	
}
