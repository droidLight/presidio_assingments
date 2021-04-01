package rmi_services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class SMSSenderService extends UnicastRemoteObject implements SMSSender {

	protected SMSSenderService() throws RemoteException {
		super();
	}

	@Override
	public void sendSms(String toPhone, String body) throws Exception, RemoteException {
		Twilio.init("ACdc90c0b0b0741c11ea5b0829a49d0446", "578aa95484f43cb6cef1128d0ebac44a");

		Message message = Message.creator(new com.twilio.type.PhoneNumber(toPhone),
				new com.twilio.type.PhoneNumber("+17085017057"), body).create();

		System.out.println("Message sent: "+message.getSid());
	}

}
