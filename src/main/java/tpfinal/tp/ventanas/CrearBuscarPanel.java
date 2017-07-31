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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CrearBuscarPanel extends JPanel{
    
    private JFrame ventana;
    private JPanel cbPanel;
    private Principal principal;
    private CrearBuscarPanel buscarCrear;
    private JButton botonVolver;

    private JButton botonCrear;
    private JButton botonBuscar;


    public CrearBuscarPanel(){
        this.armarPanel();
    }
    
    public CrearBuscarPanel(Principal principal){
        this.principal= principal;
        this.armarPanel();
    }
    
    public CrearBuscarPanel(CrearBuscarPanel crearBuscarPanel){
        this.buscarCrear = crearBuscarPanel;
        this.armarPanel();
    }
   
    private void armarPanel(){
        this.botonCrear= new JButton("Crear");
        this.botonBuscar= new JButton("Buscar");
        this.botonVolver= new JButton("Volver a Principal");
        
        this.setLayout(new GridLayout(6,0, 10, 10));
        this.add(new JLabel("Elegir opción"));
        this.add(botonCrear);
        this.add(botonBuscar);
        this.add(botonVolver);

        this.botonCrear.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                   principal.cambiarAPanelCrear();
               }
        });
        
        this.botonBuscar.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                   principal.cambiarAPanelBuscar();
               }
        });
        this.botonVolver.addActionListener(new ActionListener(){
              @Override
                 public void actionPerformed (ActionEvent e){
                         principal.principal();
            }
    });
        
        
    }
    
     
//public static void main(String[] args) {
//    javax.swing.SwingUtilities.invokeLater(new Runnable() {
//        public void run() {
//            CrearBuscarPanel cbpanel = new CrearBuscarPanel();
//            cbpanel.createAndShowGUI();
//        }
//    });
//}
void createAndShowGUI() {
        ventana = new JFrame("Biblioteca");
        ventana.setSize(600, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cbPanel = new CrearBuscarPanel(this);
        cbPanel.setSize(300, 200);
        ventana.add(cbPanel);

        ventana.add(cbPanel, BorderLayout.PAGE_START);

        ventana.pack();
        ventana.setVisible(true);
    }

public void cambiarAPanelBuscar() {
        this.ventana.remove(this.cbPanel);
        cbPanel = new PanelLibro();
        cbPanel.setSize(300, 200);
        ventana.add(cbPanel);

        ventana.add(cbPanel, BorderLayout.PAGE_START);

        ventana.pack();
    }
}
