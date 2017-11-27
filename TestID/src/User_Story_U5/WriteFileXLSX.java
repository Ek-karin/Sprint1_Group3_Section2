package User_Story_U5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import User_Story_U2.Course;
import User_Story_U6.Student;
import User_Story_U6.StudentPersistanceManager;


public class WriteFileXLSX {
	
	private Course course;
	private final String FILE_PATH = "./StudentList/";
	private final String FILE_NAME = "Registry";
	private final String FILE_TYPE = ".xlsx";
	private StudentPersistanceManager persis;

	public WriteFileXLSX(Course course ,ArrayList<Student> students) {
		this.course = course;
		persis = new StudentPersistanceManager(students);
		writeFileXLSX();
	
	}
	
	private void writeFileXLSX() {
		try {
			XSSFWorkbook workBook = new XSSFWorkbook();
			XSSFSheet sheet = workBook.createSheet("sheet1");
			sheet.setColumnWidth(1, 4000);
			sheet.setColumnWidth(2, 10000);
			int RowNum = 0;
			XSSFRow rowTitele = sheet.createRow(RowNum);
			rowTitele.createCell(0).setCellValue(course.getCourseID());
			rowTitele.createCell(1).setCellValue(course.getCourseName());
			RowNum++;
			XSSFRow rowTName = sheet.createRow(RowNum);
			String temp = "";
			for(int i = 0;i<course.getProfessor().length;i++) {
				temp+=course.getProfessor()[i]+",";
			}
			rowTName.createCell(0).setCellValue(temp);
			RowNum++;
			XSSFRow rowIntro = sheet.createRow(RowNum);
			rowIntro.createCell(0).setCellValue("StudentList");
			RowNum++;
			XSSFRow rowFirst = sheet.createRow(RowNum);
			rowFirst.createCell(0).setCellValue("No.");
			rowFirst.createCell(1).setCellValue("Student ID");
			rowFirst.createCell(2).setCellValue("Name Lastname");
			rowFirst.createCell(3).setCellValue("Grade");
			RowNum++;
			for(Student s : persis.getList()) {
				XSSFRow row = sheet.createRow(RowNum);
					row.createCell(0).setCellValue(s.getIndex());
					row.createCell(1).setCellValue(s.getStudentID());
					row.createCell(2).setCellValue(s.getName());
					row.createCell(3).setCellValue(s.getGrade());
					RowNum++;
			}
			
		FileOutputStream fileout = new FileOutputStream(FILE_PATH+FILE_NAME+course.getCourseID()+FILE_TYPE);
		workBook.write(fileout);
		fileout.close();
		//System.out.println("Done");
		JOptionPane.showMessageDialog(null, "Write file complete. : ["+FILE_NAME+course.getCourseID()+FILE_TYPE+"]");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/*public static void main(String[] args) {
		new WriteFileXLSX("cs284");
	}*/
}
