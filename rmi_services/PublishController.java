package rmi_services;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class PublishController {
	public static void main(String[] args) throws Exception{
		ControllerService service = new ControllerService();
		LocateRegistry.createRegistry(6000);
		Naming.bind("rmi://localhost:6000/services/controller", service);
		System.out.println("Controller deployed");
	}
}
