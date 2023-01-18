package Java;

import javax.swing.SwingUtilities;

import Java.vue.ihm.MainJFrame;

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
		new MainJFrame();
    }

}