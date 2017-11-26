package User_Story_U8;

import java.util.ArrayList;

import User_Story_U4.FillScorePersistanceForNetScore;
import User_Story_U6.Student;
import User_Story_U6.StudentPersistanceManager;

public class GradePersistance {
	
	private StudentPersistanceManager stdPersis;
	private NormReferenced norm;
 	private FillScorePersistanceForNetScore fill;
 	
 	public GradePersistance(ArrayList<Student> list) {
		stdPersis = new StudentPersistanceManager(list);
		fill = new FillScorePersistanceForNetScore(list);
	}
 	
 	public void calculated() {
 		norm = new NormReferenced(fill.getStudentMidtermNetScore(), fill.getStudentFinalNetScore(), fill.getStudentQuizNetScore(), fill.getStudentHomeworkNetScore());
 	}
 	
 	public void setGrade() {
 		for(int i = 0 ; i < stdPersis.getList().size();i++) {
 			stdPersis.getList().get(i).setGrade(norm.getGrade().get(i));
 		}
 	}
 	
 	public ArrayList<Student> getList(){
 		return stdPersis.getList();
 	}

}
