package exfour;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TestClient {
	
	public static void main(String[] args) throws Exception{
		
		URL url = new URL("http://localhost:9010/ws/testservice?wsdl");
		QName qName = new QName("http://exfour/", "TestImplService");
		
		Service service = Service.create(url, qName);
		
		TestInterface test = service.getPort(TestInterface.class);
		System.out.println(test.tenTimes(10));
	}
}
