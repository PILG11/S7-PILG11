package Java.controleur.actions;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Java.modele.basededonnees.RequeteBddAvis;
import Java.vue.ihm.MainJFrame;
import Java.vue.ihm.PanneauQuestions;

public class ActionSupprimerAvis extends AbstractAction{

    private MainJFrame mainJFrame;
    private PanneauQuestions panneauQuestions;
    private List<Integer> listId;
    private int index;

    public ActionSupprimerAvis(MainJFrame mainJFrame, PanneauQuestions panneauQuestions){
        this.panneauQuestions = panneauQuestions;
        this.mainJFrame = mainJFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String name = source.getName();

        listId = this.panneauQuestions.getListNumber();
        this.index = listId.get(Integer.valueOf(name));

        System.out.println(index);

        RequeteBddAvis requeteBddAvis = new RequeteBddAvis();
        requeteBddAvis.supprimerAvis(this);
        JOptionPane.showMessageDialog(null, "L'avis a bien été supprimée de la base de données", "Information", JOptionPane.INFORMATION_MESSAGE);
        this.mainJFrame.setContentPane("questions");
    }

    public int getIndex() {
        return index;
    }
    
}