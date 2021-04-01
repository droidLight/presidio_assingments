package day16;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RmiService extends UnicastRemoteObject implements Stock{

	protected RmiService() throws RemoteException {
		super();
		
	}

	@Override
	public int getStockPrice(String name) throws RemoteException {
		System.out.println("in rmi service");
		if(name.equals("TCS")) {
			return 2300; 
		}else {
			return 300;
		}
	}

	public static void main(String[] args) throws Exception{
		RmiService service = new RmiService();
		
		LocateRegistry.createRegistry(1099);
		Naming.bind("rmi://localhost:1099/rmiservice/stockService", service);
	}
}
