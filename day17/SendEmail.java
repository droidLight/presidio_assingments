package day17;

import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;

public class SendEmail {
	
	public static void main(String[] args) {
		
		String from = "121003262@sastra.ac.in";
		String to = "sibinehru99@gmail.com";
		
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.ssl.enable", "true");
		properties.setProperty("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(properties, new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "IRONMAN!@#123");
            }

        });
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			message.setSubject("JavaMail API");
			message.setText("Test email sent using JavaMail API");
			
			Transport.send(message);
			System.out.println("email sent");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
