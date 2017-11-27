package User_Story_U3;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import User_Story_U2.Course;
import User_Story_U2.CourseList;

import User_Story_U4.FillScoreUI;

import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;

public class FillNetScoreUI extends JFrame {

	private JPanel contentPane;
	private CourseList list;
	private ControllerFillScore checkScore;
	private Course course;

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FillNetScoreUI frame = new FillNetScoreUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public FillNetScoreUI(Course course) {
		this.course = course;
		checkScore = new ControllerFillScore(course);
		setTitle(course.getCourseID() + " : "+course.getCourseName());
		list = new CourseList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(581, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
		MyTableModel table = new MyTableModel();
		contentPane.setLayout(null);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(42, 461, 475, 74);
		contentPane.add(tablePanel);
		tablePanel.setLayout(null);
		JTable t = new JTable(table);
		t.setFont(new Font("consolas", Font.BOLD, 10));
		t.setRowHeight(20);
		t.setValueAt(list.getCorseByCourseID(course.getCourseID()).getHomeWork(), 0, 0);
		t.setValueAt(list.getCorseByCourseID(course.getCourseID()).getQuiz(), 0, 1);
		t.setValueAt(list.getCorseByCourseID(course.getCourseID()).getMidTerm(), 0, 2);
		t.setValueAt(list.getCorseByCourseID(course.getCourseID()).getFinalTerm(), 0, 3);
		JScrollPane scrollPane = new JScrollPane(t);
		scrollPane.setBounds(12, 13, 452, 50);
		tablePanel.add(scrollPane);
		scrollPane.setViewportBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton nextBtn = new JButton("");
		nextBtn.setIcon(new ImageIcon("./src/next_04.png"));
		nextBtn.setFocusPainted(false);
		nextBtn.setContentAreaFilled(false);
		nextBtn.setBorderPainted(false);
		nextBtn.setBounds(33, 607, 247, 83);
		nextBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				nextBtn.setIcon(new ImageIcon("./src/next_03.png"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				nextBtn.setIcon(new ImageIcon("./src/next_04.png"));
				int score = (int) table.getValueAt(0, 0);
				int quiz = (int) table.getValueAt(0, 1);
				int mid = (int) table.getValueAt(0, 2);
				int finalScore = (int) table.getValueAt(0, 3);
				boolean check = checkScore.setScore(score, quiz, mid, finalScore);
				if(check){
					if(checkScore.nextStepOkButton(course)) {
						new FillScoreUI(course);
						dispose();
					}
					else {
						
					}
				}
				else{
					
				}
			}
		});
		contentPane.add(nextBtn);
		
		JButton settingBtn = new JButton("");
		settingBtn.setIcon(new ImageIcon("./src/setting_04.png"));
		settingBtn.setFocusPainted(false);
		settingBtn.setContentAreaFilled(false);
		settingBtn.setBorderPainted(false);
		settingBtn.setBounds(281, 607, 247, 83);
		settingBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				settingBtn.setIcon(new ImageIcon("./src/setting_03.png"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				settingBtn.setIcon(new ImageIcon("./src/setting_04.png"));
				checkScore.nextStepSettingButton();
				
			}
		});
		contentPane.add(settingBtn);
		
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 563, 721);
		background.setIcon(new ImageIcon("./src/SetNetSCore_UI_NEW_03.jpg"));
		contentPane.add(background);
		setVisible(true);

	}
}
