/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

// Make a class for calculation
public class ReportDB extends Database {


 public String doAmount(String sql) {
  Database db = new Database();
  db.databaseConnection();

  Connection conn = db.databaseConnection();
  Statement stmt = null;
  try {
   stmt = conn.createStatement();
   db.setQuery(sql);
   db.getResultSet(stmt);
   ResultSet rs = stmt.executeQuery(sql);
   db.setResult(rs);
   if (db.getResultSet(stmt).next()) {
    String num = (db.getdata("Total"));
    return num;

   }
  } catch (SQLException se) {

  }
  return null;
 }


 public String doName(String sql) {
  Database db = new Database();
  db.databaseConnection();

  Connection conn = db.databaseConnection();
  Statement stmt = null;
  try {
   stmt = conn.createStatement();
   db.setQuery(sql);
   db.getResultSet(stmt);
   ResultSet rs = stmt.executeQuery(sql);
   db.setResult(rs);
   if (db.getResultSet(stmt).next()) {
    String num = (db.getdata("AccountName"));
    return num;

   }
  } catch (SQLException se) {

  }
  return null;
 }

}