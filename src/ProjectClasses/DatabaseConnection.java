package ProjectClasses;

import java.sql.*;
/**
 *
 * @author lenovo
 */
public class DatabaseConnection {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/databaseofcaarc";
    private static final String username = "root";
    private static final String password = "";

    private static Connection connection;

    // Private constructor to prevent instantiation
    private DatabaseConnection() {
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcURL, username, password);
                System.out.println("Connected to Database.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database", e);
        }
        return connection;
    }

     public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
