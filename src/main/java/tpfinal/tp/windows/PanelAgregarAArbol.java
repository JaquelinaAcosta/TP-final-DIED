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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tpfinal.tp.controller.ArbolController;
import tpfinal.tp.controller.MaterialCapacitacionController;
import tpfinal.tp.estructuraArbolNario.TipoNodo;
import tpfinal.tp.integrador.MaterialCapacitacion;


public class PanelAgregarAArbol extends JPanel{
    private JTextField txtDato;
    private JComboBox comboSubRaiz;
    private JComboBox comboHMetadatos;
    private JComboBox comboHijoResumen;
    private JComboBox comboHCapitulos;
    private JComboBox comboHijoSecciones;
    private JComboBox comboHijoMetadatos;
    private JComboBox comboArbol;
    
    private MaterialCapacitacionController matController;
    private JButton botonAceptar;
    private MaterialCapacitacion material;
    private JTextField textAutor;
    private JTextField txtMaterialBuscado;
    private JTextField txtCapitulo;
    private TipoNodo tipoNodo;
    
    
   private ArbolController arbolControl;
    private JButton botonAgregarCap;
    private JTextField txtResumen;
     private JTextField txtMetadatos;
    private JButton botonAgregarResumen;
    private JButton botonAgregarMetadatos;
    private JButton botonAgregarArbol;
    private JComboBox<TipoNodo> comboSubRaiz1;
    private JComboBox<TipoNodo> comboSubRaiz2;
    private JTextField txtComboResumen;
    private JTextField txtComboCapitulo;
    private JTextField txtComboMetadato;
    private JTextField txtComboHijoMetadato;
    private JButton botonAgregarHijoResumen;
    private JButton botonAgregarHijoMetadato;
    private JTextField txtHijoSecciones;
    private JButton botonAgregarHijoSeciones;
    
    public PanelAgregarAArbol(MaterialCapacitacionController control, MaterialCapacitacion materialR){
        this.matController = control;
        this.material=materialR;
        System.out.println("este material recibi"+material);
        this.armarPanel();
    }
        public PanelAgregarAArbol(MaterialCapacitacion materialR){
        this.material=materialR;
        System.out.println("este material recibi"+material);
        this.armarPanel();
    }
    
    public PanelAgregarAArbol(){
        this.armarPanel();
    }
    
