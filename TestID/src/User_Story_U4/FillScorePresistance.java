package User_Story_U4;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import User_Story_U2.Course;
import User_Story_U6.Student;



public class FillScorePresistance {
	private ArrayList<Student> list;
	private String textList;
	private JTable jTable;
	private Course course;
	private final String FILE_PATH = "./StudentList/studentList";
	private final String FILE_TYPE[] = {".xlsx",".txt"};
	private static final String FILE_ENCODE = "UTF-8";
	
	public FillScorePresistance(Course course) {
		this.course = course;
		list = new ArrayList<>();
		textList ="";
	}
	

	public void writeTextFile(Course course,ArrayList<Student> studentList) throws IOException {
		try {
			XSSFWorkbook workBook = new XSSFWorkbook();
			XSSFSheet sheet = workBook.createSheet("sheet1");
			int RowNum = 0;
			XSSFRow rowFirst = sheet.createRow(RowNum);
			rowFirst.createCell(0).setCellValue("No.");
			rowFirst.createCell(1).setCellValue("Student ID");
			rowFirst.createCell(2).setCellValue("Name Lastname");
			rowFirst.createCell(3).setCellValue("Homework Score");
			rowFirst.createCell(4).setCellValue("Quiz Score");
			rowFirst.createCell(5).setCellValue("Midterm Score");
			rowFirst.createCell(6).setCellValue("Final Score");
			rowFirst.createCell(7).setCellValue("HomeworkNet Score");
			rowFirst.createCell(8).setCellValue("QuizNet Score");
			rowFirst.createCell(9).setCellValue("MidtermNet Score");
			rowFirst.createCell(10).setCellValue("FinalNet Score");
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
			
		FileOutputStream fileout = new FileOutputStream(FILE_PATH+course.getCourseID()+FILE_TYPE[0]);
		workBook.write(fileout);
		fileout.close();
		System.out.println("Done");
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void readFileScore() {
		list.clear();
		try {
			int skip = 0;
			FileInputStream in = new FileInputStream(FILE_PATH+course.getCourseID()+FILE_TYPE[0]);
			Workbook workbook = new XSSFWorkbook(in);
			int numberOfSheets = workbook.getNumberOfSheets();
			for(int i = 0 ; i< numberOfSheets;i++) {
				Sheet sheet = workbook.getSheetAt(i);
				Iterator rowIterator = sheet.iterator();
				while(rowIterator.hasNext()) {
					Student s = new Student();
					Row row = (Row) rowIterator.next();
					Iterator cellIteratoe = row.cellIterator();
					while(cellIteratoe.hasNext()) {
						Cell cell = (Cell) cellIteratoe.next();
						if(skip == 0) {
							
						}
						else {
						if(Cell.CELL_TYPE_STRING == cell.getCellType()) {
							if(cell.getColumnIndex() == 2) {
							s.setName(cell.getStringCellValue());
							}
							else if(cell.getColumnIndex()==11 ) {
								s.setGrade(cell.getStringCellValue());
							}
						}
						else if(Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
							if(cell.getColumnIndex()==0) {
								s.setIndex((int) cell.getNumericCellValue());
							}
							else if(cell.getColumnIndex()==1) {
								s.setStudentID((long) cell.getNumericCellValue());
							}
							else if(cell.getColumnIndex()==3) {
								s.setHomework((int) cell.getNumericCellValue());
							}
							else if(cell.getColumnIndex()==4) {
								s.setQuiz((int) cell.getNumericCellValue());
							}
							else if(cell.getColumnIndex()==5) {
								s.setMidtermScore((int) cell.getNumericCellValue());
							}
							else if(cell.getColumnIndex()==6) {
								s.setFinalScore((int) cell.getNumericCellValue());
							}
							else if(cell.getColumnIndex()==7) {
								s.setNetHomeworkScore((int) cell.getNumericCellValue());
							}
							else if(cell.getColumnIndex()==8) {
								s.setNetQuizScore((int) cell.getNumericCellValue());
							}
							else if(cell.getColumnIndex()==9) {
								s.setNetMidtermScore((int) cell.getNumericCellValue());
							}
							else if(cell.getColumnIndex()==10) {
								s.setNetFinalScore((int) cell.getNumericCellValue());
							}
							
						}
						}
					}
					if(skip == 0 ) {
						
					}
					else {
						//System.out.println(s.toString());
						list.add(s);
					}
					skip++;
				}
			}
			in.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
	
	public ArrayList<Student> setMaxScore(ArrayList<Student> student,ArrayList<Integer> maxHome,ArrayList<Integer> maxQuiz,ArrayList<Integer> maxMid,ArrayList<Integer> maxFinal) {
		for(int i = 0; i <student.size() ;i++) {
			student.get(i).setNetHomeworkScore(maxHome.get(i));
			student.get(i).setNetQuizScore(maxQuiz.get(i));
			student.get(i).setNetMidtermScore(maxMid.get(i));
			student.get(i).setNetFinalScore(maxFinal.get(i));
			student.get(i).setGrade(list.get(i).getGrade());
		}
		this.list = student;
		return list;
	}
}
