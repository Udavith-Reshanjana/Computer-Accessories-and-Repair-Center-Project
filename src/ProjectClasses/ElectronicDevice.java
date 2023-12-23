/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectClasses;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class ElectronicDevice implements Hardware {
    private Connection connection;
    
    public ElectronicDevice(){}
    
    public void closeConnection() {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    System.out.println("Database connection closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    public void addHardware(String hardwareID, String hardwareName, String brandName, String hardwareType, double unitprice, int qty, String importedCountry, int usageTime) {
        try {
            connection = DatabaseConnection.getConnection();
            String insertQuery = "INSERT INTO hardware (hardwareID, name, brandName, type, unitPrice, qty, importedCountry, usageTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                insertStatement.setString(1, hardwareID);
                insertStatement.setString(2, hardwareName);
                insertStatement.setString(3, brandName);
                insertStatement.setString(4, hardwareType);
                insertStatement.setDouble(5, unitprice);
                insertStatement.setInt(6, qty);
                insertStatement.setString(7, importedCountry);

                if (usageTime > 0) {
                    insertStatement.setInt(8, usageTime);
                } else {
                    insertStatement.setNull(8, java.sql.Types.INTEGER);
                }

                int rowsAffected = insertStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Hardware added successfully !!!");
                    JOptionPane.showMessageDialog(null, "Hardware was added successfully !!!");
                } else {
                    System.out.println("Failed to add hardware.");
                    JOptionPane.showMessageDialog(null, "Failed to add hardware.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteHardware(String hardwareID){
        try {
            connection = DatabaseConnection.getConnection();
            String deleteQuery = "DELETE FROM hardware WHERE hardwareID = ?";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                deleteStatement.setString(1, hardwareID);    
                               
                int rowsAffected = deleteStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Hardware deleted successfully !!!");
                    JOptionPane.showMessageDialog(null, "Hardware was deleted successfully !!!");
                } else {
                    System.out.println("Failed to delete hardware.");
                    JOptionPane.showMessageDialog(null, "Failed to delete hardware.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateHardware(String hardwareID, String hardwareName, String brandName, String hardwareType, double unitprice, int qty, String importedCountry, int usageTime) {
        try {
            connection = DatabaseConnection.getConnection();
            StringBuilder updateQuery = new StringBuilder("UPDATE hardware SET ");

            // Add non-null parameters to the update query
            if (hardwareName != null) {
                updateQuery.append("name = ?, ");
            }
            if (brandName != null) {
                updateQuery.append("brandName = ?, ");
            }
            if (hardwareType != null) {
                updateQuery.append("type = ?, ");
            }
            if (unitprice != 0.0) { 
                updateQuery.append("unitPrice = ?, ");
            }
            if (qty >= 0) { 
                updateQuery.append("qty = ?, ");
            }
            if (importedCountry != null) {
                updateQuery.append("importedCountry = ?, ");
            }
            if (usageTime >= 0) { 
                updateQuery.append("usageTime = ?, ");
            }

            // Remove the trailing comma and space
            updateQuery.setLength(updateQuery.length() - 2);

            // Add the WHERE clause
            updateQuery.append(" WHERE hardwareID = ?");

            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery.toString())) {
                int parameterIndex = 1;

                // Set non-null parameters
                if (hardwareName != null) {
                    updateStatement.setString(parameterIndex++, hardwareName);
                }
                if (brandName != null) {
                    updateStatement.setString(parameterIndex++, brandName);
                }
                if (hardwareType != null) {
                    updateStatement.setString(parameterIndex++, hardwareType);
                }
                if (unitprice != 0.0) {
                    updateStatement.setDouble(parameterIndex++, unitprice);
                }
                if (qty >= 0) {
                    updateStatement.setInt(parameterIndex++, qty);
                }
                if (importedCountry != null) {
                    updateStatement.setString(parameterIndex++, importedCountry);
                }
                if (usageTime >= 0) {
                    updateStatement.setInt(parameterIndex++, usageTime);
                }

                // Set the WHERE clause parameter
                updateStatement.setString(parameterIndex, hardwareID);

                int rowsAffected = updateStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Hardware updated successfully !!!");
                    JOptionPane.showMessageDialog(null, "Hardware was updated successfully !!!");
                } else {
                    System.out.println("Failed to update hardware. Hardware ID not found.");
                    JOptionPane.showMessageDialog(null, "Failed to update hardware. Hardware ID not found.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showHardwareDetails(javax.swing.JTable table) {
        try {
            connection = DatabaseConnection.getConnection();
            String showQuery = "SELECT * FROM hardware";
            try(PreparedStatement showStatement = connection.prepareCall(showQuery)){
                ResultSet resultset = showStatement.executeQuery();
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                model.setRowCount(0);
                while(resultset.next()) {
                    model.addRow(new String[]{
                        resultset.getString(1),
                        resultset.getString(2),
                        resultset.getString(3),
                        resultset.getString(4),
                        resultset.getString(5),
                        resultset.getString(6),
                        resultset.getString(7),
                        resultset.getString(8)});
                }                
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occured while loading employee details", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public int parseIntegerValue(Object value) {
        try {
            return Integer.parseInt(String.valueOf(value));
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Or log the error
            return 0; // Return a default value or handle the error as needed
        }
    }
    public double parseDoubleValue(Object value) {
        try {
            return Double.parseDouble(String.valueOf(value));
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Or log the error
            return 0.0; // Return a default value or handle the error as needed
        }
    }
    
    public boolean isHardwareExist(String hardwareID){
        try {
            connection = DatabaseConnection.getConnection();
            String query  = "SELECT hardwareID FROM hardware WHERE hardwareID = ?";

            try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, hardwareID);
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean isHardwareIDValid(String hardwareID) {

        String pattern1 = "HW/BN/\\d{5}";
        String pattern2 = "HW/SEC/\\d{5}";

        Pattern regexPattern1 = Pattern.compile(pattern1);
        Pattern regexPattern2 = Pattern.compile(pattern2);

        Matcher matcher1 = regexPattern1.matcher(hardwareID);
        Matcher matcher2 = regexPattern2.matcher(hardwareID);

        return matcher1.matches() || matcher2.matches();
    }
    public boolean isHardwareQtyValid(String qty) {
        try {
            int quantity = Integer.parseInt(qty);
            return quantity >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean isHardwareUsageTimeValid(String usagetime) {
        try {
            int hwUsagetime = Integer.parseInt(usagetime);
            return hwUsagetime >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean isHardwareUnitPriceValid(String unitprice) {
        try {
            double price = Double.parseDouble(unitprice);
            return price >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}
