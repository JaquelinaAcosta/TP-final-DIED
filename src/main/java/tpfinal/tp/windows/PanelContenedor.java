/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.windows;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tpfinal.tp.controller.ArbolController;
import tpfinal.tp.controller.GrafoController;
import tpfinal.tp.controller.MaterialCapacitacionController;
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.integrador.Publicacion;
import tpfinal.tp.integrador.Video;

import tpfinal.tp.vista.ControlPanel;
import tpfinal.tp.vista.GrafoPanel;


public class PanelContenedor extends JPanel {
    private ArrayList<MaterialCapacitacion> listaMaterial;
    MaterialCapacitacionController controller;
    
    public PanelContenedor(MaterialCapacitacionController controller,ArrayList<MaterialCapacitacion> lista)
    {
//        JFrame f = new JFrame();//ventana
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ControlPanel panelCtrl = new ControlPanel(controller,lista);
        GrafoPanel panelGrf = new GrafoPanel();
        GrafoController gf = new GrafoController(panelGrf, panelCtrl);
        panelGrf.setController(gf);
        panelCtrl.setController(gf);
        this.setLayout(new BorderLayout());
        this.add(panelCtrl, BorderLayout.PAGE_START);
        this.add(panelGrf, BorderLayout.CENTER);

//        f.pack();
//        f.setVisible(true);
    }
    
    public PanelContenedor(MaterialCapacitacionController controller,MaterialCapacitacion materialE)
    {
         JFrame f = new JFrame();//ventana
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //  PanelBusquedaArbol panelBusqueda = new PanelBusquedaArbol(controller,materialE);
        PanelAgregarAArbol panelAgregar= new PanelAgregarAArbol(controller,materialE);
        ArbolController arbolctrl= new ArbolController(panelAgregar);
        panelAgregar.setController(arbolctrl);
       // panelBusqueda.setController(arbolctrl);
        f.add(panelAgregar);
      //  f.add(panelBusqueda);
        f.pack();
        f.setVisible(true);
    }
    
//     public PanelContenedor(MaterialCapacitacionController controller,Video materialE)
//    {
//         JFrame f = new JFrame();//ventana
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        PanelBusquedaArbol panelBusqueda = new PanelBusquedaArbol(controller,materialE);
//       // PanelAgregarAArbol panelAgregar= new PanelAgregarAArbol(controller,materialE);
//        ArbolController arbolctrl= new ArbolController(panelBusqueda);
//      // panelAgregar.setController(arbolctrl);
//        panelBusqueda.setController(arbolctrl);
//      //  f.add(panelAgregar);
//        f.add(panelBusqueda);
//        f.pack();
//        f.setVisible(true);
//    }
//    
//     public PanelContenedor(MaterialCapacitacionController controller,Publicacion materialE)
//    {
//         JFrame f = new JFrame();//ventana
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        PanelBusquedaArbol panelBusqueda = new PanelBusquedaArbol(controller,materialE);
//      //  PanelAgregarAArbol panelAgregar= new PanelAgregarAArbol(controller,materialE);
//        ArbolController arbolctrl= new ArbolController(panelBusqueda);
//     //   panelAgregar.setController(arbolctrl);
//        panelBusqueda.setController(arbolctrl);
//     //   f.add(panelAgregar);
//        f.add(panelBusqueda);
//        f.pack();
//        f.setVisible(true);
//    }
//    
//     public PanelContenedor(MaterialCapacitacionController controller,Libro materialE)
//    {
//         JFrame f = new JFrame();//ventana
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        PanelBusquedaArbol panelBusqueda = new PanelBusquedaArbol(controller,materialE);
//       // PanelAgregarAArbol panelAgregar= new PanelAgregarAArbol(controller,materialE);
//        ArbolController arbolctrl= new ArbolController(panelBusqueda);
//       // panelAgregar.setController(arbolctrl);
//        panelBusqueda.setController(arbolctrl);
//     //   f.add(panelAgregar);
//        f.add(panelBusqueda);
//        f.pack();
//        f.setVisible(true);
//    }
    
    
}
