package Java.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Java.vue.ihm.MainJFrame;

public class ActionValiderActu extends AbstractAction{

    private MainJFrame mainJFrame;
    
    public ActionValiderActu(MainJFrame mainJFrame){
        super("ValidationActu");
        this.mainJFrame = mainJFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
