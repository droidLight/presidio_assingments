package day17;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLSAXDemo {
	public static void main(String[] args) throws Exception {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser sp = factory.newSAXParser();
		
		sp.parse(new File("./books.xml"), new SAXHandler());
	}
}

class SAXHandler extends DefaultHandler{
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("parsing started");
	}
	
	@Override
	public void endDocument() throws SAXException{
		System.out.println("parsing ended");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println(new String(ch, start, length));
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("<"+qName+">");
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("</"+qName+">");
	}
}
