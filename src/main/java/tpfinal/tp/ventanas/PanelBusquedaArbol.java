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
 *Clase que se utiliza para el ingresar el contenido del material de capacitacion 
 * 
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
        
        //falta completar
        
   
    
//    //aca filtramos la lista que fue importada en Principal, en el metodo cambiarAPanelBuscar()
//   private void filtrar() throws MaterialNoEncontradoException{
//        if(boxTitulo.isSelected()){
//      
//            listaMateriales.removeIf(material -> ! material.getTitulo().equals(txtTitulo.getText()));
//        }
//        if(boxCalificacion.isSelected()){
//            listaMateriales.removeIf(material -> ! material.getCalificacion().equals((Integer) comboCalificacion.getSelectedItem()));
//        }
//        if(boxTema.isSelected()){
//            listaMateriales.removeIf(material -> ! material.getTema().equals((TemasMateriales) comboTema.getSelectedItem()));
//        }
//        
//        //Uso la clase Portal para ordenar la listaMateriales
//        portal = new Portal();
//        //Cargo la lista con los materiales para que la ordene
//        for(MaterialCapacitacion material: listaMateriales){
//            portal.agregar(material);
//        }
//        //en estos ordenas las listas con los metodos que estaban en portal, segun lo que elegimos en el checkBox
//        if(boxTituloAlfabetico.isSelected()){
//            listaMateriales = portal.ordenadaAlfabeticamente();
//        }
//        if(boxCalificacionOrden.isSelected()){
//            listaMateriales = portal.ordenadaPorCalificacionEditor();
//        }
//        if(boxPrecioOrden.isSelected()){
//            listaMateriales = portal.ordenadaPorPrecio();
//        }
//        if(listaMateriales.isEmpty()){
//            throw new MaterialNoEncontradoException();
//        }
        
       
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
