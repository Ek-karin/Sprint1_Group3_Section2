package User_Story_U2;


public class Test
{

	public static void main(String[] args)
	{
		Course c = new Course("src/CourseList/CS284.txt");
		Course c6 = new Course("src/CourseList/CS300.txt");
		System.out.println(c.getCourseID());
		System.out.println(c.getCourseName());
		CheckCourseList c2 = new CheckCourseList();
		System.out.println(c2.checkCourse("Cs284"));
		System.out.println(c2.checkCourse("Cs300"));
		System.out.println("Have Score ?  "+c2.checkFileHaveScore("cs284"));
		//c2.setScore(30, 45, 30, 10,"284");
		System.out.println("Have Score ?  "+c2.checkFileHaveScore("cs284"));
		CourseList l = new CourseList();
		System.out.println(l.getCorseByCourseID("cs284").getMidTerm());
		
		
		
		
	}

}
