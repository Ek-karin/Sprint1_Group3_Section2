package User_Story_U2;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class CheckCourseList
{
	private CourseFileMgr courseFileMgr;
	private CourseList courseList;
	public CheckCourseList()
	{
		courseFileMgr = new CourseFileMgr();
		courseList =  courseFileMgr.courseList();
	}
	public boolean checkCourse(String name)
	{	
		ArrayList<String> nameList = new ArrayList<>();
		nameList = courseList.getCourseIDList();
		boolean check = false;
		for (String n : nameList)
		{
			if(n.contains(name.toLowerCase()))
				check = true;
		}
		return check;		
	}
	public boolean checkFileHaveScore(String courseID)
	{
		if(courseList.getCorseByCourseID(courseID).getMidTerm()==-1||
				courseList.getCorseByCourseID(courseID).getFinalTerm()==-1||courseList.getCorseByCourseID(courseID).getQuiz()==-1)
		{
			
			return false;
		}
		else
			return true;
		
	}
	public void setScore(int midTerm,int finalTerm,int quiz,int homeWork,String courseID)
	{
		if(checkCourse(courseID))
		{
			if(midTerm>-1&&finalTerm>-1&&quiz>-1)
			{
				courseList.getCorseByCourseID(courseID).setScore(midTerm, finalTerm, quiz,homeWork);
			}
			else
				System.out.println("Don't input less than 0");
			
		}
	}
}

