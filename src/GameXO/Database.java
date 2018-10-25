/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameXO;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author I3
 */

public class Database {
    static MongoClientURI uri ;
    static MongoClient mongo ;
    static DB db;
    static DBCollection user;
    static DBObject dockUser;
   
    
     public static void connect(){
        try {
            uri = new MongoClientURI("mongodb://dbboat:boat1234@ds245512.mlab.com:45512/dbxo");
            mongo = new MongoClient(uri);
            db = mongo.getDB(uri.getDatabase());
            user = db.getCollection("user");
            System.out.print("success");
        }catch (IOException ex) {

        }
    }
      public static DBObject getUser(String username){
          BasicDBObject searchQuery  = new BasicDBObject();
          searchQuery.put("username",username);
          dockUser = user.findOne(searchQuery);
          if(dockUser!=null){
              return dockUser;
          }return null;
      }
      public static Users getUser(String username,String pass){
          DBObject dockUser = getUser(username);
          if(dockUser!=null){
          if(dockUser.get("password").equals(pass)){
              updateStatus(username,"online");
              Users user = new Users((String)dockUser.get("name"),(String)dockUser.get("username")
                      ,(String)dockUser.get("password"),(int)dockUser.get("score_win")
                      ,(int)dockUser.get("score_lose"),(int)dockUser.get("score_draw")
                      ,(String)dockUser.get("status"),(int)dockUser.get("icon"));
              return user;
          }
          }
          return null;
      }
      
      public static ArrayList<Users> getAll(){
           DBCursor cursor = user.find();
           ArrayList<Users> userList = new ArrayList<Users>();
            while(cursor.hasNext()) {
                DBObject dockUser = cursor.next();
                userList.add(new Users((String)dockUser.get("name"),(String)dockUser.get("username")
                      ,(String)dockUser.get("password"),(int)dockUser.get("score_win")
                      ,(int)dockUser.get("score_lose"),(int)dockUser.get("score_draw")
                      ,(String)dockUser.get("status"),(int)dockUser.get("icon")));
                }
                return userList;              
        }
      
      public static void updateStatus(String username,String status){
            BasicDBObject  searchUser = new BasicDBObject();
            searchUser.put("username",username);
            BasicDBObject setUpdate = new BasicDBObject();
            BasicDBObject statusUser = new BasicDBObject();
            statusUser.put("status",status);
            setUpdate.put("$set",statusUser);
            user.update(searchUser, setUpdate); 
      }
      
      public static void saveRegis(String name,String username,String password,int icon) {
        BasicDBObject add = new BasicDBObject();
            add.put("name", name);
            add.put("username", username);
            add.put("password", password);
            add.put("score_win", 0);
            add.put("score_lose", 0);
            add.put("score_draw", 0);
            add.put("status", "offline");
            add.put("icon", icon);
            user.insert(add);           
          
    }
      
}
