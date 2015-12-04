package ch.makery.address.view;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ch.makery.address.model.Person;
import ch.makery.address.util.DateUtil;

/**
 *
 * The Seeker class can locate a particular contact in the XML file. In the Test
 * class is passed as parameter the contact to search.
 *
 * @author JoseManuel
 *
 */
public class Seeker {

	/**
	 * Method to find a person in the XML file
	 *
	 * @param route
	 *            File location
	 * @param comparar
	 *            Receives parameter from class test
	 * @return salida It contains data found in the specified node
	 */
	public Person buscar_persona(String route, String comparar) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Person salida = null;
		try {
			builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(route));
			document.getDocumentElement().normalize();
			NodeList lista_nodo = document.getElementsByTagName("person"); // etiqueta
																			// a
																			// buscar

			boolean find = false;
			int contador = 0;
			while (!find && contador != lista_nodo.getLength()) {

				Node nodo = lista_nodo.item(contador);

				Element elemento = (Element) nodo;
				String nombre = getNodo("firstName", elemento);
				String apellido = getNodo("lastName", elemento);
				if (comparar.equalsIgnoreCase(nombre)) {
					find = true;
					System.out.println("Nombre encontrado " + nombre);
					salida = new Person(nombre, apellido);
					salida.setStreet(getNodo("street", elemento));
					salida.setPostalCode(Integer.parseInt(getNodo("postalCode", elemento)));
					salida.setCity(getNodo("city", elemento));
					salida.setBirthday(DateUtil.parse(getNodo("birthday", elemento)));
				}
				contador++;
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salida;

	}

	/**
	 * Method that accesses the specified node
	 *
	 * @param string
	 * @param elemento
	 * @return -> element
	 */
	private String getNodo(String string, Element elemento) {
		// TODO Auto-generated method stub

		return elemento.getElementsByTagName(string).item(0).getTextContent();

	}
}
