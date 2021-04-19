package exfour;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

public class MacAddressValidatorHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("handleMessage called...");

		boolean isRequest = (boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (!isRequest) {
			try {
				SOAPMessage soapMsg = context.getMessage();
				SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
				SOAPHeader soapHeader = soapEnv.getHeader();

				if (soapHeader == null) {
					soapHeader = soapEnv.addHeader();
					generateSOAPErrMessage(soapMsg, "No header found");
				}
				Iterator it = soapHeader.extractHeaderElements(SOAPConstants.URI_SOAP_ACTOR_NEXT);
				if (it == null || !it.hasNext())
					generateSOAPErrMessage(soapMsg, "Iterator null");

				Node macNode = (Node) it.next();
				String macValue = (macNode == null) ? null : macNode.getValue();

				if (macValue == null)
					generateSOAPErrMessage(soapMsg, "mac addr not found");
				if (!macValue.equals("90-4C-E5-44-B9-8F11111")) {
					generateSOAPErrMessage(soapMsg, "Invalid mac address, access is denied.");
				}
				
				// logging
				soapMsg.writeTo(System.out);
			} catch (Exception e) {
				System.out.println("handleMessage: " + e);
			}
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("handlefault");
		return false;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("getHeader");
		return null;
	}

	private void generateSOAPErrMessage(SOAPMessage msg, String reason) throws Exception {
		SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();
		SOAPFault soapFault = soapBody.addFault();
		soapFault.setFaultString(reason);
		throw new SOAPFaultException(soapFault);
	}

}
