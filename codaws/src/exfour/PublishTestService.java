package exfour;

import javax.xml.ws.Endpoint;

public class PublishTestService {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9010/ws/testservice", new TestImpl());
		System.out.println("Published test service");
	}
}
