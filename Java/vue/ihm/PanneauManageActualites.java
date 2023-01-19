package Java.vue.ihm;

import javax.swing.JButton;
import javax.swing.JPanel;

import Java.controleur.actions.ActionChangerPanneau;

public class PanneauManageActualites extends JPanel{

    private MainJFrame mainJFrame;

    public PanneauManageActualites(MainJFrame mainJFrame){
        this.mainJFrame = mainJFrame;

        JButton buttonRetour = new JButton(new ActionChangerPanneau(this.mainJFrame, "Retour", "actualites"));
        buttonRetour.setText("Retour");
        this.add(buttonRetour);
    }
    
}
