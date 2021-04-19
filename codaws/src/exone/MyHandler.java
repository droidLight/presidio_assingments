package exone;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class MyHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		boolean result = (boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		try {
			SOAPMessage msg = context.getMessage();
			PrintStream out = new PrintStream(System.out);
			msg.writeTo(out);
			out.println();
			FileOutputStream fout;
			if (result) {
				System.out.println("Outbound message response");
				fout = new FileOutputStream("response.xml");				
			} else {
				System.out.println("Inbound message request");
				fout = new FileOutputStream("request.xml");
			}
			msg.writeTo(fout);
		} catch (Exception e) {
			System.out.println("handleMessage: " + e);
		}

		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
