package rmi_services;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface XMLParser extends Remote {
	
	public void parseXMLToPdf(File file) throws RemoteException, Exception;
	public void parseXMLToExcel(File file) throws RemoteException, Exception;
}
