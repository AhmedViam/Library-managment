package library;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Silfvro
 */
public class Constants {

 public String JDBC_DRIVER = "com.mysql.jdbc.Driver";
 public String DB_URL = "jdbc:mysql://127.0.0.1:3306/Library?autoReconnect=true&useSSL=false";
 public String USER = "root";
 public String PASS = "";
 public String emptyField = "One or more fields are empty";


 public String getJDBC_DRIVER() {
  return this.JDBC_DRIVER;
 }

 public String getJDB_URL() {
  return this.DB_URL;
 }

 public String getUSER() {
  return this.USER;
 }

 public String getPASS() {
  return this.PASS;
 }


 public void setJDBC_DRIVER(String JDBC_DRIVER) {
  this.JDBC_DRIVER = JDBC_DRIVER;
 }

 public void setJDB_URL(String DB_URL) {
  this.DB_URL = DB_URL;
 }

 public void setUSER(String USER) {
  this.USER = USER;
 }

 public void setPASS(String PASS) {
  this.PASS = PASS;
 }



 public String getFieldError() {
  return emptyField;
 }
}