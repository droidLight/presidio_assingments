package rmi_services;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class PublishParser {
	public static void main(String[] args) throws Exception{
		
		XMLInvoiceParserService service = new XMLInvoiceParserService();
		LocateRegistry.createRegistry(2000);
		Naming.bind("rmi://localhost:2000/services/pdf", service);
		System.out.println("ParserService deployed");
	}
}
