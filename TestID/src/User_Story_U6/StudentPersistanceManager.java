package User_Story_U6;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
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

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.CORBA.IdentifierHelper;

import User_Story_U2.Course;

public class StudentPersistanceManager {
	private ArrayList<Student> studentList = new ArrayList<>();
	private String classListStr;
	private boolean isWrite = false , canRead = true;
	private Course course;
	private final String FILE_PATH = "./StudentList/studentList";
	private final String FILE_TYPE = ".xlsx";
	private static final String FILE_ENCODE = "UTF-8";

	public StudentPersistanceManager(File file, Course course) throws IOException {
		this.course = course;
		studentList.clear();
		uploadStudentList(file);
		readList(classListStr);
		if(canRead) {
		writeTextFile();
		isWrite(isWrite);
		}
		// previewTable();

	}

	public StudentPersistanceManager(ArrayList<Student> studentlist) {
		this.studentList = studentlist;
	}

	public void previewTable() {
		String[] column = { "No.", "Student_ID", "Student_Name", "Homework", "Quiz", "Midterm", "Final" };
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
		for (int i = 3; i < 7; i++) {
			jTable.getColumnModel().getColumn(i).setPreferredWidth(50);
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(jTable);

		JFrame tableFrame = new JFrame("preview class list");
		tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel tablePanel = new JPanel(new BorderLayout());
		tablePanel.setPreferredSize(new Dimension(jTable.getColumnCount() * 100, 500));

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
		Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/User_Story_U6/studentList.txt"),FILE_ENCODE));
		for (int i = 0; i < studentList.size(); i++) {
			bufferedWriter.write(studentList.get(i).toString() + "\n");
		}
		bufferedWriter.close();
		try {
			XSSFWorkbook workBook = new XSSFWorkbook();
			XSSFSheet sheet = workBook.createSheet("sheet1");
			for(int i =0;i < 12;i++) {
				if(i == 1) {
					sheet.setColumnWidth(i, 4000);
				}
				else if(i == 2) {
					sheet.setColumnWidth(i, 10000);
				}
				else {
					sheet.autoSizeColumn(i);
				}
			}
			int RowNum = 0;
			XSSFRow rowFirst = sheet.createRow(RowNum);
			rowFirst.createCell(0).setCellValue("No.");
			rowFirst.createCell(1).setCellValue("Student ID");
			rowFirst.createCell(2).setCellValue("Name Lastname");
			rowFirst.createCell(3).setCellValue("HW_Score");
			rowFirst.createCell(4).setCellValue("Q_Score");
			rowFirst.createCell(5).setCellValue("Midterm_Score");
			rowFirst.createCell(6).setCellValue("Final_Score");
			rowFirst.createCell(7).setCellValue("HMN_Score");
			rowFirst.createCell(8).setCellValue("QN_Score");
			rowFirst.createCell(9).setCellValue("MidtermN_Score");
			rowFirst.createCell(10).setCellValue("FinalN_Score");
			rowFirst.createCell(11).setCellValue("Grade");
			RowNum++;
			for(Student s : studentList) {
				XSSFRow row = sheet.createRow(RowNum);
				row.createCell(0).setCellValue(s.getIndex());
				row.createCell(1).setCellValue(s.getStudentID());
				row.createCell(2).setCellValue(s.getName());
				row.createCell(3).setCellValue(s.getHomework());
				row.createCell(4).setCellValue(s.getQuiz());
				row.createCell(5).setCellValue(s.getMidtermScore());
				row.createCell(6).setCellValue(s.getFinalScore());
				row.createCell(7).setCellValue(s.getNetHomeworkScore());
				row.createCell(8).setCellValue(s.getNetQuizScore());
				row.createCell(9).setCellValue(s.getNetMidtermScore());
				row.createCell(10).setCellValue(s.getNetFinalScore());
				row.createCell(11).setCellValue(s.getGrade());
				RowNum++;
			}
			
		FileOutputStream fileout = new FileOutputStream(FILE_PATH+course.getCourseID()+FILE_TYPE);
		workBook.write(fileout);
		fileout.close();
		System.out.println("Done");
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		isWrite = true;
	}

	public void readList(String classListStr) throws IOException {
		try {
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
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Please select file .csv");
			canRead = false;
		}
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

	public ArrayList<Student> getList() {
		return studentList;
	}

}
