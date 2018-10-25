/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameXO;


import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class LobbyService 
{
    
    
    
    
    public static void logout(String username){
        Database.updateStatus(username, "offline");
        Login form = new Login();
        GameMain.frame.setContentPane(form);
        GameMain.frame.pack();       
        GameMain.frame.setVisible(true);
    }
    


 public static void gotoRanking(){
//        rankForm rank = new rankForm();
//        frame.setContentPane(rank.mainPanel);
    }

     public static void gotoEdit(){
//        editForm edit = new editForm();
//        frame.setContentPane(edit.mainPanel);
    }

     public static void gotoLogin(){
//        loginForm login = new loginForm();
//        frame.setContentPane(login.mainPanel);

    }

    public static void gotoRules(){
//        rulesForm rules = new rulesForm();
//        frame.setContentPane(rules.mainPanel);
    }

    public static void letMatching(){

        showMessageMatching();
    }

     public static void letInvite(String name){

        showMessageWaitAccept(name);
    }

     public static void gotoGame(){
//        gameForm game = new gameForm();
//        frame.setContentPane(game.mainPanel);

    }
    
    
    
     public static void showMessageMatching(){
        JOptionPane.showMessageDialog(null, "Matching...");
        if(JOptionPane.CANCEL_OPTION==2){

        }
    }
    
    
    
     public static void showMessageWaitAccept(String name){
        JOptionPane.showMessageDialog(null, "Waiting..."+name);
        if(JOptionPane.CANCEL_OPTION==2){

        }
    }
    
    
    
     public static void showMessageBusy(){
        JOptionPane.showMessageDialog(null, "Your friend is busy");
    }
    
    
    
     public static void showMessageInvite(){
        JOptionPane.showMessageDialog(null, "Someone invite you");
        if(JOptionPane.YES_OPTION==0){
            gotoGame();
        }
    }
    
    
    
     public static void updateIsMatching(){

    }

     public static void updeteIsMatched(){

    }

     public static void updateIsDefault(){

    }

     public static void updateIsInviting(){

    }

     public static void matchStatus(){

    }

    public static void checkStatus(){

    }

     public static void checkAccept(){

    }
    
}
