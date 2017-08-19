/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import tpfinal.tp.controller.MaterialCapacitacionController;
import tpfinal.tp.integrador.MaterialCapacitacion;

/**
 *
 * @author jaque
 */
public class PanelResultadoBusquedaVP extends JPanel{

    private JButton botonActualizar;
    private JButton botonBorrar;
    private JButton botonSalir;
    private JButton botonVolver;
    private JList lista;
    private tpfinal.tp.ventanas.Principal principal;
    private JButton botonBuscarArbol;
    private JButton botonCargarArbol;
    private List<? extends MaterialCapacitacion> listaMateriales;
    MaterialCapacitacionController controller;

    public PanelResultadoBusquedaVP(){
        this.armarPanel();
    }
    
    public PanelResultadoBusquedaVP(MaterialCapacitacionController controller, List<? extends MaterialCapacitacion> listaMateriales){
        this.controller = controller;
        this.listaMateriales = listaMateriales;
        this.armarPanel();
    }
    
    public PanelResultadoBusquedaVP(MaterialCapacitacionController controller){
        this.controller = controller;
        this.armarPanel();
    }
   
    public void armarPanel(){
        this.botonActualizar= new JButton("Actualizar");
        this.botonSalir= new JButton("Salir");
        this.botonBorrar= new JButton("Borrar");
        this.botonVolver= new JButton("Volver a Principal");
        //Para pasar la lista (listaMateriales) resultado de filtrar busqueda de panel BuscarOdenar, 
        // y que salga en el JList (lista),
        this.lista= new JList(listaMateriales.toArray(new MaterialCapacitacion[listaMateriales.size()]));
        this.botonBuscarArbol= new JButton("Buscar detalles de Material");
        this.botonCargarArbol= new JButton("Cargar datos en Material");
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout()); 
        panelBotones.add(botonActualizar);
        panelBotones.add(botonBorrar);
        panelBotones.add(botonBuscarArbol);
        panelBotones.add(botonCargarArbol);
        panelBotones.add(botonVolver);
        panelBotones.add(botonSalir);
        
        this.setLayout(new GridLayout(3,1, 10, 10));
        this.add(new JLabel("LISTA"));
        this.add(lista);
        this.add(panelBotones);
        
      //  Para borrar un material de la lista..
        this.botonBorrar.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                   controller.cambiarAPanelBorrar((MaterialCapacitacion) lista.getSelectedValue());
               }
        });
        
        this.botonActualizar.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                   controller.actualizarDatos((MaterialCapacitacion) lista.getSelectedValue());
               }
        });
           
        //Sale de todo
        this.botonSalir.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                   System.exit(0);
               }
        });
        this.botonVolver.addActionListener(new ActionListener(){
              @Override
                 public void actionPerformed (ActionEvent e){
                         controller.principal();
            }
    });
        
        
        //falta hacer estos metodos que son de arbol
               this.botonCargarArbol.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                       principal.cambiarAPanelAgregarAArbol((MaterialCapacitacion) lista.getSelectedValue());
                        //Llama al metodo que estan en la ventana principal, y realiza la accion correspondiente.
               }
        });
              this.botonBuscarArbol.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                       principal.cambiarPanelBusquedaArbol((MaterialCapacitacion) lista.getSelectedValue());
                        //Llama al metodo que estan en la ventana principal, y realiza la accion correspondiente.
               }
        });

    }
    
     

    
}


