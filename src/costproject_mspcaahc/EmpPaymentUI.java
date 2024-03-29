/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package costproject_mspcaahc;

import ProjectClasses.CustomComboBoxRenderer;
import ProjectClasses.Customer;
import ProjectClasses.ElectronicDevice;
import ProjectClasses.Employee;
import ProjectClasses.Receptionalist;
import ProjectClasses.Technician;
import java.awt.Color;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author lenovo
 */
public class EmpPaymentUI extends javax.swing.JFrame {

    private ElectronicDevice electronicDevice;
    private Receptionalist receptionalist;
    private Customer customer;
    private Technician technician;
    /**
     * Creates new form EmpPaymentUI
     */
    public EmpPaymentUI() {
        initComponents();
        disableTextBoxes();
    }

        private void disableTextBoxes() {
        electronicDevice = new ElectronicDevice();
        receptionalist = new Receptionalist();
        
        electronicDevice.showHardwareDetails(hardwareTable);
        receptionalist.setNextOrderIDFromDatabase(orderIDTxt);        
        
        hardwareIDTxt.setEnabled(false);
        unitPriceTxt.setEnabled(false);
        typeTxt.setEnabled(false);
        usageTimeTxt.setEnabled(false);
        orderIDTxt.setEnabled(false);
        repairIDTxt.setEnabled(false);
        
        unitPriceTxt.setToolTipText("This field is for display only.");
        typeTxt.setToolTipText("This field is for display only.");
        hardwareIDTxt.setToolTipText("This field is for display only.");
        usageTimeTxt.setToolTipText("This field is for display only.");
        orderIDTxt.setToolTipText("This field is for display only.");
        repairIDTxt.setToolTipText("This field is for display only.");
        
        hardwareIDTxt.setDisabledTextColor(Color.BLACK);
        unitPriceTxt.setDisabledTextColor(Color.BLACK);
        usageTimeTxt.setDisabledTextColor(Color.BLACK);
        orderIDTxt.setDisabledTextColor(Color.BLACK);
        typeTxt.setRenderer(new CustomComboBoxRenderer());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        close = new javax.swing.JButton();
        dashboardButton = new javax.swing.JToggleButton();
        repair = new javax.swing.JToggleButton();
        customerButton = new javax.swing.JToggleButton();
        backToLogin = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hardwareTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        hardwareCart = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        dropButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        proceedToPay = new javax.swing.JButton();
        empIDTxt = new javax.swing.JTextField();
        warrantyDueDateTxt = new com.toedter.calendar.JDateChooser();
        warrantyDateTxt = new com.toedter.calendar.JDateChooser();
        usageTimeTxt = new javax.swing.JTextField();
        typeTxt = new javax.swing.JComboBox<>();
        unitPriceTxt = new javax.swing.JTextField();
        qtyTxt = new javax.swing.JTextField();
        hardwareIDTxt = new javax.swing.JTextField();
        orderIDTxt = new javax.swing.JTextField();
        customerIDTxt = new javax.swing.JTextField();
        repairIDTxt = new javax.swing.JTextField();
        paymentBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1366, 768));
        jPanel1.setMinimumSize(new java.awt.Dimension(1366, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setBackground(new java.awt.Color(255, 0, 51));
        close.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setText("X");
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 0, 180, 50));

        dashboardButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dashboardButton.setForeground(new java.awt.Color(0, 102, 255));
        dashboardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-dashboard-64.png"))); // NOI18N
        dashboardButton.setText("Dashboard");
        dashboardButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardButtonActionPerformed(evt);
            }
        });
        jPanel1.add(dashboardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 390, 80));

        repair.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        repair.setForeground(new java.awt.Color(0, 102, 255));
        repair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-repair-64.png"))); // NOI18N
        repair.setText("Repair");
        repair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        repair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repairActionPerformed(evt);
            }
        });
        jPanel1.add(repair, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 390, 90));

        customerButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        customerButton.setForeground(new java.awt.Color(0, 102, 255));
        customerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-customer-64.png"))); // NOI18N
        customerButton.setText("Customer");
        customerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerButtonActionPerformed(evt);
            }
        });
        jPanel1.add(customerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 390, 80));

        backToLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        backToLogin.setForeground(new java.awt.Color(0, 102, 255));
        backToLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-login-64.png"))); // NOI18N
        backToLogin.setText("Back to Login");
        backToLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToLoginActionPerformed(evt);
            }
        });
        jPanel1.add(backToLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 390, 80));

        jLabel1.setBackground(new java.awt.Color(0, 102, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("Available Hardwares");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, -1));

        hardwareTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Brand", "Type", "Unit Price", "Qty", "Country", "Used Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hardwareTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hardwareTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hardwareTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(hardwareTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 60, 840, 230));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("The Hardware Cart");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 310, -1, -1));

        hardwareCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hardware ID", "Amount", "Unit Price", "Start date", "Due date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hardwareCart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hardwareCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hardwareCartMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(hardwareCart);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 350, 450, 290));

        addButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addButton.setText("ADD");
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 660, 90, -1));

        dropButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dropButton.setText("DROP");
        dropButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dropButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropButtonActionPerformed(evt);
            }
        });
        jPanel1.add(dropButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 90, -1));

        clearButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        jPanel1.add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 660, 80, -1));

        proceedToPay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        proceedToPay.setForeground(new java.awt.Color(0, 102, 204));
        proceedToPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-money-64.png"))); // NOI18N
        proceedToPay.setText("Proceed To Pay");
        proceedToPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        proceedToPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedToPayActionPerformed(evt);
            }
        });
        jPanel1.add(proceedToPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 700, 280, 60));
        jPanel1.add(empIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 710, 210, -1));

        warrantyDueDateTxt.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(warrantyDueDateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 660, 210, -1));

        warrantyDateTxt.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(warrantyDateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 600, 210, -1));

        usageTimeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usageTimeTxtActionPerformed(evt);
            }
        });
        jPanel1.add(usageTimeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, 210, -1));

        typeTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Brand New", "Second Hand" }));
        typeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeTxtActionPerformed(evt);
            }
        });
        jPanel1.add(typeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 510, 210, 30));
        jPanel1.add(unitPriceTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, 210, -1));

        qtyTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyTxtActionPerformed(evt);
            }
        });
        jPanel1.add(qtyTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 210, -1));

        hardwareIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardwareIDTxtActionPerformed(evt);
            }
        });
        jPanel1.add(hardwareIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, 210, -1));
        jPanel1.add(orderIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, 210, -1));
        jPanel1.add(customerIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, 210, -1));
        jPanel1.add(repairIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, 210, -1));

        paymentBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EmpPaymentUI.png"))); // NOI18N
        jPanel1.add(paymentBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        if (isHardwareCartEmpty()) {
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Please drop all items from the cart before closing", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_closeActionPerformed
    
    private boolean isHardwareCartEmpty() {
        return hardwareCart.getRowCount() == 0;
    }
    
    private void repairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repairActionPerformed
        // TODO add your handling code here:
        if (isHardwareCartEmpty()) {
            EmpRepairUI empRepairUI = new EmpRepairUI();
            empRepairUI.setVisible(true);
            this.setVisible(false); 
        } else {
            JOptionPane.showMessageDialog(null, "Please drop all items from the cart before closing", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_repairActionPerformed

    private void customerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerButtonActionPerformed
        // TODO add your handling code here:
        if (isHardwareCartEmpty()) {
            EmpCustomerUI empCustomerUI = new EmpCustomerUI();
            empCustomerUI.setVisible(true);
            this.setVisible(false);    
        } else {
            JOptionPane.showMessageDialog(null, "Please drop all items from the cart before leave this page", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_customerButtonActionPerformed

    private void backToLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToLoginActionPerformed
        // TODO add your handling code here:
        if (isHardwareCartEmpty()) {
            MainLoginUI mainLoginUI = new MainLoginUI();
            mainLoginUI.setVisible(true);
            this.setVisible(false);   
        } else {
            JOptionPane.showMessageDialog(null, "Please drop all items from the cart before leave this page", "Error", JOptionPane.ERROR_MESSAGE);
        }    
    }//GEN-LAST:event_backToLoginActionPerformed

    private void hardwareTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hardwareTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) hardwareTable.getModel();
        electronicDevice = new ElectronicDevice();

        int selectedRow = hardwareTable.getSelectedRow();

        // Check if a row is selected
        if (selectedRow != -1) {
            String hWHardwareID = String.valueOf(model.getValueAt(selectedRow, 0));
            String hwHardwareType = String.valueOf(model.getValueAt(selectedRow, 3)).trim();
            double hwUnitPrice = electronicDevice.parseDoubleValue(model.getValueAt(selectedRow, 4));

            // Parse qty and usageTime as integers
            int hwUsageTime = electronicDevice.parseIntegerValue(model.getValueAt(selectedRow, 7));

            // Update your UI components with the values
            hardwareIDTxt.setText(hWHardwareID);
            unitPriceTxt.setText(String.valueOf(hwUnitPrice));
            usageTimeTxt.setText(String.valueOf(hwUsageTime));

            if (hwHardwareType.equalsIgnoreCase("Brand New")) {
                typeTxt.setSelectedIndex(0);
            } else {
                typeTxt.setSelectedIndex(1);
            }
        }
    }//GEN-LAST:event_hardwareTableMouseClicked

    private void hardwareCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hardwareCartMouseClicked
        // TODO add your handling code here:
        int selectedRowIndex = hardwareCart.getSelectedRow();

        if (selectedRowIndex != -1) {
            String hardwareID = hardwareCart.getValueAt(selectedRowIndex, 0).toString();
            int qty = Integer.parseInt(hardwareCart.getValueAt(selectedRowIndex, 1).toString());
            double unitPrice = Double.parseDouble(hardwareCart.getValueAt(selectedRowIndex, 2).toString());

            // Assuming columns 3 and 4 are for warrantyDate and warrantyDueDate
            Date warrantyDate = (Date) hardwareCart.getValueAt(selectedRowIndex, 3);
            Date warrantyDueDate = (Date) hardwareCart.getValueAt(selectedRowIndex, 4);

            hardwareIDTxt.setText(hardwareID);
            qtyTxt.setText(String.valueOf(qty));
            unitPriceTxt.setText(String.valueOf(unitPrice));

            // Display or handle the warranty dates as needed
            if (warrantyDate != null) {
                warrantyDateTxt.setDate(warrantyDate);
            } else {
                // Handle if warrantyDate is null or not available
                warrantyDateTxt.setDate(null);  // Clear the JDateChooser
            }

            if (warrantyDueDate != null) {
                warrantyDueDateTxt.setDate(warrantyDueDate);
            } else {
                // Handle if warrantyDueDate is null or not available
                warrantyDueDateTxt.setDate(null);  // Clear the JDateChooser
            }
        }
    }//GEN-LAST:event_hardwareCartMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        String customerID = customerIDTxt.getText();
        String orderID = orderIDTxt.getText();
        String repairID = (repairIDTxt.getText().isEmpty()) ? null : repairIDTxt.getText();
        String hardwareID = hardwareIDTxt.getText();
        int typeIndex = typeTxt.getSelectedIndex();
        String type = (typeIndex == 0) ? "Brand New" : "Second Hand";
        Date warrantyDate = warrantyDateTxt.getDate();
        Date warrantyDueDate = warrantyDueDateTxt.getDate();
        String employeeID = empIDTxt.getText();

        // Initialize variables with default values
        int qty = 0;
        double unitPrice = 0.0;
        int usageTime = 0;

        // Check if the text fields are not empty before parsing
        if (!qtyTxt.getText().isEmpty()) {
            qty = Integer.parseInt(qtyTxt.getText());
        }

        if (!unitPriceTxt.getText().isEmpty()) {
            unitPrice = Double.parseDouble(unitPriceTxt.getText());
        }

        if (!usageTimeTxt.getText().isEmpty()) {
            usageTime = Integer.parseInt(usageTimeTxt.getText());
        }

        customer = new Customer();
        electronicDevice = new ElectronicDevice();
        technician = new Technician();
        receptionalist = new Receptionalist();
        Employee employee = new Employee();

        if (customerID.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the customer ID");
        }
        else if (customer.isPersonIDValid(customerID) == false) {
            JOptionPane.showMessageDialog(null, "Please enter a valid customer ID which follows either CUS/N/XXXXX or CUS/W/XXXXX pattern", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (customer.isPersonExist(customerID) == false) {
            JOptionPane.showMessageDialog(null, "This customer ID does not exist", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (qtyTxt.getText().isEmpty() || qty == 0) {
            JOptionPane.showMessageDialog(null, "Please enter the amount");
        }
        else if (!receptionalist.validateHardwareQuantity(hardwareID, qty)) {
            JOptionPane.showMessageDialog(null, "Entered quantity exceeds available quantity", "Message", JOptionPane.ERROR_MESSAGE);
        }
        else if (electronicDevice.isHardwareQtyValid(qtyTxt.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Please enter the amount as a natural number");
        }
        else if (electronicDevice.isHardwareQtyValid(qtyTxt.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Hardware quantity must be an integer !!!", "Message", JOptionPane.ERROR_MESSAGE);
        }                
        else if (employeeID.equals("") == true) {
            JOptionPane.showMessageDialog(null, "Please enter the employee ID");
        }        
        else if (receptionalist.isPersonIDValid(employeeID) == false) {
            JOptionPane.showMessageDialog(null, "Please enter a valid employee ID which follows EMP/REC/XXX pattern", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (employee.isPersonExist(employeeID) == false) {
            JOptionPane.showMessageDialog(null, "This employee does not exist", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (unitPriceTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the unit price");
        }
        else if (usageTimeTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the unit price");
        }
        else if (usageTimeTxt.getText().isEmpty() || hardwareID.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the hardware ID by clicking relevant row of the table.");
        }        
        else if (repairID != null && repairID.equals("") == false) {
            if (technician.isRepairIDValid(repairID) == false) {
                JOptionPane.showMessageDialog(null, "Please enter a valid repair ID which follows REP/XXXXX pattern", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (technician.isRepairIDExist(repairID) == true) {
                JOptionPane.showMessageDialog(null, "This repair already exists", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            if (warrantyDate == null || warrantyDueDate == null) {
                JOptionPane.showMessageDialog(null, "Please select warranty dates", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method if dates are not selected
            }
            receptionalist.AddHardwareToCart(hardwareTable, hardwareCart, hardwareID, qty, unitPrice, warrantyDate, warrantyDueDate);
            try {
                hardwareIDTxt.setText("");
                typeTxt.setSelectedIndex(0);
                qtyTxt.setText("");
                unitPriceTxt.setText("");
                usageTimeTxt.setText("");
                warrantyDateTxt.setDate(null);
                warrantyDueDateTxt.setDate(null);
                JOptionPane.showMessageDialog(null, "Item added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error adding Item", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void dropButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropButtonActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = hardwareCart.getSelectedRow();
        receptionalist = new Receptionalist();
        // Check if a row is selected
        if (selectedRowIndex != -1) {
            // Get the hardware ID from the selected row
            String hardwareID = hardwareCart.getValueAt(selectedRowIndex, 0).toString();

            // Get the quantity from the selected row
            int qty = Integer.parseInt(hardwareCart.getValueAt(selectedRowIndex, 1).toString());

            // Increase the hardware quantity in the database
            receptionalist.dropHardwareFromCart(hardwareTable, hardwareCart, hardwareID, qty);

            // Remove the selected row from the hardware cart table
            DefaultTableModel model = (DefaultTableModel) hardwareCart.getModel();
            model.removeRow(selectedRowIndex);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to drop", "Error", JOptionPane.ERROR_MESSAGE);
        }
        hardwareIDTxt.setText("");
        typeTxt.setSelectedIndex(0);
        qtyTxt.setText("");
        repairIDTxt.setText("");
        unitPriceTxt.setText("");
        usageTimeTxt.setText("");
        warrantyDateTxt.setDate(null);
        warrantyDueDateTxt.setDate(null);
    }//GEN-LAST:event_dropButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        empIDTxt.setText("");
        customerIDTxt.setText("");
        hardwareIDTxt.setText("");
        typeTxt.setSelectedIndex(0);
        qtyTxt.setText("");
        repairIDTxt.setText("");
        unitPriceTxt.setText("");
        usageTimeTxt.setText("");
        warrantyDateTxt.setDate(null);
        warrantyDueDateTxt.setDate(null);
    }//GEN-LAST:event_clearButtonActionPerformed

    private void proceedToPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedToPayActionPerformed
        // TODO add your handling code here:
        if (isHardwareCartEmpty()) {
            JOptionPane.showMessageDialog(null, "You have not choose any item to pay.", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else {
            String employeeID = empIDTxt.getText();
            String customerID = customerIDTxt.getText();
            String orderID = orderIDTxt.getText();

            receptionalist = new Receptionalist();
            // Print debug information
            System.out.println("Adding Order: CustomerID=" + customerID + ", OrderID=" + orderID + ", EmployeeID=" + employeeID);
            receptionalist.addOrder(customerID, orderID, employeeID);

            // Iterate through the rows in hardwareCart table
            DefaultTableModel cartModel = (DefaultTableModel) hardwareCart.getModel();
            int rowCount = cartModel.getRowCount();

            for (int i = 0; i < rowCount; i++) {
                String hardwareID = cartModel.getValueAt(i, 0).toString();
                int qty = Integer.parseInt(cartModel.getValueAt(i, 1).toString());
                double unitPrice = Double.parseDouble(cartModel.getValueAt(i, 2).toString());
                Date warrantyDate = (Date) cartModel.getValueAt(i, 3);
                Date warrantyDueDate = (Date) cartModel.getValueAt(i, 4);

                // Print debug information
                System.out.println("Adding Order Warranty: CustomerID=" + customerID + ", OrderID=" + orderID + ", HardwareID=" + hardwareID);

                // Call the function to add order warranty for each row
                receptionalist.addOrderWarranty(customerID, orderID, hardwareID, qty, warrantyDate, warrantyDueDate);
            }
            for (int i = rowCount - 1; i >= 0; i--) {
                cartModel.removeRow(i);
            }
            PrintBillUI printBillUI = new PrintBillUI();
            printBillUI.setVisible(true);
            this.setVisible(false);
            empIDTxt.setText("");
            customerIDTxt.setText("");
            hardwareIDTxt.setText("");
            typeTxt.setSelectedIndex(0);
            qtyTxt.setText("");
            repairIDTxt.setText("");
            unitPriceTxt.setText("");
            usageTimeTxt.setText("");
            warrantyDateTxt.setDate(null);
            warrantyDueDateTxt.setDate(null);
        }
    }//GEN-LAST:event_proceedToPayActionPerformed

    private void usageTimeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usageTimeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usageTimeTxtActionPerformed

    private void qtyTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyTxtActionPerformed

    private void hardwareIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hardwareIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hardwareIDTxtActionPerformed

    private void dashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardButtonActionPerformed
        // TODO add your handling code here:
        if (isHardwareCartEmpty()) {
            EmpDashboard empDashboard = new EmpDashboard();
            empDashboard.setVisible(true);
            this.setVisible(false);   
        } else {
            JOptionPane.showMessageDialog(null, "Please drop all items from the cart before leave this page", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_dashboardButtonActionPerformed

    private void typeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeTxtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmpPaymentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpPaymentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpPaymentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpPaymentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpPaymentUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JToggleButton backToLogin;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton close;
    private javax.swing.JToggleButton customerButton;
    private javax.swing.JTextField customerIDTxt;
    private javax.swing.JToggleButton dashboardButton;
    private javax.swing.JButton dropButton;
    private javax.swing.JTextField empIDTxt;
    private javax.swing.JTable hardwareCart;
    private javax.swing.JTextField hardwareIDTxt;
    private javax.swing.JTable hardwareTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField orderIDTxt;
    private javax.swing.JLabel paymentBackground;
    private javax.swing.JButton proceedToPay;
    private javax.swing.JTextField qtyTxt;
    private javax.swing.JToggleButton repair;
    private javax.swing.JTextField repairIDTxt;
    private javax.swing.JComboBox<String> typeTxt;
    private javax.swing.JTextField unitPriceTxt;
    private javax.swing.JTextField usageTimeTxt;
    private com.toedter.calendar.JDateChooser warrantyDateTxt;
    private com.toedter.calendar.JDateChooser warrantyDueDateTxt;
    // End of variables declaration//GEN-END:variables
}
