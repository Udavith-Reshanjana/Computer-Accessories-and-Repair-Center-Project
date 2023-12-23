/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package costproject_mspcaahc;

import javax.swing.JOptionPane;
import ProjectClasses.Employee;
import javax.swing.JFrame;

/**
 *
 * @author lenovo
 */
public class MainLoginUI extends javax.swing.JFrame {

    /**
     * Creates new form MainLoginUI
     */
    public MainLoginUI() {
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
        logInButton = new javax.swing.JButton();
        logInUserName = new javax.swing.JTextField();
        logInPassword = new javax.swing.JPasswordField();
        logInRole = new javax.swing.JComboBox<>();
        showPWBox = new javax.swing.JCheckBox();
        loginBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logInButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logInButton.setForeground(new java.awt.Color(0, 102, 255));
        logInButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-log-in-64.png"))); // NOI18N
        logInButton.setText("LOGIN");
        logInButton.setBorder(null);
        logInButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInButtonActionPerformed(evt);
            }
        });
        jPanel1.add(logInButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 170, 60));

        logInUserName.setPreferredSize(new java.awt.Dimension(229, 20));
        logInUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInUserNameActionPerformed(evt);
            }
        });
        jPanel1.add(logInUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 222, 240, 30));
        jPanel1.add(logInPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 240, 30));

        logInRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Receptionalist", "Technician" }));
        jPanel1.add(logInRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 240, 20));

        showPWBox.setText("Show password");
        showPWBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPWBoxActionPerformed(evt);
            }
        });
        jPanel1.add(showPWBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, -1, -1));

        loginBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.gif"))); // NOI18N
        jPanel1.add(loginBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 420));

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
                        MainDashboard db1 = new MainDashboard();
                        db1.setVisible(true);
                        this.setVisible(false);
                    }
                    else if (getRole.equalsIgnoreCase("Receptionalist")) {
                        JOptionPane.showMessageDialog(null, "Login successful !!!");
                        EmpDashboard empDashboard = new EmpDashboard();
                        empDashboard.setVisible(true);
                        this.setVisible(false);
                    }
                    else if (getRole.equalsIgnoreCase("Technician")) {
                        JOptionPane.showMessageDialog(null, "Login successful !!!");
                        TecRepairUI tecRepairUI = new TecRepairUI();
                        tecRepairUI.setVisible(true);
                        this.setVisible(false);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Wrong role, username, or password !!!", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
            finally{
                System.out.println("");
            }
        }
    }//GEN-LAST:event_logInButtonActionPerformed

    private void logInUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logInUserNameActionPerformed

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
            java.util.logging.Logger.getLogger(MainLoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainLoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainLoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainLoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainLoginUI().setVisible(true);
            }
        });
        // Add a shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // This code will be executed when the JVM is shutting down
            Employee employee = new Employee();
            employee.closeConnection();
            System.out.println("Database connection was closed");
        }));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logInButton;
    private javax.swing.JPasswordField logInPassword;
    private javax.swing.JComboBox<String> logInRole;
    private javax.swing.JTextField logInUserName;
    private javax.swing.JLabel loginBackground;
    private javax.swing.JCheckBox showPWBox;
    // End of variables declaration//GEN-END:variables
}