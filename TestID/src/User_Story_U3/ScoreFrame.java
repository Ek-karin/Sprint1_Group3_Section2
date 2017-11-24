package User_Story_U3;

import java.awt.Dimension;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import User_Story_U2.Course;
import User_Story_U2.CourseList;




public class ScoreFrame extends JFrame {
	private JButton ok,setting;
	private JLabel text;
	private MyTableModel table;
	private JPanel content;
	private CourseList list;
	private ControllerFillScore checkScore;
	private Course course;
	
	
	public ScoreFrame() {
		checkScore = new ControllerFillScore();
		ok = new JButton("OK");
		setting = new JButton("Setting");
		table = new MyTableModel();
		text = new JLabel("Please fill maximum score.",JLabel.CENTER);
		text.setFont(new Font("consolas", Font.BOLD, 20));
		ok.setFont(new Font("consolas", Font.BOLD, 10));
		setting.setFont(new Font("consolas", Font.BOLD, 10));
		addtoPanel();
		addtoFrame();
		addAction();
	}
	public ScoreFrame(Course course) {
		this.course = course;
		checkScore = new ControllerFillScore(course);
		list = new CourseList();
		table = new MyTableModel();
		setTitle(course.getCourseID());
		//if(checkScore.checkHaveScore((String) course)) {
			table.setValueAt(list.getCorseByCourseID(course.getCourseID()).getHomeWork(), 0, 0);
			table.setValueAt(list.getCorseByCourseID(course.getCourseID()).getQuiz(), 0, 1);
			table.setValueAt(list.getCorseByCourseID(course.getCourseID()).getMidTerm(), 0, 2);
			table.setValueAt(list.getCorseByCourseID(course.getCourseID()).getFinalTerm(), 0, 3);
		//}
		ok = new JButton("OK");
		setting = new JButton("Setting");
		text = new JLabel("Please fill maximum score.",JLabel.CENTER);
		text.setFont(new Font("consolas", Font.BOLD, 20));
		ok.setFont(new Font("consolas", Font.BOLD, 10));
		setting.setFont(new Font("consolas", Font.BOLD, 10));
		addtoPanel();
		addtoFrame();
		addAction();
	}
	private void addtoPanel() {
		content = new JPanel(new GridLayout(3, 0));
		JPanel scorePanel = new JPanel();
		scorePanel.setPreferredSize(new Dimension(500, 50));
		JTable t = new JTable(table);
		t.setFont(new Font("consolas", Font.BOLD, 10));
		t.setRowHeight(20);
		JScrollPane scrollPane = new JScrollPane(t);
		scorePanel.add(scrollPane);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(ok);
		buttonPanel.add(setting);
		content.add(text);
		content.add(scorePanel);
		content.add(buttonPanel);
	}
	private void addtoFrame(){
		add(content);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void addAction() {
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int score = (int) table.getValueAt(0, 0);
				int quiz = (int) table.getValueAt(0, 1);
				int mid = (int) table.getValueAt(0, 2);
				int finalScore = (int) table.getValueAt(0, 3);
				boolean check = checkScore.setScore(score, quiz, mid, finalScore);
				if(check){
					if(checkScore.nextStepOkButton(course)) {
						System.out.println("have student list in data ready for next step !");
						dispose();
					}
					else {
						
					}
				}
				else{
					
				}
			}
		});
		
		setting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 	checkScore.nextStepSettingButton();
				}
			
		});
	}
	
}
