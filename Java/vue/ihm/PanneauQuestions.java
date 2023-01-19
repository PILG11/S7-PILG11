package Java.vue.ihm;

import java.awt.Color;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.SwingConstants;


import java.util.List;

import Java.controleur.actions.ActionChangerPanneau;

import Java.controleur.actions.ActionValiderAvis;
import Java.controleur.actions.ActionDepublierAvis;
import Java.controleur.actions.ActionSupprimerAvis;
import Java.modele.basededonnees.RequeteBddAvis;

public class PanneauQuestions extends JPanel {

    private MainJFrame mainJFrame;

    private JLabel titreNumberAvis;
    private JLabel titreNom;
    private JLabel titrePrenom;
    private JLabel titreEmail;
    private JLabel titreRate;
    private JLabel titreCommentaire;
    private JLabel validation;

    List<String> listNom;
    List<String> listPrenom;
    List<String> listEmail;
    List<String> listCommentaire;
    List<Integer> listNumber;
    List<Integer> listNote;
    List<Boolean> listValide;

    public PanneauQuestions(MainJFrame mainJFrame) {
        super.setBackground(Color.white);
        this.mainJFrame = mainJFrame;

        GridLayout grid = new GridLayout(10, 1);
        this.setLayout(grid);

        JButton buttonRetour = new JButton(new ActionChangerPanneau(this.mainJFrame, "Retour", "accueil"));
        buttonRetour.setText("Retour");
        this.add(buttonRetour);

        this.labelTab();
        this.avisListe();
        this.afficherAvis();
    }

    private void labelTab() {
        JPanel ligne = new JPanel();
        ligne.setLayout(new GridLayout(1, 10));

        titreNumberAvis = new JLabel("Avis N°");
        titreNom = new JLabel("Nom");
        titrePrenom = new JLabel("Prénom");
        titreEmail = new JLabel("Adresse Email");
        titreRate = new JLabel("Note/5");
        titreCommentaire = new JLabel("Commentaire");
        validation = new JLabel("Validation");
        JLabel buttonPublier = new JLabel("Publier");
        JLabel buttonDepublier = new JLabel("Enlever");
        JLabel buttonSupprimer = new JLabel("Supprimer");

        titreNumberAvis.setHorizontalAlignment(SwingConstants.CENTER);
        titreNom.setHorizontalAlignment(SwingConstants.CENTER);
        titrePrenom.setHorizontalAlignment(SwingConstants.CENTER);
        titreEmail.setHorizontalAlignment(SwingConstants.CENTER);
        titreRate.setHorizontalAlignment(SwingConstants.CENTER);
        titreCommentaire.setHorizontalAlignment(SwingConstants.CENTER);
        validation.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPublier.setHorizontalAlignment(SwingConstants.CENTER);
        buttonDepublier.setHorizontalAlignment(SwingConstants.CENTER);
        buttonSupprimer.setHorizontalAlignment(SwingConstants.CENTER);

        ligne.add(titreNumberAvis);
        ligne.add(titreNom);
        ligne.add(titrePrenom);
        ligne.add(titreEmail);
        ligne.add(titreRate);
        ligne.add(titreCommentaire);
        ligne.add(validation);
        ligne.add(buttonPublier);
        ligne.add(buttonDepublier);
        ligne.add(buttonSupprimer);

        this.add(ligne);
    }

    private void afficherAvis() {
        for (int i = 0; i < this.listNumber.size(); i++) {

            JPanel ligne = new JPanel();
            ligne.setLayout(new GridLayout(1, 10));

            JLabel nom = new JLabel(this.listNom.get(i));
            JLabel prenom = new JLabel(this.listPrenom.get(i));
            JLabel email = new JLabel(this.listEmail.get(i));
            JLabel commentaire = new JLabel(this.listCommentaire.get(i));
            JLabel numero = new JLabel(Integer.toString(this.listNumber.get(i)));
            JLabel note = new JLabel(Integer.toString(this.listNote.get(i)));
            JLabel validation = new JLabel(Boolean.toString(this.listValide.get(i)));

            JButton buttonPublier = new JButton(new ActionValiderAvis(this.mainJFrame, this));
            buttonPublier.setText("Publier sur le site");
            String publier = Integer.toString(i);
            buttonPublier.setName(publier);

            JButton buttonDepublier = new JButton(new ActionDepublierAvis(this.mainJFrame, this));
            buttonDepublier.setText("Enlever l'avis");
            String depublier = Integer.toString(i);
            buttonDepublier.setName(depublier);

            JButton buttonSupprimer = new JButton(new ActionSupprimerAvis(this.mainJFrame, this));
            buttonSupprimer.setText("Supprimer l'avis");
            String supprimer = Integer.toString(i);
            buttonSupprimer.setName(supprimer);
           

            nom.setHorizontalAlignment(SwingConstants.CENTER);
            prenom.setHorizontalAlignment(SwingConstants.CENTER);
            email.setHorizontalAlignment(SwingConstants.CENTER);
            commentaire.setHorizontalAlignment(SwingConstants.CENTER);
            numero.setHorizontalAlignment(SwingConstants.CENTER);
            note.setHorizontalAlignment(SwingConstants.CENTER);
            validation.setHorizontalAlignment(SwingConstants.CENTER);
            buttonPublier.setHorizontalAlignment(SwingConstants.CENTER);
            buttonDepublier.setHorizontalAlignment(SwingConstants.CENTER);
            buttonSupprimer.setHorizontalAlignment(SwingConstants.CENTER);

            ligne.add(numero);
            ligne.add(nom);
            ligne.add(prenom);
            ligne.add(email);
            ligne.add(commentaire);
            ligne.add(numero);
            ligne.add(note);
            ligne.add(validation);
            ligne.add(buttonPublier);
            ligne.add(buttonDepublier);
            ligne.add(buttonSupprimer);
          
            this.add(ligne);
        }
    }

    private void avisListe() {
        RequeteBddAvis requeteBddAvis = new RequeteBddAvis();
        this.listNom = requeteBddAvis.getNom();
        this.listPrenom = requeteBddAvis.getPrenom();
        this.listEmail = requeteBddAvis.getEmail();
        this.listCommentaire = requeteBddAvis.getCommentaire();
        this.listNumber = requeteBddAvis.getNumberAvis();
        this.listNote = requeteBddAvis.getNote();
        this.listValide = requeteBddAvis.getValide();
    }

    public List<Integer> getListNumber() {
        return listNumber;
    }
}
