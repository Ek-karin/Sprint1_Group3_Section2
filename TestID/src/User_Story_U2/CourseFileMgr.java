package User_Story_U2;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CourseFileMgr
{
	private String FILE_DIRETORY_COURSE = "./CourseList";
	private File file;
	public CourseFileMgr()
	{
		file = new File(FILE_DIRETORY_COURSE);	
	}
	public File getFileCourseDirectory()
	{
		if(file.isDirectory())
			return file;
		else
		{
			return null;
		}
	}
	public CourseList courseList()
	{
		return new CourseList();
	}
}
