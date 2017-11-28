package Test_User_Story;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import User_Story_U7.CalculateNetScoreThread;

public class Test_User_Story_U7 {
	CalculateNetScoreThread  cal ;
	@Test
	public void testConvertTRUE() {
		ArrayList<Integer> s = new ArrayList<>();
		try {
		s.add(100);
		s.add(95);
		s.add(94);
		s.add(90);
		s.add(60);
		s.add(50);
		s.add(0);
		cal = new CalculateNetScoreThread(s, 10, 100);
			   cal.run();
			  System.out.println(cal.getNetScoreThread());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue("error",e instanceof Exception);
			System.out.println("zreo2");
		}
	}
	@Test
	public void testConvertTRUE2() {
		ArrayList<Integer> s = new ArrayList<>();
		try {
		s.add(10);
		s.add(20);
		s.add(13);
		s.add(9);
		s.add(6);
		s.add(5);
		s.add(0);
		cal = new CalculateNetScoreThread(s, 10, 20);
			   cal.run();
			  System.out.println(cal.getNetScoreThread());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue("error",e instanceof Exception);
			System.out.println("zreo2");
		}
	}
	@Test
	public void testConvertTRUE3() {
		ArrayList<Integer> s = new ArrayList<>();
		try {
		s.add(10);
		s.add(9);
		s.add(4);
		s.add(0);
		s.add(6);
		s.add(5);
		s.add(0);
		cal = new CalculateNetScoreThread(s, 100, 10);
		 cal.run();
		 assertTrue("error", cal.finish);
			  System.out.println(cal.getNetScoreThread());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue("error",e instanceof Exception);
			System.out.println("zreo2");
		}
	}

}

