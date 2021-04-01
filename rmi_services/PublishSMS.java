package rmi_services;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class PublishSMS {
	public static void main(String[] args) throws Exception{
		SMSSenderService service = new SMSSenderService();
		
		LocateRegistry.createRegistry(4000);
		Naming.bind("rmi://localhost:4000/services/sms", service);
		System.out.println("SMS Service deployed");
	}
}
