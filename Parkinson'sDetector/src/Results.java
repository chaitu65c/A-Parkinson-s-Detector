import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class Results extends JPanel {
	JButton toMenu, playGame;
	static JLabel results;
	Main m;
	String text;
	public static int[] r = new int[4];
	public static double wordsPerMinute;

	public Results(Main main) {
		initComponents();
		m = main;
		
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		playGame = new JButton();
		toMenu = new JButton();
		results = new JLabel();

		setBackground(new Color(44, 62, 80));

		playGame.setText("Retry the test");
		playGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					restartGameActionPerformed(evt);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		toMenu.setText("Go to Menu");
		toMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				toInstructionsActionPerformed(evt);
			}
		});
		if(r != null){
			text = getResults();
		}
		else{
			text = "";
		}
		results = new JLabel();
		results.setText("<html><div style='text-align: center;'>" + text + "</html>");
		results.setFont(new Font("Times New Roman", 0, 48));
		results.setForeground(new Color(255, 255, 255));
		javax.swing.GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								layout.createSequentialGroup().addGap(200, 200, 200)
										.addComponent(playGame, GroupLayout.PREFERRED_SIZE, 160,
												GroupLayout.PREFERRED_SIZE)
										.addGap(82, 82, 82)
										.addComponent(toMenu, GroupLayout.PREFERRED_SIZE, 160,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(198, Short.MAX_VALUE))
						.addGroup(GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup()
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(results).addGap(248, 248, 248)));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(205, 205, 205).addComponent(results)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(playGame, GroupLayout.PREFERRED_SIZE, 80,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(toMenu, GroupLayout.PREFERRED_SIZE, 80,
												GroupLayout.PREFERRED_SIZE))
								.addGap(150, 150, 150)));
	}

	public  void refresh() {
		text = getResults();
		initComponents();
	}

	public static String getResults() {
		int age, diet, gender, sleep; // 1 for opt1, 0 for opt2, -1 for opt3;
		age = diet = gender = sleep = 0;
		String results = "";
		boolean Age, Diet, Gender, Sleep;
		Age = Gender = Sleep = Diet = false;
		for (int i = 0; i < r.length; i++) {
			if(i == 0){
				age = r[i];
			}
			else if(i==1){
				diet = r[1];
			}
			else if (i == 2){
				gender = r[i];
			}
			else if(i == 3){
				sleep = r[i];
			}
		}
		if (age == 1)
			return "Our test will not show you have if you have signs of Parkinson's.<br> But, it is advisable to talk to your doctor.";
		else
			Age = true;
		if (diet == 0)
			Diet = true;
		if (gender != -1)
			Gender = true;
		if (sleep == 0)
			Sleep = true;
		if (Age && Diet && Gender && wordsPerMinute < 26 && wordsPerMinute > 0) {
			return "Please consult your doctor immediately.<br> The reason is because your age is in the general limit.<br> In addition, your diet is another factor plus<br>your typing speed is below the average typing speed.";
		} else if ((Age && Diet || Age && Sleep) && wordsPerMinute < 26 && wordsPerMinute > 0) {
			return "Please consult your doctor immediately.<br> The reason is because your age is in the general limit.<br> In addition, your diet is another factor plus<br>your typing speed is below the average typing speed.";
		} else if (Age) {
			return "You are in the group inw which a lot of people have the disease. Try exercisizing regualrly and also conult your <br>doctor regularly if you experience other dsigns.";
		} else if (Sleep) {
			return "You could be displaying a false sign of the<br> disease. Try consulting your doctor to <br>get the correct answer.";
		} else if (Age && Diet || Age && Sleep) {
			return "You could be displaying early signs of the<br> disease. Try consulting your doctor to <br>prevent this.";
		}
		
		return "<br>Our test cannot find any signs for <br>you. Continue living a healthy lifestyle and<br>. you will be fine!";

	}

	protected void restartGameActionPerformed(ActionEvent evt) throws InterruptedException {
		// TODO Auto-generated method stub
		m.playGame();
	}

	protected void toInstructionsActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		m.changeFromInstructionsToMenu();
	}

	protected void playGameActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

	}

	public static void setR(int[] chosen) {
		// TODO Auto-generated method stub
		r = chosen;
	}

	public void setSpeed(double finalSpeed) {
		// TODO Auto-generated method stub
		wordsPerMinute = finalSpeed;
	}

}
