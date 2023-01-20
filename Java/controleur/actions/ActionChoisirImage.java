package Java.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import Java.vue.ihm.PanneauActualites;

public class ActionChoisirImage extends AbstractAction{

    private PanneauActualites panneauActualites;
    private JLabel imageChoisie;

    public ActionChoisirImage(PanneauActualites panneauActualites,JLabel imageChoisie){
        super("ValidationActu");
        this.panneauActualites = panneauActualites;
        this.imageChoisie = imageChoisie;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser("Importer");

		FileNameExtensionFilter filtre = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png");
		fileChooser.addChoosableFileFilter(filtre);
        fileChooser.setFileFilter(filtre);

		int choose = fileChooser.showOpenDialog(this.panneauActualites);
		
		if(choose == JFileChooser.APPROVE_OPTION) {
			String path  = fileChooser.getSelectedFile().getAbsolutePath();
            if(path.contains("Website")){
                if(path.contains("img")){
                    int startIndex = path.indexOf("img");
                    String newPath = path.substring(startIndex);
                    newPath = newPath.replace("\\", "/");
                    this.panneauActualites.setPath(this.imageChoisie,"../"+newPath);
                }
            }else{
			    this.panneauActualites.setPath(this.imageChoisie,"L'image n'est pas dans le bon dossier");
            }
		}
    }
    
}
