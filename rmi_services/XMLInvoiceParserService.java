package rmi_services;

import java.io.File;
import java.io.FileOutputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

public class XMLInvoiceParserService extends UnicastRemoteObject implements XMLParser {

	List<String> productList, priceList, quantityList, taxList, unitList;

	protected XMLInvoiceParserService() throws RemoteException {
		super();
		this.productList = new ArrayList<>();
		this.priceList = new ArrayList<>();
		this.quantityList = new ArrayList<>();
		this.taxList = new ArrayList<>();
		this.unitList = new ArrayList<>();
	}

	private void parseXML(File xmlFile) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();

		parser.parse(xmlFile, new SAXParserHandler());

		for (int i = 0; i < productList.size(); i++) {
			System.out.println(productList.get(i) + "\t" + priceList.get(i) + "\t" + quantityList.get(i) + "\t"
					+ unitList.get(i) + "\t" + taxList.get(i));
		}
	}

	@Override
	public void parseXMLToPdf(File file) throws RemoteException, Exception {
		System.out.println("Parsing XML to PDF");
		//this.parseXML(file);				
		PDFGenerator.getInstance().generate(productList, priceList, quantityList, taxList, unitList);
	}
	
	@Override
	public void parseXMLToExcel(File file) throws RemoteException, Exception {
		System.out.println("Parsing XML to Excel");
		this.parseXML(file);
	}
	
	private class SAXParserHandler extends DefaultHandler {

		Stack<String> stack;
		String value;

		public SAXParserHandler() {

			this.stack = new Stack<>();
			this.value = null;
		}

		@Override
		public void startDocument() throws SAXException {
			System.out.println("parsing started");
		}

		@Override
		public void endDocument() throws SAXException {
			System.out.println("parsing ended");
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			this.value = new String(ch, start, length);
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			this.stack.push(qName);
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (this.stack.peek().equals(qName)) {
				this.stack.pop();

				switch (qName) {
				case "itemname":
					productList.add(this.value);
					break;
				case "unit":
					unitList.add(this.value);
					break;
				case "qty":
					quantityList.add(this.value);
					break;
				case "price":
					priceList.add(this.value);
					break;
				case "tax":
					taxList.add(this.value);
					break;
				}
			}
		}
	}

}
