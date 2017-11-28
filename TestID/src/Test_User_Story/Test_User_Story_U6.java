package Test_User_Story;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

import User_Story_U6.Student;


public class Test_User_Story_U6 {
	Student student =new Student();
	@Test
	public void TestPlusInteger() {
		try{
		assertTrue("error",student.getHomework()>=0);
		assertTrue("error",student.getFinalScore()>=0);
		assertTrue("error",student.getMidtermScore()>=0);
		assertTrue("error",student.getQuiz()>=0);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Eror Score please input intput number>=0");
		}
		
	}
	@Test
	public void TestMinusInteger() {
		try{
		assertFalse("error",student.getHomework()>0);
		assertFalse("error",student.getFinalScore()>0);
		assertFalse("error",student.getMidtermScore()>0);
		assertFalse("error",student.getQuiz()>0);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Eror Score please input intput number>=0");
		}
	}
	
	@Test
	public void InsertNull() throws Exception{
		student =null;
		assertFalse("error",student!=null) ;
	}
}