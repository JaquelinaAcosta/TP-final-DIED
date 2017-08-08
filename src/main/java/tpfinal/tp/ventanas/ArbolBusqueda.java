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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tpfinal.tp.estructuraArbolNario.Node;
import tpfinal.tp.estructuraArbolNario.TipoNodo;
import tpfinal.tp.estructuraArbolNario.Tree;
import tpfinal.tp.guardarADisco.ArbolDao;
import tpfinal.tp.integrador.MaterialCapacitacion;


public class ArbolBusqueda extends JPanel{

    private JTextField txtDato;
    private JComboBox comboTipo;
    private Principal principal;
    private JButton botonBuscar;
    private MaterialCapacitacion material;
    private ArbolDao arbolDao;
    private List<Tree> lista = new ArrayList<Tree>();
    private List<Tree> listaResultado = new ArrayList<Tree>();
    private Node<TipoNodo> nodo;
    
    public ArbolBusqueda(){
        this.armarPanel();  
    }
    
     public ArbolBusqueda(Principal principal,Node<TipoNodo> n,List arbolCargado){
        this.principal = principal;
        this.material=material;
        this.nodo=n;
        this.lista=arbolCargado;
        this.armarPanel();
    }
    
    
    public ArbolBusqueda(Principal principal, MaterialCapacitacion material,List arbolCargado){
        this.principal = principal;
        this.material=material;
        this.lista=arbolCargado;
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
                   filtrarLista();
                              }
        });
     }
     
   public void filtrarLista()
   {
       for(int i=0;i<lista.size();i++)
       {
       lista.get(i).buscarDato(nodo,nodo.dato(),nodo.getData(), listaResultado);
   }
       
   }

private static void crearShowGUI(){
        JFrame ventana = new JFrame("Biblioteca");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ArbolBusqueda boPanel = new ArbolBusqueda();
        boPanel.setSize(300, 200);
        ventana.add(boPanel);
    
        ventana.add(boPanel, BorderLayout.PAGE_START);
        
        ventana.pack();
        ventana.setVisible(true);
}

public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          ArbolBusqueda pBuscar=new ArbolBusqueda();
          pBuscar.crearShowGUI();
        }
    });
}
}

