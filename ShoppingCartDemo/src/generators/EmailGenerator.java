package generators;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import models.Invoice;

public class EmailGenerator implements Generator, Cloneable {

	private static EmailGenerator instance;
	Invoice invoice;
	String subject, body, toAddress;
	
	private EmailGenerator() {}
	
	private EmailGenerator getClone() {
		EmailGenerator obj = null;
		try {
			obj = (EmailGenerator) super.clone();
		}catch(Exception e) {
			System.out.println("EmailGenerator: "+e);
		}
		return obj;
	}
	
	public static EmailGenerator getInstance(String toAddress, String subject, String body) {
		if(instance == null)
			instance = new EmailGenerator();
		EmailGenerator temp = instance.getClone();
		temp.toAddress = toAddress;
		temp.subject = subject;
		temp.body = body;
		return temp;
	}
	
	@Override
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@Override
	public String execute(String path) throws Exception {
		Generator generator;

		// generating pdf and spreadsheets
		generator = PdfGenerator.getInstance();
		generator.setInvoice(invoice);
		String pdfPath = generator.execute(path);

		generator = SpreadsheetGenerator.getInstance();
		generator.setInvoice(invoice);
		String sheetPath = generator.execute(path);

		// sending email
		String from = "121003262@sastra.ac.in";
		String password = "IRONMAN!@#123";

		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.ssl.enable", "true");
		properties.setProperty("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		// subject and body
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(RecipientType.TO, new InternetAddress(toAddress));
		message.setSubject(subject);

		// email body
		BodyPart messageBody = new MimeBodyPart();
		messageBody.setText(body);
		
		// pdf attachment
		MimeBodyPart pdfAttach = new MimeBodyPart();
		DataSource dataSource = new FileDataSource(pdfPath);
		pdfAttach.setDataHandler(new DataHandler(dataSource));
		pdfAttach.setFileName("invoice.pdf");

		// spreadsheet attachment
		MimeBodyPart sheetAttach = new MimeBodyPart();
		dataSource = new FileDataSource(sheetPath);
		sheetAttach.setDataHandler(new DataHandler(dataSource));
		sheetAttach.setFileName("invoice.xls");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBody);
		multipart.addBodyPart(pdfAttach);
		multipart.addBodyPart(sheetAttach);

		message.setContent(multipart);
		Transport.send(message);
		System.out.println("email sent");

		return path;
	}

}
