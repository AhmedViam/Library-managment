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

// Make a class for calculation
public class Database extends Constants {

    static Object d;

 private String sql = "";
 private String identifier;
 private Connection con = null;
 private Statement stmt = null;
 private ResultSet result = null;
 private int res;
 private static String search = "";

 /**
  *
  */

 /**
  *
  * @param con
  * @param stmt
  * @param sql
  * @param result
  * @param identifier
  */
 public Database(Connection con, Statement stmt, String sql, ResultSet result, String identifier, String search) {
  Constants c = new Constants();

  this.JDBC_DRIVER = c.getJDBC_DRIVER();
  this.DB_URL = c.getJDB_URL();
  this.USER = c.getUSER();
  this.PASS = c.getPASS();
  this.con = con;
  this.stmt = stmt;
  this.sql = sql;
  this.result = result;
  this.identifier = identifier;
  this.search = search;
 }

 Database() {

 }
 public static void setSearch(String search){
     Database.search = search;
     
 }
 
 public static String getSearch(){
     return Database.search;   
 }

 public Connection databaseConnection() {
  try {
   this.con = DriverManager.getConnection(DB_URL, USER, PASS);
   return con;
  } catch (SQLException e) {}
  return null;
 }

 public Statement getStatement() {
  return stmt;
 }

 public void setStatement(Statement stmt) {
  this.stmt = stmt;
 }

 public String getQuery() {
  return sql;
 }

 public void setQuery(String sql) {
   this.sql = sql;
  }
  /*
  public  Statement createStatement(Connection con){
      this.stmt = createStatement(con);
      return this.stmt;
  }*/

 public void setResult(ResultSet result) {
  this.result = result;

 }
 public ResultSet getResultSet(Statement stmt) {
  try {
   this.result = stmt.executeQuery(this.sql);
   return this.result;
  } catch (SQLException ex) {
   Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
  }
  return null;
 }

 public int getResultSetUpdate(Statement stmt) {
  try {
   res = stmt.executeUpdate(this.sql);
   return res;
  } catch (SQLException ex) {
   Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
  }
  return 0;
 }



 public String getdata(String identifier) {
  try {
   return this.result.getString(identifier);
  } catch (SQLException ex) {
   Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
  }
  return null;
 }

 public String setdata(String identifier) {
  try {
   return this.result.getString(identifier);
  } catch (SQLException ex) {
   Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
  }
  return null;
 }
}