package Java.modele.basededonnees;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Java.controleur.actions.ActionValiderAvis;
import Java.controleur.actions.ActionDepublierAvis;
import Java.controleur.actions.ActionSupprimerAvis;

public class RequeteBddAvis {

    private ConnectionBdd dbConnection;
    private ActionValiderAvis actionValiderAvis;
    private ActionDepublierAvis actionDepublierAvis;
    private ActionSupprimerAvis actionSupprimerAvis;
    
    public RequeteBddAvis(){
        this.dbConnection = new ConnectionBdd();
    }

    public void publierAvis(ActionValiderAvis actionValiderAvis){
        this.actionValiderAvis = actionValiderAvis;
        dbConnection.openConnection();
        try {
            String sql = "UPDATE `Avis` SET valide = '1' WHERE id = ?";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(sql);
            stmt.setInt(1, this.actionValiderAvis.getIndex());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
    }

    public void depublierAvis(ActionDepublierAvis actionDepublierAvis){
        this.actionDepublierAvis = actionDepublierAvis;
        dbConnection.openConnection();
        try {
            String sql = "UPDATE `Avis` SET valide = '0' WHERE id = ?";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(sql);
            stmt.setInt(1, this.actionDepublierAvis.getIndex());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
    }

    public void supprimerAvis(ActionSupprimerAvis actionSupprimerAvis){
        this.actionSupprimerAvis = actionSupprimerAvis;
        dbConnection.openConnection();
        try {
            String query = "DELETE FROM Avis WHERE id = ?";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, this.actionSupprimerAvis.getIndex());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
    }

    public List<Integer>  getNumberAvis(){
        dbConnection.openConnection();
        List<Integer> listNumber = new ArrayList<>();
        try {
            String query = "SELECT id FROM Avis";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listNumber.add(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listNumber;
    }

    public List<String>  getNom(){
        dbConnection.openConnection();
        List<String> listNom = new ArrayList<>();
        try {
            String query = "SELECT nom FROM Avis";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listNom.add(rs.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listNom;
    }

    public List<String>  getPrenom(){
        dbConnection.openConnection();
        List<String> listPrenom = new ArrayList<>();
        try {
            String query = "SELECT prenom FROM Avis";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listPrenom.add(rs.getString("prenom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listPrenom;
    }

    public List<String>  getEmail(){
        dbConnection.openConnection();
        List<String> listEmail = new ArrayList<>();
        try {
            String query = "SELECT email FROM Avis";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listEmail.add(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listEmail;
    }

    public List<String>  getCommentaire(){
        dbConnection.openConnection();
        List<String> listCommentaire = new ArrayList<>();
        try {
            String query = "SELECT commentaire FROM Avis";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listCommentaire.add(rs.getString("commentaire"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listCommentaire;
    }

    public List<Integer>  getNote(){
        dbConnection.openConnection();
        List<Integer> listNote = new ArrayList<>();
        try {
            String query = "SELECT note FROM Avis";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listNote.add(rs.getInt("note"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listNote;
    }

    public List<Boolean>  getValide(){
        dbConnection.openConnection();
        List<Boolean> listValide = new ArrayList<>();
        try {
            String query = "SELECT valide FROM Avis";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listValide.add(rs.getBoolean("valide"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listValide;
    }
}
