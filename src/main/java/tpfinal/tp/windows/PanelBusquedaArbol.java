/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.windows;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tpfinal.tp.controller.ArbolController;
import tpfinal.tp.controller.MaterialCapacitacionController;
import tpfinal.tp.estructuraArbolNario.Nodo;
import tpfinal.tp.estructuraArbolNario.TipoNodo;
import tpfinal.tp.estructuraArbolNario.ArbolNario;
import tpfinal.tp.guardarADisco.ArbolDao;
import tpfinal.tp.integrador.MaterialCapacitacion;


public class PanelBusquedaArbol extends JPanel{
    private JTextField txtDato;
    private JComboBox comboTipo;
    private MaterialCapacitacionController matController;
    private JButton botonBuscar;
    private MaterialCapacitacion material;
    private ArbolDao arbolDao;
    private List<ArbolNario> lista = new ArrayList<ArbolNario>();
    private ArbolController arbolControl;
    private Nodo<TipoNodo> nodoA;
    
    public PanelBusquedaArbol(){
        this.armarPanel();  
    }
   
    
    public PanelBusquedaArbol(MaterialCapacitacionController mat, MaterialCapacitacion material){
        this.matController = mat;
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
        
        botonBuscar.addActionListener(new ActionListener(){
               public void actionPerformed (ActionEvent e){
//                  try
//                  {
                      TipoNodo tipo= (TipoNodo) comboTipo.getSelectedItem();
                  System.out.println("este es el tipo "+tipo);
                  System.out.println("este es el txt "+txtDato.getText());
                  arbolControl.buscarNodo(txtDato.getText(),tipo);
               
                   
//                  }catch(Exception err){
//                      System.out.println("Error no puedo buscar nada");
//                  }
            }
        });
     }

   
     
 
    public ArbolController getController() {
        return arbolControl;
    }

    public void setController(ArbolController controller) {
        this.arbolControl = controller;
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
