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

import User_Story_U2.CheckCourseList;
import User_Story_U2.Course;
import User_Story_U5.Mail;
import User_Story_U5.WriteFileXLSX;
import User_Story_U6.Student;
import User_Story_U7.CalculateNetScore;
import User_Story_U8.GradeController;
import User_Story_U8.NormReferenced;



public class FillScoreController {
	
	private ArrayList<Student> studentList;
	private Course course;
	private FillScorePresistance persis;

	public FillScoreController(Course course) {
		studentList = new ArrayList<>();
		this.course = course;
		persis = new FillScorePresistance(course);
	}
	
	public int checkScore(String str,String type) throws StudentNumberFormatException, StudentScoreLessThanZero, StudentScoreMoreThanMax{
		try{
			int checkMax[] = new int[] {course.getMaxRawScoreHomeWork(),course.getMaxRawScoreQuiz(),course.getMaxRawScoreMidTerm(),course.getMaxRawScoreFinalTerm()};
			String temp[] = new String[] {"Homework","Quiz","Midterm","Final"};
			int index = 0;
			for(int i = 0;i < temp.length ;i++) {
				if(type.equalsIgnoreCase(temp[i])) {
					index = i;
					break;
				}
			}
			int score = Integer.parseInt(str);
			if(score < 0){
				throw new StudentScoreLessThanZero();
			}
			else {
					if(score > checkMax[index]){
						throw new StudentScoreMoreThanMax();
					}
					else {
						return score;
					}
			}
		}catch(NumberFormatException e){
			throw new StudentNumberFormatException();
		}
	}
	
	public int checkMaxScore(int temp) throws MaxScoreLessThanZero {
		if(temp < 0) {
			throw new MaxScoreLessThanZero();
		}
		
		return temp;
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
					if(j >= 3 && j < 7){
						temp = checkScore(table.getValueAt(i, j).toString(),table.getColumnName(j));
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
				catch (StudentScoreMoreThanMax e) {
					listFail+=student.getStudentID()+" : "+e.getMessage()+System.lineSeparator();
					check =false;
				}
				catch(StudentScoreLessThanZero e){
					listFail+=student.getStudentID()+" : "+e.getMessage()+System.lineSeparator();
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
	
	public void setMaxScore(JTable table) {
		int homeMax = 0;
		int quizMax = 0;
		int midMax = 0;
		int finalMax = 0;
		String error = "";
		for(int i = 0;i<table.getRowCount();i++) {
			for(int j = 0; j < table.getColumnCount();j++) {
				try {
					int temp = checkMaxScore((int) table.getValueAt(i, j));
					if(j == 0)
						homeMax = temp;
					if(j == 1)
						quizMax = temp;
					if(j == 2)
						midMax = temp;
					if(j == 3)
						finalMax = temp;
				} catch (MaxScoreLessThanZero e) {
					error+=table.getColumnName(j)+" "+e.getMessage()+System.lineSeparator();
				}	
			}
		}
		if(!error.isEmpty()) {
			JTextArea text = new JTextArea(error);
			text.setEditable(false);
			JPanel fail = new JPanel(new BorderLayout());
			fail.setPreferredSize(new Dimension(300, 150));
			fail.add(new JScrollPane(text));
			JOptionPane.showMessageDialog(null, fail, "List Fail", JOptionPane.DEFAULT_OPTION);
		}
		course.setMaxRawScore(midMax, finalMax, quizMax, homeMax);
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
		CalculateNetScore calHomework = new CalculateNetScore(f.getStudentHomeWorkScore(), course.getHomeWork(), course.getMaxRawScoreHomeWork());
		CalculateNetScore calQuiz = new CalculateNetScore(f.getStudentQuizScore(), course.getQuiz(), course.getMaxRawScoreQuiz());
		CalculateNetScore calMidterm = new CalculateNetScore(f.getStudentMidtermScore(), course.getMidTerm(), course.getMaxRawScoreMidTerm());
		CalculateNetScore calFinal = new CalculateNetScore(f.getStudentFinalScore()	, course.getFinalTerm(), course.getMaxRawScoreFinalTerm());
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
		studentList = persis.setMaxScore(studentList, homeworkNet, quizNet, midtermNet, finalNet);
	}
	
	public void nextStep(String what_do_you_want) {
		if(what_do_you_want.equalsIgnoreCase("calgrade")) {
			GradeController grade = new GradeController(studentList);
			studentList = grade.getList();
			JOptionPane.showMessageDialog(null, "Calculated grade complete.");
			wrtieFileCSV();
		}
		if(what_do_you_want.equalsIgnoreCase("export")) {
			studentList = persis.getList();
			if(studentList.get(0).getGrade() == null) {
				JOptionPane.showMessageDialog(null, "Please Calculated Grade before.");
			}else {
				WriteFileXLSX write = new WriteFileXLSX(course, studentList);
			}
		}
		if(what_do_you_want.equalsIgnoreCase("send")) {
			if(studentList.get(0).getGrade() == null) {
				JOptionPane.showMessageDialog(null, "Please Calculated Grade before.");
			}
			else {
				new Mail();
			}
		}
		
	}
	
}
