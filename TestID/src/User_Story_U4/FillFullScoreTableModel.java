package User_Story_U4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class FillFullScoreTableModel extends AbstractTableModel {
	private String[] columnNames = { "Homework Fullscore", "Quiz Fullscore", "Mid Fullscore", "Final Fullscore"};
	private Object[][] data;
	
	public FillFullScoreTableModel() {
		data = new Object[][] {{ 0,0,0,0}};
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	public Class getColumnClass(int c) {
		if(getValueAt(0, c)==null){
			setValueAt(0, 0, c);
		}
		return getValueAt(0, c).getClass();
	}

	public void setValueAt(Object value, int row, int col) {
		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

}
