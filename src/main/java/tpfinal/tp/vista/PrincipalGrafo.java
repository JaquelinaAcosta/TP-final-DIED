/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.vista;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tpfinal.tp.controller.GrafoController;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.ventanas.Principal;


public class PrincipalGrafo extends JPanel {
    
    private Principal principal;
    private List<MaterialCapacitacion> listaRtdo;
    public PrincipalGrafo()
    {
        this.createAndShowGUI();
    }
    
    public PrincipalGrafo(Principal principal,List<MaterialCapacitacion> lista)
    {
        this.principal=principal;
        this.listaRtdo=lista;
        this.createAndShowGUI();
    }
//public static void main(String[] args) {
//    javax.swing.SwingUtilities.invokeLater(new Runnable() {
//        public void run() {
//          this.createAndShowGUI();
//        }
//    });
//}

 private  void createAndShowGUI() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ControlPanel panelCtrl = new ControlPanel();
        GrafoPanel panelGrf = new GrafoPanel(listaRtdo);
        GrafoController gf = new GrafoController(panelGrf, panelCtrl);
        panelGrf.setController(gf);
        panelCtrl.setController(gf);
        
        f.add(panelCtrl, BorderLayout.PAGE_START);
        f.add(panelGrf);

        f.pack();
        f.setVisible(true);
    }
}