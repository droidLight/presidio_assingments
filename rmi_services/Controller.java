package rmi_services;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Controller extends Remote {
	public Object getObject()throws RemoteException, Exception;
}
