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
import javax.swing.JPanel;


public class PanelBorrar extends JPanel{
    
    private JButton botonSi;
    private JButton botonNo;
    
    public PanelBorrar(){
        this.armarPanel();
    }
    
    public void armarPanel(){
        this.botonSi = new JButton ("Si");
        this.botonNo = new JButton ("No");
        
        this.setLayout(new GridLayout (2, 1, 10, 10));
        this.add(new JLabel("¿Desea borrar el material?"));
        this.add(new JLabel(" "));
        this.add(botonSi);
        this.add(botonNo);
    }
    
    private static void crearBorrarShowGUI(){
        JFrame ventana = new JFrame("Biblioteca");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelBorrar borrarPanel = new PanelBorrar();
        borrarPanel.setSize(300, 200);
        ventana.add(borrarPanel);
    
        ventana.add(borrarPanel, BorderLayout.PAGE_START);
        
        ventana.pack();
        ventana.setVisible(true);
}
public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          PanelBorrar panelBorrar = new PanelBorrar();  
          panelBorrar.crearBorrarShowGUI();
          
        }
    });
    
}
}
