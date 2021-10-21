package de.dhbwka.java.exercise.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg Cooperative
 * State University.
 *
 * (C) 2016 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.0
 */
public class Grid {
	public static final int GRIDS = 5; // Rastergröße

	public static void main(String[] args) {
		Bounds kaBounds = Gazetteer.getBounds("Karlsruhe");
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.newDocument();
			Element kml = doc.createElementNS("http://earth.google.com/kml/2.2", "kml");
			Element document = doc.createElement("Document");
			kml.appendChild(document);
			doc.appendChild(kml);
			int i = 0;
			double stepx = (kaBounds.east - kaBounds.west) / (GRIDS - 1);
			double stepy = (kaBounds.north - kaBounds.south) / (GRIDS - 1);
			for (double y = kaBounds.south; y <= kaBounds.north; y += stepy)
				for (double x = kaBounds.west; x <= kaBounds.east; x += stepx) {
					String coord = x + "," + y + ",0";
					Element pm = doc.createElement("Placemark");
// Element "name" erzeugen und anhängen
					Element name = doc.createElement("name");
					name.setTextContent("Punkt " + i);
					pm.appendChild(name);
// Element "description" erzeugen und anhängen
					Element description = doc.createElement("description");
					description.setTextContent("Koordinaten: " + coord);
					pm.appendChild(description);
// Element "point" erzeugen und anhängen
					Element point = doc.createElement("Point");
					pm.appendChild(point);
// Element "point" erzeugen, an "point" anhängen
					Element coordinates = doc.createElement("coordinates");
					coordinates.setTextContent(coord);
					point.appendChild(coordinates);
// neues "placemark" an kml anhängen
					document.appendChild(pm);
					i++;
				}
			TransformerFactory tFactory = TransformerFactory.newInstance();
			tFactory.setAttribute("indent-number", 2);
			Transformer transformer = tFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(
					new OutputStreamWriter(new FileOutputStream(new File("karlsruhe.kml")), "UTF-8"));
			transformer.transform(source, result);
		} catch (Exception ex) {
		}
	}
}