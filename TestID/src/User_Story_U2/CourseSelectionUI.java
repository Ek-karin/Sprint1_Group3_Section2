package User_Story_U2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import User_Story_U3.FillNetScoreUI;


import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;

public class CourseSelectionUI extends JFrame {

	private JPanel contentPane;
	private CourseList listCourse;
	private Course course;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseSelectionUI frame = new CourseSelectionUI();
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
	public CourseSelectionUI() {
		listCourse = new CourseList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(581, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
		contentPane.setLayout(null);
		
		JButton nextBtn = new JButton("");
		nextBtn.setIcon(new ImageIcon("./src/next_01.png"));
		nextBtn.setBounds(27, 607, 504, 83);
		nextBtn.setBorderPainted( false );
		nextBtn.setFocusPainted( false );
		nextBtn.setContentAreaFilled(false);
		nextBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				nextBtn.setIcon(new ImageIcon("./src/next_02.png"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				nextBtn.setIcon(new ImageIcon("./src/next_01.png"));
				new FillNetScoreUI(listCourse.getCorseByCourseID((String) comboBox.getSelectedItem()));
				dispose();
			}
		});
		
		JPanel boxPanel = new JPanel();
		boxPanel.setOpaque(false);
		boxPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		boxPanel.setBounds(46, 439, 465, 115);
		comboBox = new JComboBox();
		comboBox.setBounds(12, 45, 441, 22);
		boxPanel.add(comboBox);
		boxPanel.setLayout(null);
		contentPane.add(boxPanel);
		
		contentPane.add(nextBtn);
		
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("./src/CourseSelection_UI_NEW_03.jpg"));
		background.setBounds(0, 0, 563, 721);
		contentPane.add(background);
		setVisible(true);
		setItem();
	}
	
	public void setItem() {
		for(int i = 0;i<listCourse.listCourse().size();i++) {
			comboBox.addItem(listCourse.listCourse().get(i).getCourseID());
		}
	}
}
