/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tpfinal.tp.estructuraArbolNario.TipoNodo;
import tpfinal.tp.integrador.MaterialCapacitacion;

/**
 *
 * @author jaque
 */
public class PanelBusquedaArbol extends JPanel{
    private JTextField txtDato;
    private JComboBox comboTipo;
    private Principal principal;
    private JButton botonBuscar;
    private MaterialCapacitacion material;
    
    
    public PanelBusquedaArbol(){
        this.armarPanel();  
    }
    
    public PanelBusquedaArbol(Principal principal, MaterialCapacitacion material){
        this.principal = principal;
        this.material=material;
        this.armarPanel();
    }
    
     private void armarPanel(){
         TipoNodo[] listaTipo = {TipoNodo.AUTOR, TipoNodo.CAPITULO, TipoNodo.EDITORIAL, TipoNodo.FECHA_PUBLICACON, TipoNodo.METADATO, TipoNodo.PALABRA_CLAVE, TipoNodo.PARRAFO, TipoNodo.RESUMEN, TipoNodo.SECCION, TipoNodo.TITULO};
        this.comboTipo= new JComboBox<>(listaTipo);
        this.txtDato = new JTextField(10);
        this.botonBuscar= new JButton("Buscar");
        
        
        this.setLayout(new GridLayout(4,2, 10, 10));
        this.add(new JLabel("BUSCAR"));
        this.add(new JLabel("Realizar busqueda por texto o selección"));
        this.add(new JLabel("Ingrese busqueda"));
        this.add(txtDato);
        this.add(new JLabel("Seleccionar"));
        this.add(comboTipo);
        this.add(botonBuscar);
     }
    

private static void crearShowGUI(){
        JFrame ventana = new JFrame("Biblioteca");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelBusquedaArbol boPanel = new PanelBusquedaArbol();
        boPanel.setSize(300, 200);
        ventana.add(boPanel);
    
        ventana.add(boPanel, BorderLayout.PAGE_START);
        
        ventana.pack();
        ventana.setVisible(true);
}

public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
           PanelBusquedaArbol pBuscar=new PanelBusquedaArbol();
          pBuscar.crearShowGUI();
        }
    });
}
}
