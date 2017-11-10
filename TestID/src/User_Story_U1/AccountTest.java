package User_Story_U1;

import java.io.File;

public class AccountTest {
	
	private AccountList al;
	
	public AccountTest() {
		al = new AccountList(new File("account.txt"));
		printTest();
	}
	
	public void printTest() {
		for(Account acc : al.getAccountList()) {
			System.out.println(acc.toString());
		}
	}

	public static void main(String[] args) {
		new AccountTest();
	}

}
