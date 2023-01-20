package Java.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Java.vue.ihm.MainJFrame;

public class ActionChangerPanneau extends AbstractAction{

    private MainJFrame mainJFrame;
    private String nouveauPanneau;
    private int indexClient = 0;

    public ActionChangerPanneau(MainJFrame mainJFrame, String nom, String nouveauPanneau){
        super(nom);
        this.mainJFrame = mainJFrame;
        this.nouveauPanneau = nouveauPanneau;
    }

    public ActionChangerPanneau(MainJFrame mainJFrame, String nom, String nouveauPanneau, int indexClient){
        super(nom);
        this.mainJFrame = mainJFrame;
        this.indexClient = indexClient;
        this.nouveauPanneau = nouveauPanneau;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(this.indexClient != 0){
            this.mainJFrame.setContentPane(this.nouveauPanneau, this.indexClient);
        }
        this.mainJFrame.setContentPane(this.nouveauPanneau);
    }
    
}
