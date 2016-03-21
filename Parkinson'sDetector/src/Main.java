
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Main extends JFrame implements KeyListener {

	JPanel menus, game, deathScreen;
	Results r;
	CardLayout cl;

	// Changes made: added throws InterruptedException

	public Main() throws InterruptedException {

		super("Parkinson's Tester");

		setBounds(0, 0, 1000, 1000);
		setDefaultCloseOperation(3);
		setResizable(false);

		menus = new JPanel();
		game = new JPanel();
		deathScreen = new JPanel();

		cl = new CardLayout();
		menus.setLayout(cl);

		IntroScreen intro = new IntroScreen(this);
		Instructions instructions = new Instructions(this);
		// Poll questions = new Poll(this);
		r = new Results(this);
		// Test test = new Test(this);
		// gamePanel = new GameLoop(this);
		// loseScreen = new DeathScreen(gamePanel);

		// game.add(gamePanel);

		menus.add(intro, "1");
		menus.add(instructions, "2");
		menus.add(r, "3");

		// deathScreen.add(screen);
		// menus.add(panel2, " 2");
		add(menus);

		setVisible(true);
		setResizable(false);

	}

	public void getResults() {

		((CardLayout) menus.getLayout()).show(menus, "3");
		requestFocus();
	}

	public void playGame() throws InterruptedException {
		JPanel panel = new JPanel();// Ten30, Thirty50, Fifty, Veg, Omni, Vegan,
									// Male, Female,Other,Insomia,noInsomia
		JRadioButton b1 = new JRadioButton();
		JRadioButton b2 = new JRadioButton();
		JRadioButton b3 = new JRadioButton();

		String[] options1 = { "Under 30", "Veg", "Male", "Yes" };
		String[] options2 = { "30-50", "Anything", "Female", "Nope" };
		String[] options3 = { "50+", "Vegan", "Prefer not to identify", "Sometimes" };
		String[] questions = { "WHAT IS YOUR AGE?", "WHAT IS YOUR DIET?", "WHAT IS YOUR GENDER?",
				"ARE YOU ABLE TO SLEEP AT NIGHT?" };
		int[] chosen = new int[12];
		for (int i = 0; i < 4; i++) {
			b1 = new JRadioButton(options1[i]);
			b1.setActionCommand(options1[i]);
			b2 = new JRadioButton(options2[i]);
			b2.setActionCommand(options2[i]);
			b3 = new JRadioButton(options3[i]);
			b3.setActionCommand(options3[i]);

			panel = new JPanel();
			panel.add(new JLabel(questions[i]));
			panel.add(b1);
			panel.add(b2);
			panel.add(b3);
			JOptionPane.showMessageDialog(null, panel);
			if (b1.isSelected()) {
				chosen[i] = 1;
			} else if (b2.isSelected()) {
				chosen[i] = 0;
			}
			else{
				chosen[i] = -1;
			}
		}
		r.setR(chosen);
		Test t = new Test();
		t.main(null);
	}

	public void changeToInstructions() {
		((CardLayout) menus.getLayout()).show(menus, "2");
		requestFocus();
	}

	public void changeFromInstructionsToMenu() {
		((CardLayout) menus.getLayout()).show(menus, "1");
		requestFocus();
	}

	public static void main(String[] args) throws InterruptedException {
		Main w = new Main();
		w.addKeyListener(w);
		// JFrame frame = new JFrame("Storm Runners");
		// frame.getContentPane().add(w);
		// frame.setBounds(100, 100, 800, 700);
		// frame.setResizable(true);
		// frame.setVisible(true);
		// frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void setSpeed(double finalSpeed) {
		// TODO Auto-generated method stub
		r.setSpeed(finalSpeed);
	}

}
