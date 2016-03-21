import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test extends JFrame implements ActionListener {
	private JFrame thisWindow;
	private JTextArea original, marked, words;
	private JButton stop, refresh, start;
	private String inBox;
	private int wordCount;
	private long startTime, endTime;
	private Algorithm analyzer = new Algorithm();
	Main m;
	private double finalSpeed;

	// Constructor
	public Test() throws InterruptedException{		
		super("The Typing Test");
		m = new Main();
		thisWindow = this;
		startTime = endTime=0;
		setJMenuBar(new MenuBar(this));
		setupGui();
		original.setText("");
		refresh();
	}

	public String getText() {
		return marked.getText();
	}

	public void setText(String text) {
		original.setText(text);
	}

	public void refresh() {
		Algorithm analyzer = new Algorithm();
		inBox = analyzer.wordsChosen();
		original.setText(inBox);

	}

	// Called when the Refresh button is clicked
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Restart the test")) {
			refresh();
			start.setEnabled(true);
			 stop.setEnabled(false);
		} 
		else if(e.getActionCommand().equals("Stop the test")){
			 endTime = System.currentTimeMillis();
			 start.setEnabled(true);
			 stop.setEnabled(false);
			 double word = 0;
			 double time = 0;
			 double wordsInSec = 0;
			 double wordsInMin = 0;
			 time = (endTime - startTime) / 1000.0;
			 if(getText().length()> 0)
			{
			 word = getText().length()/5.0;
			 wordsInSec = word/time;
			 wordsInMin = wordsInSec * 60;
			 finalSpeed = (analyzer.getSpeed(inBox, getText(),time, wordsInMin));
			 Results.wordsPerMinute = (double) finalSpeed;
			}	
			 words.setText("" + time + " seconds" + "\n" + finalSpeed+ " WPM"+"\n" + inBox.length()/5.0 + " Words");
			 refresh();
		}
		else if(e.getActionCommand().equals("Start the Test")){
			marked.setEditable(true);
			 startTime = System.currentTimeMillis();
			 start.setEnabled(false);
			 stop.setEnabled(true);
		
		}
	}

	// ********************** GUI setup ********************************

	private void setupGui() {
		original = new JTextArea(10, 20);
		original.setLineWrap(true);
		original.setWrapStyleWord(true);
		JScrollPane originalPane = new JScrollPane(original, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		original.setTransferHandler(null);

		marked = new JTextArea(10, 20);
		original.setEditable(false);
		original.setBackground(Color.LIGHT_GRAY);
		marked.setEditable(false);
		marked.setLineWrap(true);
		marked.setWrapStyleWord(true);
		JScrollPane markedPane = new JScrollPane(marked, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		marked.setTransferHandler(null);
		
		words = new JTextArea(10, 10);
		words.setEditable(false);
		words.setBackground(Color.LIGHT_GRAY);
		JScrollPane wordsPane = new JScrollPane(words, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		stop = new JButton("Stop the test");
		stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                goToResults(evt);
            }
        });
		refresh = new JButton("Restart the test");
		refresh.addActionListener(this);
		stop.setEnabled(false);
		stop.addActionListener(this);
		start = new JButton("Start the Test");
		start.addActionListener(this);
		
		Box box1 = Box.createVerticalBox();
		box1.add(Box.createVerticalStrut(10));
		box1.add(originalPane);
		box1.add(Box.createVerticalStrut(10));
		box1.add(markedPane);
		box1.add(Box.createVerticalStrut(10));
		box1.add(stop);
		box1.add(refresh);
		box1.add(start);

		Box box2 = Box.createVerticalBox();
		box2.add(Box.createVerticalStrut(10));
		box2.add(wordsPane);
		box2.add(Box.createVerticalStrut(40));
		Box box3 = Box.createHorizontalBox();
		box3.add(box1);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(box2);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(box3);
	}

	protected void goToResults(ActionEvent evt) {
		// TODO Auto-generated method stub
		m.getResults();
		m.setSpeed(finalSpeed);
	}

	public void main(String[] args) throws InterruptedException {
		Test window = new Test();
		window.setBounds(0, 0, 480, 600);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
