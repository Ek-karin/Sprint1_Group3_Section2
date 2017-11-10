package User_Story_U1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AccountList {
	
	private ArrayList<Account> accountList;
	
	public AccountList() {
		accountList = new ArrayList<>();
	}
	
	public AccountList(File file) {
		accountList = new ArrayList<>();
		creatAccount(file);
	}
	
	public ArrayList<Account> getAccountList() {
		return accountList;
	}
	
	public void creatAccount(File file) {
		try(BufferedReader buffer = new BufferedReader(new FileReader(file))
				){
					String line="";
					while((line = buffer.readLine())!=null) {
						try {
						String account[] = line.split("\\s+");
						accountList.add(new Account(account[0], account[1], account[2]));
						}
						catch(ArrayIndexOutOfBoundsException arrayException) {
							continue; //Skip to read next line.
						}
						
					}
				}catch(FileNotFoundException e) {
					
				}catch(IOException e1) {
					
				}
	}
	
	public Account get(int index) {
		return accountList.get(index);
	}
	
	public int size() {
		return accountList.size();
	}

}
