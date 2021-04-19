package exone;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class HelloClient {
	public static void main(String[] args) throws Exception{
		
		URL url = new URL("http://localhost:8080/ws/helloservice?wsdl");
		QName qName = new QName("http://exone/","HelloServiceImplService");

		Service service = Service.create(url, qName);
		Hello hello = service.getPort(Hello.class);
		System.out.println(hello.sayHello("sibi"));
	}
}
