/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jaque
 */
public class PanelBuscarOrdenar extends JPanel{
    
//    private GrafoController controller;
    private JButton botonBuscar;
    private JButton botonSalir;
    private JCheckBox boxTitulo;
    private JCheckBox boxTituloAlfabetico;
    private JCheckBox boxCalificacionOrden;
    private JCheckBox boxPrecioOrden;
    private JCheckBox boxCalificacion;
    private JCheckBox boxTema;
    private Principal principal;
    private PanelBuscarOrdenar buscarOrdenar;

    public PanelBuscarOrdenar(){
        this.armarPanel();
    }
    
    public PanelBuscarOrdenar (Principal principal){
        this.principal= principal;
        this.armarPanel();
    }
    
    public PanelBuscarOrdenar(PanelBuscarOrdenar buscarOrdenar){
        this.buscarOrdenar = buscarOrdenar;
        this.armarPanel();
    }
   
    private void armarPanel(){
        this.botonBuscar= new JButton("Buscar");
        this.botonSalir= new JButton("Salir");
        this.boxCalificacion= new JCheckBox();
        this.boxTituloAlfabetico=new JCheckBox();
        this.boxPrecioOrden=new JCheckBox();
        this.boxCalificacionOrden=new JCheckBox();
        this.boxTema=new JCheckBox();
        this.boxTitulo=new JCheckBox();
        
        
        
        this.setLayout(new GridLayout(5,3, 10, 10));
        this.add(new JLabel("BUSCAR"));
        this.add(new JLabel(" "));
        this.add(new JLabel("Ordenar por"));
        this.add(new JLabel(" "));
        this.add(new JLabel("Título"));
        this.add(boxTitulo);
        this.add(new JLabel("Titulo Alfabético"));
        this.add(boxTituloAlfabetico);
        this.add(new JLabel("Calificacion"));
        this.add(boxCalificacion);
        this.add(new JLabel("Calificacion"));
        this.add(boxCalificacionOrden);
        this.add(new JLabel("Tema"));
        this.add(boxTema);
        this.add(new JLabel("Precio"));
        this.add(boxPrecioOrden);
        this.add(new JLabel(" "));
        this.add(new JLabel(" "));
        this.add(botonBuscar);
        this.add(botonSalir);

       this.botonBuscar.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                   try {
                       principal.cambiarBuscarLibroVideoPublicacion();
                        //Llama al metodo que estan en la ventana principal, y realiza la accion correspondiente.
                   } catch (Exception ex) {
                       Logger.getLogger(PanelBuscarOrdenar.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
        });
       
       //Cierra la ventana
       this.botonSalir.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                   System.exit(0);
               }
        });

        
    }
    
     
private static void crearBuscarShowGUI(){
        JFrame ventana = new JFrame("Biblioteca");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelBuscarOrdenar boPanel = new PanelBuscarOrdenar();
        boPanel.setSize(300, 200);
        ventana.add(boPanel);
    
        ventana.add(boPanel, BorderLayout.PAGE_START);
        
        ventana.pack();
        ventana.setVisible(true);
}
//public static void main(String[] args) {
//    javax.swing.SwingUtilities.invokeLater(new Runnable() {
//        public void run() {
//           PanelBuscarOrdenar pBuscarOrdenar=new PanelBuscarOrdenar();
//          pBuscarOrdenar.crearBuscarShowGUI();
//        }
//    });
//}
    
    
}
