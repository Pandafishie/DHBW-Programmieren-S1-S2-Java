package de.dhbwka.java.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class DataStream {

	public static void WriteFile(String FileName, String Value) throws IOException {
		File file = new File(FileName);
		StandardOpenOption option=null;
		if (file.exists()) {
					option=StandardOpenOption.APPEND;	
		}
		else {
			option=StandardOpenOption.CREATE;
		}
		Value+=System.lineSeparator();
		Files.writeString(Paths.get(FileName), Value,option);
	}
	public static void WriteFile(String FileName, List<String> strings) throws IOException {
		File file = new File(FileName);
		StandardOpenOption option=null;
		if (file.exists()) {
					option=StandardOpenOption.APPEND;	
		}
		else {
			option=StandardOpenOption.CREATE;
		}
		for (String string : strings) {
			string+=System.lineSeparator();			
			Files.writeString(Paths.get(FileName), string,option);
		}
	}
	public static void deleteFile(String FileName) throws IOException {		
		if (Files.exists(Paths.get(FileName), LinkOption.NOFOLLOW_LINKS)) {
			Files.delete(Paths.get(FileName));
		}
		else {
			System.out.println("Keine Datei gefunden");			
		}
	}
	public static void clearFile(String FileName) throws IOException {
		deleteFile(FileName);
		createFile(FileName);
		
	}
	public static void createFile(String FileName) throws IOException {
		new File(FileName);
		Files.writeString(Paths.get(FileName), "", StandardOpenOption.CREATE);
	}
	
	public static File ReadFile_File(String FileName) {
		return new File(FileName);
	}
	public static List<String> ReadFile_List(String FileName) throws IOException{
		return Files.readAllLines(Paths.get(FileName));
	}
	
}