package Test_User_Story;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_User_Story_U3 {
	@Test
	public void TestPlusInteger() {
		int po = 1;
		assertTrue("error",po>0);
	}
	@Test
	public void TestMinusInteger() {
		int po1 =-1;
		assertFalse("error",po1>0);
	}
	
	@Test
	public void InsertNull() throws Exception{
		Integer x = null;
		assertFalse("error",x!=null) ;
	}
}