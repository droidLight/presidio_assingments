package rmi_services;

import java.io.File;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Client {
	
	
	public static void main(String[] args) throws Exception {

		Controller controller = (Controller) Naming.lookup("rmi://localhost:6000/services/controller");
		Object obj = controller.getObject();

//		XMLParser parser = (XMLParser) obj;
//		parser.parseXMLToExcel(new File("./invoice.xml"));
//		parser.parseXMLToPdf(new File("./invoice.xml"));

//		EmailSender emailSender = (EmailSender) obj;
//		emailSender.sendEmail("sibinehru99@gmail.com", "test email",
//				"email sent from java using controller and dynamic binding");

//		SMSSender smsSender = (SMSSender) obj;
//		smsSender.sendSms("+919080633574", "test message from dynamic binding controller");
	
	}
}
