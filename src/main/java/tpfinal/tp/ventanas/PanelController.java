/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.ventanas;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tpfinal.tp.integrador.MaterialCapacitacion;


public class PanelController extends JPanel{
    private Principal principal;
    private PanelGrafo panelGrafo;
    private PanelControlGrafo controlGrafo;
    private List<MaterialCapacitacion> listaRtdo;
    
    public PanelController(Principal principal,List<MaterialCapacitacion> lista)
    {
    this.principal= principal;
    this.listaRtdo=lista;
    createAndShowGUI();
       
    }
     public PanelController(Principal principal,PanelGrafo panelG,PanelControlGrafo control,List<MaterialCapacitacion> lista)
    {
    this.controlGrafo=control;
    this.principal=principal;
    this.panelGrafo=panelG;
    this.listaRtdo=lista;
    }
 

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
        PanelControlGrafo panelCtrl = new PanelControlGrafo();
        PanelGrafo panelGrf = new PanelGrafo();
        f.add(panelCtrl, BorderLayout.PAGE_START);
        f.add(panelGrf);
        f.pack();
        f.setVisible(true);
    }
}
