package exone;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@WebService(endpointInterface="exone.Hello", name="myhelloservice")
@HandlerChain(file = "exone-handler.xml")
public class HelloServiceImpl implements Hello{

	@Override
	public String sayHello(String name) {
		System.out.println("sayHello called...");
		return "Hello "+name+" from web service";
	}	
}
