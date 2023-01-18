package Java.modele.basededonnees;

import java.sql.*;

public class ConnectionBdd {
    
    private Connection connection;

    public void openConnection() {
        try {
            // Établir la connexion à la base de données en utilisant les informations de connexion
            String url = "jdbc:mysql://localhost:8889/gite ";
            String login = "root";
            String password = "root";
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
