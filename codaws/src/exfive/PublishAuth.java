package exfive;

import javax.xml.ws.Endpoint;

public class PublishAuth {

	public static void main(String[] args) throws Exception{
		
		Endpoint.publish("http://localhost:9000/ws/auth", new AuthImpl());
		System.out.println("Published auth service");
	}
}
