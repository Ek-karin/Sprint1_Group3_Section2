package User_Story_U4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import User_Story_U2.CheckCourseList;
import User_Story_U2.Course;
import User_Story_U2.CourseFileMgr;
import User_Story_U7.CalculateNetScore;

public class FillScoreForm extends JFrame implements ActionListener{
	private JButton setFullScoreBtn , exportBtn , sendBtn , saveBtn , gradeCal;
	private JLabel advisorName ;
	private FillScoreController u4Contro;
	private Course course;
	private JScrollPane scrollPane;
	private CheckCourseList checkCourse;
	
	public FillScoreForm(Course course) {
		this.course = course;
		u4Contro = new FillScoreController(course);
		u4Contro.readFileCSV();
		checkCourse = new CheckCourseList();
		setSize(800, 600);
		setTitle("FillScoreForm");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel(new GridLayout(1, 2));
		JPanel advisorNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		String temp="";
		for(String s : course.getProfessor()) {
			temp+=s+System.lineSeparator();
		}
		advisorName = new JLabel(temp);										//Show advisor name.
		JPanel setFullScorePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));	//Set full score.
		setFullScoreBtn = new JButton("Set Full Score");
		setFullScoreBtn.addActionListener(this);
		advisorNamePanel.add(advisorName);
		setFullScorePanel.add(setFullScoreBtn);
		topPanel.add(advisorNamePanel);
		topPanel.add(setFullScorePanel);
		
		JPanel middlePanel = new JPanel(new BorderLayout());
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(u4Contro.showTable()); //add JTable here.
		middlePanel.add(scrollPane);		
		
		
		JPanel bottomPanel = new JPanel(new FlowLayout());
		saveBtn = new JButton("Save"); 	
		saveBtn.addActionListener(this); 	 	 	 		 	 //Save score.
		exportBtn = new JButton("Make File");					//Make .xls file.
		sendBtn = new JButton("Send");	 	 	 	 	 	 	 //Send to student
		gradeCal = new JButton("Grade Calculated");
		exportBtn.addActionListener(this);
		sendBtn.addActionListener(this);
		gradeCal.addActionListener(this);
		bottomPanel.add(saveBtn);
		bottomPanel.add(exportBtn);
		bottomPanel.add(sendBtn);
		bottomPanel.add(gradeCal);
		
		add(topPanel , BorderLayout.NORTH);
		add(middlePanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		//pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/*public static void main(String[] args) {
		new U4FillScoreForm();
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(saveBtn)) {
			if(checkCourse.checkFileHaveMaxRawScore(course.getCourseID()))
			{
			u4Contro.setScore(u4Contro.getTable());
			u4Contro.calculatedNetScore();
			u4Contro.wrtieFileCSV();
			System.out.println("Save Complete.");
			}
			else {
				JOptionPane.showMessageDialog(null, "This course not have max score please click [set full score] button.");
			}
		}
		if(e.getSource().equals(setFullScoreBtn)) {
			new FullScoreFrame(course);
		}
		
		if(e.getSource().equals(gradeCal)) {
			System.out.println("Cal");
		}
		if(e.getSource().equals(exportBtn)) {
			System.out.println("Export");
		}
		if(e.getSource().equals(sendBtn)) {
			System.out.println("Send");
		}
		
		
	}

}
