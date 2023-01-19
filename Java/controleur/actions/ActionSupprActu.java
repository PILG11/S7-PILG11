package Java.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Java.vue.ihm.MainJFrame;

public class ActionSupprActu extends AbstractAction{

    private MainJFrame mainJFrame;

    public ActionSupprActu(MainJFrame mainJFrame){
        this.mainJFrame = mainJFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        this.mainJFrame.setContentPane("manageActualites");
    }
    
}
