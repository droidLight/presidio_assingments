package rmi_services;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SMSSender extends Remote {
	public void sendSms(String toPhone, String body) throws Exception, RemoteException;
}
