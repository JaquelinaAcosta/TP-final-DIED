/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.windows;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          createAndShowGUI();
        }
    });
}

 private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+ SwingUtilities.isEventDispatchThread());
        JFrame f = new Principal();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //f.add();
        f.pack();
        f.setVisible(true);
    }
}
