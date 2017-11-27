package User_Story_U4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import User_Story_U2.CheckCourseList;
import User_Story_U2.Course;

public class FillScoreUI extends JFrame {

	private JPanel contentPane;
	private FillScoreController u4Contro;
	private Course course;
	private CheckCourseList checkCourse;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FillScoreUI frame = new FillScoreUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public FillScoreUI(Course course) {
		setTitle(course.getCourseID() + " : "+course.getCourseName());
		this.course = course;
		u4Contro = new FillScoreController(course);
		u4Contro.readFileCSV();
		checkCourse = new CheckCourseList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(810	, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
		contentPane.setLayout(null);
		//FillFullScoreTableModel tableModel = new FillFullScoreTableModel();
		
		JButton saveBtn = new JButton("");
		saveBtn.setBounds(36, 462, 153, 78);
		saveBtn.setIcon(new ImageIcon("./src/Save_01.png"));
		saveBtn.setFocusPainted(false);
		saveBtn.setContentAreaFilled(false);
		saveBtn.setBorderPainted(false);
		saveBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				saveBtn.setIcon(new ImageIcon("./src/Save_02.png"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				saveBtn.setIcon(new ImageIcon("./src/Save_01.png"));
				if(checkCourse.checkFileHaveMaxRawScore(course.getCourseID()))
				{
				u4Contro.setScore(u4Contro.getTable());
				u4Contro.calculatedNetScore();
				u4Contro.wrtieFileCSV();
				}
				else {
					JOptionPane.showMessageDialog(null, "This course not have max score please click [set full score] button.");
				}
				
			}
		});
		
		JButton fullScoreBtn = new JButton("");
		fullScoreBtn.setBounds(599, 104, 153, 78);
		contentPane.add(fullScoreBtn);
		fullScoreBtn.setIcon(new ImageIcon("./src/FullScore_01.png"));
		fullScoreBtn.setFocusPainted(false);
		fullScoreBtn.setContentAreaFilled(false);
		fullScoreBtn.setBorderPainted(false);
		fullScoreBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				fullScoreBtn.setIcon(new ImageIcon("./src/FullScore_02.png"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				fullScoreBtn.setIcon(new ImageIcon("./src/FullScore_01.png"));
				new SetFullScoreUI(course);
				
			}
		});
		contentPane.add(saveBtn);
		
		JButton sendBtn = new JButton("");
		sendBtn.setIcon(new ImageIcon("./src/Send_01.png"));
		sendBtn.setFocusPainted(false);
		sendBtn.setContentAreaFilled(false);
		sendBtn.setBorderPainted(false);
		sendBtn.setBounds(226, 462, 153, 78);
		sendBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				sendBtn.setIcon(new ImageIcon("./src/Send_02.png"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				sendBtn.setIcon(new ImageIcon("./src/Send_01.png"));
				u4Contro.setScore(u4Contro.getTable());
				u4Contro.calculatedNetScore();
				u4Contro.readFileCSV();
				u4Contro.nextStep("send");
				
			}
		});
		contentPane.add(sendBtn);
		
		JButton makeFileBtn = new JButton("");
		makeFileBtn.setIcon(new ImageIcon("./src/MakeFile_01.png"));
		makeFileBtn.setFocusPainted(false);
		makeFileBtn.setContentAreaFilled(false);
		makeFileBtn.setBorderPainted(false);
		makeFileBtn.setBounds(413, 462, 153, 78);
		makeFileBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				makeFileBtn.setIcon(new ImageIcon("./src/MakeFile_02.png"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				makeFileBtn.setIcon(new ImageIcon("./src/MakeFile_01.png"));
				u4Contro.setScore(u4Contro.getTable());
				u4Contro.calculatedNetScore();
				u4Contro.readFileCSV();
				u4Contro.nextStep("export");
				
			}
		});
		contentPane.add(makeFileBtn);
		
		JButton gradeBtn = new JButton("");
		gradeBtn.setIcon(new ImageIcon("./src/Grade_01.png"));
		gradeBtn.setFocusPainted(false);
		gradeBtn.setContentAreaFilled(false);
		gradeBtn.setBorderPainted(false);
		gradeBtn.setBounds(599, 462, 153, 78);
		gradeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				gradeBtn.setIcon(new ImageIcon("./src/Grade_02.png"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				gradeBtn.setIcon(new ImageIcon("./src/Grade_01.png"));
				u4Contro.setScore(u4Contro.getTable());
				u4Contro.calculatedNetScore();
				u4Contro.nextStep("calgrade");
				
			}
		});
		contentPane.add(gradeBtn);
		
		JPanel tablePanel = new JPanel(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(u4Contro.showTable());
		tablePanel.setBounds(36, 182, 716, 279);
		tablePanel.add(scrollPane);
		contentPane.add(tablePanel);
		//tablePanel.setLayout(null);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon("./src/FillScoreTable_UI_NEW_05.jpg"));
		background.setBounds(0, 0, 800, 553);
		contentPane.add(background);
		JPanel bottomPanel = new JPanel(new FlowLayout());
		setVisible(true);
	
	}
}
