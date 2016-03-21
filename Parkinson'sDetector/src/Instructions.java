import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chaitanya Manchikanti
 */
public class Instructions extends JPanel {

	Main m;
	
    public Instructions(Main main) {
        initComponents();
        m = main;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backToMenu = new JButton();
        playGame = new JButton();
        mainObjective = new JLabel();
        avoid = new JLabel();

        backToMenu.setText("Back to Menu");
        backToMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backToMenuActionPerformed(evt);
            }
        });

        playGame.setText("Start the Test!" );
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

        mainObjective.setFont(new Font("Arial", 0, 32)); // NOI18N
        mainObjective.setText("This test compromises of a poll section and a typing test");

        avoid.setFont(new Font("Arial", 0, 24)); // NOI18N
        avoid.setText("<html>The test will be compossed of two tests: " + "<br>1) A poll about your diet and lifestyle" 
        + "<br>2) A Typing test to test your Motor Skills</html>");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(backToMenu, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(playGame, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(mainObjective)
                            .addComponent(avoid))))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(playGame, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(backToMenu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65)
                .addComponent(mainObjective)
                .addGap(26, 26, 26)
                .addComponent(avoid)
                .addContainerGap(568, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backToMenuActionPerformed(ActionEvent evt) {//GEN-FIRST:event_backToMenuActionPerformed
        // TODO add your handling code here:
    	m.changeFromInstructionsToMenu();
    }//GEN-LAST:event_backToMenuActionPerformed

    private void playGameActionPerformed(ActionEvent evt) throws InterruptedException {//GEN-FIRST:event_playGameActionPerformed
        // TODO add your handling code here:
    	m.playGame();
    }//GEN-LAST:event_playGameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToMenu;
    private javax.swing.JLabel mainObjective;
    private javax.swing.JLabel avoid;
    private javax.swing.JButton playGame;
    // End of variables declaration//GEN-END:variables
}
