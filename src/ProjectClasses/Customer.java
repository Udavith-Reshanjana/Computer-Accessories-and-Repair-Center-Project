/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectClasses;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class Customer extends Person {
    
    private Connection connection;
    
    public Customer(){}

    
    //not edited
    public boolean checkLogin(String role, String username, String password) {
        try {
            connection = DatabaseConnection.getConnection();
            String query  = "SELECT role, username, password FROM employee WHERE role = ? AND username = ? AND password = ?";

            try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                System.out.println("Role: " + role);
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);

                preparedStatement.setString(1, role);
                preparedStatement.setString(2, username);
                preparedStatement.setString(3, password);

                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
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
    //edited
    public boolean isPersonExist(String pID){
        try {
            connection = DatabaseConnection.getConnection();
            String query  = "SELECT customerID FROM customer WHERE customerID = ?";

            try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, pID);
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean isPersonPhoneNumberExist(String pID, String phoneNumbers){
        try {
            connection = DatabaseConnection.getConnection();
            String query  = "SELECT customerID, phoneNumber FROM customerphonenumber WHERE customerID = ? AND phoneNumber = ?";

            try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, pID);
                preparedStatement.setString(2, phoneNumbers);
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean isPhoneNumberDuplicated(String phoneNumbers){
        try {
            connection = DatabaseConnection.getConnection();
            String query  = "SELECT phoneNumber FROM customerphonenumber WHERE phoneNumber = ?";

            try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, phoneNumbers);
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean isPersonIDValid(String pID){
        String pattern = "^(CUS/N/\\d{5}|CUS/W/\\d{5})$";
        return pID.matches(pattern);
    }
    public void addPerson(String pID, String fName, String mName, String lName, String personNIC, String add, String role, String username, String password){}
    public void addPerson(String customerID, String customerName, String customerType, String NIC, String address, String userName, String password) {
        try {
            connection = DatabaseConnection.getConnection();
            String insertQuery = "INSERT INTO customer (customerID, customerName, type, NIC, address, userName, password) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                insertStatement.setString(1, customerID);
                insertStatement.setString(2, customerName);
                insertStatement.setString(3, customerType);
                insertStatement.setString(4, NIC);
                insertStatement.setString(5, address);
                insertStatement.setString(6, userName);
                insertStatement.setString(7, password);

                int rowsAffected = insertStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Customer added successfully!");
                    JOptionPane.showMessageDialog(null, "Customer was added successfully!");
                } else {
                    System.out.println("Failed to add customer.");
                    JOptionPane.showMessageDialog(null, "Failed to add customer.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deletePerson(String pID){
        try {
            connection = DatabaseConnection.getConnection();
            String deleteQuery = "DELETE FROM customer WHERE customerID = ?";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                deleteStatement.setString(1, pID);

                int rowsAffected = deleteStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Customer deleted successfully !!!");
                    JOptionPane.showMessageDialog(null, "Customer was deleted successfully !!!");
                } else {
                    System.out.println("Failed to delete customer.");
                    JOptionPane.showMessageDialog(null, "Failed to delete customer.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updatePerson(String pID, String fName, String mName, String lName, String personNIC, String add, String role, String username, String password) {}
    public void updateCustomer(String cusID, String cusName, String cusType, String cusNIC, String cusAddress, String cusUsername, String cusPassword) {
        try {
            connection = DatabaseConnection.getConnection();
            StringBuilder updateQuery = new StringBuilder("UPDATE customer SET ");

            // Add non-null parameters to the update query
            if (cusName != null) {
                updateQuery.append("customerName  = ?, ");
            }
            if (cusType != null) {
                updateQuery.append("type = ?, ");
            }
            if (cusNIC != null) {
                updateQuery.append("NIC = ?, ");
            }
            if (cusAddress != null) {
                updateQuery.append("address = ?, ");
            }
            if (cusUsername != null) {
                updateQuery.append("userName = ?, ");
            }
            if (cusPassword != null) {
                updateQuery.append("password = ?, ");
            }

            // Remove the trailing comma and space
            updateQuery.setLength(updateQuery.length() - 2);

            // Add the WHERE clause
            updateQuery.append(" WHERE customerID = ?");

            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery.toString())) {
                int parameterIndex = 1;

                // Set non-null parameters
                if (cusName != null) {
                    updateStatement.setString(parameterIndex++, cusName);
                }
                if (cusType != null) {
                    updateStatement.setString(parameterIndex++, cusType);
                }
                if (cusNIC != null) {
                    updateStatement.setString(parameterIndex++, cusNIC);
                }
                if (cusAddress != null) {
                    updateStatement.setString(parameterIndex++, cusAddress);
                }
                if (cusUsername != null) {
                    updateStatement.setString(parameterIndex++, cusUsername);
                }
                if (cusPassword != null) {
                    updateStatement.setString(parameterIndex++, cusPassword);
                }

                // Set the WHERE clause parameter
                updateStatement.setString(parameterIndex, cusID);

                int rowsAffected = updateStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Customer updated successfully!");
                    JOptionPane.showMessageDialog(null, "Customer was updated successfully!");
                } else {
                    System.out.println("Failed to update customer. Customer ID not found.");
                    JOptionPane.showMessageDialog(null, "Failed to update customer. Customer ID not found.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addPhoneNumber(String pID, String phoneNumbers){
        try {
            connection = DatabaseConnection.getConnection();
            String insertQuery = "INSERT INTO customerphonenumber (customerID, phoneNumber) VALUES (?, ?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                insertStatement.setString(1, pID);
                insertStatement.setString(2, phoneNumbers);

                int rowsAffected = insertStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Phone number added successfully for customer " + pID);
                    JOptionPane.showMessageDialog(null, "Phone number added successfully for customer " + pID);
                } else {
                    System.out.println("Failed to add phone number for customer " + pID);
                    JOptionPane.showMessageDialog(null, "Failed to add phone number for customer " + pID, "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updatePhoneNumber(String pID, String oldPhoneNumbers, String newPhoneNumber) {
        try {
            connection = DatabaseConnection.getConnection();
            String updateQuery = "UPDATE customerphonenumber SET phoneNumber = ? WHERE customerID  = ? AND phoneNumber = ?";

            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                updateStatement.setString(1, newPhoneNumber);
                updateStatement.setString(2, pID);
                updateStatement.setString(3, oldPhoneNumbers);

                int rowsAffected = updateStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Phone number updated successfully !!!");
                    JOptionPane.showMessageDialog(null, "Phone number was updated successfully !!!");
                } else {
                    System.out.println("Failed to update phone number. Customer ID not found.");
                    JOptionPane.showMessageDialog(null, "Failed to update phone number. Customer ID not found.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deletePhoneNumber(String pID, String oldpPhoneNumbers){
        try {
            connection = DatabaseConnection.getConnection();
            String deleteQuery = "DELETE FROM customerphonenumber WHERE customerID = ? AND phoneNumber = ?";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                deleteStatement.setString(1, pID);
                deleteStatement.setString(2, oldpPhoneNumbers);

                int rowsAffected = deleteStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Phone number deleted successfully for customer " + pID);
                    JOptionPane.showMessageDialog(null, "Phone number deleted successfully for customer " + pID);
                } else {
                    System.out.println("Failed to delete phone number for customer " + pID);
                    JOptionPane.showMessageDialog(null, "Failed to delete phone number for customer " + pID, "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showPrsonDetails(javax.swing.JTable table){
        try {
            connection = DatabaseConnection.getConnection();
            String showQuery = "SELECT * FROM customer";
            try (PreparedStatement showStatement = connection.prepareCall(showQuery)) {
                ResultSet resultSet = showStatement.executeQuery();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                while (resultSet.next()) {
                    model.addRow(new String[]{
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7)});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while loading details", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void showPrsonContactDetails(javax.swing.JTable table){
        try {
            connection = DatabaseConnection.getConnection();
            String showQuery = "SELECT * FROM customerphonenumber";
            try(PreparedStatement showStatement = connection.prepareCall(showQuery)){
                ResultSet resultset = showStatement.executeQuery();
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                model.setRowCount(0);
                while(resultset.next()) {
                    model.addRow(new String[]{
                        resultset.getString(1),
                        resultset.getString(2)});
                }                
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occured while loading customer contact details", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public String getStringValue(Object value) {
        return (value != null) ? value.toString() : "";
    }
    public boolean isNICExist(String nic) {
        String query = "SELECT * FROM customer WHERE NIC = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, nic);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Return true if the result set has at least one row (NIC exists)
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Handle the exception appropriately based on your application's logic
        }
    }

    public String getCustomerIdByNIC(String nic) {
    String customerId = null;

    try {
        connection = DatabaseConnection.getConnection();
        if (connection == null) {
            System.err.println("Database connection is null.");
            return null;
        }

        String sql = "SELECT customerID FROM customer WHERE NIC = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nic);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    customerId = resultSet.getString("customerID");
                }
            }
        }
    } catch (SQLException e) {
        // Log the exception or rethrow a custom exception
        e.printStackTrace(); // This is just a placeholder; consider using a logging framework
        // Alternatively, throw a custom exception to provide more information
        throw new RuntimeException("Error while getting customer ID by NIC", e);
    } finally {
        // Close the connection if needed
        // Note: It's usually a good practice to close the connection in a finally block
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // Log or handle the exception
            e.printStackTrace(); // Again, consider using a logging framework
        }
    }

    return customerId;
}
    




}
