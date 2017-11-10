package User_Story_U3;

import javax.swing.JFrame;

public class ScorePanelTest extends JFrame{

	public ScorePanelTest() {
		add(new ScorePanel());
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ScorePanelTest();
	}

}
