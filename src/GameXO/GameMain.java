/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameXO;

import javax.swing.JFrame;

/**
 *
 * @author I3
 */

public class GameMain {
   public static JFrame frame;
    public static void main(String[] args) {
        frame = new JFrame();
        Database.connect();
        Login form = new Login();
        frame.setContentPane(form);
        frame.pack();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);        
        frame.setVisible(true);
        
    }
}
