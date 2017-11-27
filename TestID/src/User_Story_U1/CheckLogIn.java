package User_Story_U1;

import java.io.File;

import User_Story_U2.CourseSelectionUI;






public class CheckLogIn {
	
	private AccountList accountList;
	
	public CheckLogIn() {
		accountList = new AccountList(new File("account.txt"));
	}
	public CheckLogIn(File file) {
		accountList = new AccountList(file);
	}
	
	public boolean checkId_Pass(String id,String pass) {
		int index = -1;
		for(int i = 0;i<accountList.size();i++) {
			if(accountList.get(i).getId().equals(id)) {
				index = i;
			}
		}
		if(index == -1) {
			return false; /// Can't not find with id.
		}
		else {
			if(accountList.get(index).getPassword().equals(pass)) {
				return true;
			}
			return false;
		}
	}
	
	public void nextStepBeforeCheck(boolean check) {
		if(check) {
			//new SelectCourseFrame();
			new CourseSelectionUI();
		}
		else {
			//System.out.println("Show massage invalid to Login panel");
		}
	}

}
