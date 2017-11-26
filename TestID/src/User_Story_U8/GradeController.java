package User_Story_U8;

import java.util.ArrayList;

import User_Story_U4.FillScorePersistanceForNetScore;
import User_Story_U6.Student;
import User_Story_U6.StudentPersistanceManager;

public class GradeController {

	 	private GradePersistance gradePersis;
	 	
	 	public GradeController(ArrayList<Student> stdPersis) {
			gradePersis = new GradePersistance(stdPersis);
			calculated();
			setGrade();
		}
	 	
	 	private void calculated() {
	 		gradePersis.calculated();
	 	}
	 	
	 	private void setGrade() {
	 		gradePersis.setGrade();
	 	}
	 	
	 	public ArrayList<Student> getList(){
	 		return gradePersis.getList();
	 	}
}
