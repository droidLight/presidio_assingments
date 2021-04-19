package exfive;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface AuthInterface {
	@WebMethod
	public String authUser();
}
