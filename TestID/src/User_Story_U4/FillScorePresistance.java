package User_Story_U4;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Test_User_Story6.Student;
import User_Story_U2.Course;



public class FillScorePresistance {
	private ArrayList<Student> list;
	private String textList;
	private JTable jTable;
	private Course course;
	private final String FILE_PATH = "./StudentList/studentList";
	private final String FILE_TYPE[] = {".csv",".txt"};
	
	public FillScorePresistance(Course course) {
		this.course = course;
		list = new ArrayList<>();
		textList ="";
	}
	

	public void writeTextFile(Course course,ArrayList<Student> studentList) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH+course.getCourseID()+FILE_TYPE[1]));
		for (int i = 0; i < studentList.size(); i++) {
			bufferedWriter.write(studentList.get(i).toString() + "\n");
		}
		bufferedWriter.close();
		BufferedWriter bufferedWritercsv = new BufferedWriter(new FileWriter(FILE_PATH+course.getCourseID()+FILE_TYPE[0]));
		for(Student student : studentList) {
			bufferedWritercsv.append(String.valueOf(student.getIndex()));
			bufferedWritercsv.append(",");
			bufferedWritercsv.append(String.valueOf(student.getStudentID()));
			bufferedWritercsv.append(",");
			bufferedWritercsv.append(student.getName());
			bufferedWritercsv.append(",");
			bufferedWritercsv.append(String.valueOf(student.getHomework()));
			bufferedWritercsv.append(",");
			bufferedWritercsv.append(String.valueOf(student.getQuiz()));
			bufferedWritercsv.append(",");
			bufferedWritercsv.append(String.valueOf(student.getMidtermScore()));
			bufferedWritercsv.append(",");
			bufferedWritercsv.append(String.valueOf(student.getFinalScore()));
			bufferedWritercsv.append(",");
			bufferedWritercsv.append(student.getCredit());
			bufferedWritercsv.append(System.lineSeparator());
		}
		bufferedWritercsv.flush();
		bufferedWritercsv.close();
	}
	
	public void readFileScore() {
		list.clear();
		try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH+course.getCourseID()+FILE_TYPE[0]))){
			String temp ="";
			while(true) {
				temp = reader.readLine();
				if(temp==null) {
					break;
				}
				else {
					textList+=temp+System.lineSeparator();
				}
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		cuttoSetStudent(textList);
	}
	
	private void cuttoSetStudent(String text) {
		text = text.trim();
		Scanner sc = new Scanner(text);
		while(sc.hasNextLine()) {
			String s[] = sc.nextLine().split(",");
			if(s.length == 8) {
				Student temp = new Student();
				temp.setIndex(Integer.parseInt(s[0]));
				temp.setStudentID(Long.parseLong(s[1]));
				temp.setName(s[2]);
				temp.setHomework(Integer.parseInt(s[3]));
				temp.setQuiz(Integer.parseInt(s[4]));
				temp.setMidtermScore(Integer.parseInt(s[5]));
				temp.setFinalScore(Integer.parseInt(s[6]));
				temp.setCredit(s[7]);
				list.add(temp);
			}
		}
	}
	
	public void setJTable() {
		String[] column = { "No.", "Student_ID", "Student_Name", "Homework", "Quiz",
				"Midterm", "Final" };
		Object[][] data = {{new Integer(0),new Long(0),new String(),new Integer(0),new Integer(0),new Integer(0),new Integer(0)}};
		data = new Object[list.size()][column.length];
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < column.length; j++) {
				if (j == 0) {
					data[i][j] = list.get(i).getIndex();
				} else if (j == 1) {
					data[i][j] = list.get(i).getStudentID();
				} else if (j == 2) {
					data[i][j] = list.get(i).getName();
				} else if (j == 3) {
					data[i][j] = list.get(i).getHomework();
				} else if (j == 4) {
					data[i][j] = list.get(i).getQuiz();
				} else if (j == 5) {
					data[i][j] = list.get(i).getMidtermScore();
				} else if (j == 6) {
					data[i][j] = list.get(i).getFinalScore();
				}
			}
		}
		DefaultTableModel table = new DefaultTableModel(data,column) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column < 3) {
					return false;
				}
				else {
					return true;
				}
			}
			
		};
		jTable = new JTable(table);
		jTable.getColumnModel().getColumn(1).setPreferredWidth(50);
		jTable.getColumnModel().getColumn(0).setPreferredWidth(3);
		jTable.getColumnModel().getColumn(2).setPreferredWidth(170);
		for(int i=3 ;i<7;i++) {
			jTable.getColumnModel().getColumn(i).setPreferredWidth(50);
		}

	}
	
	public JTable getTable() {
		return jTable;
	}
	
	public ArrayList<Student> getList(){
		return list;
	}
	
	public void setArrayList(ArrayList<Student> list) {
		this.list = list;
	}
	
}
