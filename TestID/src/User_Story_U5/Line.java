package User_Story_U5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import User_Story_U2.Course;

public class Line implements Runnable
{
	private static final String strEndpoint = "https://notify-api.line.me/api/notify";
	private Course course;
	public Line(Course course) {
		this.course = course;
	}
	@Override
	public void run()
	{
		
		callEvent("9SmHQGowLz0VlRHNseuTOStdr9c93guWLo3moaRek2W", "Release The Kraken");
		/*callEvent("9SmHQGowLz0VlRHNseuTOStdr9c93guWLo3moaRek2W", "***ประกาศ !!! ***\nทางอาจารย์ได้ส่งเกรดประจำวิชา "
				+ course.getCourseID() +" "+course.getCourseName() + "เรียบร้อยเเล้ว !!@!\n");*/
		
	}
	public boolean callEvent(String token, String message) {
		boolean result = false;
		try {
			// File file = new File("./src/mailTest/account.txt"); กำหนดให้มันส่งลิ้งเเทน
			message = replaceProcess(message);
			message = URLEncoder.encode(message, "UTF-8");
			String strUrl = strEndpoint;
			URL url = new URL(strUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.addRequestProperty("Authorization", "Bearer " + token);
			connection.setRequestMethod("POST");
			connection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setDoOutput(true);
			String parameterString = new String("message=" + message);
			PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
			printWriter.print(parameterString);
			printWriter.close();

			connection.connect();

			int statusCode = connection.getResponseCode();
			if (statusCode == 200) {
				result = true;
			} else {
				throw new Exception("Error:(StatusCode)" + statusCode + ", " + connection.getResponseMessage());
			}
			connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	private String replaceProcess(String txt) {
		txt = replaceAllRegex(txt, "\\\\", "￥"); // \
		return txt;
	}

	private String replaceAllRegex(String value, String regex, String replacement) {
		if (value == null || value.length() == 0 || regex == null || regex.length() == 0 || replacement == null)
			return "";
		return Pattern.compile(regex).matcher(value).replaceAll(replacement);
	}

	
}