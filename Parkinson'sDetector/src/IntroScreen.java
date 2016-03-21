

//	public IntroScreen() {
//		super("The Typing Test");
//		thisWindow = this;
//		startTime = endTime=0;
//		setJMenuBar(new MenuBar(this));
//		setupGui();
//		original.setText("");
//		refresh();
//	}
//	
//	public static void main(String[] args) {
//		Test window = new Test();
//		window.setBounds(0, 0, 480, 600);
//		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		window.setVisible(true);
//	}
//}
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class IntroScreen extends JPanel {

		Main m;
		private JLabel title;
	    private JButton playGame;
	    private JButton toInstructions;
	    
	    public IntroScreen(Main w) {
	        initComponents();
	        m = w;
	    }

	    @SuppressWarnings("unchecked")
	    private void initComponents() {

	        playGame = new JButton();
	        toInstructions = new JButton();
	        title = new JLabel();

	        setBackground(new Color(44, 62, 80));

	        playGame.setText("Start the Test!");
	        playGame.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                try {
						playGameActionPerformed(evt);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        });

	        toInstructions.setText("Instructions?");
	        toInstructions.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                toInstructionsActionPerformed(evt);
	            }
	        });
	        String text = "Parkinson's Tester<br>Done By:<br>Chaitanya Manchikanti<br>Homestead High School"
	        		+ "<br><br> DISCLAIMER: THIS TEST IS NOT 100% ACCURATE. IT TELLS THE DECISION BASED ON THIS"
	        		+ " DATA ONLY AND THERE ARE MORE FACTORS.";
	        title =  new JLabel("<html><div style='text-align: center;'>" + text + "</html>");
	        title.setFont(new Font("Times New Roman", 0, 36)); 
	        title.setForeground(new Color(255,255,255));
	      

	       
	        javax.swing.GroupLayout layout = new GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(200, 200, 200)
	                .addComponent(playGame, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
	                .addGap(82, 82, 82)
	                .addComponent(toInstructions, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(198, Short.MAX_VALUE))
	            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(title)
	                .addGap(248, 248, 248))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addGap(75, 75, 75)
	                .addComponent(title)
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(playGame, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(toInstructions, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
	                .addGap(150, 150, 150))
	        );
	    }

	    private void playGameActionPerformed(ActionEvent evt) throws InterruptedException {
	        // TODO add your handling code here:
	    	m.playGame();
	    	
	    }
	    
	    private void toInstructionsActionPerformed(ActionEvent evt)
	    {
	    	m.changeToInstructions();
	    }

	

}
