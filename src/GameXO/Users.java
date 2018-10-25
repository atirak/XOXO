/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameXO;

public class Users {
    String name ;
    String username;
    String password;
    int score_win;
    int score_lose;
    int score_draw;
    String status;
    int icon ;

   
  
    
    
    Users(String name,String username,String password,int score_win,int score_lose,int score_draw,String status,int icon){
        this.name = name;
        this.username = username;
        this.password = password;
        this.score_win = score_win;
        this.score_lose = score_lose;
        this.score_draw = score_draw;
        this.status = status;
        this.icon = icon;
    }
}
