/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TestGUI;

import ProjectClasses.Customer;
import ProjectClasses.Employee;
import ProjectClasses.Receptionalist;
import ProjectClasses.Technician;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class TestEmpRepairUI extends javax.swing.JFrame {

    private Technician technician;
    private Receptionalist receptionalist;
    private Customer customer;
    /**
     * Creates new form empRepairUI
     */
    public TestEmpRepairUI() {
        initComponents();
        disableTextBoxes();
        
        technician = new Technician();
        technician.showRepairDetailsWithPaymentId(repairTable);
    }

    private void disableTextBoxes() {
        receptionalist = new Receptionalist();
        technician = new Technician();
        
        receptionalist.setNextOrderIDFromDatabase(orderIDTxt);        
        repairIDTxt.setText(technician.getNextRepairID());
        
        repairIDTxt.setEnabled(false);
        statusTxt.setEnabled(false);
        orderIDTxt.setEnabled(false);
        
        repairIDTxt.setToolTipText("This field is for display only.");
        statusTxt.setToolTipText("This field is for display only.");
        orderIDTxt.setToolTipText("This field is for display only.");
        
        repairIDTxt.setDisabledTextColor(Color.BLACK);
        orderIDTxt.setDisabledTextColor(Color.BLACK);
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        repairTable = new javax.swing.JTable();
        close = new javax.swing.JButton();
        customerIDTxt = new javax.swing.JTextField();
        orderIDTxt = new javax.swing.JTextField();
        empIDTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        statusTxt = new javax.swing.JComboBox<>();
        repairIDTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        repairDescTxt = new javax.swing.JTextArea();
        discardButton = new javax.swing.JButton();
        proceedToPay = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1366, 768));
        jPanel1.setMinimumSize(new java.awt.Dimension(1366, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 102, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("Repair Details");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, -1));

        repairTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Repair ID", "Repair Discription", "Customer ID", "Status", "Payment ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        repairTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(repairTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 840, 230));

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
        jPanel1.add(customerIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 270, -1));
        jPanel1.add(orderIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 360, 270, -1));
        jPanel1.add(empIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 270, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Customer ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Order ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 330, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Empoyee ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 410, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Status");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 410, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Repair ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 330, -1, -1));

        statusTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending" }));
        jPanel1.add(statusTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 440, 260, -1));
        jPanel1.add(repairIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 360, 230, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Repair Description");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 500, -1, -1));

        repairDescTxt.setColumns(20);
        repairDescTxt.setRows(5);
        jScrollPane2.setViewportView(repairDescTxt);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 530, -1, -1));

        discardButton.setBackground(new java.awt.Color(255, 0, 51));
        discardButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        discardButton.setForeground(new java.awt.Color(255, 255, 255));
        discardButton.setText("Discard");
        discardButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        discardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardButtonActionPerformed(evt);
            }
        });
        jPanel1.add(discardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 680, 280, 60));

        proceedToPay.setBackground(new java.awt.Color(0, 102, 204));
        proceedToPay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        proceedToPay.setForeground(new java.awt.Color(255, 255, 255));
        proceedToPay.setText("Proceed To Pay");
        proceedToPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        proceedToPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedToPayActionPerformed(evt);
            }
        });
        jPanel1.add(proceedToPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 680, 280, 60));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empRepairUI.png"))); // NOI18N
        bg.setMaximumSize(new java.awt.Dimension(1366, 768));
        bg.setMinimumSize(new java.awt.Dimension(1366, 768));
        bg.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
            System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    private void discardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardButtonActionPerformed
        // TODO add your handling code here:
        empIDTxt.setText("");
        customerIDTxt.setText("");
        repairDescTxt.setText("");
    }//GEN-LAST:event_discardButtonActionPerformed

    private void proceedToPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedToPayActionPerformed
        // TODO add your handling code here:
        String employeeID = empIDTxt.getText().trim();
        String customerID = customerIDTxt.getText().trim();
        String orderID = orderIDTxt.getText().trim();
        String repairID = repairIDTxt.getText().trim();
        String status = statusTxt.getItemAt(0).trim();
        String repairDescription = repairDescTxt.getText();

        receptionalist = new Receptionalist();
        technician = new Technician();
        Employee employee = new Employee();
        customer = new Customer();
        
        if (customerID.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the customer ID");
        }
        else if (customer.isPersonIDValid(customerID) == false) {
            JOptionPane.showMessageDialog(null, "Please enter a valid customer ID which follows either CUS/N/XXXXX or CUS/W/XXXXX pattern", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (customer.isPersonExist(customerID) == false) {
            JOptionPane.showMessageDialog(null, "This customer does not exist", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (employeeID.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the employee ID");
        }
        else if (employee.isPersonIDValid(employeeID) == false) {
            JOptionPane.showMessageDialog(null, "Please enter a valid employee ID which follows either EMP/REC/XXX or EMP/TEC/XXX pattern", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (employee.isPersonExist(employeeID) == false) {
            JOptionPane.showMessageDialog(null, "This employee does not exist", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            receptionalist.addOrder(customerID, orderID, employeeID);
            technician.addRepairData(repairID, repairDescription, customerID, status);
            TestPrintRepairBillUI testPrintRepairBillUI = new TestPrintRepairBillUI();
            testPrintRepairBillUI.setVisible(true);
            this.setVisible(false);
            
            empIDTxt.setText("");
            customerIDTxt.setText("");
            orderIDTxt.setText("");
            repairIDTxt.setText("");
            repairIDTxt.setText("");
            repairDescTxt.setText("");
        }
    }//GEN-LAST:event_proceedToPayActionPerformed

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
            java.util.logging.Logger.getLogger(TestEmpRepairUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestEmpRepairUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestEmpRepairUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestEmpRepairUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestEmpRepairUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton close;
    private javax.swing.JTextField customerIDTxt;
    private javax.swing.JButton discardButton;
    private javax.swing.JTextField empIDTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField orderIDTxt;
    private javax.swing.JButton proceedToPay;
    private javax.swing.JTextArea repairDescTxt;
    private javax.swing.JTextField repairIDTxt;
    private javax.swing.JTable repairTable;
    private javax.swing.JComboBox<String> statusTxt;
    // End of variables declaration//GEN-END:variables
}
