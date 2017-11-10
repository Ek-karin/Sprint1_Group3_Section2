package User_Story_U2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Course
{
	private int midTerm=-1,finalTerm=-1,quiz=-1,homeWork = -1;
	private File file;
	public Course(String fileName)
	{
		file = new File(fileName);	
	}
	private String getDetailWithKeyWord(String keyWord)
	{
		String str;
		try(BufferedReader b = new BufferedReader(new FileReader(file)))
		{
			while((str = b.readLine())!=null)
			{
				if(str.contains(keyWord))
				{
					String s[];
					s = str.split(",");
					return s[1];
				}
			}
		} catch (Exception e)
		{
			return null;
		}
		return null;
	}
	private boolean courseHaveScore()
	{
		if(getDetailWithKeyWord("Score")!=null)
		{
			String str;
			try(BufferedReader b = new BufferedReader(new FileReader(file)))
			{
				while((str = b.readLine())!=null)
				{
					if(str.contains("Score"))
					{
						String s[];
						
						s = str.split(",");
						String p[]= new String[s.length-1];
						if(s.length!=0)
						{			
							for (int i = 1; i < s.length; i++)
							{
								p[i-1] = s[i];
							}
						}	
						midTerm = Integer.parseInt(p[0]);
						finalTerm = Integer.parseInt(p[1]);
						quiz = Integer.parseInt(p[2]);
						homeWork = Integer.parseInt(p[3]);
					}
				}
			} catch (Exception e)
			{
	
			}	
			return true;
		}
		else
			return false;
	}
	public void printDetailCourse()
	{
		String str = "";
		try(BufferedReader b = new BufferedReader(new FileReader(file)))
		{
			while((str = b.readLine())!=null)
			{
				System.out.println(str);
			}
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	public String getCourseID()
	{
		return getDetailWithKeyWord("ID");
	}
	public String getCourseName()
	{
		return getDetailWithKeyWord("NameCourse");
	}
	public String[] getProfessor()
	{
		String str;
		try(BufferedReader b = new BufferedReader(new FileReader(file)))
		{
			while((str = b.readLine())!=null)
			{
				if(str.contains("Professor."))
				{
					String s[];
					
					s = str.split(",");
					if(s.length!=0)
					{		
						String p[]= new String[s.length-1];
						for (int i = 1; i < s.length; i++)
						{
							p[i-1] = s[i];
						}
						return p;
					}	
				}
			}
		} catch (Exception e)
		{
			return null;
		}
		return null;
	}
	public void setScore(int midTerm,int finalTerm,int quiz,int homeWork)
	{
		ArrayList<String> str = new ArrayList<>();
		String line;
		try(BufferedReader b = new BufferedReader(new FileReader(file)))
		{
			while((line = b.readLine())!=null)
			{
				str.add(line);
			}
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		try (BufferedWriter b = new BufferedWriter(new FileWriter(file));)
		{
			for(String s:str)
			{
				if(!s.contains("Score,"))
				{
					b.write(s+"\n");
				}			
			}
			b.write("Score,"+midTerm+","+finalTerm+","+quiz+","+homeWork);
		}
		catch (Exception e) {
			// TODO: handle exception
		}						
	}	
	
	public int getMidTerm()
	{
		if(courseHaveScore())
		{
			return midTerm;
		}
		return -1;
	}
	public int getFinalTerm()
	{
		if(courseHaveScore())
		{
			return finalTerm;
		}
		return -1;
	}
	public int getQuiz()
	{
		if(courseHaveScore())
		{
			return quiz;
		}
		return -1;
	}
	public int getHomeWork()
	{
		if(courseHaveScore())
		{
			return homeWork;
		}
		return -1;
	}
	
}
