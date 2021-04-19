package exfour;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="exfour.TestInterface")
@HandlerChain(file="exfour-handler.xml")
public class TestImpl implements TestInterface{

	@WebMethod
	@Override
	public int tenTimes(int n) {
		System.out.println("multiplying by 10....");
		return n * 10;
	}
	
}
