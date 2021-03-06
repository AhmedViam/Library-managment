/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import library.Database;



/**
 *
 * @author Silfvro
 */
public class DeleteAccount extends javax.swing.JFrame {




 /**
  * Creates new form DeleteAccount
  */
 public DeleteAccount() {
  initComponents();
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
   jLabel3 = new javax.swing.JLabel();
   delete_acc_name = new javax.swing.JTextField();
   jLabel2 = new javax.swing.JLabel();
   jButton1 = new javax.swing.JButton();

   setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

   jPanel1.setBackground(new java.awt.Color(42, 50, 50));

   jLabel3.setBackground(new java.awt.Color(0, 51, 51));
   jLabel3.setFont(new java.awt.Font("Browallia New", 2, 48)); // NOI18N
   jLabel3.setForeground(new java.awt.Color(0, 102, 102));
   jLabel3.setText("DELETE ACCOUNT");
   jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
   jLabel3.setOpaque(true);

   jLabel2.setForeground(new java.awt.Color(255, 255, 255));
   jLabel2.setText("Account Name");

   jButton1.setText("Submit");
   jButton1.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
     jButton1ActionPerformed(evt);
    }
   });

   javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
   jPanel1.setLayout(jPanel1Layout);
   jPanel1Layout.setHorizontalGroup(
    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(jPanel1Layout.createSequentialGroup()
     .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
       .addGap(18, 18, 18)
       .addComponent(jLabel2)
       .addGap(18, 18, 18)
       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jButton1)
        .addComponent(delete_acc_name, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
      .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
     .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
   );
   jPanel1Layout.setVerticalGroup(
    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(jPanel1Layout.createSequentialGroup()
     .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
     .addGap(26, 26, 26)
     .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
      .addComponent(delete_acc_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
      .addComponent(jLabel2))
     .addGap(27, 27, 27)
     .addComponent(jButton1)
     .addGap(0, 88, Short.MAX_VALUE))
   );

   javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
   getContentPane().setLayout(layout);
   layout.setHorizontalGroup(
    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(layout.createSequentialGroup()
     .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
     .addGap(0, 0, Short.MAX_VALUE))
   );
   layout.setVerticalGroup(
    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
   );

   pack();
  } // </editor-fold>//GEN-END:initComponents

 private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_jButton1ActionPerformed
   // TODO add your handling code here:
   if (delete_acc_name.getText().equals("")) {
    Constants c = new Constants();
    JOptionPane.showMessageDialog(null, c.getFieldError());
    return;
   }
   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


   Database db = new Database();
   db.databaseConnection();

   Connection conn = db.databaseConnection();
   Statement stmt = null;

   String username = delete_acc_name.getText();
   try {


    stmt = conn.createStatement();
    String sql;
    sql = "SELECT AccountName FROM user WHERE AccountName = '" + username + "';";


    db.setQuery(sql);
    db.getResultSet(stmt);
    ResultSet rs = stmt.executeQuery(sql);
    db.setResult(rs);

    if (db.getResultSet(stmt).next()) {
     String AccountName;
     AccountName = db.getdata("AccountName");
     if (AccountName.equals(username)) {
      System.out.println(AccountName + "\n" + username);
      JOptionPane.showMessageDialog(null, "Deleting user");
      stmt = conn.createStatement();
      sql = ("DELETE FROM user WHERE AccountName = '" + username + "';");
      JOptionPane.showMessageDialog(null, "Deleting " + username + "");
      db.setQuery(sql);
      db.getResultSetUpdate(stmt);
      return;
     }
    }
    JOptionPane.showMessageDialog(null, "Username not found in database");
    stmt.close();
    conn.close();

   } catch (SQLException se) {} catch (Exception e) {} finally {
    try {
     if (stmt != null)
      stmt.close();
    } catch (SQLException se2) {}
    try {
     if (conn != null)
      conn.close();
    } catch (SQLException se) {}
   }










  } //GEN-LAST:event_jButton1ActionPerformed

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
   for (javax.swing.UIManager.LookAndFeelInfo info: javax.swing.UIManager.getInstalledLookAndFeels()) {
    if ("Nimbus".equals(info.getName())) {
     javax.swing.UIManager.setLookAndFeel(info.getClassName());
     break;
    }
   }
  } catch (ClassNotFoundException ex) {
   java.util.logging.Logger.getLogger(DeleteAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(DeleteAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(DeleteAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(DeleteAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
  //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new DeleteAccount().setVisible(true);
   }
  });
 }

 // Variables declaration - do not modify//GEN-BEGIN:variables
 private javax.swing.JTextField delete_acc_name;
 private javax.swing.JButton jButton1;
 private javax.swing.JLabel jLabel2;
 private javax.swing.JLabel jLabel3;
 private javax.swing.JPanel jPanel1;
 // End of variables declaration//GEN-END:variables
}