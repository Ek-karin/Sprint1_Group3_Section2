package Test_User_Story6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;

public class UploadController {
	
	public UploadController() throws IOException {
		JFileChooser fileChooser = new JFileChooser(".");
		if(fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {			
			new StudentPersistanceManager(fileChooser.getSelectedFile());
		};
	}
	
	public static void main(String[] args) throws IOException {
		new UploadController();
		

	}

}
