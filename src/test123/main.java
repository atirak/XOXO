/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test123;

import java.awt.Dimension;
import com.mongodb.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 *
 * @author I3
 */

public class main {
    static MongoClientURI uri ;
    static MongoClient mongo ;
    static DB db;
    static DBCollection user;
    static DBObject dockUser;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        login form = new login();
        frame.setContentPane(form);
        frame.pack();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500,500));        
        frame.setVisible(true);
        connect();

    }
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
    
}

