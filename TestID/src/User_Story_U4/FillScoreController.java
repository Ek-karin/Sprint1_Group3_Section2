package User_Story_U4;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.Timer;

import Test_User_Story6.Student;
import User_Story_U2.Course;
import User_Story_U7.CalculateNetScore;



public class FillScoreController {
	
	private ArrayList<Student> studentList;
	private Course course;
	private FillScorePresistance persis;
	
	public FillScoreController(Course course) {
		studentList = new ArrayList<>();
		this.course = course;
		persis = new FillScorePresistance(course);
	}
	
	public int checkScore(String str) throws StudentNumberFormatException, StudentScoreLessThanZero{
		try{
			int score = Integer.parseInt(str);
			if(score < 0){
				throw new StudentScoreLessThanZero();
			}
			return score;
		}catch(NumberFormatException e){
			throw new StudentNumberFormatException();
		}
	}
	
	public void setScore(JTable table) {
		studentList.clear();
		String listFail = "";
		boolean check = true;
		for(int i = 0;i < table.getRowCount();i++) {
			Student student = new Student();
			for(int j = 0;j < table.getColumnCount();j++) {
				try{
					int temp = 0;
					if(j >= 3){
						temp = checkScore(table.getValueAt(i, j).toString());
					}
				 	if(j==0)
				 		student.setIndex(Integer.parseUnsignedInt(table.getValueAt(i, j).toString()));
					if(j==1)
						student.setStudentID((long)table.getValueAt(i, j));
					if(j==2)
						student.setName((String)table.getValueAt(i, j));
					if(j==3){
							student.setHomework(temp);
					}
					if(j==4)
							student.setQuiz(temp);
					if(j==5)
							student.setMidtermScore(temp);
					if(j==6)
							student.setFinalScore(temp);
					if(j==7)
						student.setCredit((String)table.getValueAt(i, j));
				}catch(StudentNumberFormatException e){
					listFail+=student.getStudentID()+" : "+e.getMessage()+System.lineSeparator();
					check = false;
				}
				catch(StudentScoreLessThanZero temp){
					listFail+=student.getStudentID()+" : "+temp.getMessage()+System.lineSeparator();
					check =false;
					//JOptionPane.showMessageDialog(null, temp.getMessage());
				}
			}
			studentList.add(student);
		}
		if(!check){
			JTextArea text = new JTextArea(listFail);
			text.setEditable(false);
			JPanel error = new JPanel(new BorderLayout());
			error.setPreferredSize(new Dimension(300, 150));
			error.add(new JScrollPane(text));
			JOptionPane.showMessageDialog(null, error, "List Fail", JOptionPane.DEFAULT_OPTION);
		}
	}
	
	public void wrtieFileCSV() {
		try {
			persis.writeTextFile(course, studentList);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void readFileCSV() {
		persis.readFileScore();
	}
	
	public JTable showTable() {
		persis.setJTable();
		return persis.getTable();
	}
	
	public JTable getTable() {
		return persis.getTable();
	}
	
	public void calculatedNetScore() {
		FillScorePersistanceForNetScore f = new FillScorePersistanceForNetScore(studentList);
		CalculateNetScore calHomework = new CalculateNetScore(f.getStudentHomeWorkScore(), course.getHomeWork(), 10);
		CalculateNetScore calQuiz = new CalculateNetScore(f.getStudentQuizScore(), course.getQuiz(), 20);
		CalculateNetScore calMidterm = new CalculateNetScore(f.getStudentMidtermScore(), course.getMidTerm(), 30);
		CalculateNetScore calFinal = new CalculateNetScore(f.getStudentFinalScore()	, course.getFinalTerm(), 40);
		ArrayList<Integer> homeworkNet = null;
		ArrayList<Integer> quizNet = null;
		ArrayList<Integer> midtermNet = null;
		ArrayList<Integer> finalNet = null;
		while(true) {
			try {
				homeworkNet = calHomework.getNetScore();
				quizNet = calQuiz.getNetScore();
				midtermNet = calMidterm.getNetScore();
				finalNet = calFinal.getNetScore();
				break;
			} catch (Exception e) {
				
			}
		}
		for(int i = 0;i<studentList.size();i++) {
			System.out.println("["+studentList.get(i).getStudentID()+" : HomeworkNet: "+homeworkNet.get(i)+" QuizNet: "+quizNet.get(i)
			+" MidtermNet: "+midtermNet.get(i)+" FinalNet: "+finalNet.get(i)+"]");
		}
	}
	
}
