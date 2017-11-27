package User_Story_U1;

import java.awt.EventQueue;

import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import java.awt.Window.Type;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Button;
import javax.swing.JList;

public class LoginUI {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField usernameField;
	private CheckLogIn controllerLogin;

	public LoginUI() {
		initialize();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI window = new LoginUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		controllerLogin = new CheckLogIn();
		frame = new JFrame();
		frame.setSize(581, 768);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
		frame.getContentPane().setLayout(null);
		
		JButton confirmBtn = new JButton("");
		confirmBtn.setBorderPainted( false );
		confirmBtn.setFocusPainted( false );
		confirmBtn.setContentAreaFilled(false);
		confirmBtn.setIcon(new ImageIcon("./src/LogInBtn_03.png"));
		confirmBtn.setBounds(27, 608, 505, 80);
		confirmBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				confirmBtn.setIcon(new ImageIcon("./src/LogInBtn_02.png"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				confirmBtn.setIcon(new ImageIcon("./src/LogInBtn_03.png"));
				login();
				
			}
		});
		
		JLabel resultLabel = new JLabel("");
		resultLabel.setForeground(Color.RED);
		resultLabel.setBounds(294, 360, 351, 43);
		resultLabel.setFont(new Font("Bangna New", Font.BOLD, 24));
		frame.getContentPane().add(resultLabel);
		frame.getContentPane().add(confirmBtn);
		
		usernameField = new JTextField();
		usernameField.setBorder(null);
		usernameField.setBounds(140, 428, 360, 43);
		usernameField.setFont(new Font("Bangna New", Font.PLAIN, 24));
		usernameField.setForeground(Color.WHITE);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		usernameField.setOpaque(false);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setBorder(null);
		passwordField.setBounds(140, 517, 360, 43);
		passwordField.setFont(new Font("Bangna New", Font.PLAIN, 24));
		passwordField.setOpaque(false);
		frame.getContentPane().add(passwordField);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("./src/login_UI_NEW_05.jpg"));
		background.setBounds(0, 0, 573, 721);
		frame.getContentPane().add(background);
		ImageIcon icon = new ImageIcon("./src/correct.png");
		
		
	}
	
	private void login() {
		if(controllerLogin.checkId_Pass(usernameField.getText().trim(), passwordField.getText().trim())) {
			controllerLogin.nextStepBeforeCheck(true);
			frame.dispose();
		}
		else {
			passwordField.setText(null);
		}
	}
}
