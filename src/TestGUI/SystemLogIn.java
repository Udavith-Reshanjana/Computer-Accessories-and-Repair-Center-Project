/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TestGUI;

import javax.swing.JOptionPane;
import ProjectClasses.Employee;
import javax.swing.JFrame;

/**
 *
 * @author lenovo
 */
public class SystemLogIn extends javax.swing.JFrame {

    /**
     * Creates new form SystemLogIn
     */
    
    public SystemLogIn() {
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
        logInRole = new javax.swing.JComboBox<>();
        logInUserName = new javax.swing.JTextField();
        logInPassword = new javax.swing.JPasswordField();
        logInButton = new javax.swing.JButton();
        showPWBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logInRole.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        logInRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", "Employee", "Manager", "Receptionalist", "Technician" }));
        logInRole.setBorder(null);
        logInRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logInRole.setName(""); // NOI18N
        logInRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInRoleActionPerformed(evt);
            }
        });
        jPanel1.add(logInRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 240, 20));

        logInUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInUserNameActionPerformed(evt);
            }
        });
        jPanel1.add(logInUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 222, 240, 27));
        jPanel1.add(logInPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 240, 27));

        logInButton.setBackground(new java.awt.Color(0, 102, 255));
        logInButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logInButton.setForeground(new java.awt.Color(255, 255, 255));
        logInButton.setText("LOGIN");
        logInButton.setBorder(null);
        logInButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInButtonActionPerformed(evt);
            }
        });
        jPanel1.add(logInButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 330, 140, 60));

        showPWBox.setText("Show password");
        showPWBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPWBoxActionPerformed(evt);
            }
        });
        jPanel1.add(showPWBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 300, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png"))); // NOI18N
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logInRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logInRoleActionPerformed

    private void logInUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logInUserNameActionPerformed

    private void logInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInButtonActionPerformed
        // TODO add your handling code here:
        if (logInUserName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter your username");
        }
        else if (logInPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter your password");
        }
        else {
            String getRole = logInRole.getSelectedItem().toString();
            String getUsername = logInUserName.getText();
            String getPword = logInPassword.getText();
            
            Employee emp = new Employee();
            try{
                boolean result = emp.checkLogin(getRole, getUsername, getPword);

                if (result == true) {
                    if (getRole.equalsIgnoreCase("Manager")) {
                        JOptionPane.showMessageDialog(null, "Login successful !!!");
                        SystemMainDashboard db1 = new SystemMainDashboard();
//                        db1.setLoginFrameReference(this);
//                        loginFrameReferenceClose();
//                        loginFrameReferenceClose();
                        db1.setVisible(true);
                        this.setVisible(false);
                    }
                    else if (getRole.equalsIgnoreCase("Receptionalist")) {
                        JOptionPane.showMessageDialog(null, "Login successful !!!");
                    }
                    else if (getRole.equalsIgnoreCase("Technician")) {
                        JOptionPane.showMessageDialog(null, "Login successful !!!");
                    }              
                }
                else {
                        JOptionPane.showMessageDialog(null, "Wrong username or password !!!", "Message", JOptionPane.ERROR_MESSAGE);
                    }             
            } 
            finally{
//                emp.closeConnection();
                    System.out.println("");
            }
            
        }
    }//GEN-LAST:event_logInButtonActionPerformed

    private void showPWBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPWBoxActionPerformed
        // TODO add your handling code here:
        if (showPWBox.isSelected()) {
            logInPassword.setEchoChar((char)0);
        }
        else {
            logInPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_showPWBoxActionPerformed

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
            java.util.logging.Logger.getLogger(SystemLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SystemLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SystemLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SystemLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SystemLogIn().setVisible(true);
            }
        });
        // Add a shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // This code will be executed when the JVM is shutting down
            Employee empc = new Employee();
            empc.closeConnection();
            System.out.println("Database connection was closed");
        }));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logInButton;
    private javax.swing.JPasswordField logInPassword;
    private javax.swing.JComboBox<String> logInRole;
    private javax.swing.JTextField logInUserName;
    private javax.swing.JCheckBox showPWBox;
    // End of variables declaration//GEN-END:variables
}
