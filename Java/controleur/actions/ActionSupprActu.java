package Java.controleur.actions;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Java.modele.basededonnees.RequeteBddActualites;
import Java.vue.ihm.MainJFrame;
import Java.vue.ihm.PanneauManageActualites;

public class ActionSupprActu extends AbstractAction{

    private MainJFrame mainJFrame;
    private PanneauManageActualites panneauManageActualites;
    private List<Integer> listId;
    private int index;

    public ActionSupprActu(MainJFrame mainJFrame, PanneauManageActualites panneauManageActualites){
        this.panneauManageActualites = panneauManageActualites;
        this.mainJFrame = mainJFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String name = source.getName();

        listId = this.panneauManageActualites.getListId();
        this.index = listId.get(Integer.valueOf(name));

        RequeteBddActualites requeteBddActualites = new RequeteBddActualites();
        requeteBddActualites.supprActu(this);
        JOptionPane.showMessageDialog(null, "L'actualité à bien été supprimée de la base de données", "Information", JOptionPane.INFORMATION_MESSAGE);
        this.mainJFrame.setContentPane("manageActualites");
    }

    public int getIndex() {
        return index;
    }
    
}
