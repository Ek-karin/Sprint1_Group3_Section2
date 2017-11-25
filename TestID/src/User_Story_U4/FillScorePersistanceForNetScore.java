package User_Story_U4;

import java.util.ArrayList;

import User_Story_U6.Student;

public class FillScorePersistanceForNetScore {
	
	private ArrayList<Student> student;
	
	public FillScorePersistanceForNetScore(ArrayList<Student> student) {
		this.student = student;
	}
	
	public ArrayList<Integer> getStudentHomeWorkScore(){
		ArrayList<Integer> temp = new ArrayList<>();
		for(Student s : student) {
			temp.add(s.getHomework());
		}
		return temp;
	}
	
	public ArrayList<Integer> getStudentQuizScore(){
		ArrayList<Integer> temp = new ArrayList<>();
		for(Student s : student) {
			temp.add(s.getQuiz());
		}
		return temp;
	}
	
	public ArrayList<Integer> getStudentMidtermScore(){
		ArrayList<Integer> temp = new ArrayList<>();
		for(Student s : student) {
			temp.add(s.getMidtermScore());
		}
		return temp;
	}
	
	public ArrayList<Integer> getStudentFinalScore(){
		ArrayList<Integer> temp = new ArrayList<>();
		for(Student s : student) {
			temp.add(s.getFinalScore());
		}
		return temp;
	}
	
	public ArrayList<Student> getArrayList(){
		return student;
	}

}
