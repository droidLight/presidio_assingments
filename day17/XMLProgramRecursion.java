package day17;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Document;

public class XMLProgramRecursion {
	
	private static void traverseDocument(Node rootElement) {
		for(int i = 0; i < rootElement.getChildNodes().getLength(); i++) {
			Node node = rootElement.getChildNodes().item(i);
			if(node.hasChildNodes()) {
				traverseDocument(node);
			}else {
				System.out.println(node+"  "+node.getNodeValue());			
			}
		}
	}
	public static void main(String[] args) throws Exception{
		
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dbFactory.setValidating(true);
		dbFactory.setIgnoringElementContentWhitespace(true);
		
		DocumentBuilder db = dbFactory.newDocumentBuilder();
		//Document doc = db.parse("./recursionprogram.xml");
		Document doc = db.parse("./books.xml");
		
		Element rootElement = doc.getDocumentElement();
		traverseDocument((Node) rootElement);
		
	}
}
