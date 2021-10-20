package de.utils.fileIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BasicFileWriter {
	
	/**
	 * Schreibt einen String in eine Datei.
	 * @param string - String der in die Datei geschrieben wird
	 * @param filename - Dateiname oder Pfad der Datei
	 * @param append - Soll der Inhalt an die Datei angehängt werden
	 */
	public void writeToFile(String string, String filename, boolean append) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(filename, append));
			//writer = new BufferedWriter(new FileWriter(filename));
			writer.write(string);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
