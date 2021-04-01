package rmi_services;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EmailSender extends Remote{
	public void sendEmail(String toEmail, String subject, String message) throws Exception, RemoteException;

}
