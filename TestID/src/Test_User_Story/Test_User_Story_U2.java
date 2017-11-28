package Test_User_Story;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

import User_Story_U2.CourseList;

public class Test_User_Story_U2 {
	CourseList cl =new CourseList();
	@Test
	public void TestInputCourse() throws Exception{
		String sub= "cs284";
		try{
		assertTrue("Error",cl.getCourseIDList().get(0).equals(sub));
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Course not found!!");
		}
	}

	@Test
	public void TestInputWrongCourse() throws Exception{
		String sub= "cs213";
		try{
		assertFalse("Error",cl.getCourseIDList().get(0).equals(sub));
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Course not found!!");
		}
	}
}
