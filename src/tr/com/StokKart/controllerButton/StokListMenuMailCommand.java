package tr.com.StokKart.controllerButton;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

import tr.com.StokKart.view.StokList;

public class StokListMenuMailCommand implements ICommand {
	
	private StokList stokList;
	
	
	
	public StokListMenuMailCommand(StokList stokList) {
		super();
		this.stokList = stokList;
	}



	@Override
	public void execute() {

		String mail = "javamailgonder@gmail.com";
		String sifre = "rkbpntywyyvhmnyy";
		String baslik = "Dosya";
		String dosya = "C:\\Users\\emrek\\Desktop\\excel\\report.pdf";
		String mail2 = JOptionPane.showInputDialog("Mail Adresinizi Giriniz");
		
		
		Properties properties = System.getProperties();
		Session session;
		MimeMessage mesaj;
		//Message
		properties.put("mail.smtp.auth", "true");

		properties.put("mail.smtp.starttls.enable", "true");

		properties.put("mail.smtp.host", "smtp.gmail.com");

		properties.put("mail.smtp.port", "587");

		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		session = Session.getInstance(properties,new Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(mail, sifre);
			}
			
		});
	
		
		
		mesaj = new MimeMessage(session);
		try {
			mesaj.setFrom(new InternetAddress(mail));
			mesaj.setRecipient(Message.RecipientType.TO, new InternetAddress(mail2));
			mesaj.setText(dosya);
			mesaj.setSubject(baslik);
								
			BodyPart attachment = new MimeBodyPart();
			attachment.setDataHandler(new DataHandler (new FileDataSource(dosya)));
			attachment.setFileName("reports.pdf");
			
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(attachment);
			
			mesaj.setContent(multipart);

			Transport.send(mesaj);
			
			JOptionPane.showMessageDialog(null, "Mail Gönderildi");
		} catch (AddressException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
	}

}
