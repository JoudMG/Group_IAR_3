/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RandJLawFirm;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class ModifyTransaction extends javax.swing.JFrame {

    File CaseFile;
    int index =-1;
    private String filename;
    private File caseDoc;

    public void TableContent() throws FileNotFoundException {

        // Set Table Rows and Columns Sizes
        jTable1.setRowHeight(20);
        TableColumnModel columnModel = jTable1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(40);
        columnModel.getColumn(3).setPreferredWidth(10);

        // declare table variable to start fill the table with Transaction information
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        // clear table from any values 
        model.setRowCount(0);
        // fill Transaction arraylist
        Transaction.ReadTranInformations();
        // insert Transaction information into the table 
        for (int i = 0; i < Transaction.getTransactions().size(); i++) {
            Vector row = new Vector();

            row.add(Transaction.getTransactions().get(i).getCaseNumber());
            row.add(Transaction.getTransactions().get(i).getCaseTitle());
            CaseFile = new File(Transaction.getTransactions().get(i).getCaseDoc());
            row.add(CaseFile.getName());
            row.add(Transaction.getTransactions().get(i).getStatus());

            model.addRow(row);
        }
    }

    public ModifyTransaction() throws FileNotFoundException {
        initComponents();
        TableContent();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        caseNum = new javax.swing.JTextField();
        caseTitle = new javax.swing.JTextField();
        Status = new javax.swing.JTextField();
        ClientInfo = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        CaseDoc = new javax.swing.JTextField();
        Interface = new javax.swing.JLabel();
        ModifyTrans = new javax.swing.JButton();
        OpenFile = new javax.swing.JButton();
        ReplaceFile = new javax.swing.JButton();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        caseNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        caseNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caseNumActionPerformed(evt);
            }
        });
        getContentPane().add(caseNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 200, 41));

        caseTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(caseTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 520, 200, 41));

        Status.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 519, 200, 41));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "           Case number", "           Case title", "Case Document", "            Statu"
            }
        ));
        jTable1.setFillsViewportHeight(true);
        jTable1.setRowHeight(18);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable1InputMethodTextChanged(evt);
            }
        });
        ClientInfo.setViewportView(jTable1);

        getContentPane().add(ClientInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 206, 810, 230));

        CaseDoc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CaseDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaseDocActionPerformed(evt);
            }
        });
        getContentPane().add(CaseDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 200, 41));

        Interface.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/ModifyTransaction.png"))); // NOI18N
        Interface.setText("jLabel1");
        getContentPane().add(Interface, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, -1));

        ModifyTrans.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ModifyTrans.setText("Modify");
        ModifyTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyTransActionPerformed(evt);
            }
        });
        getContentPane().add(ModifyTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 620, 150, 50));

        OpenFile.setBackground(new java.awt.Color(204, 204, 204));
        OpenFile.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        OpenFile.setText("Open Document");
        OpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFileActionPerformed(evt);
            }
        });
        getContentPane().add(OpenFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 600, 190, 40));

        ReplaceFile.setBackground(new java.awt.Color(204, 204, 204));
        ReplaceFile.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ReplaceFile.setText("Replace Document");
        ReplaceFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplaceFileActionPerformed(evt);
            }
        });
        getContentPane().add(ReplaceFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 600, 180, 40));

        back.setText("jLabel2");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 40, 60, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void caseNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caseNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caseNumActionPerformed

    private void ModifyTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyTransActionPerformed

        try {
            int TransactionAttributes = 4;
            boolean changeFound = false;// to print massage to user 
            if (index == -1) {
                JOptionPane.showConfirmDialog(null,
                        "You Did Not Select Transaction to Modify",
                        "Select Transaction", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);

            } else {
                if (!caseNum.getText().equals(Transaction.getTransactions().get(index).getCaseNumber())) {

                    // The method will only overwrite on previous value on the file
                    Transaction.ModifyTransaction(("TransactionFile.txt"),
                            (index * TransactionAttributes) + 1, caseNum.getText());
                    // modify on arraylist
                    Transaction.getTransactions().get(index).setCaseNumber(caseNum.getText());
                    changeFound = true;

                }
                if (!caseTitle.getText().equals(Transaction.getTransactions().get(index).getCaseTitle())) {

                    Transaction.ModifyTransaction(("TransactionFile.txt"),
                            (index * TransactionAttributes) + 2, caseTitle.getText());

                    Transaction.getTransactions().get(index).setCaseTitle(caseTitle.getText());
                    changeFound = true;
                }
                if (!Status.getText().equals(Transaction.getTransactions().get(index).getStatus())) {

                    Transaction.ModifyTransaction(("TransactionFile.txt"),
                            (index * TransactionAttributes) + 4, Status.getText());

                    Transaction.getTransactions().get(index).setStatus(Status.getText());
                    changeFound = true;
                }
                if (!("Transactions\\" + CaseDoc.getText()).equals(Transaction.getTransactions().get(index).getCaseDoc())) {

                    Transaction.ModifyTransaction(("TransactionFile.txt"),
                            (index * TransactionAttributes) + 3, "Transactions\\" + caseDoc.getName());

                    Transaction.getTransactions().get(index).setCaseDoc("Transactions\\" + caseDoc.getName());
                    changeFound = true;
                }
                if (changeFound) {

                    JOptionPane.showMessageDialog(null, "Transaction Information has been Modified successfully");
                    TableContent();// to update table with changes

                }
                if (!changeFound) {
                    JOptionPane.showMessageDialog(null, "You did not commit any modifications");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ModifyTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_ModifyTransActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        index = jTable1.getSelectedRow();
        TableModel tableModel = jTable1.getModel();
        // ----------------------------------------------------------------
        // STEP 2 : show selected row on the text fields to user to modify 
        caseNum.setText(Transaction.getTransactions().get(index).getCaseNumber());
        caseTitle.setText(Transaction.getTransactions().get(index).getCaseTitle());
        CaseFile = new File(Transaction.getTransactions().get(index).getCaseDoc());
        CaseDoc.setText(CaseFile.getName());
        Status.setText(Transaction.getTransactions().get(index).getStatus());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable1InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1InputMethodTextChanged

    private void OpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileActionPerformed

        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(CaseFile);
        } catch (IOException ex) {
        }

    }//GEN-LAST:event_OpenFileActionPerformed

    private void ReplaceFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReplaceFileActionPerformed
        filename = FileChooser.pickAFile();
        caseDoc = new File(filename);
        File currentDirFile = new File("Transactions\\" + caseDoc.getName());
        try {
            Files.copy(caseDoc.toPath(), currentDirFile.toPath(), REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(ModifyTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ReplaceFileActionPerformed

    private void CaseDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaseDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CaseDocActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        new HomePage().setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_backMouseClicked

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
            java.util.logging.Logger.getLogger(ModifyTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ModifyTransaction().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ModifyTransaction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CaseDoc;
    private javax.swing.JScrollPane ClientInfo;
    private javax.swing.JLabel Interface;
    private javax.swing.JButton ModifyTrans;
    private javax.swing.JButton OpenFile;
    private javax.swing.JButton ReplaceFile;
    private javax.swing.JTextField Status;
    private javax.swing.JLabel back;
    private javax.swing.JTextField caseNum;
    private javax.swing.JTextField caseTitle;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
