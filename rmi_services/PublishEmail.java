package rmi_services;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class PublishEmail {
	
	public static void main(String[] args) throws Exception{
		EmailSenderService service = new EmailSenderService();
		
		LocateRegistry.createRegistry(3000);
		Naming.bind("rmi://localhost:3000/services/email", service);
		System.out.println("Email service deployed");
	}
}
