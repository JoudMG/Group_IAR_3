/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RandJLawFirm;

import RandJLawFirm.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.text.html.HTML.Attribute.ID;

public class addUser extends javax.swing.JFrame {

    /**
     * Creates new form addUser
     */
    public addUser() {
        Employee.AllEmployees();
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        forPass = new javax.swing.JTextField();
        forEmail = new javax.swing.JTextField();
        forID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ADD = new javax.swing.JButton();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/add user.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/add user.png"))); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/add user.png"))); // NOI18N
        jLabel4.setToolTipText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        forPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forPassActionPerformed(evt);
            }
        });
        jPanel1.add(forPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 372, 315, 50));

        forEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forEmailActionPerformed(evt);
            }
        });
        jPanel1.add(forEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 488, 315, 50));

        forID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forIDActionPerformed(evt);
            }
        });
        jPanel1.add(forID, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 260, 315, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/add user.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -23, -1, 740));

        ADD.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        ADD.setText("Add");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });
        jPanel1.add(ADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 610, 270, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void forPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forPassActionPerformed

    private void forEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forEmailActionPerformed

    private void forIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forIDActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed

        try {
            // To Setup add user array by store all previous Users information in text file if the array empty
            User.ReadInformations();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(addUser.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            if (forID.getText().isEmpty() || forPass.getText().isEmpty()
                    || forEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "You MUST fill All the feilds!!");
                throw new Exception("You MUST fill All the feilds!!");
            } else {
                Boolean isEmployee = Employee.isEmployeeID(forID.getText());
                if (!isEmployee) {// Check if Entered Id Exist in Employees Data
                    JOptionPane.showMessageDialog(null, "Invalid ID, No Employee ID Match The ID You Entered");
                } else if (User.isIDExist(forID.getText())){
                    JOptionPane.showMessageDialog(null, "User ID is Already Registered!");
                }else {
                    // Add new add user to the array and store User information on the file
                    User.RegisterUser(new User(forID.getText(), forPass.getText(), forEmail.getText()));
                    JOptionPane.showMessageDialog(null, "The user has been Added successfully");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }

    }//GEN-LAST:event_ADDActionPerformed

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
            java.util.logging.Logger.getLogger(addUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JTextField forEmail;
    private javax.swing.JTextField forID;
    private javax.swing.JTextField forPass;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
