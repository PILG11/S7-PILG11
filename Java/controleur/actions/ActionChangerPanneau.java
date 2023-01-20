package Java.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Java.vue.ihm.MainJFrame;

public class ActionChangerPanneau extends AbstractAction{

    private MainJFrame mainJFrame;
    private String nouveauPanneau;

    public ActionChangerPanneau(MainJFrame mainJFrame, String nom, String nouveauPanneau){
        super(nom);
        this.mainJFrame = mainJFrame;
        this.nouveauPanneau = nouveauPanneau;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        this.mainJFrame.setContentPane(this.nouveauPanneau);
    }
    
}
