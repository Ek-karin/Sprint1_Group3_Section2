package User_Story_U4;

import java.util.ArrayList;

import User_Story_U6.Student;
import User_Story_U6.StudentPersistanceManager;

public class FillScorePersistanceForNetScore {
	
	private StudentPersistanceManager studentPersis;
	
	public FillScorePersistanceForNetScore(ArrayList<Student> student) {
		studentPersis = new StudentPersistanceManager(student);
	}
	
	public ArrayList<Integer> getStudentHomeWorkScore(){
		ArrayList<Integer> temp = new ArrayList<>();
		for(Student s : studentPersis.getList()) {
			temp.add(s.getHomework());
		}
		return temp;
	}
	
	public ArrayList<Integer> getStudentQuizScore(){
		ArrayList<Integer> temp = new ArrayList<>();
		for(Student s : studentPersis.getList()) {
			temp.add(s.getQuiz());
		}
		return temp;
	}
	
	public ArrayList<Integer> getStudentMidtermScore(){
		ArrayList<Integer> temp = new ArrayList<>();
		for(Student s : studentPersis.getList()) {
			temp.add(s.getMidtermScore());
		}
		return temp;
	}
	
	public ArrayList<Integer> getStudentFinalScore(){
		ArrayList<Integer> temp = new ArrayList<>();
		for(Student s : studentPersis.getList()) {
			temp.add(s.getFinalScore());
		}
		return temp;
	}
	
	public ArrayList<Integer> getStudentHomeworkNetScore(){
		ArrayList<Integer> temp = new ArrayList<>();
		for(Student s : studentPersis.getList()) {
			temp.add(s.getNetHomeworkScore());
		}
		return temp;
	}
	
	public ArrayList<Integer> getStudentQuizNetScore(){
		ArrayList<Integer> temp = new ArrayList<>();
		for(Student s : studentPersis.getList()) {
			temp.add(s.getNetQuizScore());
		}
		return temp;
	}
	
	public ArrayList<Integer> getStudentMidtermNetScore(){
		ArrayList<Integer> temp = new ArrayList<>();
		for(Student s : studentPersis.getList()) {
			temp.add(s.getNetMidtermScore());
		}
		return temp;
	}
	
	public ArrayList<Integer> getStudentFinalNetScore(){
		ArrayList<Integer> temp = new ArrayList<>();
		for(Student s : studentPersis.getList()) {
			temp.add(s.getNetFinalScore());
		}
		return temp;
	}

	public ArrayList<Student> getArrayList(){
		return studentPersis.getList();
	}

}
