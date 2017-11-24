package User_Story_U2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import User_Story_U3.ScoreFrame;

public class SelectCourseFrame extends JFrame {
	private JComboBox<String> box;
	private JButton ok;
	private CourseList listCourse;
	private MyTableModel table;
	private JPanel content;
	private Course course;
	
	public SelectCourseFrame() {
		content = new JPanel(new BorderLayout());
		listCourse = new CourseList();
		JPanel north = new JPanel(new GridLayout(2, 0));
		JPanel box_ok = new JPanel();
		JLabel text = new JLabel("Select course below.",JLabel.CENTER);
		text.setFont(new Font("Consolas", Font.BOLD, 13));
		box = new JComboBox<>();
		box.setPreferredSize(new Dimension(100, 20));
		box.setFont(new Font("Consolas", Font.BOLD, 13));
		ok = new JButton("OK");
		ok.setPreferredSize(new Dimension(50, 20));
		ok.setFont(new Font("Consolas", Font.BOLD, 13));
		north.add(text);
		box_ok.add(box);
		box_ok.add(ok);
		north.add(box_ok);
		north.setPreferredSize(new Dimension(250, 100));
		north.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
		content.add(north,BorderLayout.NORTH);
		setItem();
		addAction();
		addtoFrame();
	}
	
	private void addtoFrame() {
		setTitle("Select Course");
		add(content);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void setItem(String item) {
		box.addItem(item);
	}
	public void setItem() {
		for(int i = 0;i<listCourse.listCourse().size();i++) {
			box.addItem(listCourse.listCourse().get(i).getCourseID());
		}
	}
	
	
	public void addAction() {
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ScoreFrame(listCourse.getCorseByCourseID((String) box.getSelectedItem()));
				dispose();
			}
		});
	}

}
