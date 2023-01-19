package Java.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.util.List;

import Java.modele.basededonnees.RequeteBddAvis;
import Java.vue.ihm.MainJFrame;
import javax.swing.JOptionPane;
import Java.vue.ihm.PanneauQuestions;

public class ActionValiderAvis extends AbstractAction{

    private MainJFrame mainJFrame;
    private PanneauQuestions panneauQuestions;

    private List<Integer> listNumber;
    private int index;

    public PanneauQuestions getPanneauQuestions() {
        return panneauQuestions;
    }

    public ActionValiderAvis(MainJFrame mainJFrame, PanneauQuestions panneauQuestions){
        super("ValidationAvis");
        this.mainJFrame = mainJFrame;
        this.panneauQuestions = panneauQuestions;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String name = source.getName();

        listNumber = this.panneauQuestions.getListNumber();
        this.index = listNumber.get(Integer.valueOf(name));

        this.requetePublicationAvis();
        JOptionPane.showMessageDialog(null, "L'avis a bien été publié sur le site web", "Information", JOptionPane.INFORMATION_MESSAGE);
        this.mainJFrame.setContentPane("questions");
    }

    private void requetePublicationAvis(){
        RequeteBddAvis requetteBddAvis = new RequeteBddAvis();
        requetteBddAvis.publierAvis(this);
    }

    public int getIndex() {
        return index;
    }
}
