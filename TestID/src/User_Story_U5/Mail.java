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
	private static String recipient = "ppinggii@gmail.com";
	private MailPersisance mailPersis;

	public Mail() {
		props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		mailPersis = new MailPersisance();
		sendMail(recipient);
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
			for(MailModel m : mailPersis.getlist()) {
				message.setFrom(new InternetAddress(m.getMail()));
			}
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Recipient));// u
			// will // to
			message.setSubject("เธ—เธ”เธชเธญเธ�เธ�เธฒเธฃเธชเน�เธ� e-mail เธ�เธฐเธ�เธฃเธฑเธ�เธ�เธฐ");
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();

			// attached 1 --------------------------------------------
			JFileChooser jFileChooser = new JFileChooser(".");
			//jFileChooser.showOpenDialog(null);
			if(jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = jFileChooser.getSelectedFile();
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(file);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(file.getName());
			String description = "เธ�เธตเน�เธ�เธทเธญเธ�เธฒเธฃเน€เธ—เธชเธ�เธฐเธ�เธฃเธฑเธ�เธ�เธก";
			messageBodyPart.setText(description);
			multipart.addBodyPart(messageBodyPart);
			
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
