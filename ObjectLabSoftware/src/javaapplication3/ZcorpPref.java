/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Morgan
 */
public class ZcorpPref extends javax.swing.JFrame {

    boolean errFree;
    private SQLMethods dba = new SQLMethods();

    public void ZcorpPrefStart() {
        initComponents();
                try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ZcorpPref.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        uncheckBoxes();
        hideEditErrorFields();
        ResultSet res = dba.searchPrinterSettings("zcorp");
        try {
            if (res.next()) {
                cubicCostTextField.setText(res.getString("materialCostPerUnit"));
            } else {
                cubicCostTextField.setText("0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ZcorpPref.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(true);
    }

    public void errorCheck() {
        try {
            float cubicPrice = Float.parseFloat(cubicCostTextField.getText());
            System.out.println(cubicPrice);
        } catch (Exception e) {
            if (cubicCheckBox.isSelected()) {
                errFree = false;
                cubicError.setText("*No price set");
                cubicError.setVisible(true);
            }
        }
    
    }

    public void getPrice() {
        float cubic = Float.parseFloat(cubicCostTextField.getText());
        if ((cubic != 0)) {
            //Update
            dba.updatePrinterSettings("Zcorp", "Cubic Inches", "cubic inches", cubic, "", "", 0, "", "", 0, "", "", 0, "", "", 0);
            System.out.println("Updated Price Settings");
        } else {
            //create new printer
            dba.insertPrinterSettings("Zcorp", "Cubic Inches", "cubic inches", cubic, "", "", 0, "", "", 0, "", "", 0, "", "", 0);
            System.out.println("Created New Price Settings");
        }
    }

    private void hideEditErrorFields() {
        cubicError.setVisible(false);
    }

    private void uncheckBoxes() {
        cubicCheckBox.setSelected(false);
        cubicCostTextField.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        cubicCheckBox = new javax.swing.JCheckBox();
        cubicCostTextField = new javax.swing.JTextField();
        cubicError = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Preferences");
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ZCorp Pricing Settings");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 320, 10));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel21.setText("Select price to change:");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 177, -1));

        cubicCheckBox.setText("Cost per cubic inch");
        cubicCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cubicCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(cubicCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        cubicCostTextField.setEditable(false);
        cubicCostTextField.setText("jTextField11");
        cubicCostTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cubicCostTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(cubicCostTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 80, -1));

        cubicError.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cubicError.setForeground(new java.awt.Color(255, 0, 0));
        cubicError.setText("Error Text");
        getContentPane().add(cubicError, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 120, 20));

        jButton5.setText("Confirm Changes");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 120, -1));

        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication3/black and white bg.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 370, 180));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cubicCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cubicCheckBoxActionPerformed
        if (cubicCheckBox.isSelected()) {
            cubicCostTextField.setEditable(true);
        } else {
            cubicCostTextField.setEditable(false);
        }
    }//GEN-LAST:event_cubicCheckBoxActionPerformed

    private void cubicCostTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cubicCostTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cubicCostTextFieldActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        errorCheck();
        if (errFree = true) {
            getPrice();
            dispose();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cubicCheckBox;
    private javax.swing.JTextField cubicCostTextField;
    private javax.swing.JLabel cubicError;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}