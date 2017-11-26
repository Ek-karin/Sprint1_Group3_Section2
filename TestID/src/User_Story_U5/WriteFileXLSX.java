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
		/*try {
			String csvFile = "./StudentList/studentListcs284.csv";
			String output = "./StudentList/studentListcs284.xlsx";
			
			XSSFWorkbook workBook = new XSSFWorkbook();
			XSSFSheet sheet = workBook.createSheet("sheet1");
			String line = null;
			int RowNum = 0;
			BufferedReader br = new BufferedReader(new FileReader(csvFile));
			while((line = br.readLine())!=null) {
				String s[] = line.split(",");
				RowNum++;
				XSSFRow row = sheet.createRow(RowNum);
				int cell = 0;
				for(int i = 0; i < s.length;i++) {
					if(i < 3 || i == s.length-1) {
					row.createCell(cell).setCellValue(s[i]);
					cell++;
					}
				}
			}
		FileOutputStream fileout = new FileOutputStream(output);
		workBook.write(fileout);
		fileout.close();
		System.out.println("Done");
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}*/
		writeFileXLSX();
	
	}
	
	private void writeFileXLSX() {
		try {
			XSSFWorkbook workBook = new XSSFWorkbook();
			XSSFSheet sheet = workBook.createSheet("sheet1");
			int RowNum = 0;
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
		System.out.println("Done");
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/*public static void main(String[] args) {
		new WriteFileXLSX("cs284");
	}*/
}
