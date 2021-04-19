package exfive;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AuthClient {
	
	public static void main(String[] args) throws Exception{
		
		final String URL_WS = "http://localhost:9000/ws/auth?wsdl";  
		URL url = new URL(URL_WS);
		QName qName = new QName("http://exfive/", "AuthImplService");
		
		Service service = Service.create(url, qName);
		
		AuthInterface auth = service.getPort(AuthInterface.class);
		Map<String, Object> reqCtx = ((BindingProvider) auth).getRequestContext();
		
		reqCtx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, URL_WS);
		
		Map<String, List<String>> header = new HashMap();
		
		
		header.put("username", Collections.singletonList("sibi"));
		header.put("password", Collections.singletonList("password"));
		
		reqCtx.put(MessageContext.HTTP_REQUEST_HEADERS, header);
		
		System.out.println(auth.authUser());
	}
}
