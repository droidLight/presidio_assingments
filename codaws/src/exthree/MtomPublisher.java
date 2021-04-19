package exthree;

import javax.xml.ws.Endpoint;

import exone.HelloServiceImpl;

public class MtomPublisher {
	public static void main(String[] args) throws Exception{
		
		Endpoint.publish("http://localhost:8090/ws/mtomimage", new MtomImpl());
		System.out.println("MTOM Image service published");
	}
}
