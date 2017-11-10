package User_Story_U2;

import java.io.File;
import java.util.ArrayList;

public class CourseList
{
	private CourseFileMgr fileListCourse;
	private ArrayList<Course> courseList;
	public CourseList()
	{
		fileListCourse = new CourseFileMgr();
		courseList  = new  ArrayList<>();
		if(fileListCourse.getFileCourseDirectory()!=null)
		{
			for(File file:fileListCourse.getFileCourseDirectory().listFiles())
			{
				courseList.add(new Course("./CourseList/"+file.getName()));
			}
		}
	}
	public ArrayList<Course> listCourse()
	{
		return courseList;
	}
	public ArrayList<String> getCourseIDList()
	{
		ArrayList<String> name = new ArrayList<>();
		for(Course n:courseList)
		{
			name.add(n.getCourseID());
		}
		return name;
	}
	public Course getCorseByCourseID(String name)
	{
		for(Course n:courseList)
		{
			if(n.getCourseID().contains(name.toLowerCase()))
				return n;
		}
		return null;
	}
}
