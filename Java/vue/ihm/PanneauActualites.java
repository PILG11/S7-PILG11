package Java.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Java.controleur.actions.ActionChangerPanneau;
import Java.controleur.actions.ActionChoisirImage;
import Java.controleur.actions.ActionValiderActu;

public class PanneauActualites extends JPanel{

    private MainJFrame mainJFrame;

    private JLabel titreLabel;
    private JTextField titreField;
    private JLabel descriptionLabel;
    private JTextArea descriptionArea;

    public PanneauActualites(MainJFrame mainJFrame){
        this.mainJFrame = mainJFrame;
        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        super.setBackground(Color.gray);
        super.setPreferredSize(new Dimension(800,300));

        this.initChampSaisie();
        this.initChampImage();
        this.initBouton();
    }

    private void initChampSaisie(){
        titreLabel = new JLabel("Titre :");
        titreField = new JTextField();

        descriptionLabel = new JLabel("Description :");
        descriptionArea = new JTextArea();
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

        add(titreLabel);
        add(titreField);
        add(descriptionLabel);
        add(descriptionArea);
    }

    private void initChampImage(){
        JButton buttonChoixImg1 = new JButton(new ActionChoisirImage(this));
        buttonChoixImg1.setText("Choisir Image 1");

        JButton buttonChoixImg2 = new JButton(new ActionChoisirImage(this));
        buttonChoixImg2.setText("Choisir Image 2");

        JButton buttonChoixImg3 = new JButton(new ActionChoisirImage(this));
        buttonChoixImg3.setText("Choisir Image 3");

        JButton buttonChoixImg4 = new JButton(new ActionChoisirImage(this));
        buttonChoixImg4.setText("Choisir Image 4");

        this.add(buttonChoixImg1);
        this.add(buttonChoixImg2);
        this.add(buttonChoixImg3);
        this.add(buttonChoixImg4);
    }

    private void initBouton(){
        JButton buttonRetour = new JButton(new ActionChangerPanneau(this.mainJFrame, "Retour", "accueil"));
        buttonRetour.setText("Retour");

        JButton buttonValider = new JButton(new ActionValiderActu(this.mainJFrame));
        buttonValider.setText("Valider");

        JButton buttonReset = new JButton(new ActionChangerPanneau(this.mainJFrame, "Reset", "actualites"));
        buttonReset.setText("Reset");

        this.add(buttonRetour);
        this.add(buttonValider);
        this.add(buttonReset);
    }
    
}
