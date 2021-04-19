package exthree;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService(endpointInterface="exthree.MtomInterface")
public class MtomImpl implements MtomInterface{

	@WebMethod
	@Override
	public Image getImage(String filePath) throws Exception {
		File img = new File(filePath);
		return ImageIO.read(img);
	}

	@WebMethod
	@Override
	public void setImage(Image img, String path) throws Exception {
		
		try {
			File f = new File(path);
			BufferedImage bufferedImage = (BufferedImage)img;
			ImageIO.write(bufferedImage, "jpg", f);
		}catch(Exception e) {
			System.out.println("setImage: "+e);
		}
	}
	
}
