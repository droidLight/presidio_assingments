package exfour;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface TestInterface {

	@WebMethod
	public int tenTimes(int n);
}
