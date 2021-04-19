package exthree;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ReadClient {
	
	public static void main(String[] args) throws Exception{
		URL url = new URL("http://localhost:8090/ws/mtomimage?wsdl");
		QName qName = new QName("http://exthree/", "MtomImplService");
		Service service = Service.create(url, qName);
		
		MtomInterface mtom = service.getPort(MtomInterface.class);
		Image img = mtom.getImage("copy.jpg");
		
		File f = new File("C:\\users\\VC\\Documents\\get.jpg");
		BufferedImage bufferedImage = (BufferedImage)img;
		ImageIO.write(bufferedImage, "jpg", f);
		
		System.out.println("Image received");
	}
}
