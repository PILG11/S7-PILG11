package Java.vue.ihm;

import java.awt.GridLayout;
import java.awt.Dimension;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Java.controleur.actions.ActionChangerPanneau;
import Java.modele.basededonnees.RequeteBddActualites;

public class PanneauManageActualites extends JPanel{

    private MainJFrame mainJFrame;

    List<String> listTitre;
    List<String> listDescr;
    List<String> listDate;
    List<Integer> listId;

    public PanneauManageActualites(MainJFrame mainJFrame){
        this.mainJFrame = mainJFrame;
        GridLayout grid = new GridLayout(10, 1);
        this.setLayout(grid);
        super.setPreferredSize(new Dimension(600,500));
        this.initListe();
        this.initNomColonne();
        /// set les bouton suppr avec requete sqls
        this.afficherActu();
        this.returnButton();
    }

    private void initNomColonne(){
        JPanel ligne = new JPanel();
        ligne.setLayout(new GridLayout(1, 4));

        JLabel labelTitre = new JLabel("Titre");
        JLabel labelDescr = new JLabel("Description");
        JLabel labelDate = new JLabel("Date");
        JLabel labelSuppr = new JLabel("Supprimer l'actu");

        ligne.add(labelTitre);
        ligne.add(labelDescr);
        ligne.add(labelDate);
        ligne.add(labelSuppr);
        this.add(ligne);
    }

    private void afficherActu(){
        for (int i = 0; i < this.listTitre.size(); i++) {

            JPanel ligne = new JPanel();
            ligne.setLayout(new GridLayout(1, 4));

            JLabel titre = new JLabel(this.listTitre.get(i));
            JLabel descr = new JLabel(this.listDescr.get(i));
            JLabel date = new JLabel(this.listDate.get(i));
            JButton supprButton = new JButton(new ActionSupprActu());
            supprButton.setText("Supprimer");
            String num = Integer.toString(i);
            supprButton.setName(num);

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

    private void initListe(){
        RequeteBddActualites requeteBddActualites = new RequeteBddActualites();
        this.listTitre = requeteBddActualites.getTitre();
        this.listDescr = requeteBddActualites.getDescr();
        this.listDate = requeteBddActualites.getDate();
        this.listId = requeteBddActualites.getId();
    }
    
}
