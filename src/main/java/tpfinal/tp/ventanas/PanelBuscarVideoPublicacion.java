/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;


public class PanelBuscarVideoPublicacion extends JPanel{
    
//    private GrafoController controller;
    private JButton botonActualizar;
    private JButton botonBorrar;
    private JButton botonSalir;
    private JList lista;
    private Principal principal;

    public PanelBuscarVideoPublicacion(){
        this.armarPanel();
    }
    
    public PanelBuscarVideoPublicacion(Principal principal){
        this.principal= principal;
        this.armarPanel();
    }
   
    private void armarPanel(){
        this.botonActualizar= new JButton("Actualizar");
        this.botonSalir= new JButton("Salir");
        this.botonBorrar= new JButton("Borrar");
        this.lista= new JList();
        
        this.setLayout(new GridLayout(2,3, 10, 10));
        this.add(new JLabel("LISTA"));
        this.add(lista);
        this.add(new JLabel(" "));
        this.add(botonActualizar);
        this.add(botonBorrar);
        this.add(botonSalir);
    }
    
     
private static void crearBuscarShowGUI(){
        JFrame ventana = new JFrame("Biblioteca");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelBuscarVideoPublicacion bvpPanel = new PanelBuscarVideoPublicacion();
        bvpPanel.setSize(300, 200);
        ventana.add(bvpPanel);
    
        ventana.add(bvpPanel, BorderLayout.PAGE_START);
        
        ventana.pack();
        ventana.setVisible(true);
}
//public static void main(String[] args) {
//    javax.swing.SwingUtilities.invokeLater(new Runnable() {
//        public void run() {
//           PanelBuscarVideoPublicacion pbVideoPublicacion=new PanelBuscarVideoPublicacion();
//          pbVideoPublicacion.crearBuscarShowGUI();
//        }
//    });
//}
    
}
