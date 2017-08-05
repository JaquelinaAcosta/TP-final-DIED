/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.ventanas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tpfinal.tp.controller.GrafoController;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.vista.ControlPanel;
import tpfinal.tp.vista.GrafoPanel;

/*Clase que se utiliza como la union del paquete de grafo con
*el panel principal
*/

    
public class PanelContenedor extends JPanel {
    private Principal principal;
    private ArrayList<MaterialCapacitacion> listaMaterial;
    
    public PanelContenedor(Principal principal,ArrayList<MaterialCapacitacion> lista)
    {
        JFrame f = new JFrame();//ventana
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ControlPanel panelCtrl = new ControlPanel(principal,lista);
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
