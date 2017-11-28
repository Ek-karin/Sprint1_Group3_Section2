package Test_User_Story;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import User_Story_U2.Course;
import User_Story_U3.ControllerFillScore;
import User_Story_U4.FillScoreController;
import User_Story_U4.MaxScoreLessThanZero;
import User_Story_U4.StudentNumberFormatException;
import User_Story_U4.StudentScoreLessThanZero;
import User_Story_U4.StudentScoreMoreThanMax;
import User_Story_U7.CalculateNetScore;

public class Test_User_Story_U4 {
	String cs284 = "cs284";
	Course course = new Course(cs284);
	ControllerFillScore setmax = new ControllerFillScore();
	FillScoreController u4 = new FillScoreController(course);
	String max = "100";
	
	@Test
	public void testcase1() throws StudentNumberFormatException, StudentScoreLessThanZero, StudentScoreMoreThanMax,MaxScoreLessThanZero {
		course.setMaxRawScore(100, 100, 100, 100);
		try{
			String num ="1";
			Object number = u4.checkScore(num, max);
		
		}catch (Exception e) {
			// TODO: handle exception
			assertTrue("Input less than zero",e instanceof StudentScoreMoreThanMax);
		
		}
	}
	@Test
	public void testcase2() throws StudentNumberFormatException, StudentScoreLessThanZero, StudentScoreMoreThanMax, MaxScoreLessThanZero{
		try{
			String num ="0";
			Object number = u4.checkScore(num, max);
				
		}catch (Exception e) {
			// TODO: handle exception
			assertTrue("Input less than zero",e instanceof StudentScoreMoreThanMax);
		}
	}
	@Test
	public void testcase3() {
		
		try{
		String num ="-1";
		Object number =u4.checkScore(num,max);
		fail("Except less than zero");
		}catch(Exception e){
			assertTrue("Input less than zero", e instanceof StudentScoreLessThanZero);
		}
	}
	@Test
	public void testcase4() {
		try{

		String num ="a";
		Object number =u4.checkScore(num,max);
		fail("Except numberformat");
		}
		catch (Exception e) {
			// TODO: handle exception
			assertTrue("Input Integer",e instanceof StudentNumberFormatException);
		}
		
	}
	@Test
	public void testcase5() {
		try{

		String num ="@";
		Object number =u4.checkScore(num,max);
		fail("Except numberformat");
		}
		catch (Exception e) {
			// TODO: handle exception
			assertTrue("Input Integer",e instanceof StudentNumberFormatException);
	}
}
	@Test
	public void testcase6() {
		try{

			String num ="45g";
			Object number =u4.checkScore(num,max);
			fail("Except numberformat");
			}
			catch (Exception e) {
				// TODO: handle exception
				assertTrue("Input Integer",e instanceof StudentNumberFormatException);
		}
		}
	@Test
	public void testcase7() {
		try{
			String num =null;

			Object number =u4.checkScore(num,max);
			fail("Except numberformat");
			}
			catch (Exception e) {
				// TODO: handle exception
				assertTrue("Input Integer",e instanceof StudentNumberFormatException);
		}
		}
	@Test
	public void testcase8() {
		try{
			String num ="0.3";
			Object number =u4.checkScore(num,max);
			fail("Except numberformat");
			}
			catch (Exception e) {
				// TODO: handle exception
				assertTrue("Input Integer",e instanceof StudentNumberFormatException);
		}
		}
	@Test
	public void testcase9() {								   	
		
		try{	
			String num ="10000000000";
			Object number = u4.checkScore(num,max);
			fail("Except numberformat");
		}catch (Exception e) {
			// TODO: handle exception
			assertTrue("Input Integer",e instanceof StudentNumberFormatException);
		}
	}
	@Test
	public void testcase10()  {
		try{
			
			String num ="10";
			Object number = u4.checkScore(num,max);

		}
		catch (Exception e) {
			// TODO: handle exception
			assertTrue("Input Integer",e instanceof StudentScoreMoreThanMax);
			System.out.println("zero");
		}

		}

}
