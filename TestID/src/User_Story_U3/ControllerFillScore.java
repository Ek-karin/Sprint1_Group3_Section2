package User_Story_U3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Test_User_Story6.UploadController;
import User_Story_U1.LoginFrame;
import User_Story_U2.CheckCourseList;
import User_Story_U2.Course;
import User_Story_U2.CourseList;


public class ControllerFillScore {
	private CheckCourseList checkList;
	private Course course;
	private CourseList list;
	private int tempTotalScore,score,quiz,finalScore,mid;
	private final String FILE_PATH = "./StudentList/studentList";
	private final String FILE_TYPE = ".csv";
	
	public ControllerFillScore() {
		tempTotalScore = 0;
		checkList = new CheckCourseList();
		list = new CourseList();
	}
	public ControllerFillScore(Course course) {
		this.course = course;
		checkList = new CheckCourseList();
		list = new CourseList();
	}
	
	public boolean checkHaveScore(String courseID) {
		return checkList.checkFileHaveScore(courseID);
	}
	
	public boolean setScore(int score,int quiz,int mid,int finalScore) {
		if(checkFillScore(score, quiz, mid, finalScore)) {
			list.getCorseByCourseID(((Course)course).getCourseID()).setScore(mid, finalScore, quiz,score);
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean checkFillScore(int score,int quiz,int mid,int finalScore) {
		try {
			if(score < 0 || quiz < 0 || mid < 0 || finalScore < 0) {
				JOptionPane.showMessageDialog(null, "Invalid Data", "Warning", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			tempTotalScore = score+quiz+mid+finalScore;
			this.quiz = quiz;
			this.score = score;
			this.mid = mid;
			this.finalScore = finalScore;
			if(tempTotalScore < 100){
				JOptionPane.showMessageDialog(null, "Total Score less than 100 %", "Warning", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			if(tempTotalScore > 100){
				JOptionPane.showMessageDialog(null, "Total  Score more than 100 %");
			 return false;
			}
		}catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public boolean nextStepOkButton(Course course){
		JLabel label = new JLabel("Total score : "+tempTotalScore+"% [ "
		+"Homework : "+score+"%"+" Quiz : "+quiz+"%"+" Midterm : "+mid+"%"+" FinalExam : "+finalScore+"% ]",JLabel.CENTER);
		JOptionPane.showMessageDialog(null, label, course.getCourseID(), JOptionPane.DEFAULT_OPTION);
		try {
			FileInputStream stream = new FileInputStream(FILE_PATH+course.getCourseID()+FILE_TYPE);
		} catch (FileNotFoundException e) {
			System.out.println("Not have student data on this course please select student in [setting] menu before press [OK] menu");
			return false;
		}
		return true;
	}
	public void nextStepSettingButton(){
		try {
			new UploadController(course);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
