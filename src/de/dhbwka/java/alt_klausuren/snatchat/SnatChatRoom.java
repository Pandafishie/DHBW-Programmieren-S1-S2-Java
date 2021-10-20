package de.dhbwka.java.alt_klausuren.snatchat;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

public class SnatChatRoom {
	
	private String roomName;
	private List<SnatChatFrontend> frontends = new LinkedList<SnatChatFrontend>();
	
	
	public SnatChatRoom(String roomName) {
		this.roomName = roomName;
	}

	public void register(SnatChatFrontend frontend) {
		this.frontends.add(frontend);
		
		try ( BufferedReader reader = new BufferedReader(new FileReader(this.roomName + ".txt"))) {
			List<String> lines = new ArrayList<>();
			while(reader.ready()) {
				lines.add(reader.readLine());
			}
			
			@SuppressWarnings("unused")
			int startIndex = Math.max(0, lines.size()-10);
			for (int i = 0; i < lines.size(); i++) {
				frontend.receiveMessage(lines.get(i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void unregister(SnatChatFrontend frontend) {
		this.frontends.remove(frontend);
		
	}
	
	public String getRoomName() {
		return this.roomName;
	}
	
	public void sendMessage(Message msg) {
		for (SnatChatFrontend snatChatFrontend : frontends) {
			snatChatFrontend.receiveMessage(msg);
		}
		
		this.logToFile(msg.getSender() + ": " + msg.getText());
	}
	
	public void sendMessage(String text) {
		for (SnatChatFrontend snatChatFrontend : frontends) {
			snatChatFrontend.receiveMessage(text);
		}
		
		this.logToFile(text);
	}
	
	public void logToFile(String line) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(this.roomName+".txt" ,true))){
			pw.println(Message.rot13(line));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