     private void armarPanel(){
         txtMaterialBuscado= new JTextField(20);
        //datos Hijos del Nodo Raiz
         TipoNodo[] listaSubHRaiz = {TipoNodo.CAPITULO};
         TipoNodo[] listaSubHRaiz1 = {TipoNodo.METADATO};
         TipoNodo[] listaSubHRaiz2 = {TipoNodo.RESUMEN};
        this.comboSubRaiz= new JComboBox<>(listaSubHRaiz);
        this.comboSubRaiz1= new JComboBox<>(listaSubHRaiz1);
        this.comboSubRaiz2= new JComboBox<>(listaSubHRaiz2);
        this.txtCapitulo= new JTextField(20);
        this.txtResumen= new JTextField(20);
        this.txtMetadatos= new JTextField(20);
        this.txtMetadatos.setEditable(false);
        this.txtComboCapitulo= new JTextField(20);
        this.txtComboResumen= new JTextField(20);
        this.txtComboMetadato= new JTextField(20);
        this.txtComboHijoMetadato= new JTextField(20);
        //datos de los hijos de los hijos
        TipoNodo[] listaHResumen = {TipoNodo.PARRAFO};
        this.comboHijoResumen= new JComboBox<>(listaHResumen);
       
        TipoNodo[] listaHSecciones = {TipoNodo.SECCION, TipoNodo.PARRAFO,TipoNodo.METADATO};
        this.comboHijoSecciones= new JComboBox<>(listaHSecciones);
        TipoNodo[] listaHCapMetadatos = { TipoNodo.PALABRA_CLAVE, TipoNodo.EJERCICIOS, TipoNodo.SOLUCIONES,TipoNodo.AUTOR,  TipoNodo.EDITORIAL, TipoNodo.FECHA_PUBLICACON, TipoNodo.PALABRA_CLAVE};
        this.comboHijoMetadatos= new JComboBox<>(listaHCapMetadatos);
        this.txtHijoSecciones= new JTextField(20);
        this.botonAgregarHijoSeciones= new JButton("Agregar");
        this.txtDato = new JTextField(10);
        this.botonAceptar= new JButton("Aceptar");
        this.txtMaterialBuscado.setText(material.getTitulo().toString());
        this.txtMaterialBuscado.setEditable(false);
        /**titulo es el que viene como resultado de la busqueda*/
        this.textAutor= new JTextField(10);
        this.botonAgregarCap=new JButton("Agregar");
        this.botonAgregarResumen= new JButton("Agregar");
        this.botonAgregarMetadatos= new JButton("Agregar");
        this.botonAgregarArbol=new JButton("Finalizar Carga");
        this.botonAgregarHijoResumen= new JButton("Agregar");
        this.botonAgregarHijoMetadato= new JButton("Agregar");
        
        /**Desde aca comienzo agregar los paneles*/
        this.setLayout(new GridLayout(0,2));
        this.add(new JLabel("AGREGAR DATOS AL MATERIAL"));
        this.add(txtMaterialBuscado);
        this.add(comboSubRaiz);//Capitulo
        this.add(txtCapitulo);
        this.add(this.botonAgregarCap);
        this.add(new JLabel("                   "));
        this.add(this.comboHijoSecciones);
        this.add(txtHijoSecciones);
        this.add(botonAgregarHijoSeciones);
        this.add(new JLabel("                   "));
        this.add(this.comboSubRaiz1);//Metadato
        this.add(this.txtMetadatos);
        this.add(this.botonAgregarMetadatos);
        this.add(new JLabel("                   "));
        this.add(this.comboHijoMetadatos);
        this.add(txtComboHijoMetadato);
        this.add(botonAgregarHijoMetadato);
        this.add(new JLabel("                   "));
        this.add(this.comboSubRaiz2);//Resumen
        this.add(this.txtResumen);
        this.add(this.botonAgregarResumen);
        this.add(new JLabel("                   "));
        this.add(this.comboHijoResumen);
        this.add(this.txtComboResumen);
        this.add(botonAgregarHijoResumen);
        this.add(this.botonAgregarArbol);
        this.add(new JLabel("                   "));
        
       this.botonAgregarCap.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
          try{  
           arbolControl.cargarRaizArbol(txtMaterialBuscado.getText(),tipoNodo.TITULO);//escribe el titulo que viene
           TipoNodo tipoNodoRaiz=(TipoNodo) comboSubRaiz.getSelectedItem(); 
          arbolControl.cargarNodoDeRaiz(txtCapitulo.getText(),tipoNodoRaiz);//tiene q ir el txt field que tiene el dato
          }catch(Exception ex){
            System.out.println("Error no puedo agregar material");
            }
          }
        });
         
         this.botonAgregarMetadatos.addActionListener(new ActionListener(){   
         public void actionPerformed(ActionEvent e){
             TipoNodo tipoNodoMetadato=(TipoNodo) comboSubRaiz1.getSelectedItem();
             arbolControl.cargarNodoDeRaiz("Metadato",tipoNodoMetadato);
         }
       });
         
        this.botonAgregarResumen.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             TipoNodo tipoNodoSeccion=(TipoNodo)comboSubRaiz2.getSelectedItem();
             arbolControl.cargarNodoDeRaiz(txtResumen.getText(),tipoNodoSeccion);
                }
        
                });
               
     this.botonAgregarHijoMetadato.addActionListener(new ActionListener(){   
         public void actionPerformed(ActionEvent e){
             TipoNodo hijoMetadato= (TipoNodo) comboHijoMetadatos.getSelectedItem();
             arbolControl.agregarHijosMetadato(txtComboHijoMetadato.getText(), hijoMetadato);
             
         }
         });
     
     this.botonAgregarHijoResumen.addActionListener(new ActionListener(){   
         public void actionPerformed(ActionEvent e){
             TipoNodo hijoResumen= (TipoNodo) comboHijoResumen.getSelectedItem();
             arbolControl.agregarHijosResumen(txtComboResumen.getText(), hijoResumen);
         }
         });
     
     this.botonAgregarHijoSeciones.addActionListener(new ActionListener(){   
         public void actionPerformed(ActionEvent e){
             TipoNodo hijoSeccion= (TipoNodo) comboHijoSecciones.getSelectedItem();
             arbolControl.agregarHijosCapitulo(txtHijoSecciones.getText(), hijoSeccion);
         }
         });
        
        this.botonAgregarArbol.addActionListener(new ActionListener(){   
         public void actionPerformed(ActionEvent e){
            arbolControl.cargarArbol();
           arbolControl.dibujarArbol();
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
        PanelAgregarAArbol boPanel = new PanelAgregarAArbol();
        boPanel.setSize(300, 200);
        ventana.add(boPanel);
    
        ventana.add(boPanel, BorderLayout.PAGE_START);
        
        ventana.pack();
        ventana.setVisible(true);
}

public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
           PanelAgregarAArbol pBuscar=new PanelAgregarAArbol();
          pBuscar.crearShowGUI();
        }
    });
}
    
}