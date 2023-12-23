/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectClasses;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class Technician extends Employee {
    
    private Connection connection;
    
    public Technician(){}
    
    public boolean isPersonIDValid(String pID){
        String pattern = "^(EMP/TEC/\\d{3})$";
        return pID.matches(pattern);
    }
    public boolean isRepairIDValid(String repairID){
        String pattern = "^(REP/\\d{5})$";
        return repairID.matches(pattern);
    }
    public boolean isRepairIDExist(String repairID){
        try {
            connection = DatabaseConnection.getConnection();
            String query  = "SELECT repairID FROM repair WHERE repairID = ?";

            try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, repairID);
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void showRepairDetailsWithPaymentId(javax.swing.JTable table) {
        try {
            connection = DatabaseConnection.getConnection();
            String showQuery = "SELECT r.*, p.paymentID FROM repair r " +
                               "LEFT JOIN payment p ON r.repairID = p.repairID";
            try (PreparedStatement showStatement = connection.prepareStatement(showQuery)) {
                ResultSet resultSet = showStatement.executeQuery();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                while (resultSet.next()) {
                    model.addRow(new String[]{
                            resultSet.getString("r.repairID"),
                            resultSet.getString("r.repairDiscription"),
                            resultSet.getString("r.customerID"),
                            resultSet.getString("r.Status"),
                            resultSet.getString("p.paymentID")
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while loading repair details with payment ID", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public String getNextRepairID() {
        String nextRepairID = null;

        try {
            connection = DatabaseConnection.getConnection();
            String maxQuery = "SELECT MAX(CAST(SUBSTRING(repairID, 5) AS SIGNED)) FROM repair";
            try (PreparedStatement maxStatement = connection.prepareStatement(maxQuery)) {
                ResultSet resultSet = maxStatement.executeQuery();

                if (resultSet.next()) {
                    int maxNumericPart = resultSet.getInt(1);
                    // Increment the numeric part to get the next ID
                    int nextNumericPart = maxNumericPart + 1;

                    // Format the next repair ID
                    nextRepairID = String.format("REP/%05d", nextNumericPart);
                } else {
                    // If the table is empty, start from the first numeric part
                    nextRepairID = "REP/00001";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while getting the next repair ID", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return nextRepairID;
    }
    public void addRepairData(String repairID, String repairDescription, String customerID, String status) {
        try {
            connection = DatabaseConnection.getConnection();
            String insertQuery = "INSERT INTO repair (repairID, repairDiscription, customerID, Status) VALUES (?, ?, ?, ?)";

            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                insertStatement.setString(1, repairID);
                insertStatement.setString(2, repairDescription);
                insertStatement.setString(3, customerID);
                insertStatement.setString(4, status);

                int rowsAffected = insertStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Repair data added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add repair data", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while adding repair data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void showRepairData(String repairID, javax.swing.JTable table) {
        try {
            connection = DatabaseConnection.getConnection();
            String showQuery = "SELECT repairID, repairDiscription FROM repair WHERE repairID = ?";

            try (PreparedStatement showStatement = connection.prepareStatement(showQuery)) {
                showStatement.setString(1, repairID);

                ResultSet resultSet = showStatement.executeQuery();

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                while (resultSet.next()) {
                    model.addRow(new String[]{
                            resultSet.getString("repairID"),  
                            resultSet.getString("repairDiscription") 
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while loading repair details", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void showRepairData(javax.swing.JTable table) {
        try {
            connection = DatabaseConnection.getConnection();
            String showQuery = "SELECT * FROM repair";

            try (PreparedStatement showStatement = connection.prepareStatement(showQuery)) {
//                showStatement.setString(1, repairID);

                ResultSet resultSet = showStatement.executeQuery();

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                while (resultSet.next()) {
                    model.addRow(new String[]{
                            resultSet.getString("repairID"),  
                            resultSet.getString("repairDiscription"),
                            resultSet.getString("customerID"),
                            resultSet.getString("Status")
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while loading repair details", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public String getHighestRepairID() {
        String highestRepairID = null;

        try {
            connection = DatabaseConnection.getConnection();
            String query = "SELECT MAX(repairID) AS highestRepairID FROM repair";

            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    highestRepairID = resultSet.getString("highestRepairID");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return highestRepairID;
    }
    public void addPayment(String paymentID, String orderID, double amount, double givenAmount, java.util.Date paymentDate, javax.swing.JTextField customerIDTxt, double discount, String repairID) {
        try {
            connection = DatabaseConnection.getConnection();
            String insertQuery = "INSERT INTO payment (paymentID, orderID, totalAmount, givenAmount, date, customerID, discount, repairID ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                insertStatement.setString(1, paymentID);
                insertStatement.setString(2, orderID);
                insertStatement.setDouble(3, amount);
                insertStatement.setDouble(4, givenAmount);

                // Convert java.util.Date to java.sql.Date
                java.sql.Date sqlPaymentDate = new java.sql.Date(paymentDate.getTime());
                insertStatement.setDate(5, sqlPaymentDate);

                // Check for null to avoid NullPointerException
                insertStatement.setString(6, (customerIDTxt.getText() != null) ? customerIDTxt.getText() : "");
                insertStatement.setDouble(7, discount);
                insertStatement.setString(8, repairID);

                int rowsAffected = insertStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Payment added successfully!");
                    JOptionPane.showMessageDialog(null, "Payment added successfully!");
                } else {
                    System.out.println("Failed to add payment.");
                    JOptionPane.showMessageDialog(null, "Failed to add payment.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateRepair(String repairID, String newDescription, String newStatus) {
        try {
            connection = DatabaseConnection.getConnection();
            String updateQuery = "UPDATE repair SET repairDiscription = ?, Status = ? WHERE repairID = ?";

            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                updateStatement.setString(1, newDescription);
                updateStatement.setString(2, newStatus);
                updateStatement.setString(3, repairID);

                int rowsAffected = updateStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Update successful");
                } else {
                    System.out.println("No rows updated. Check if repairID exists.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while updating repair details", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void updateRepair(String repairID, String newStatus) {
        try {
            connection = DatabaseConnection.getConnection();
            String updateQuery = "UPDATE repair SET Status = ? WHERE repairID = ?";

            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                updateStatement.setString(1, newStatus);
                updateStatement.setString(2, repairID);

                int rowsAffected = updateStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Update successful");
                } else {
                    System.out.println("No rows updated. Check if repairID exists.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while updating repair details", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
