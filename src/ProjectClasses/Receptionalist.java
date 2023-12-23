/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectClasses;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author lenovo
 */
public class Receptionalist extends Employee {
    
    private Connection connection;
    
    public Receptionalist() {}
    
    public void setNextPaymentIDFromDatabase(javax.swing.JTextField paymentID) {
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT MAX(paymentID) AS last_id FROM payment";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String lastPrimaryKey = resultSet.getString("last_id");
                        String nextPaymentID = getNextPaymentID(lastPrimaryKey);
                        paymentID.setText(nextPaymentID);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private String getNextPaymentID(String paymentID) {
        String numericPart = paymentID.substring(4);
        int nextValue = Integer.parseInt(numericPart) + 1;
        return "PMT/" + String.format("%05d", nextValue);
    }
    private String getNextOrderID(String orderID) {
        String numericPart = orderID.substring(4);
        int nextValue = Integer.parseInt(numericPart) + 1;
        return "ORD/" + String.format("%05d", nextValue);
    }
    public void setNextOrderIDFromDatabase(javax.swing.JTextField orderID) {
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT MAX(orderID) AS last_id FROM `order`";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String lastPrimaryKey = resultSet.getString("last_id");
                        String nextOrderID = getNextOrderID(lastPrimaryKey);
                        orderID.setText(nextOrderID);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void AddHardwareToCart(javax.swing.JTable hardwareTable, javax.swing.JTable cartTable, String hardwareID, int qty, double unitPrice, java.util.Date warrantyDate, java.util.Date warrantyDueDate) {
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        model.addRow(new Object[]{
                hardwareID,
                qty,
                unitPrice,
                new java.sql.Date(warrantyDate.getTime()),
                new java.sql.Date(warrantyDueDate.getTime()),               
        });
        updateHardwareQuantity(hardwareID, qty);
        try {
            ElectronicDevice electronicDevice = new ElectronicDevice();
            electronicDevice.showHardwareDetails(hardwareTable);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while loading hardware data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void updateHardwareQuantity(String hardwareID, int qty) {
        try {
            connection = DatabaseConnection.getConnection();
            String updateQuery = "UPDATE hardware SET qty = qty - ? WHERE hardwareID = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                updateStatement.setInt(1, qty);
                updateStatement.setString(2, hardwareID);
                updateStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating hardware quantity", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void dropHardwareFromCart(javax.swing.JTable hardwareTable, javax.swing.JTable cartTable, String hardwareID, int qty) {
        try {
            connection = DatabaseConnection.getConnection();
            String updateQuery = "UPDATE hardware SET qty = qty + ? WHERE hardwareID = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                updateStatement.setInt(1, qty);
                updateStatement.setString(2, hardwareID);
                updateStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error increasing hardware quantity", "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            ElectronicDevice electronicDevice = new ElectronicDevice();
            electronicDevice.showHardwareDetails(hardwareTable);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while loading hardware data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public int getAvailableQuantity(String hardwareID) {
        int availableQty = 0;

        try {
            connection = DatabaseConnection.getConnection();
            String selectQuery = "SELECT qty FROM hardware WHERE hardwareID = ?";
            try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
                selectStatement.setString(1, hardwareID);
                ResultSet resultSet = selectStatement.executeQuery();
                if (resultSet.next()) {
                    availableQty = resultSet.getInt("qty");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving available quantity", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return availableQty;
    }
    public void increaseHardwareQuantity(String hardwareID, int qty) {
        try {
            connection = DatabaseConnection.getConnection();
            String updateQuery = "UPDATE hardware SET qty = qty + ? WHERE hardwareID = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                updateStatement.setInt(1, qty);
                updateStatement.setString(2, hardwareID);
                updateStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error increasing hardware quantity", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public boolean validateHardwareQuantity(String hardwareID, int enteredQuantity) {
        int availableQuantity = getAvailableQuantity(hardwareID);
        return enteredQuantity <= availableQuantity;
    }
    public void addOrderWarranty(String customerID, String orderID, String hardwareID, int qty, java.util.Date initialDateOfWarranty, java.util.Date dueDateOfWarranty) {
        try {
            connection = DatabaseConnection.getConnection();
            String insertQuery = "INSERT INTO orderwarranty (customerID, orderID, hardwareID, orderQty, initialDateOfWarranty, dueDateOfWarranty) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                insertStatement.setString(1, customerID);
                insertStatement.setString(2, orderID);
                insertStatement.setString(3, hardwareID);
                insertStatement.setInt(4, qty);

                // Convert java.util.Date to java.sql.Date
                java.sql.Date sqlInitialDate = new java.sql.Date(initialDateOfWarranty.getTime());
                java.sql.Date sqlDueDate = new java.sql.Date(dueDateOfWarranty.getTime());

                insertStatement.setDate(5, sqlInitialDate);
                insertStatement.setDate(6, sqlDueDate);

                int rowsAffected = insertStatement.executeUpdate();
                System.out.println("SQL Query: " + insertQuery);
                if (rowsAffected > 0) {
                    System.out.println("Order Warranty added successfully !!!");
                    JOptionPane.showMessageDialog(null, "Order Warranty was added successfully !!!");
                } else {
                    System.out.println("Failed to add Order Warranty.");
                    JOptionPane.showMessageDialog(null, "Failed to add Order Warranty.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addOrder(String customerID, String orderID, String employeeID) {
        
        try {
            connection = DatabaseConnection.getConnection();
            String insertQuery = "INSERT INTO `order` (customerID, orderID, employeeID) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, customerID);
                preparedStatement.setString(2, orderID);
                preparedStatement.setString(3, employeeID);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Order added successfully.");
                } else {
                    System.out.println("Failed to add order.");
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error adding order to the database.");
        }
    }
    public String getLastOrderID() {
        String lastOrderID = null;

        try {
            connection = DatabaseConnection.getConnection();
            String query = "SELECT MAX(CAST(SUBSTRING(orderID, 4) AS SIGNED)) AS maxOrderID FROM `order`";

            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    int maxOrderID = resultSet.getInt("maxOrderID");
                    lastOrderID = String.format("ORD%05d", maxOrderID + 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lastOrderID;
    }
    public String getHighestOrderID() {
        String highestOrderID = null;

        try {
            connection = DatabaseConnection.getConnection();
            String query = "SELECT MAX(orderID) AS highestOrderID FROM `order`";

            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    highestOrderID = resultSet.getString("highestOrderID");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return highestOrderID;
    }
    public String getCustomerIDFromOrder(String orderID) {
        String customerID = null;

        try {
            connection = DatabaseConnection.getConnection();
            String query = "SELECT customerID FROM `order` WHERE orderID = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, orderID);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        customerID = resultSet.getString("customerID");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customerID;
    }
    public void populateHardwareCart(String customerID, String orderID, javax.swing.JTable hardwareCart) {
        DefaultTableModel cartModel = (DefaultTableModel) hardwareCart.getModel();
        cartModel.setRowCount(0); // Clear existing rows in the table

        try {
            connection = DatabaseConnection.getConnection();
            String query = "SELECT ow.hardwareID, ow.orderQty, ow.initialDateOfWarranty, ow.dueDateOfWarranty, h.unitPrice " +
                           "FROM orderwarranty ow " +
                           "JOIN hardware h ON ow.hardwareID = h.hardwareID " +
                           "WHERE ow.customerID = ? AND ow.orderID = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, customerID);
                statement.setString(2, orderID);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String hardwareID = resultSet.getString("hardwareID");
                        int orderQty = resultSet.getInt("orderQty");
                        Date initialDateOfWarranty = resultSet.getDate("initialDateOfWarranty");
                        Date dueDateOfWarranty = resultSet.getDate("dueDateOfWarranty");
                        double unitPrice = resultSet.getDouble("unitPrice");

                        Object[] rowData = {hardwareID, orderQty, unitPrice, initialDateOfWarranty, dueDateOfWarranty};
                        cartModel.addRow(rowData);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public double calculateTotalPrice(String orderID, String customerID) {
        double totalValue = 0;

        try {
            connection = DatabaseConnection.getConnection();
            String query = "SELECT ow.orderQty, h.unitPrice " +
                           "FROM orderwarranty ow " +
                           "JOIN hardware h ON ow.hardwareID = h.hardwareID " +
                           "WHERE ow.orderID = ? AND ow.customerID = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, orderID);
                statement.setString(2, customerID);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int orderQty = resultSet.getInt("orderQty");
                        double unitPrice = resultSet.getDouble("unitPrice");
                        totalValue += orderQty * unitPrice;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalValue;
    }
    public double calculateFinalCharge(double discount, double totalPrice) {
        totalPrice -= (totalPrice * discount) / 100;
        return totalPrice;
    }
    public Double calculateRest(double total, double given) {
        return given - total;
    }
    public void addPayment(String paymentID, String orderID, double amount, double givenAmount, java.util.Date paymentDate, javax.swing.JTextField customerIDTxt, double discount) {
        try {
            connection = DatabaseConnection.getConnection();
            String insertQuery = "INSERT INTO payment (paymentID, orderID, totalAmount, givenAmount, date, customerID, discount) VALUES (?, ?, ?, ?, ?, ?, ?)";

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
    public void exportBillToPDF(JPanel billPanel) {
        // Prompt the user to choose a file location
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection != JFileChooser.APPROVE_OPTION) {
            return; // The user canceled the operation
        }

        File fileToSave = fileChooser.getSelectedFile();
        String outputPath = fileToSave.getAbsolutePath() + ".pdf";

        PDDocument document = new PDDocument();
        PDPage page = new PDPage(new PDRectangle(500, 600));
        document.addPage(page);

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            // Create a BufferedImage from the JPanel
            BufferedImage image = new BufferedImage(
                    500, 600, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = image.createGraphics();
            billPanel.print(g);
            g.dispose();

            // Convert BufferedImage to PDImageXObject
            PDImageXObject pdImage = LosslessFactory.createFromImage(document, image);

            // Draw the PDImageXObject to the PDF
            contentStream.drawImage(pdImage, 0, 0, 500, 600);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            document.save(outputPath);
            document.close();
            System.out.println("PDF created successfully at: " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getEmployeeIDByOrderID(String orderID) {
        String employeeID = null;

        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT employeeID FROM `order` WHERE orderID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, orderID);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        employeeID = resultSet.getString("employeeID");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeID;
    }
    public boolean isPersonIDValid(String pID){
        String pattern = "^(EMP/REC/\\d{3})$";
        return pID.matches(pattern);
    }
    public void displayCustomerDetails(String customerID, javax.swing.JTable customerTable) {
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT c.customerID, c.customerName, c.type, c.NIC, c.address, cp.phoneNumber " +
                    "FROM customer c " +
                    "LEFT JOIN customerphonenumber cp ON c.customerID = cp.customerID " +
                    "WHERE c.customerID = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, customerID);

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
    public void displayCustomerDetailsByNIC(String nic, JTable customerTable) {
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT customerID, customerName, type, NIC, address " +
                         "FROM customer " +
                         "WHERE NIC = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nic);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet != null) {
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
                    } else {
                        System.out.println("ResultSet is null");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayPaymentDetails(String customerID, JTable paymentTable) {
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT p.paymentID, p.date, p.totalAmount, p.givenAmount, p.discount, p.repairID, p.customerID, p.orderID " +
                         "FROM payment p " +
                         "WHERE p.customerID = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, customerID);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet != null) {
                        Vector<Vector<Object>> data = new Vector<>();

                        // Add data
                        while (resultSet.next()) {
                            Vector<Object> row = new Vector<>();
                            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                                row.add(resultSet.getObject(i));
                            }
                            data.add(row);
                        }

                        DefaultTableModel model = (DefaultTableModel) paymentTable.getModel();
                        model.setRowCount(0); 

                        for (Vector<Object> row : data) {
                            model.addRow(row);
                        }
                    } else {
                        System.out.println("ResultSet is null");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void displayPaymentDetailsByNIC(String nic, JTable paymentTable) {
        try {
            connection = DatabaseConnection.getConnection(); 

            String sql = "SELECT p.paymentID, p.date, p.totalAmount, p.givenAmount, p.discount, p.repairID, p.customerID, p.orderID " +
                    "FROM payment p " +
                    "JOIN `order` o ON p.orderID = o.orderID " +
                    "JOIN customer c ON p.customerID = c.customerID " +
                    "WHERE c.NIC = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nic);

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

                    DefaultTableModel model = (DefaultTableModel) paymentTable.getModel();
                    model.setRowCount(0); 
                    for (Vector<Object> row : data) {
                        model.addRow(row);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void displayOrderWarrantyDetails(String customerID, JTable orderWarrantyTable) {
        try {
            connection = DatabaseConnection.getConnection(); 

            String sql = "SELECT ow.customerID, ow.orderID, ow.hardwareID, ow.orderQty, ow.initialDateOfWarranty, ow.dueDateOfWarranty " +
                    "FROM orderwarranty ow " +
                    "JOIN `order` o ON ow.customerID = o.customerID AND ow.orderID = o.orderID " +
                    "WHERE o.customerID = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, customerID);

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

                    DefaultTableModel model = (DefaultTableModel) orderWarrantyTable.getModel();
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
    public void displayOrderWarrantyDetailsByNIC(String nic, JTable orderWarrantyTable) {
        try {
            connection = DatabaseConnection.getConnection(); 

            String sql = "SELECT ow.customerID, ow.orderID, ow.hardwareID, ow.orderQty, ow.initialDateOfWarranty, ow.dueDateOfWarranty " +
                    "FROM orderwarranty ow " +
                    "INNER JOIN customer c ON ow.customerID = c.customerID " +
                    "WHERE c.NIC = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nic);

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

                    DefaultTableModel model = (DefaultTableModel) orderWarrantyTable.getModel();
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
    public void displayRepairDetailsByCustomerId(String customerId, JTable repairTable) {
        try {
            connection = DatabaseConnection.getConnection();

            String sql = "SELECT r.repairID, r.repairDiscription, r.customerID, r.Status " +
                    "FROM repair r " +
                    "INNER JOIN customer c ON r.customerID = c.customerID " +
                    "WHERE c.customerID = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, customerId);

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

                    DefaultTableModel model = (DefaultTableModel) repairTable.getModel();
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
    public void displayRepairDetailsByCustomerNIC(String nic, JTable repairTable) {
        try {
            connection = DatabaseConnection.getConnection();

            String sql = "SELECT r.repairID, r.repairDiscription, r.customerID, r.Status " +
                    "FROM repair r " +
                    "INNER JOIN customer c ON r.customerID = c.customerID " +
                    "WHERE c.NIC = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nic);

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

                    DefaultTableModel model = (DefaultTableModel) repairTable.getModel();
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
    public boolean isNumberbetween0and100(String value) {
        try {
            double val =Double.parseDouble(value);
            return val < 0.0 || 100 <= val;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean isNumberbetPositive(String value) {
        try {
            double val =Double.parseDouble(value);
            return val < 0.0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
