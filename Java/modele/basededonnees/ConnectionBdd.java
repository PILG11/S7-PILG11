package Java.modele.basededonnees;

import java.sql.*;

public class ConnectionBdd {
    
    private Connection connection;

    public void openConnection() {
        try {
            // Établir la connexion à la base de données en utilisant les informations de connexion
            String url = "jdbc:mysql://192.168.56.81:3306";
            String login = "admin";
            String password = "mdpgite";
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
