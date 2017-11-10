package User_Story_U3;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ScorePanel extends JPanel {
	private JButton ok,setting;
	private JLabel text;
	private MyTableModel table;
	
	
	public ScorePanel() {
		ok = new JButton("OK");
		setting = new JButton("Setting");
		table = new MyTableModel();
		text = new JLabel("Please fill maximum score.",JLabel.CENTER);
		text.setFont(new Font("consolas", Font.BOLD, 20));
		ok.setFont(new Font("consolas", Font.BOLD, 10));
		setting.setFont(new Font("consolas", Font.BOLD, 10));
		addtoPanel();
	}
	private void addtoPanel() {
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
		setLayout(new GridLayout(3,0));
		add(text);
		add(scorePanel);
		add(buttonPanel);
	}

}
