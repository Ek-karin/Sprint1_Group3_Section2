package User_Story_U5;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import javax.swing.JOptionPane;

public class Mail {
	private static Properties props;
	private final String username = "studenttestmail284@gmail.com"; // ur email
	private final String password = "cs284284";
	//private static String recipient = "studentrecipient284@hotmail.com";
	//private static String recipient = "ppinggii@gmail.com";
	private MailPersisance mailPersis;

	public Mail() {
		props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		mailPersis = new MailPersisance();
		for(MailModel mail : mailPersis.getlist()) {
			sendMail(mail.getMail());
		}
	}

	public void sendMail(String Recipient) {
		try {
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			Message message = new MimeMessage(session);
			//message.setFrom(new InternetAddress("ppinggii@gmail.com"));// ur email
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Recipient));// u
			// will // to
			message.setSubject("Test Sender Message !");
			MimeBodyPart messageBodyPart1 = new MimeBodyPart();
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();

			// attached 1 --------------------------------------------
			JFileChooser jFileChooser = new JFileChooser(".");
			//jFileChooser.showOpenDialog(null);
			if(jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = jFileChooser.getSelectedFile();
			String description = "Open file below here";
			messageBodyPart1.setText(description);
			DataSource source = new FileDataSource(file);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(file.getName());
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);
			
			// ------------------------------------------------------

			message.setContent(multipart);

			Transport.send(message);
			JOptionPane.showMessageDialog(null, "Done");
			}

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
