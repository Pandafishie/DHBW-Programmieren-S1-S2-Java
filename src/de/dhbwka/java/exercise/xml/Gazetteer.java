package de.dhbwka.java.exercise.xml;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg Cooperative
 * State University.
 *
 * (C) 2016 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.0
 */
public class Gazetteer {
	public static Bounds getBounds(String queryTerm) {
		Bounds result = new Bounds();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			String url = "https://maps.googleapis.com/maps/api/geocode/xml?sensor=false&address=" + queryTerm;
			Document doc = parser.parse(url);
			// Auf (einzige) formatted_address setzen und...
			String form_adress = doc.getDocumentElement().getElementsByTagName("formatted_address").item(0)
					.getTextContent();
			System.out.println("Adresse: " + form_adress);

			String long_name = "kein locality-Name gefunden";
			NodeList nl = doc.getDocumentElement().getElementsByTagName("address_component");
// evtl. mehrfach vorhanden!
			for (int i = 0; i < nl.getLength(); i++) {
				if (getNamedChildNode(nl.item(i), "type").getTextContent().equals("locality")) {
					long_name = getNamedChildNode(nl.item(i), "long_name").getTextContent();
					break;
				}
			}
			System.out.println("Long Name: " + long_name);

			// Lage
			Node loc = doc.getDocumentElement().getElementsByTagName("location").item(0);
			String lat = getNamedChildNode(loc, "lat").getTextContent();
			String lng = getNamedChildNode(loc, "lng").getTextContent();
			System.out.println("Location: (latitude=" + lat + "" + ", longitude=" + lng + ")");
			Node bounds = doc.getDocumentElement().getElementsByTagName("bounds").item(0);
			result = new Bounds(getNamedChildNode(getNamedChildNode(bounds, "northeast"), "lng").getTextContent(), // east
					getNamedChildNode(getNamedChildNode(bounds, "northeast"), "lat").getTextContent(), // north
					getNamedChildNode(getNamedChildNode(bounds, "southwest"), "lng").getTextContent(), // west
					getNamedChildNode(getNamedChildNode(bounds, "southwest"), "lat").getTextContent() // south
			);
		} catch (ParserConfigurationException | SAXException | IOException | DOMException ex) {
			System.err.println("Fehler bei getBounds: " + ex.getMessage());
		}
		return result;
	}

	// Liefert den ersten Kind-Koten mit dem angegebenen Namen
	public static Node getNamedChildNode(Node n, String name) {
		NodeList children = n.getChildNodes();
		for (int i = 0; i < children.getLength(); i++)
			if (children.item(i).getNodeName().equals(name))
				return children.item(i);
		return null;
	}

	public static void main(String[] args) {
		System.out.println(getBounds("Karlsruhe"));
	}
}