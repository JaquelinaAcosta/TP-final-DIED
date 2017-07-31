/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.lllll
 */
package tpfinal.tp.ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import tpfinal.tp.controller.GrafoController;
import tpfinal.tp.excepcion.CreditoInsuficienteException;
import tpfinal.tp.guardarADisco.LibrosDao;
import tpfinal.tp.guardarADisco.SuscriptoresDao;
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.integrador.Suscriptor;
import tpfinal.tp.vista.ControlPanel;
import tpfinal.tp.vista.GrafoPanel;


public class PanelBuscarLibro extends JPanel{
    
   private JButton botonActualizar;
    private JButton botonBorrar;
    private JButton botonAgregar;
    private JButton botonVolver;
    private JButton botonSalir;
    private JList listaLibros;
    private JList listSuscriptores;
    private List<? extends MaterialCapacitacion> listaMateriales;
    private Principal principal;
    private SuscriptoresDao suscriptoresDao;

    public PanelBuscarLibro(){
        this.armarPanel();
    }
    
    public PanelBuscarLibro(Principal principal){
        this.principal= principal;
        this.armarPanel();
    }
    
    public PanelBuscarLibro(Principal principal, List<? extends MaterialCapacitacion> listaMateriales){
        this.principal = principal;
        this.listaMateriales = listaMateriales;
        this.armarPanel();
    }
   
    private void armarPanel(){
        suscriptoresDao = new SuscriptoresDao();
        List<Suscriptor> listaSuscriptores = new ArrayList<Suscriptor>();
        listaSuscriptores= suscriptoresDao.cargarLista();
                   
        
        this.botonActualizar= new JButton("Actualizar");
        this.botonSalir= new JButton("Salir");
        this.botonAgregar= new JButton("Agregar");
        this.botonVolver= new JButton("Volver a Principal");
        this.botonBorrar= new JButton("Borrar");
        this.listaLibros= new JList(listaMateriales.toArray(new MaterialCapacitacion[listaMateriales.size()]));
        this.listSuscriptores= new JList(listaSuscriptores.toArray(new Suscriptor[listaSuscriptores.size()]));
        
        
        
        this.setLayout(new GridLayout(3,6, 10, 10));
        this.add(new JLabel("LIBROS"));
        this.add(new JLabel(" "));
        this.add(new JLabel("SUSCRIPTORES"));
        this.add(new JLabel(" "));
        this.add(new JLabel(" "));
        this.add(listaLibros);
        this.add(new JLabel(" "));
        this.add(listSuscriptores);
        this.add(new JLabel(" "));
        this.add(new JLabel(" "));
        this.add(botonAgregar);
        this.add(botonActualizar);
        this.add(botonBorrar);
        this.add(botonVolver);
        this.add(botonSalir);
        
        
        this.botonBorrar.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                   principal.cambiarAPanelBorrar((MaterialCapacitacion) listaLibros.getSelectedValue());
               }
        });
        
        this.botonActualizar.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                   principal.actualizarDatos((MaterialCapacitacion) listaLibros.getSelectedValue());
               }
        });
           
        //Sale de todo
        this.botonSalir.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                   System.exit(0);
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
    }
    
    private void agregarSuscriptor(Libro libro, Suscriptor suscriptor) throws CreditoInsuficienteException{
        suscriptor.agregar(libro);
    }
     
private static void crearBuscarShowGUI(){
        JFrame ventana = new JFrame("Biblioteca");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelBuscarLibro blPanel = new PanelBuscarLibro();
        blPanel.setSize(300, 200);
        ventana.add(blPanel);
    
        ventana.add(blPanel, BorderLayout.PAGE_START);
        
        ventana.pack();
        ventana.setVisible(true);
}
public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          PanelBuscarLibro pBuscarLibro = new PanelBuscarLibro();
          pBuscarLibro.crearBuscarShowGUI();
        }
    });
}
    
}
