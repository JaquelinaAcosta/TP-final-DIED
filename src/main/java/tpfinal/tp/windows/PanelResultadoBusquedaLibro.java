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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import tpfinal.tp.controller.MaterialCapacitacionController;
import tpfinal.tp.excepcion.CreditoInsuficienteException;
import tpfinal.tp.guardarADisco.SuscriptoresDao;
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.integrador.Suscriptor;
import tpfinal.tp.ventanas.PanelBuscarLibro;

/**
 *
 * @author jaque
 */
public class PanelResultadoBusquedaLibro extends JPanel{
    
   private JButton botonActualizar;
    private JButton botonBorrar;
    private JButton botonAgregar;
    private JButton botonVolver;
    private JButton botonSalir;
    private JList listaLibros;
    private JList listSuscriptores;
    private List<? extends MaterialCapacitacion> listaMateriales;
    private tpfinal.tp.ventanas.Principal principal;
        private JButton botonBuscarArbol;
    private JButton botonCargarArbol;
    private SuscriptoresDao suscriptoresDao;
    MaterialCapacitacionController controller;

    public PanelResultadoBusquedaLibro(MaterialCapacitacionController controller){
        this.controller = controller;
        this.armarPanel();
    }
    
    public PanelResultadoBusquedaLibro(MaterialCapacitacionController controller, List<? extends MaterialCapacitacion> listaMateriales){
        this.controller = controller;
        this.listaMateriales = listaMateriales;
        this.armarPanel();
    }
   
    public void armarPanel(){
        suscriptoresDao = new SuscriptoresDao();
        List<Suscriptor> listaSuscriptores = new ArrayList<Suscriptor>();
        listaSuscriptores= suscriptoresDao.cargarLista();
                   
        this.botonBuscarArbol= new JButton("Buscar detalles de Material");
        this.botonCargarArbol= new JButton("Cargar datos en Material");
        this.botonActualizar= new JButton("Actualizar");
        this.botonSalir= new JButton("Salir");
        this.botonAgregar= new JButton("Agregar");
        this.botonVolver= new JButton("Volver a Principal");
        this.botonBorrar= new JButton("Borrar");
        this.listaLibros= new JList(listaMateriales.toArray(new MaterialCapacitacion[listaMateriales.size()]));
        this.listSuscriptores= new JList(listaSuscriptores.toArray(new Suscriptor[listaSuscriptores.size()]));
        
        JPanel panelLista = new JPanel();
        panelLista.setLayout(new FlowLayout()); 
        panelLista.add(new JLabel("LIBROS"));
        panelLista.add(listaLibros);
        panelLista.add(new JLabel("SUSCRIPTORES"));
        panelLista.add(listSuscriptores);
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout()); 
        panelBotones.add(botonAgregar);
        panelBotones.add(botonActualizar);
        panelBotones.add(botonBorrar);
        panelBotones.add(botonBuscarArbol);
        panelBotones.add(botonCargarArbol);
        panelBotones.add(botonVolver);
        panelBotones.add(botonSalir);               
        
        
        this.setLayout(new GridLayout(3,6, 10, 10));
        this.add(panelLista);
        this.add(panelBotones);
        
        
        
        this.botonBorrar.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                   controller.cambiarAPanelBorrar((MaterialCapacitacion) listaLibros.getSelectedValue());
               }
        });
        
        this.botonActualizar.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                   controller.actualizarDatos((MaterialCapacitacion) listaLibros.getSelectedValue());
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
        this.botonAgregar.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                   try{
                       Suscriptor suscriptorNuevo = (Suscriptor) listSuscriptores.getSelectedValue();
                        agregarSuscriptor((Libro) listaLibros.getSelectedValue(), suscriptorNuevo);
                        suscriptoresDao.editar((Suscriptor) listSuscriptores.getSelectedValue(),suscriptorNuevo);
                   } catch(CreditoInsuficienteException ex){
                       JOptionPane.showMessageDialog( null, ex.getMessage());
                   } 
               }
        });
        
        
        //Hay que hacer estas funciones que son de arbol
             this.botonCargarArbol.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                       controller.cambiarAPanelAgregarAArbol((MaterialCapacitacion) listaLibros.getSelectedValue());
                        //Llama al metodo que estan en la ventana principal, y realiza la accion correspondiente.
               }
        });
              this.botonBuscarArbol.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                       controller.cambiarPanelBusquedaArbol((MaterialCapacitacion) listaLibros.getSelectedValue());
                        //Llama al metodo que estan en la ventana principal, y realiza la accion correspondiente.
               }
        });
    }
    
    private void agregarSuscriptor(Libro libro, Suscriptor suscriptor) throws CreditoInsuficienteException{
        suscriptor.agregar(libro);
    }
     

}
