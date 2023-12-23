/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package costproject_mspcaahc;

import TestGUI.*;
import ProjectClasses.Employee;
import ProjectClasses.Receptionalist;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class PrintBillUI extends javax.swing.JFrame {

    private Receptionalist receptionalist;
    /**
     * Creates new form TestPrintBill
     */
    public PrintBillUI() {
        initComponents();
        billHeader();
        disableTextBoxes();
    }

    private void billHeader() {
        receptionalist = new Receptionalist();
        Date today = Calendar.getInstance().getTime();
        
        receptionalist.setNextPaymentIDFromDatabase(pmtIDTxt);
        OrderIDTxt.setText(receptionalist.getHighestOrderID());
        customerIDTxt.setText(receptionalist.getCustomerIDFromOrder(receptionalist.getHighestOrderID()));
        dateTxt.setDate(today);
        
        String cusID = customerIDTxt.getText();
        String ordID = OrderIDTxt.getText();
        empIDTxt.setText(receptionalist.getEmployeeIDByOrderID(ordID));
        receptionalist.populateHardwareCart(cusID, ordID, hardwareCart);
        totalPriceTxt.setText(Double.toString(receptionalist.calculateTotalPrice(ordID, cusID)));
    }
    private void disableTextBoxes() {
        receptionalist = new Receptionalist();      
        
        pmtIDTxt.setEnabled(false);
        OrderIDTxt.setEnabled(false);
        dateTxt.setEnabled(false);
        customerIDTxt.setEnabled(false);
        totalPriceTxt.setEnabled(false);
        finalPrice.setEnabled(false);
        restQty.setEnabled(false);
        
        pmtIDTxt.setToolTipText("This field is for display only.");
        OrderIDTxt.setToolTipText("This field is for display only.");
        dateTxt.setToolTipText("This field is for display only.");
        customerIDTxt.setToolTipText("This field is for display only.");
        totalPriceTxt.setToolTipText("This field is for display only.");
        finalPrice.setToolTipText("This field is for display only.");
        restQty.setToolTipText("This field is for display only.");
        
        pmtIDTxt.setDisabledTextColor(Color.BLACK);
        OrderIDTxt.setDisabledTextColor(Color.BLACK);
        customerIDTxt.setDisabledTextColor(Color.BLACK);
        totalPriceTxt.setDisabledTextColor(Color.BLACK);
        finalPrice.setDisabledTextColor(Color.BLACK);
        restQty.setDisabledTextColor(Color.BLACK);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        billPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pmtIDTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        OrderIDTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        empIDTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dateTxt = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        totalPriceTxt = new javax.swing.JTextField();
        discountTxt = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        hardwareCart = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        customerIDTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        finalPrice = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        givenTxt = new javax.swing.JTextField();
        restQty = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        backgroundImage = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Calculate = new javax.swing.JToggleButton();
        printButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        billPanel.setBackground(new java.awt.Color(255, 255, 255));
        billPanel.setMaximumSize(new java.awt.Dimension(500, 600));
        billPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Payment ID : ");
        billPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        pmtIDTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pmtIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmtIDTxtActionPerformed(evt);
            }
        });
        billPanel.add(pmtIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 140, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Order ID       : ");
        billPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        OrderIDTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        OrderIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderIDTxtActionPerformed(evt);
            }
        });
        billPanel.add(OrderIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 140, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Employee ID : ");
        billPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 80, -1));

        empIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empIDTxtActionPerformed(evt);
            }
        });
        billPanel.add(empIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 120, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Date              : ");
        billPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 80, -1));

        dateTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dateTxt.setDateFormatString("yyyy-MM-dd");
        dateTxt.setIcon(null);
        billPanel.add(dateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 140, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Total Price :");
        billPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Discount    : ");
        billPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));
        billPanel.add(totalPriceTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 120, -1));
        billPanel.add(discountTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 120, -1));

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
        hardwareCart.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        hardwareCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hardwareCartMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(hardwareCart);

        billPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 450, 230));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Customer ID : ");
        billPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        customerIDTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        customerIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIDTxtActionPerformed(evt);
            }
        });
        billPanel.add(customerIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 140, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Final Charge :");
        billPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));
        billPanel.add(finalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 120, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Given : ");
        billPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Rest :");
        billPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 530, -1, -1));
        billPanel.add(givenTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 90, -1));

        restQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restQtyActionPerformed(evt);
            }
        });
        billPanel.add(restQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 530, 90, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("THANK YOU !!!");
        billPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 140, 40));

        backgroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/billUI.png"))); // NOI18N
        billPanel.add(backgroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        Calculate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Calculate.setForeground(new java.awt.Color(0, 102, 255));
        Calculate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-calculate-price-64.png"))); // NOI18N
        Calculate.setText("Calculate Final Charge");
        Calculate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateActionPerformed(evt);
            }
        });
        jPanel2.add(Calculate);
        Calculate.setBounds(20, 20, 220, 60);

        printButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        printButton.setForeground(new java.awt.Color(0, 102, 255));
        printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-print-64.png"))); // NOI18N
        printButton.setText("Print Bill");
        printButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        jPanel2.add(printButton);
        printButton.setBounds(270, 20, 180, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(billPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(billPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pmtIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmtIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pmtIDTxtActionPerformed

    private void OrderIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrderIDTxtActionPerformed

    private void empIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empIDTxtActionPerformed

    private void hardwareCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hardwareCartMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_hardwareCartMouseClicked

    private void customerIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerIDTxtActionPerformed

    private void CalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateActionPerformed
        // TODO add your handling code here:
        receptionalist = new Receptionalist();
        if (discountTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the discount.");
        }
        else if (receptionalist.isNumberbetween0and100(discountTxt.getText())) {
            JOptionPane.showMessageDialog(null, "Please enter a positive number between 0 and 100 to discount.");
        }
        else {
            try {
                double discount = Double.parseDouble(discountTxt.getText());
                double totalPrice = Double.parseDouble(totalPriceTxt.getText());


                // Calculate the final charge using the calculateFinalCharge method
                double finalCharge = receptionalist.calculateFinalCharge(discount, totalPrice);

                // Display the final charge in the finalPrice text field
                finalPrice.setText(String.valueOf(finalCharge));
                JOptionPane.showMessageDialog(null, "Final Charge Value : " + finalCharge, "Final Amount", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid real number between 0 and 100 to discount .", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_CalculateActionPerformed

    private void restQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_restQtyActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        // TODO add your handling code here:
        receptionalist = new Receptionalist();
        Employee employee = new Employee();

        if (finalPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please perform calculate final charge", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (empIDTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your employee ID");
        } else if (!employee.isPersonIDValid(empIDTxt.getText())) {
            JOptionPane.showMessageDialog(null, "Please enter a valid employee ID which follows either EMP/MGT/XXX, EMP/REP/XXX, or EMP/TEC/XXX pattern", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!employee.isPersonExist(empIDTxt.getText())) {
            JOptionPane.showMessageDialog(null, "This employee does not exist", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (givenTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the given amount", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            try {
                // Calculate rest
                double totalAmount = Double.parseDouble(finalPrice.getText());
                double givenAmount = Double.parseDouble(givenTxt.getText());
                double discount = Double.parseDouble(discountTxt.getText());
                
                if (givenAmount <= 0 || givenAmount < totalAmount) {
                    JOptionPane.showMessageDialog(null, "Your given amount " + givenTxt.getText() + " must be non-negative value which is greater than " + finalPrice.getText(), "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method if validation fails
                }
                
                double restAmount = receptionalist.calculateRest(totalAmount, givenAmount);
                String restAmountStr = String.format("%.2f", restAmount); 
                restQty.setText(restAmountStr);

                // Display rest amount
                JOptionPane.showMessageDialog(null, "Rest amount: " + restAmount, "Rest Amount", JOptionPane.INFORMATION_MESSAGE);

                // Add payment to payment table
                String paymentID = pmtIDTxt.getText(); 
                String orderID = OrderIDTxt.getText(); 

                // Assuming dateTxt is your JDateChooser component
                java.util.Date selectedDate = dateTxt.getDate();

                // If you need to convert it to a java.sql.Date
                java.sql.Date selectedSqlDate = (selectedDate != null) ? new java.sql.Date(selectedDate.getTime()) : null;

                receptionalist.addPayment(paymentID, orderID, totalAmount, givenAmount, selectedSqlDate, customerIDTxt, discount);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number format for total amount or given amount", "Error", JOptionPane.ERROR_MESSAGE);
            }
            receptionalist.exportBillToPDF(billPanel);
            EmpPaymentUI empPaymentUI = new EmpPaymentUI();
            empPaymentUI.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_printButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PrintBillUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintBillUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintBillUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintBillUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintBillUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Calculate;
    private javax.swing.JTextField OrderIDTxt;
    private javax.swing.JLabel backgroundImage;
    private javax.swing.JPanel billPanel;
    private javax.swing.JTextField customerIDTxt;
    private com.toedter.calendar.JDateChooser dateTxt;
    private javax.swing.JTextField discountTxt;
    private javax.swing.JTextField empIDTxt;
    private javax.swing.JTextField finalPrice;
    private javax.swing.JTextField givenTxt;
    private javax.swing.JTable hardwareCart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField pmtIDTxt;
    private javax.swing.JToggleButton printButton;
    private javax.swing.JTextField restQty;
    private javax.swing.JTextField totalPriceTxt;
    // End of variables declaration//GEN-END:variables
}
