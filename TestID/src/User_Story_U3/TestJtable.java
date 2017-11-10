package User_Story_U3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import User_Story_U2.MyTableModel;

public class TestJtable extends JFrame{
	
	public TestJtable() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		MyTableModel m = new MyTableModel();
		JTable t = new JTable(m);
		t.setFont(new Font("consolas", Font.BOLD, 10));
		t.setRowHeight(20);
		JScrollPane scrollPane = new JScrollPane(t);
	    add(scrollPane, BorderLayout.CENTER);
	    pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new TestJtable();
	}

}
