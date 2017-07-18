/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import tpfinal.tp.controller.GrafoController;


public class Principal {
public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          createAndShowGUI();
        }
    });
}

 private static void createAndShowGUI() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ControlPanel panelCtrl = new ControlPanel();
        GrafoPanel panelGrf = new GrafoPanel();
        GrafoController gf = new GrafoController(panelGrf, panelCtrl);
        panelGrf.setController(gf);
        panelCtrl.setController(gf);
        
        f.add(panelCtrl, BorderLayout.PAGE_START);
        f.add(panelGrf);

        f.pack();
        f.setVisible(true);
    }
}

