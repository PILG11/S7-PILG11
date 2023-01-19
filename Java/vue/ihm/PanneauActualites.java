package Java.vue.ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;

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
    private JLabel pathImage1;
    private JLabel pathImage2;
    private JLabel pathImage3;
    private JLabel pathImage4;

    public PanneauActualites(MainJFrame mainJFrame){
        this.mainJFrame = mainJFrame;
        GridLayout grid = new GridLayout(8, 2,30,15);
        this.setLayout(grid);
        super.setBackground(Color.gray);
        super.setPreferredSize(new Dimension(600,500));

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
        pathImage1 = new JLabel("Choisir une image 1");
        JButton buttonChoixImg1 = new JButton(new ActionChoisirImage(this,pathImage1));
        buttonChoixImg1.setText("Choisir Image 1");

        pathImage2 = new JLabel("Choisir une image 2");
        JButton buttonChoixImg2 = new JButton(new ActionChoisirImage(this,pathImage2));
        buttonChoixImg2.setText("Choisir Image 2");

        pathImage3 = new JLabel("Choisir une image 3");
        JButton buttonChoixImg3 = new JButton(new ActionChoisirImage(this,pathImage3));
        buttonChoixImg3.setText("Choisir Image 3");

        pathImage4 = new JLabel("Choisir une image 4");
        JButton buttonChoixImg4 = new JButton(new ActionChoisirImage(this,pathImage4));
        buttonChoixImg4.setText("Choisir Image 4");

        
        this.add(buttonChoixImg1);
        this.add(pathImage1);
        this.add(buttonChoixImg2);
        this.add(pathImage2);
        this.add(buttonChoixImg3);
        this.add(pathImage3);
        this.add(buttonChoixImg4);
        this.add(pathImage4);
    }

    private void initBouton(){
        JButton buttonRetour = new JButton(new ActionChangerPanneau(this.mainJFrame, "Retour", "accueil"));
        buttonRetour.setText("Retour");

        JButton buttonValider = new JButton(new ActionValiderActu(this.mainJFrame, this));
        buttonValider.setText("Valider");

        JButton buttonReset = new JButton(new ActionChangerPanneau(this.mainJFrame, "Reset", "actualites"));
        buttonReset.setText("Reset");

        JButton buttonManage = new JButton(new ActionChangerPanneau(this.mainJFrame, "Manage", "manageActualites"));
        buttonManage.setText("Gérer les actus");

        this.add(buttonValider);
        this.add(buttonReset);
        this.add(buttonManage);
        this.add(buttonRetour);
    }

    public void setPath(JLabel pathImage, String path){
        pathImage.setText(path);
    }

    public String getTitle(){
        return this.titreField.getText();
    }

    public String getDescription(){
        return this.descriptionArea.getText();
    }

    public String getPathImage1(){
        String path = this.pathImage1.getText();
        if (path == "Choisir une image 1" | path == "L'image n'est pas dans le bon dossier"){
            return null;
        }
        return path;
    }

    public String getPathImage2(){
        String path = this.pathImage2.getText();
        if (path == "Choisir une image 2" | path == "L'image n'est pas dans le bon dossier"){
            return null;
        }
        return path;
    }

    public String getPathImage3(){
        String path = this.pathImage3.getText();
        if (path == "Choisir une image 3" | path == "L'image n'est pas dans le bon dossier"){
            return null;
        }
        return path;
    }

    public String getPathImage4(){
        String path = this.pathImage4.getText();
        if (path == "Choisir une image 4" | path == "L'image n'est pas dans le bon dossier"){
            return null;
        }
        return path;
    }
    
}
