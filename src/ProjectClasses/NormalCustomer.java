/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectClasses;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author lenovo
 */
public class NormalCustomer extends Customer {
    
    private Connection connection;
    
    public NormalCustomer(){}
    
    public void updateCustomer(String cusID, String cusName, String cusType, String cusNIC, String cusAddress) {
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
    
    public boolean isPersonIDValid(String pID){
        String pattern = "^(CUS/N/\\d{5})$";
        return pID.matches(pattern);
    }
}
