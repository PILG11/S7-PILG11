package Java.modele.basededonnees;

import java.sql.*;

public class RequeteBdd {

    public static void main(String[] args) {
        RequeteBdd service = new RequeteBdd();
        service.tryPull(service.dbConnection);
    }

    private ConnectionBdd dbConnection;

    public RequeteBdd() {
        dbConnection = new ConnectionBdd();
    }

    public void tryRequete(ConnectionBdd dbConnection){
        dbConnection.openConnection();
        try {
            String query = "INSERT INTO `Clients`(`id`, `nom`, `prenom`, `email`, `numero`) VALUES ('2','Hugo','Blois','blois@gmail.com','0672346666')";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("L'actualité a été ajoutée avec succès!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
    }

    public void tryPull(ConnectionBdd dbConnection){
        dbConnection.openConnection();
        try {
            String query = "SELECT * FROM Clients";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nom: " + rs.getString("nom"));
                System.out.println("Prenom: " + rs.getString("prenom"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Téléphone: " + rs.getString("numero"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
    }
    
}
