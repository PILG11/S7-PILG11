package Java.modele.basededonnees;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequeteBddReservation {
    
    private ConnectionBdd dbConnection;

    public RequeteBddReservation(){
        this.dbConnection = new ConnectionBdd();
    }

    public List<Integer>  RecupererReservationId(){
        dbConnection.openConnection();
        List<Integer> listId = new ArrayList<>();
        try {
            String query = "SELECT Reservations.id FROM Reservations ;";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listId.add(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listId;
    }

    public List<String>  RecupererReservationEvenement(){
        dbConnection.openConnection();
        List<String> listId = new ArrayList<>();
        try {
            String query = "SELECT Reservations.evenement FROM Reservations ;";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listId.add(rs.getString("evenement"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listId;
    }

    public List<Integer>  RecupererReservationValide(){
        dbConnection.openConnection();
        List<Integer> listId = new ArrayList<>();
        try {
            String query = "SELECT Reservations.valide FROM Reservations ;";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listId.add(rs.getInt("valide"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listId;
    }

    public List<String>  RecupererReservationDateDebut(){
        dbConnection.openConnection();
        List<String> listId = new ArrayList<>();
        try {
            String query = "SELECT Reservations.dateDebut FROM Reservations ;";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listId.add(rs.getString("dateDebut"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listId;
    }

    public List<String>  RecupererReservationDuree(){
        dbConnection.openConnection();
        List<String> listId = new ArrayList<>();
        try {
            String query = "SELECT Reservations.duree FROM Reservations ;";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listId.add(rs.getString("duree"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listId;
    }

    public List<String>  RecupererReservationChambres(){
        dbConnection.openConnection();
        List<String> listId = new ArrayList<>();
        try {
            String query = "SELECT Chambres.nom FROM Chambres, Reservations WHERE Chambres.id = Reservations.chambres";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listId.add(rs.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listId;
    }

    public List<String>  RecupererReservationSalles(){
        dbConnection.openConnection();
        List<String> listId = new ArrayList<>();
        try {
            String query = "SELECT Salles.nom FROM Salles, Reservations WHERE Salles.id = Reservations.salles";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listId.add(rs.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listId;
    }

    public List<String>  RecupererReservationClientNom(){
        dbConnection.openConnection();
        List<String> listId = new ArrayList<>();
        try {
            String query = "SELECT Clients.nom FROM Clients, Reservations WHERE Clients.id = Reservations.client";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listId.add(rs.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listId;
    }

    public List<String>  RecupererReservationClientPrenom(){
        dbConnection.openConnection();
        List<String> listId = new ArrayList<>();
        try {
            String query = "SELECT Clients.prenom FROM Clients, Reservations WHERE Clients.id = Reservations.client";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listId.add(rs.getString("prenom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listId;
    }

    public List<Integer>  RecupererReservationClientId(){
        dbConnection.openConnection();
        List<Integer> listId = new ArrayList<>();
        try {
            String query = "SELECT Reservations.client FROM Reservations;";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listId.add(rs.getInt("client"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listId;
    }

    public int nombreDemandeReservation(){
        dbConnection.openConnection();
        int maxId = 0;
        try {
            String query = "SELECT COUNT(*) FROM Reservations;";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            maxId = rs.getInt("COUNT(*)");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return maxId;
    }

    public List<String> informationClientEmail(int idClient){

        dbConnection.openConnection();
        List<String> listInformationClient = new ArrayList<>();

        try {

            String query = "SELECT Clients.email FROM Clients WHERE Clients.id = " + idClient + ";";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listInformationClient.add(rs.getString("email"));
            }     
            return listInformationClient;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listInformationClient;
    }

    public List<String> informationClientNumero(int idClient){

        dbConnection.openConnection();
        List<String> listInformationClient = new ArrayList<>();

        try {

            String query = "SELECT Clients.numero FROM Clients WHERE Clients.id = " + idClient + ";";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listInformationClient.add(rs.getString("numero"));
            }     
            return listInformationClient;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return listInformationClient;
    }

    public void validerReservation(int idClient){

        dbConnection.openConnection();

        try {

            String query = "UPDATE reservations SET valide = 1 WHERE reservations.client = " + idClient + ";";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
    }

    public void supprimerReservation(int idClient){

        dbConnection.openConnection();

        try {

            String query = "DELETE FROM reservations WHERE reservations.id = " + idClient + ";";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
    }

// id / evenement / valide / dateDebut / duree / chambres / salles / client

// INSERT INTO `reservations` (`id`, `evenement`, `valide`, `dateDebut`, `duree`, `chambres`, `salles`, `client`) VALUES ('1', 'Anniv', '0', '2023-02-02', '2', '2', '2', '1'), ('2', 'Mariage', '0', '2023-05-02', '3', '3', '1', '2');
}
