/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameXO;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class RegisterService 
{
    
    
    
    public static void submit(String name,String username,String password,String confirmPassword) {
        if(checkInput(name,username,password,confirmPassword)){
             Database.saveRegis( name, username,password,icon);
            show_message();
            Lobby(Database.getUser(username,password));

        }
    }
    
    
    
    public static boolean checkInput(String name,String username,String password,String confirmPassword) {
        if(Check_user_wrong(username)&&Check_complete_inform(name,username,password,confirmPassword)
                &&Check_password_wrong(password)&&Check_meet_condition(password,confirmPassword)){
            return true;
        }
            
        return false;
    }
    
    
    
    
    public static boolean Check_user_wrong(String username) {
        if(Database.getUser(username)!=null){
         JOptionPane.showMessageDialog(null, "username ซ้ำ");
         return false;
        }
         return true;
    }
    
    
    
    public static boolean Check_password_wrong(String password) {
        if(password.length()<8){
            JOptionPane.showMessageDialog(null, "password 8 ตัวอักษรขึ้นไป");
            return false;
        }
         return true;
    }
    
    
    
    public static boolean Check_meet_condition(String password,String confirmPassword) {
        if(!password.equals(confirmPassword)){
            JOptionPane.showMessageDialog(null, "password ไม่ตรงกัน");
        return false;
        }
         return true;
    }
    
    
    
    public static boolean Check_complete_inform(String name,String username,String password,String confirmPassword) {
        if(name.isEmpty()||password.isEmpty()||username.isEmpty()||confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ใส่ข้อมูลให้ครบ");
            return false;
        }
         return true;
    }
    
    
    
    public static void save_Regis(String name,String username,String password,int icon) {
        Database.saveRegis(name,username,password,icon);
            
    }
    
    
    
  public static void show_message() {
        JOptionPane.showMessageDialog(null, "success");
    }
    
    
    
    public static void Login(){  
        Login form = new Login();
        Display_Panel(form);
        
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
    
    
    static void setIcon(int num) {                                            
        icon=num;
    }                                          
    static int icon =0;
}
