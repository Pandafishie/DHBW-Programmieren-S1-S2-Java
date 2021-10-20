package de.dhbwka.java.utils.fileIO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicFileReader {
	
	private static String COMMA_DELIMITER = ";";
	
	/**
	 * Erwartet einen Dateinamen, oder einen Pfad und sucht dort nach einer Datei die als String zurückgegeben wird.
	 * @param filename Dateiname oder Pfad
	 */
	public String readFile(String filename) {
		String text = null;
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			//StringBuilder baut den finalen String
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				//Zeile holen und hinzufügen
				sb.append(line);
				//neue Zeile/Zeilenumbruch
				sb.append(System.lineSeparator());
				System.out.println(line);
				//String[] values = line.split(COMMA_DELIMITER);
			}
			br.close();
			text = sb.toString();
			
			
		}
		catch (FileNotFoundException e) {
			new FileNotFoundException("Datei wurde nicht gefunden;");
		}
		catch (Exception e) {
		}
		return text;
	}
	
	/**
	 * Liest eine CSV ähnliche Datei ein in der die einzelnen Dateieinträge durch Strichkomma oder was ähnliches getrennt sind.
	 * Gibt eine doppelt geschachtelte Liste zurück, dabei sind in der inneren Liste die Strings der Felder einer Zeile,
	 * die äußere sind die einzelnen Zeilen.
	 * @param filename
	 */
	public List<List<String>> readCSVFile(String filename) {
		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			//Skip first line
			//br.readLine();
			String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(COMMA_DELIMITER);
		        records.add(Arrays.asList(values));
		    }
		}
		catch (FileNotFoundException e) {
			new FileNotFoundException("Datei wurde nicht gefunden;");
		}
		catch (Exception e) {}
		return records;
	}
		

}
