/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.windows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import tpfinal.tp.controller.ArbolController;
import tpfinal.tp.controller.MaterialCapacitacionController;
import tpfinal.tp.integrador.MaterialCapacitacion;

/**
 *
 * clase auxiliar para conectar el panel de buscar Arbol
 */
public class Contenedor extends JPanel{
    
    
   public Contenedor(MaterialCapacitacionController controller,MaterialCapacitacion materialE)
    {
         JFrame f = new JFrame();//ventana
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelBusquedaArbol panelBusqueda = new PanelBusquedaArbol(controller,materialE);
       // PanelAgregarAArbol panelAgregar= new PanelAgregarAArbol(controller,materialE);
        ArbolController arbolctrl= new ArbolController(panelBusqueda);
      // panelAgregar.setController(arbolctrl);
        panelBusqueda.setController(arbolctrl);
      //  f.add(panelAgregar);
        f.add(panelBusqueda);
        f.pack();
        f.setVisible(true);
}
   
}
