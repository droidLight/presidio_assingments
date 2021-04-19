package exthree;

import java.awt.Image;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MtomInterface {
	
	@WebMethod
	public Image getImage(String filePath)throws Exception;
	
	@WebMethod
	public void setImage(Image img, String path) throws Exception;
}
