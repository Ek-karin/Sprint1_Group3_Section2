package User_Story_U5;


import java.io.File;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;

public class Mail {
	private static Properties props;
	private final String username = "studenttestmail284@gmail.com"; // ur email
	private final String password = "cs284284";
	private static String recipient = "ppinggii@gmail.com";

	public static void main(String[] agrs) {

		props = new Properties();
		if (recipient.contains("@gmail")) {
			props.put("mail.smtp.auth", true);
			props.put("mail.smtp.starttls.enable", true);
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
		}else{
			props.put("mail.smtp.auth", true);
			props.put("mail.smtp.starttls.enable", true);
			props.put("mail.smtp.host", "smtp.live.com");
			props.put("mail.smtp.port", "25");
		}
		Mail m = new Mail();
		m.sendMail(recipient);
	}

	public void sendMail(String Recipient) {
		try {
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ppinggii@gmail.com"));// ur email
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Recipient));// u
			// will // to
			message.setSubject("ทดสอบการส่ง e-mail นะครับนะ");
			message.setText("นี่คือการเทสนะครับผม");
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();

			// attached 1 --------------------------------------------
			JFileChooser jFileChooser = new JFileChooser(".");
			jFileChooser.showOpenDialog(null);
			File file = jFileChooser.getSelectedFile();
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(file);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(file.getName());
			multipart.addBodyPart(messageBodyPart);
			// ------------------------------------------------------
			message.setDescription("นี่คือการเทสนะครับผม");
			message.setContent(multipart);

			System.out.println("sending");
			Transport.send(message);
			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
