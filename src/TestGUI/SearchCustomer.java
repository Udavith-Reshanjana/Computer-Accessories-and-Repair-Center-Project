/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TestGUI;

import ProjectClasses.Customer;
import ProjectClasses.NormalCustomer;
import ProjectClasses.Receptionalist;
import ProjectClasses.WebcamQRCodeReader;
import ProjectClasses.WholeSaleCustomer;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author lenovo
 */
public class SearchCustomer extends javax.swing.JFrame {

    Customer customer;
    WholeSaleCustomer wholeSaleCustomer;
    NormalCustomer normalCustomer;
    WebcamQRCodeReader webcamReader;
    Receptionalist receptionalist;

    /**
     * Creates new form SearchCustomer
     */
    public SearchCustomer() {
        initComponents();
        webcamReader = new WebcamQRCodeReader();
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
        qrScanButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        searchMethodTxt = new javax.swing.JComboBox<>();
        searchTxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        customerGeneralDetails = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        customerRelevantPaymentDetails = new javax.swing.JTable();
        close3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        relevantOrderDetailsTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        relevantRepairDetailsTable = new javax.swing.JTable();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        qrScanButton.setBackground(new java.awt.Color(0, 102, 255));
        qrScanButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        qrScanButton.setForeground(new java.awt.Color(255, 255, 255));
        qrScanButton.setText("Search By QR");
        qrScanButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        qrScanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qrScanButtonActionPerformed(evt);
            }
        });
        jPanel1.add(qrScanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 90, 120, 60));

        searchButton.setBackground(new java.awt.Color(0, 102, 255));
        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel1.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 100, 110, 40));

        searchMethodTxt.setBackground(new java.awt.Color(0, 102, 255));
        searchMethodTxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchMethodTxt.setForeground(new java.awt.Color(255, 255, 255));
        searchMethodTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer ID", "NIC Number" }));
        jPanel1.add(searchMethodTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 100, 140, 40));
        jPanel1.add(searchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 380, 40));

        customerGeneralDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Customer ID", "Customer Name", "Type", "NIC", "Address", "Contact Numbers"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerGeneralDetails.setShowVerticalLines(true);
        jScrollPane2.setViewportView(customerGeneralDetails);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 830, 90));

        customerRelevantPaymentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Payment ID", "Payment Date", "Total Amount", "Given Amount", "Discount", "Repair ID", "Customer ID", "Order ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerRelevantPaymentDetails.setShowVerticalLines(true);
        jScrollPane3.setViewportView(customerRelevantPaymentDetails);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 830, 110));

        close3.setBackground(new java.awt.Color(255, 0, 51));
        close3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        close3.setForeground(new java.awt.Color(255, 255, 255));
        close3.setText("X");
        close3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close3ActionPerformed(evt);
            }
        });
        jPanel1.add(close3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 0, 180, 50));

        relevantOrderDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Customer ID", "Order ID", "Hardware ID", "Amount", "Warranty Start Date", "Warranty Due Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        relevantOrderDetailsTable.setShowVerticalLines(true);
        jScrollPane1.setViewportView(relevantOrderDetailsTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 830, 110));

        relevantRepairDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Repair ID", "Repair Description", "Customer ID", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        relevantRepairDetailsTable.setShowVerticalLines(true);
        jScrollPane4.setViewportView(relevantRepairDetailsTable);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 650, 830, 110));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainCustomerUI.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

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

    private void qrScanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qrScanButtonActionPerformed
        // TODO add your handling code here:
        receptionalist = new Receptionalist();

        // Create a new thread for the webcam
        Thread webcamThread = new Thread(() -> {
            // Initialize the webcam reader
            webcamReader.initialize();

            int scanCount = 0;
            String cusID = null;  // Variable to store the decoded text

            // Continue scanning until the desired number of scans is reached
            while (scanCount < 1) { // Change 1 to the desired number of scans
                // Start reading from the webcam
                cusID = webcamReader.startReading();

                // Check if a QR code is successfully decoded
                if (cusID != null) {
                    // Do something with the decoded text
                    System.out.println("Decoded QR Code (Scan " + (scanCount + 1) + "): " + cusID);

                    receptionalist.displayCustomerDetails(cusID, customerGeneralDetails);
                    receptionalist.displayPaymentDetails(cusID, customerRelevantPaymentDetails);
                    receptionalist.displayOrderWarrantyDetails(cusID, relevantOrderDetailsTable);
                    receptionalist.displayRepairDetailsByCustomerId(cusID, relevantRepairDetailsTable);

                    // Terminate the camera after a successful scan
                    webcamReader.stopReading();
                    webcamReader.closeCameraUI();
                    System.out.println("Camera terminated successfully.");
                }

                // Schedule a task to stop the camera after 15 seconds
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        webcamReader.stopReading();
                        webcamReader.closeCameraUI();
                        System.out.println("Camera terminated successfully.");
                    }
                }, 15000);

                // Check for a successful QR code read and stop the camera if found
                while (!webcamReader.isStopReading()) {
                    try {
                        Thread.sleep(10);  // Reduce the delay to 10 milliseconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Cancel the timer and reset stopReading flag
                timer.cancel();
                webcamReader.setStopReading(false);

                scanCount++;
            }
        });

        // Start the webcam thread
        webcamThread.start();
    }//GEN-LAST:event_qrScanButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        String getSearchText = searchTxt.getText().trim();
        String getSearchMethod = searchMethodTxt.getSelectedItem().toString().trim();
        receptionalist = new Receptionalist();
        customer = new Customer();
        
        if (getSearchText.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter a customer ID or customer's NIC number");
        }
        else if ("Customer ID".equals(getSearchMethod)) {         
            if (customer.isPersonIDValid(getSearchText) == false) {
                 JOptionPane.showMessageDialog(null, "This customer ID is not valid. Use CUS/N/XXXXX or CUS/W/XXXXX pattern !!!", "Message", JOptionPane.ERROR_MESSAGE);
            }
            else if (customer.isPersonExist(getSearchText) == false) {
                 JOptionPane.showMessageDialog(null, "This customer ID is not exist !!!", "Message", JOptionPane.ERROR_MESSAGE);
            }
            else{
                receptionalist.displayCustomerDetails(getSearchText, customerGeneralDetails);
                receptionalist.displayPaymentDetails(getSearchText, customerRelevantPaymentDetails);
                receptionalist.displayOrderWarrantyDetails(getSearchText, relevantOrderDetailsTable);
                receptionalist.displayRepairDetailsByCustomerId(getSearchText, relevantRepairDetailsTable);
            }
        } else {
            if (customer.isNICValid(getSearchText) == false) {
                JOptionPane.showMessageDialog(null, "This NIC number is invalid !!!", "Message", JOptionPane.ERROR_MESSAGE);
            }
            else if (customer.isNICExist(getSearchText) == false) {
                 JOptionPane.showMessageDialog(null, "This NIC number is not exist !!!", "Message", JOptionPane.ERROR_MESSAGE);
            }
            else{ 
                receptionalist.displayCustomerDetailsByNIC(getSearchText, customerGeneralDetails);
                receptionalist.displayPaymentDetailsByNIC(getSearchText, customerRelevantPaymentDetails);
                receptionalist.displayOrderWarrantyDetailsByNIC(getSearchText, relevantOrderDetailsTable);
                receptionalist.displayRepairDetailsByCustomerNIC(getSearchText, relevantRepairDetailsTable);
            }
        }
        
        

//        receptionalist.displayCustomerDetails(getCusID, customerGeneralDetails);
//        receptionalist.displayEconomicalDataForCustomer(getCusID, jTable2);

    }//GEN-LAST:event_searchButtonActionPerformed

    private void close3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_close3ActionPerformed

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
            java.util.logging.Logger.getLogger(SearchCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton close3;
    private javax.swing.JTable customerGeneralDetails;
    private javax.swing.JTable customerRelevantPaymentDetails;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton qrScanButton;
    private javax.swing.JTable relevantOrderDetailsTable;
    private javax.swing.JTable relevantRepairDetailsTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> searchMethodTxt;
    private javax.swing.JTextField searchTxt;
    // End of variables declaration//GEN-END:variables
}
