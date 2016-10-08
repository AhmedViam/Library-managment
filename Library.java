/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.lang.System.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.sql.*;
import javax.swing.JFrame;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

/**
 *
 * @author Silfvro
 */
public class Library {

 /**
  * @param args the command line arguments
  */
    
    
   
 public static void main(String[] args) throws Exception {


















  try {

   BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
   org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
   UIManager.put("RootPane.setupButtonVisible", Boolean.FALSE);

   java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {

     LoginForm log = new LoginForm();
     // log.setUndecorated(true);


     // log.setOpacity((float) 0.95);
     log.setVisible(true);

     //log.setExtendedState(JFrame.MAXIMIZED_BOTH);
     //  log.setUndecorated(true);
     // log.setBackground(new Color(0,0,0,0));


    }
   });
  } catch (ClassNotFoundException ex) {
   Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
  } catch (UnsupportedLookAndFeelException ex) {
   Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
  }
 }
}