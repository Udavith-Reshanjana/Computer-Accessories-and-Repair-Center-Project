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
public class Employee extends Person {
    
    private Connection connection;
    
    public Employee(){}
    public Employee(String pID, String fName, String mName, String lName, String personNIC, String add, String pNum, String role, String username, String password){
        super(pID, fName, mName, lName, personNIC, add, pNum, role, username, password);
    }
    public Employee(String pID, String fName, String lName, String personNIC, String add, String pNum, String role, String username, String password){
        super(pID, fName, lName, personNIC, add, pNum, role, username, password);
    }
        
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
    public boolean isPersonExist(String pID){
        try {
            connection = DatabaseConnection.getConnection();
            String query  = "SELECT employeeID FROM employee WHERE employeeID = ?";

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
            String query  = "SELECT employeeID, phoneNumber FROM employeephonenumber WHERE employeeID = ? AND phoneNumber = ?";

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
            String query  = "SELECT phoneNumber FROM employeephonenumber WHERE phoneNumber = ?";

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
        String pattern = "^(EMP/MGT/\\d{3}|EMP/REC/\\d{3}|EMP/TEC/\\d{3})$";
        return pID.matches(pattern);
    }
    
    public void addPerson(String pID, String fName,String mName, String lName, String personNIC, String add, String role, String username, String password){
        try {
            connection = DatabaseConnection.getConnection();
            String insertQuery = "INSERT INTO employee (employeeID, fName ,mName, lName, NIC, address, role, username, password) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                insertStatement.setString(1, pID);
                insertStatement.setString(2, fName);
                
                if (mName != null) {
                    insertStatement.setString(3, mName);
                } else {
                    insertStatement.setNull(3, java.sql.Types.VARCHAR);
                }
                
                insertStatement.setString(4, lName);
                insertStatement.setString(5, personNIC);
                insertStatement.setString(6, add);
                insertStatement.setString(7, role);
                insertStatement.setString(8, username);
                insertStatement.setString(9, password);
//                insertStatement.setString(9, mName);
                               
                int rowsAffected = insertStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Employee added successfully !!!");
                    JOptionPane.showMessageDialog(null, "Employee was added successfully !!!");
                } else {
                    System.out.println("Failed to add employee.");
                    JOptionPane.showMessageDialog(null, "Failed to add employee.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deletePerson(String pID){
        try {
            connection = DatabaseConnection.getConnection();
            String deleteQuery = "DELETE FROM employee WHERE employeeID = ?";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                deleteStatement.setString(1, pID);    
                               
                int rowsAffected = deleteStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Employee deleted successfully !!!");
                    JOptionPane.showMessageDialog(null, "Employee was deleted successfully !!!");
                } else {
                    System.out.println("Failed to delete employee.");
                    JOptionPane.showMessageDialog(null, "Failed to delete employee.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updatePerson(String pID, String fName, String mName, String lName, String personNIC, String add, String role, String username, String password) {
    try {
        connection = DatabaseConnection.getConnection();
        StringBuilder updateQuery = new StringBuilder("UPDATE employee SET ");

        // Add non-null parameters to the update query
        if (fName != null) {
            updateQuery.append("fName = ?, ");
        }
        if (mName != null) {
            updateQuery.append("mName = ?, ");
        }
        if (lName != null) {
            updateQuery.append("lName = ?, ");
        }
        if (personNIC != null) {
            updateQuery.append("NIC = ?, ");
        }
        if (add != null) {
            updateQuery.append("address = ?, ");
        }
        if (role != null) {
            updateQuery.append("role = ?, ");
        }
        if (username != null) {
            updateQuery.append("username = ?, ");
        }
        if (password != null) {
            updateQuery.append("password = ?, ");
        }

        // Remove the trailing comma and space
        updateQuery.setLength(updateQuery.length() - 2);

        // Add the WHERE clause
        updateQuery.append(" WHERE employeeID = ?");

        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery.toString())) {
            int parameterIndex = 1;

            // Set non-null parameters
            if (fName != null) {
                updateStatement.setString(parameterIndex++, fName);
            }
            if (mName != null) {
                updateStatement.setString(parameterIndex++, mName);
            }
            if (lName != null) {
                updateStatement.setString(parameterIndex++, lName);
            }
            if (personNIC != null) {
                updateStatement.setString(parameterIndex++, personNIC);
            }
            if (add != null) {
                updateStatement.setString(parameterIndex++, add);
            }
            if (role != null) {
                updateStatement.setString(parameterIndex++, role);
            }
            if (username != null) {
                updateStatement.setString(parameterIndex++, username);
            }
            if (password != null) {
                updateStatement.setString(parameterIndex++, password);
            }

            // Set the WHERE clause parameter
            updateStatement.setString(parameterIndex, pID);

            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee updated successfully !!!");
                JOptionPane.showMessageDialog(null, "Employee was updated successfully !!!");
            } else {
                System.out.println("Failed to update employee. Employee ID not found.");
                JOptionPane.showMessageDialog(null, "Failed to update employee. Employee ID not found.", "Message", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public void addPhoneNumber(String pID, String phoneNumbers){
        try {
            connection = DatabaseConnection.getConnection();
            
            String insertQuery = "INSERT INTO employeephonenumber (employeeID, phoneNumber) " + "VALUES (?, ?)";
            
            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                insertStatement.setString(1, pID);
                insertStatement.setString(2, phoneNumbers);                                              
                int rowsAffected = insertStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Phone number of employee added successfully !!!");
                    JOptionPane.showMessageDialog(null, "Phone number of employee was added successfully !!!");
                } else {
                    System.out.println("Failed to add phone number of employee.");
                    JOptionPane.showMessageDialog(null, "Failed to add phone number of employee.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updatePhoneNumber(String pID, String oldPhoneNumbers, String newPhoneNumber) {
        try {
            connection = DatabaseConnection.getConnection();
            String updateQuery = "UPDATE employeephonenumber SET phoneNumber = ? WHERE employeeID = ? AND phoneNumber = ?";

            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                updateStatement.setString(1, newPhoneNumber);
                updateStatement.setString(2, pID);
                updateStatement.setString(3, oldPhoneNumbers);

                int rowsAffected = updateStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Phone number updated successfully !!!");
                    JOptionPane.showMessageDialog(null, "Phone number was updated successfully !!!");
                } else {
                    System.out.println("Failed to update phone number. Employee ID not found.");
                    JOptionPane.showMessageDialog(null, "Failed to update phone number. Employee ID not found.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deletePhoneNumber(String pID, String oldpPhoneNumbers){
        try {
            connection = DatabaseConnection.getConnection();
            String deleteQuery = "DELETE FROM employeephonenumber WHERE employeeID = ? AND phonenumber = ?";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                deleteStatement.setString(1, pID); 
                deleteStatement.setString(2, oldpPhoneNumbers); 
                               
                int rowsAffected = deleteStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Employee deleted successfully !!!");
                    JOptionPane.showMessageDialog(null, "Employee was deleted successfully !!!");
                } else {
                    System.out.println("Failed to delete employee.");
                    JOptionPane.showMessageDialog(null, "Failed to delete employee.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showPrsonDetails(javax.swing.JTable table){
        try {
            connection = DatabaseConnection.getConnection();
            String showQuery = "SELECT * FROM employee";
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
                        resultset.getString(8),
                        resultset.getString(9)});
                }                
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occured while loading employee details", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void showPrsonContactDetails(javax.swing.JTable table){
        try {
            connection = DatabaseConnection.getConnection();
            String showQuery = "SELECT * FROM employeephonenumber";
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
            JOptionPane.showMessageDialog(null, "Error occured while loading employee contact details", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
