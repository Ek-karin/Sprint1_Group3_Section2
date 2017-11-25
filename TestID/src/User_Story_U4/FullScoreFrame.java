package User_Story_U4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
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

public class FullScoreFrame extends JFrame {
	
	private JLabel setAllFullScore ;
	private JTable fillFullScoreTable ;
	private JButton confirmBtn ;
	private FillFullScoreTableModel tableModel ;
	
	public FullScoreFrame() {
		setLayout(new BorderLayout());
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
		middlePanel.add(scrollPane);
		JPanel bottomPanel = new JPanel(new FlowLayout());
		confirmBtn = new JButton("Confirm");
		bottomPanel.add(confirmBtn);
		add(topPanel , BorderLayout.NORTH);
		add(middlePanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	/*public static void main(String[] args) {
		new FullScoreFrame();
	}*/

}
