package programa;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static DocumentBuilderFactory dbf;
	public static DocumentBuilder db;
	public static DOMImplementation implementation;
	public static Document document;
	public static Element products;
	public static File f = new File("tienda.xml");
	
	// ---------------------------MAIN--------------------------------------------------------------------------------------------------------

	public static void main(String[] args) throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		
		dbf = DocumentBuilderFactory.newInstance();
		db = dbf.newDocumentBuilder();
		assert db != null;
		implementation = db.getDOMImplementation();
		document = implementation.createDocument(null, null, null);
		document.setXmlVersion("1.0");
		document.setXmlStandalone(true);
		
		int opcion = 0;
		System.out.println("\nBienvenido al programa de gestión del XML de la Tienda.");
		do {
			mostrarMenu();
			System.out.print("Elige una opcion: ");
			opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
			case 1:
				saveInfo();
				break;
			case 2:
				readInfo();
				break;
			case 3:
				addElements();
				break;
			case 4:
				deleteElement();
				break;
			case 0:
				System.out.println("Que tenga un buen dia!");
				break;
			default:
				System.err.println("Selecciona un numero valido");
			}
		} while (opcion != 0);
	}
	// ------------------------------METODOS DEL PROGRAMA-----------------------------------------------------------------------------------------------------
	private static void deleteElement() throws SAXException, IOException, InterruptedException {
		document = db.parse(f);
		
		System.out.println("¿Que producto desea borrar?(ID)");
		String idScan = sc.nextLine();
		
		deleteProductById(idScan);
		System.out.println("Producto '" + idScan + "' borrado con exito!");
		Thread.sleep(500);
		
		saveFile();
	}
	// -----------------------------------------------------------------------------------------------------------------------------------
	private static void deleteProductById(String idScan) {
		NodeList productsList = document.getElementsByTagName("product");
		for (int i = 0; i < productsList.getLength() ; i++) {
			Element product = (Element) productsList.item(i);
			String id = product.getAttribute("ProductId");
			if(id.equalsIgnoreCase(idScan)) {
				product.getParentNode().removeChild(product);
			}
		}
	}

	// -----------------------------------------------------------------------------------------------------------------------------------
	private static void addElements() throws InterruptedException, SAXException, IOException {
		int subOpcion = 0;
		do {
			mostrarSubMenu();
			System.out.print("Elige una opcion: ");
			subOpcion = sc.nextInt();
			sc.nextLine();
			switch (subOpcion) {
			case 1:
				addObject();
				break;
			case 2:
				addObjects();
				break;
			case 0:
				System.out.print("Volviendo al menu principal");
				Thread.sleep(200);
				System.out.print(".");
				Thread.sleep(500);
				System.out.print(".");
				Thread.sleep(250);
				System.out.println(".");
				Thread.sleep(250);
				break;
			default:
				System.err.println("Selecciona un numero valido");
			}
		}while(subOpcion != 0);
	}
	// -----------------------------------------------------------------------------------------------------------------------------------
	private static void addObjects() throws SAXException, IOException, InterruptedException {
		document = db.parse(f);
		products = document.getDocumentElement();
		
		System.out.print("Cuantos productos quieres añadir: ");
		int num = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < num; i++) {
			createProduct(products, document);
		}
		saveFile();
	}
	// -----------------------------------------------------------------------------------------------------------------------------------
	private static void addObject() throws InterruptedException, SAXException, IOException {
		
		document = db.parse(f);
		products = document.getDocumentElement();
		createProduct(products, document);
		saveFile();
	}
	// -----------------------------------------------------------------------------------------------------------------------------------
	private static void readInfo() {
		try {
			Path path = Path.of("tienda.xml");
			File file = path.toFile();

			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
			document = db.parse(file);
			document.getDocumentElement().normalize();

			NodeList products = document.getElementsByTagName("products").item(0).getChildNodes();
			System.out.println("\nProductos: ");
			for (int i = 0; i < products.getLength(); i++) {
				Node node = products.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE)
					switchElement(node);
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// -----------------------------------------------------------------------------------------------------------------------------------
	private static void switchElement(Node node) {
		Element element = (Element) node;
		switch (element.getNodeName()) {
		case "product":
			System.out.println("");
			System.out.print("Producto ");
			System.out.println("'" + element.getAttribute("ProductId") + "':");
			switchElement(element.getFirstChild());
			break;
		case "name":
			System.out.print("Nombre: ");
			System.out.println(element.getTextContent());
			switchElement(element.getNextSibling());
			break;
		case "price":
			System.out.print("Precio: ");
			System.out.println(element.getTextContent());
			switchElement(element.getNextSibling());
			break;
		case "quantity":
			System.out.print("Cantidad: ");
			System.out.println(element.getTextContent());
			switchElement(element.getNextSibling());
			break;
		case "expiration":
			System.out.print("Fecha de caducidad: ");
			System.out.println(element.getTextContent());
			System.out.println("");
			System.out.println("==========================");
			break;
		}
	}
	// -----------------------------------------------------------------------------------------------------------------------------------
	private static void saveInfo() throws InterruptedException {
		if (!f.exists()) {
			try {

				products = document.createElement("products");
				document.appendChild(products);
				System.out.println("XML creado con exito!");
				Thread.sleep(500);
				System.out.println("Vamos a añadir el primer producto a tu XML...");
				Thread.sleep(1000);
				createProduct(products, document);
				
				saveFile();

			} catch (TransformerFactoryConfigurationError e) {

				e.printStackTrace();
			}
		} else {
			System.out.println("El archivo XML ya esta creado");
		}
	}
	// -----------------------------------------------------------------------------------------------------------------------------------
	private static void saveFile() {
		try {
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File("tienda.xml"));
			Transformer transformer;
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	// -----------------------------------------------------------------------------------------------------------------------------------
	private static void createProduct(Element products, Document document) throws InterruptedException {

		System.out.print("Dame el ID del producto: ");
		String idScan = sc.nextLine();
		System.out.print("Dame el nombre del producto: ");
		String nameScan = sc.nextLine();
		System.out.print("Dame el precio del producto: ");
		String priceScan = sc.nextLine();
		System.out.print("Dame la cantidad del producto: ");
		String quantityScan = sc.nextLine();
		System.out.print("Dame la fecha de caducidad del producto: ");
		String expirationScan = sc.nextLine();

		Element product = document.createElement("product");
		product.setAttribute("ProductId", idScan);

		Element name = document.createElement("name");
		Text nameText = document.createTextNode(nameScan);
		name.appendChild(nameText);

		Element price = document.createElement("price");
		Text priceText = document.createTextNode(priceScan + "€");
		price.appendChild(priceText);

		Element quantity = document.createElement("quantity");
		Text quantityText = document.createTextNode(quantityScan);
		quantity.appendChild(quantityText);

		Element expiration = document.createElement("expiration");
		Text expirationText = document.createTextNode(expirationScan);
		expiration.appendChild(expirationText);

		product.appendChild(name);
		product.appendChild(price);
		product.appendChild(quantity);
		product.appendChild(expiration);

		products.appendChild(product);

		System.out.println("Producto añadido con exito!!");
	}
	
	// ---------------------------------MENUS--------------------------------------------------------------------------------------------------
	private static void mostrarMenu() {
		System.out.println("┌―――――――――――――――――――――――――――――――――――――――――――――――――――――┐");
		System.out.println("│	1--> Guardar Informacion.                     │");
		System.out.println("│	2--> Recuperar Informacion.                   │");
		System.out.println("│	3--> Añadir Objeto.                           │");
		System.out.println("│	4--> Borrar Objeto.                           │");
		System.out.println("│	0--> Salir.                                   │");
		System.out.println("└―――――――――――――――――――――――――――――――――――――――――――――――――――――┘");
	}
	private static void mostrarSubMenu() {
		System.out.println("┌―――――――――――――――――――――――――――――――――――――――――――――――――――――┐");
		System.out.println("│	1--> Añadir uno.                              │");
		System.out.println("│	2--> Añadir varios.                           │");
		System.out.println("│	0--> Volver.                                  │");
		System.out.println("└―――――――――――――――――――――――――――――――――――――――――――――――――――――┘");
	}
	
}