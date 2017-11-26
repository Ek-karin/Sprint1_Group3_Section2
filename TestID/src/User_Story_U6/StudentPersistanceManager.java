package User_Story_U6;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.IdentifierHelper;

import User_Story_U2.Course;

public class StudentPersistanceManager {
	private ArrayList<Student> studentList = new ArrayList<>();
	private String classListStr;
	private boolean isWrite = false;
	private Course course;
	private final String FILE_PATH = "./StudentList/studentList";
	private final String FILE_TYPE = ".csv";

	public StudentPersistanceManager(File file,Course course) throws IOException {
		this.course = course;
		studentList.clear();
		uploadStudentList(file);
		readList(classListStr);
		writeTextFile();
		isWrite(isWrite);
		//previewTable();

	}
	
	public StudentPersistanceManager(ArrayList<Student> studentlist) {
		this.studentList = studentlist;
	}

	public void previewTable() {
		String[] column = { "No.", "Student_ID", "Student_Name", "Homework", "Quiz",
				"Midterm", "Final" };
		Object[][] data = null;
		data = new Object[studentList.size()][column.length];
		for (int i = 0; i < studentList.size(); i++) {
			for (int j = 0; j < column.length; j++) {
				if (j == 0) {
					data[i][j] = studentList.get(i).getIndex();
				} else if (j == 1) {
					data[i][j] = studentList.get(i).getStudentID();
				} else if (j == 2) {
					data[i][j] = studentList.get(i).getName();
				} else if (j == 3) {
					data[i][j] = studentList.get(i).getHomework();
				} else if (j == 4) {
					data[i][j] = studentList.get(i).getQuiz();
				} else if (j == 5) {
					data[i][j] = studentList.get(i).getMidtermScore();
				} else if (j == 6) {
					data[i][j] = studentList.get(i).getFinalScore();
				}
			}
		}

		JTable jTable = new JTable(data, column);
		jTable.setEnabled(false);
		jTable.getColumnModel().getColumn(1).setPreferredWidth(50);
		jTable.getColumnModel().getColumn(0).setPreferredWidth(3);
		jTable.getColumnModel().getColumn(2).setPreferredWidth(170);
		for(int i=3 ;i<7;i++) {
			jTable.getColumnModel().getColumn(i).setPreferredWidth(50);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(jTable);

		JFrame tableFrame = new JFrame("preview class list");
		tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel tablePanel = new JPanel(new BorderLayout());
		tablePanel.setPreferredSize(new Dimension(jTable.getColumnCount()*100,500));

		tablePanel.add(scrollPane);
		tableFrame.getContentPane().add(tablePanel, BorderLayout.CENTER);
		tableFrame.pack();
		tableFrame.setVisible(true);
	}

	public void isWrite(boolean check) {
		if (check == true) {
			JOptionPane.showMessageDialog(null, "Upload Complete !!");
		} else {
			JOptionPane.showMessageDialog(null, "Upload ERROR !!");
		}
	}

	public void printList() {
		for (Student student : studentList) {
			System.out.println(student.toString());
		}
	}

	public void writeTextFile() throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/User_Story_U6/studentList.txt"));
		for (int i = 0; i < studentList.size(); i++) {
			bufferedWriter.write(studentList.get(i).toString() + "\n");
		}
		bufferedWriter.close();
		BufferedWriter bufferedWritercsv = new BufferedWriter(new FileWriter(FILE_PATH+course.getCourseID()+FILE_TYPE));
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
			bufferedWritercsv.append(",");
			bufferedWritercsv.append(String.valueOf(student.getNetHomeworkScore()));
			bufferedWritercsv.append(",");
			bufferedWritercsv.append(String.valueOf(student.getNetQuizScore()));
			bufferedWritercsv.append(",");
			bufferedWritercsv.append(String.valueOf(student.getNetMidtermScore()));
			bufferedWritercsv.append(",");
			bufferedWritercsv.append(String.valueOf(student.getNetFinalScore()));
			bufferedWritercsv.append(",");
			bufferedWritercsv.append(student.getGrade());
			bufferedWritercsv.append(System.lineSeparator());
		}
		bufferedWritercsv.flush();
		bufferedWritercsv.close();
		isWrite = true;
	}

	public void readList(String classListStr) throws IOException {
		StringTokenizer stringTokenizer_line, stringTokenizer;
		stringTokenizer_line = new StringTokenizer(classListStr, System.lineSeparator());
		while (stringTokenizer_line.hasMoreTokens()) {
			stringTokenizer = new StringTokenizer(stringTokenizer_line.nextToken(), ",");
			int count = 0;
			Student student = new Student();
			while (stringTokenizer.hasMoreTokens()) {
				switch (count) {
				case 0:
					student.setIndex(Integer.parseInt(stringTokenizer.nextToken()));
					count++;
					break;
				case 1:
					student.setStudentID(Long.parseLong(stringTokenizer.nextToken()));
					count++;
					break;
				case 2:
					student.setName(stringTokenizer.nextToken());
					count++;
					break;
				case 3:
					student.setStudyDegree(stringTokenizer.nextToken());
					count++;
					break;
				case 4:
					student.setCredit(stringTokenizer.nextToken());
					count++;
					break;
				default:
					break;
				}
			}
			studentList.add(student);
			count = 0;
		}
		studentList.remove(studentList.size() - 1);

	}

	public void uploadStudentList(File file) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String str = "";
		classListStr = "";
		int count = 0;
		while (true) {
			str = bufferedReader.readLine();
			if (str == null) {
				break;
			} else {
				if (count >= 7) {
					classListStr = classListStr.concat(str + "\n");
				}
			}
			count++;
		}
	}
	
	public ArrayList<Student> getList(){
		return studentList;
	}

}
