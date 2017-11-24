package User_Story_U1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
	private JPanel center,south,input,status_btn,content;
	private JLabel user,pass,status;
	private JTextField id;
	private JPasswordField password;
	private JButton btn;
	private CheckLogIn controllerLogin;
	
	public LoginFrame() {
		controllerLogin = new CheckLogIn();
		center = new JPanel();
		south = new JPanel();
		input = new JPanel();
		status_btn = new JPanel();
		user = new JLabel("Username:",JLabel.LEFT);
		pass = new JLabel("Password:");
		status = new JLabel("                         ");
		id = new JTextField(16);
		password = new JPasswordField(16);
		btn = new JButton("Login");
		center.setLayout(new GridLayout(4, 0));
		status_btn.setLayout(new BorderLayout());
		addtoPanel();
		addtoJFrame();
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
	}
	private void addtoJFrame() {
		setTitle("Log In");
		add(content);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private void addtoPanel() {
		content = new JPanel(new BorderLayout());
		content.setPreferredSize(new Dimension(230, 120));
		center.add(user);
		center.add(id);
		center.add(pass);
		center.add(password);
		input.add(center);
		status_btn.add(btn,BorderLayout.EAST);
		status_btn.add(status);
		south.add(status_btn);
		content.add(input);
		content.add(south,BorderLayout.SOUTH);
	}
	private void login() {
		if(controllerLogin.checkId_Pass(id.getText().trim(), password.getText().trim())) {
			controllerLogin.nextStepBeforeCheck(true);
			dispose();
		}
		else {
			password.setText(null);
			status.setText("invalid ID or PASSWPRD");
		}
	}
	
	public void close() {
		dispose();
	}
	public static void main(String[] args) {
		new LoginFrame();
	}

}
