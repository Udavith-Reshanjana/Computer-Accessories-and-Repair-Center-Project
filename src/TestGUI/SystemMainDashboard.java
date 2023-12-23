/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TestGUI;

/**
 *
 * @author lenovo
 */
public class SystemMainDashboard extends javax.swing.JFrame {

    /**
     * Creates new form SystemMainDashboard
     */
    public SystemMainDashboard() {
        initComponents();
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
        repair = new javax.swing.JToggleButton();
        customer = new javax.swing.JToggleButton();
        employee = new javax.swing.JToggleButton();
        hardware = new javax.swing.JToggleButton();
        payment = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        repair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        repair.setForeground(new java.awt.Color(0, 102, 255));
        repair.setText("Repair");
        repair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(repair, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 230, 50));

        customer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        customer.setForeground(new java.awt.Color(0, 102, 255));
        customer.setText("Customer");
        customer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 230, 50));

        employee.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employee.setForeground(new java.awt.Color(0, 102, 255));
        employee.setText("Employee");
        employee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 230, 50));

        hardware.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hardware.setForeground(new java.awt.Color(0, 102, 255));
        hardware.setText("Hardware");
        hardware.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(hardware, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 230, 50));

        payment.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        payment.setForeground(new java.awt.Color(0, 102, 255));
        payment.setText("Payment");
        payment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 230, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SystemMainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SystemMainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SystemMainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SystemMainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SystemMainDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton customer;
    private javax.swing.JToggleButton employee;
    private javax.swing.JToggleButton hardware;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton payment;
    private javax.swing.JToggleButton repair;
    // End of variables declaration//GEN-END:variables
}