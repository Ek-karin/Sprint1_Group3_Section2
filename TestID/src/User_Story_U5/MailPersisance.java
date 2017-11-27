package User_Story_U5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MailPersisance {
	
	private ArrayList<MailModel> mail;
	private final String FILE_PATH = "./mail/";
	private final String FILE_NAME = "emailClasslist";	
	private final String FILE_TYPE = ".csv";
	public MailPersisance() {
		mail = new ArrayList<>();
		readFile();
	}
	
	private void readFile() {
		try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH+FILE_NAME+FILE_TYPE))){
			String line = null;
			while((line = reader.readLine())!= null) {
				String s[] = line.split(",");
				if(s.length == 2) {
					try {
					mail.add(new MailModel(Long.parseLong(s[0]), s[1]));
					}catch(NumberFormatException e) {
						mail.add(new MailModel(0000000000, s[1]));
					}
				}
			}
		}
		catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public ArrayList<MailModel> getlist(){
		return mail;
	}

}
