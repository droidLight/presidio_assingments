package exthree;

import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class WriteClient {
	
	public static void main(String[] args) throws Exception{
		
		URL url = new URL("http://localhost:8090/ws/mtomimage?wsdl");
		QName qName = new QName("http://exthree/", "MtomImplService");
		
		Service service = Service.create(url, qName);
		
		MtomInterface mtom = service.getPort(MtomInterface.class);
		BindingProvider bp = (BindingProvider) mtom;
		SOAPBinding binding = (SOAPBinding) bp.getBinding();
		binding.setMTOMEnabled(true);
		
		Image img = ImageIO.read(new File("C:\\users\\VC\\Documents\\test.jpg"));
		mtom.setImage(img, "copy.jpg");
		System.out.println("Image sent");
	}
}
