package User_Story_U4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import User_Story_U2.Course;

public class SetFullScoreUI extends JFrame {

	private JPanel contentPane;
	private FillFullScoreTableModel tableModel ;
	private FillScoreController contro;
	private Course course;
	private JTable fillFullScoreTable ;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetFullScoreUI frame = new SetFullScoreUI();
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
	public SetFullScoreUI(Course course) {
		this.course = course;
		contro = new FillScoreController(course);
		tableModel = new FillFullScoreTableModel();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				dispose();
			}
		});
		setSize(581, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
		//MyTableModel table = new MyTableModel();
		fillFullScoreTable = new JTable(tableModel);
		fillFullScoreTable.setRowHeight(20);
		contentPane.setLayout(null);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(42, 461, 475, 74);
		contentPane.add(tablePanel);
		tablePanel.setLayout(null);
		//JTable t = new JTable(table);
		//t.setFont(new Font("consolas", Font.BOLD, 10));
		//t.setRowHeight(20);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setViewportView(fillFullScoreTable);
		for(int i = 0 ; i < 4 ;i++) {
			if(i==0)
				tableModel.setValueAt(this.course.getMaxRawScoreHomeWork(), 0, i);
			if(i==1)
				tableModel.setValueAt(this.course.getMaxRawScoreQuiz(), 0, i);
			if(i==2)
				tableModel.setValueAt(this.course.getMaxRawScoreMidTerm(), 0, i);
			if(i==3)
				tableModel.setValueAt(this.course.getMaxRawScoreFinalTerm(), 0, i);
		}
		scrollPane.setBounds(12, 13, 452, 50);
		tablePanel.add(scrollPane);
		scrollPane.setViewportBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton confirmBtn = new JButton("");
		confirmBtn.setIcon(new ImageIcon("./src/LogInBtn_02.png"));
		confirmBtn.setFocusPainted(false);
		confirmBtn.setContentAreaFilled(false);
		confirmBtn.setBorderPainted(false);
		confirmBtn.setBounds(32, 607, 496, 83);
		confirmBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				confirmBtn.setIcon(new ImageIcon("./src/LogInBtn_03.png"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				confirmBtn.setIcon(new ImageIcon("./src/LogInBtn_02.png"));
				contro.setMaxScore(fillFullScoreTable);
				dispose();
				
			}
		});
		contentPane.add(confirmBtn);
		
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 563, 721);
		background.setIcon(new ImageIcon("./src/SetFullScore_UI_NEW.jpg"));
		contentPane.add(background);
		setVisible(true);
	}

}
