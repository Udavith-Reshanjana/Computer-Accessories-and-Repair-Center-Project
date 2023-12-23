/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectClasses;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class Manager extends Employee {
    
    private Connection connection;
    
    public Manager(){}
    
    public boolean isPersonIDValid(String pID){
        String pattern = "^(EMP/MGT/\\d{3})$";
        return pID.matches(pattern);
    }
    
    public void displayPaymentDetails(javax.swing.JTable customerTable) {
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT c.customerID, c.customerName, c.type AS customerType, o.orderID, p.paymentID, p.totalAmount, p.discount, p.Date " +
                        "FROM\n" +
                        " customer c" +
                        " JOIN\n" +
                        " `order` o ON c.customerID = o.customerID" +
                        " JOIN " +
                        " payment p ON o.orderID = p.orderID;";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    Vector<Vector<Object>> data = new Vector<>();

                    // Add data
                    while (resultSet.next()) {
                        Vector<Object> row = new Vector<>();
                        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                            row.add(resultSet.getObject(i));
                        }
                        data.add(row);
                    }

                    DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
                    model.setRowCount(0); // Clear existing data
                    for (Vector<Object> row : data) {
                        model.addRow(row);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
