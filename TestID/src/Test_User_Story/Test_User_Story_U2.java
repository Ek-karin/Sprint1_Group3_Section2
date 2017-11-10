package Test_User_Story;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_User_Story_U2 {
	private String s1[] ={"cs211","cs248"};
	@Test
	public void TestInputCourse() throws Exception{
		String sub= "cs211";
		assertTrue("Error",s1[0].equals(sub));
	}

	@Test
	public void TestInputWrongCourse() throws Exception{
		String sub= "cs213";
		assertFalse("Error",s1[0].equals(sub));
	}
}
