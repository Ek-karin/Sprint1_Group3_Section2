package Test_User_Story;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.Test;

import User_Story_U1.Account;
import User_Story_U1.AccountList;
import User_Story_U1.CheckLogIn;

public class Test_User_Story_U1 {

	@Test
	public void TestLogin(){
		Account id = new Account();
		Account pass = new Account();
		String testId= "parinya";
		String testPass = "5909610601";
		id.setId("parinya");
		pass.setPassword("5909610601");
		try{
		assertTrue("Eror",testId.equals(id.getId()));
		assertTrue("Eror",testPass.equals(pass.getPassword()));
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Wrong input ID or Password");
		}
	}
	@Test
	public void TestEmptyLogin() throws Exception{
		Account id = new Account();
		Account pass = new Account();
		String testId = "";
		String testPass = "";
		id.setId("parinya");
		pass.setPassword("5909610601");
		try{
		assertFalse("Eror",testId.equals(id.getId()));
		assertFalse("Eror",testPass.equals(pass.getPassword()));
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Wrong input ID or Password");
		}
	}
	@Test
	public void TestWrongUserLogin() throws Exception{
		Account id = new Account();
		Account pass = new Account();
		String testId ="Ekarin";
		String testPass = "5909610601";
		id.setId("parinya");
		pass.setPassword("5909610601");
		try{
		assertFalse("Eror",testId.equals(id.getId()));
		assertTrue("Eror",testPass.equals(pass.getPassword()));
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Wrong input ID or Password");
		}
	}
	@Test
	public void TestWrongPassLogin() throws Exception{
		Account id = new Account();
		Account pass = new Account();
		String testId ="parinya";
		String testPass = "5909680117";
		id.setId("parinya");
		pass.setPassword("5909610601");
		try{
		assertTrue("Eror",testId.equals(id.getId()));
		assertFalse("Eror",testPass.equals(pass.getPassword()));
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Wrong input ID or Password");
		}
	}
	@Test
	public void TestSpecialAlphabet() throws Exception{
		Account id = new Account();
		Account pass = new Account();
		String testId ="!@#$%^^&&";
		String testPass = "!#@$%^&**";
		id.setId("parinya");
		pass.setPassword("5909610601");
		try{
		assertFalse("Eror",testId.equals(id.getId()));
		assertFalse("Eror",testPass.equals(pass.getPassword()));
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Wrong input ID or Password");
		}
	}
	@Test
	public void TestSwapIdPassword() throws Exception{
		Account id = new Account();
		Account pass = new Account();
		String testId ="5909610601";
		String testPass = "parinya";
		id.setId("parinya");
		pass.setPassword("5909610601");
		try{
		assertFalse("Eror",testId.equals(id.getId()));
		assertFalse("Eror",testPass.equals(pass.getPassword()));
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Wrong input ID or Password");
		}
	}

}
