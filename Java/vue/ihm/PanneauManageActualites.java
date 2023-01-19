package Java.vue.ihm;

import java.awt.GridLayout;
import java.awt.Dimension;

import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Java.controleur.actions.ActionChangerPanneau;

public class PanneauManageActualites extends JPanel{

    private MainJFrame mainJFrame;

    List<String> listTitre = Arrays.asList("titre1", "titre2", "titre3");
    List<String> listDescr = Arrays.asList("descr1", "descr2", "descr3");
    List<String> listDate = Arrays.asList("date1","date2","date3");

    public PanneauManageActualites(MainJFrame mainJFrame){
        this.mainJFrame = mainJFrame;
        GridLayout grid = new GridLayout(10, 1);
        this.setLayout(grid);
        super.setPreferredSize(new Dimension(600,500));
        /// requete sql pour recup les lists
        /// set les bouton suppr avec requete sqls
        afficherActu();
        returnButton();
    }

    private void afficherActu(){
        for (int i = 0; i < this.listTitre.size(); i++) {

            JPanel ligne = new JPanel();
            ligne.setLayout(new GridLayout(1, 3));

            JLabel titre = new JLabel(this.listTitre.get(i));
            JLabel descr = new JLabel(this.listDescr.get(i));
            JLabel date = new JLabel(this.listDate.get(i));
            JButton supprButton = new JButton();
            supprButton.setText("Supprimer");

            ligne.add(titre);
            ligne.add(descr);
            ligne.add(date);
            ligne.add(supprButton);
            this.add(ligne);
        }
    }

    private void returnButton(){
        JButton buttonRetour = new JButton(new ActionChangerPanneau(this.mainJFrame, "Retour", "actualites"));
        buttonRetour.setText("Retour");
        this.add(buttonRetour);
    }
    
}
