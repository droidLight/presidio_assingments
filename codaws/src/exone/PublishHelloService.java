package exone;

import javax.xml.ws.Endpoint;

public class PublishHelloService {
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/ws/helloservice", new HelloServiceImpl());
		System.out.println("Hello service published");
	}
}
