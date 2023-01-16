package Java;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

import Java.vue.ihm.PanneauAccueil;

public class GestionSite {
	
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
                new GestionSite();
            }
		});
	}

    private GestionSite() {
		JFrame testFrame = new JFrame("Gestion Du Site");
		PanneauAccueil panel = new PanneauAccueil();

        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.add(panel,BorderLayout.WEST);
		testFrame.pack();
		testFrame.setLocationRelativeTo(null);
		testFrame.setVisible(true);
    }

}