
package tpfinal.tp.ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import tpfinal.tp.estructuraArbolNario.TipoNodo;
import tpfinal.tp.integrador.MaterialCapacitacion;

/*En esta clase se van a ingresar los datos en el arbol Nario
para la Busqueda de texto
*/


public class PanelAgregarAArbol extends JPanel{
    private JTextField txtDato;
    private JComboBox comboHRaiz;
    private JComboBox comboHMetadatos;
    private JComboBox comboHResumen;
    private JComboBox comboHCapitulos;
    private JComboBox comboHSecciones;
    private JComboBox comboHCapMetadatos;
    private JComboBox comboArbol;
    
    private Principal principal;
    private JButton botonAceptar;
    private MaterialCapacitacion material;
    private JTextField textAutor;
    private JTextField txtMaterialBuscado;
    private JTextField txtCapitulo;
    private TipoNodo tipoNodo;
    
    
   private ArbolController arbolControl;
    private JButton botonAgregarCap;
    private JTextField txtSecciones;
     private JTextField txtMetadatos;
    private JButton botonAgregarSecciones;
    private JButton botonAgregarMetadatos;
    
    public PanelAgregarAArbol(Principal principal, MaterialCapacitacion materialR){
        this.principal = principal;
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
         this.txtSecciones= new JTextField(20);
         this.txtMetadatos= new JTextField(20);
         TipoNodo[] listaHRaiz = {TipoNodo.CAPITULO, TipoNodo.METADATO, TipoNodo.RESUMEN};
        this.comboHRaiz= new JComboBox<>(listaHRaiz);
        this.txtCapitulo= new JTextField(20);
        TipoNodo[] listaHResumen = {TipoNodo.PARRAFO};
        this.comboHResumen= new JComboBox<>(listaHResumen);
        TipoNodo[] listaHCapitulos = {TipoNodo.METADATO, TipoNodo.SECCION};
        this.comboHCapitulos= new JComboBox<>(listaHCapitulos);
        TipoNodo[] listaHSecciones = { TipoNodo.PARRAFO };
        this.comboHSecciones= new JComboBox<>(listaHSecciones);
        TipoNodo[] listaHCapMetadatos = { TipoNodo.PALABRA_CLAVE, TipoNodo.EJERCICIOS, TipoNodo.SOLUCIONES,TipoNodo.AUTOR,  TipoNodo.EDITORIAL, TipoNodo.FECHA_PUBLICACON, TipoNodo.PALABRA_CLAVE};
        this.comboHCapMetadatos= new JComboBox<>(listaHCapMetadatos);
        
        this.txtDato = new JTextField(10);
        this.botonAceptar= new JButton("Aceptar");
        this.txtMaterialBuscado.setText(material.getTitulo().toString());
        this.txtMaterialBuscado.setEditable(false);
        /**titulo es el que viene como resultado de la busqueda*/
        this.textAutor= new JTextField(10);
        this.botonAgregarCap=new JButton("Agregar");
        this.botonAgregarSecciones= new JButton("Agregar");
        this.botonAgregarMetadatos=new JButton("Agregar");
        
        /**Desde aca comienzo agregar los paneles*/
        this.setLayout(new GridLayout(10,2));
        this.add(new JLabel("AGREGAR DATOS AL MATERIAL"));
        this.add(txtMaterialBuscado);
        
        this.add(comboHRaiz);
        this.add(txtCapitulo);
        
        this.add(botonAgregarCap); 
        this.add(new JLabel("                   "));
        
        this.add(new JLabel("Solo para capitulos"));
        this.add(new JLabel("                   "));
        
        this.add(comboHSecciones);
        this.add(txtSecciones);
        
        this.add(botonAgregarSecciones);
        this.add(new JLabel("                   "));
        
        this.add(new JLabel("metadatos "));
       this.add(new JLabel("                   "));
        
       this.add(comboHCapMetadatos);    
        this.add(txtMetadatos);
        this.add(botonAgregarMetadatos);
        
TipoNodo tipoNodoRaiz=(TipoNodo) comboHRaiz.getSelectedItem();
        comboHRaiz.addActionListener((ActionEvent e) -> {
            try{
                System.out.println("hola entreeeeeeeeeee titulo de material "+material.getTitulo());
              arbolControl.cargarRaizArbol(material.getTitulo(),TipoNodo.TITULO);
              //this.tipoNodo=(TipoNodo) comboHRaiz.getSelectedItem();
        
            }catch(Exception ex){
                System.out.println("Error no puedo cargar el arbol");
            }
         });
        

       this.botonAgregarCap.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
          try{
             arbolControl.cargarMetadatos(tipoNodoRaiz,txtCapitulo.getText());//tiene q ir el txt field que tiene el dato
          }catch(Exception ex){
            System.out.println("Error no puedo agregar material");
            }
          }
        });
         
       TipoNodo tipoNodoSeccion=(TipoNodo) comboHSecciones.getSelectedItem();
       this.comboHSecciones.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
          try{
          TipoNodo tipo=(TipoNodo) comboHSecciones.getSelectedItem();
          }catch(Exception ex){
            System.out.println("Error");
            }
          }
        });
        
        this.botonAgregarSecciones.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             arbolControl.cargarMetadatos(tipoNodoSeccion,txtSecciones.getText());
                }
        
                });
                
                
         TipoNodo tipoNodoMetadato=(TipoNodo) comboHCapMetadatos.getSelectedItem();
                
        this.comboHCapMetadatos.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
          try{
             arbolControl.cargarMetadatos(tipoNodo,txtSecciones.getText());
          }catch(Exception ex){
            System.out.println("Error en secciones");
            }
          }
        });
        
        this.botonAgregarMetadatos.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             arbolControl.cargarMetadatos(tipoNodoMetadato,txtMetadatos.getText());
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