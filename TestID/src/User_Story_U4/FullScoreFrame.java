package User_Story_U4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import User_Story_U2.Course;

public class FullScoreFrame extends JFrame {
	
	private JLabel setAllFullScore ;
	private JTable fillFullScoreTable ;
	private JButton confirmBtn ;
	private FillFullScoreTableModel tableModel ;
	private FillScoreController contro;
	private Course course;
	
	public FullScoreFrame(Course course) {
		this.course = course;
		setLayout(new BorderLayout());
	    contro = new FillScoreController(course);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				dispose();
			}
		});
		setSize(500, 155);
		JPanel topPanel = new JPanel(new FlowLayout());
		setAllFullScore = new JLabel("Set All Full Score");
		topPanel.add(setAllFullScore);
		JPanel middlePanel = new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		tableModel = new FillFullScoreTableModel();
		fillFullScoreTable = new JTable(tableModel);
		fillFullScoreTable.setRowHeight(20);
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
		middlePanel.add(scrollPane);
		JPanel bottomPanel = new JPanel(new FlowLayout());
		confirmBtn = new JButton("Confirm");
		bottomPanel.add(confirmBtn);
		add(topPanel , BorderLayout.NORTH);
		add(middlePanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		setVisible(true);
		setLocationRelativeTo(null);
		
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contro.setMaxScore(fillFullScoreTable);
				dispose();
			}
		});
	}
	
	
	/*public static void main(String[] args) {
		new FullScoreFrame();
	}*/

}
