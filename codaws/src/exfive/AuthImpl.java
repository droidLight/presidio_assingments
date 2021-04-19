package exfive;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import java.util.Map;
import java.util.List;

@WebService(endpointInterface = "exfive.AuthInterface")
public class AuthImpl implements AuthInterface{
	
	@Resource
	WebServiceContext ctx;
	
	@WebMethod
	@Override
	public String authUser() {
		
		MessageContext mctx = ctx.getMessageContext();
		Map httpHeader = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		
		List userList = (List) httpHeader.get("username");
		List passList = (List) httpHeader.get("password");
		
		String userName = null, password = null;
		
		if(userList != null)
			userName = userList.get(0).toString();
		if(passList != null)
			password = passList.get(0).toString();
		
		
		if(userName.equals("sibi") && password.equals("password")) {
			return "Welcome, "+userName;
		}else {
			return "unknown user";
		}
	}
	
}
