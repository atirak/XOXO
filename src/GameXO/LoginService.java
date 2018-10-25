/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameXO;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class LoginService 
{
    
    
    public static void login(String username,String password) {                                          
       Users users;
  
        if(username.equals("")||password.equals("")){
            JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลให้ครบถ้วน");
        }
        else{
            users=Database.getUser(username,password);
            if(users!=null){
                JOptionPane.showMessageDialog(null, "ล็อคอินสำเร็จ");
                Lobby(users);
                Database.updateStatus(username,"online");
            }else{
                JOptionPane.showMessageDialog(null, "username หรือ password ผิดพลาด");
            }
        }
    }
    
     public static void Display_Panel(JPanel panel){
        GameMain.frame.setContentPane(panel);
        GameMain.frame.pack();    
        GameMain.frame.setVisible(true);
        
    }
    
    
    public static void Lobby(Users users){  
        Lobby form = new Lobby();
        form.setLobby(users);
        Display_Panel(form);
        
    }
    
    public static boolean Vertify_Username(String username,String password,DBObject dockUser){
       
        if(is_Username_Exit(username,dockUser) && is_Password_Correct(password,dockUser)){
            return true;
        }
        return false;
    }
    
    
    
    public static boolean is_Username_Exit(String username,DBObject dockUser){
        
        if(dockUser != null){
            return true;
        }
        return false;
    }
    
    
    
    public static boolean is_Password_Correct(String password,DBObject dockUser){
        String passInDB = (String) dockUser.get("password");
        if(passInDB.equals(password)){
            return true;
        }
        return false;
    }
    
    public static void Regis(){  
        Register form = new Register();
        Display_Regis(form);
        
    }
    
    
    
    public static void Display_Regis(JPanel regis){
        GameMain.frame.setContentPane(regis);
        GameMain.frame.pack();    
        GameMain.frame.setVisible(true);
        
    }
    
}
