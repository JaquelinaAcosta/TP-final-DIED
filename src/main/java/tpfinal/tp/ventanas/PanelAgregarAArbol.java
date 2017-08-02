
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
    
    public PanelAgregarAArbol(Principal principal, MaterialCapacitacion material){
        this.principal = principal;
        this.material=material;
        this.armarPanel();
    }
    
    public PanelAgregarAArbol(){
        this.armarPanel();
    }
    
     private void armarPanel(){
         TipoNodo[] listaHRaiz = {TipoNodo.CAPITULO, TipoNodo.METADATO, TipoNodo.RESUMEN};
        this.comboHRaiz= new JComboBox<>(listaHRaiz);
      
        TipoNodo[] listaHMetadatos = {TipoNodo.AUTOR,  TipoNodo.EDITORIAL, TipoNodo.FECHA_PUBLICACON, TipoNodo.PALABRA_CLAVE};
        this.comboHMetadatos= new JComboBox<>(listaHMetadatos);
        TipoNodo[] listaHResumen = {TipoNodo.PARRAFO};
        this.comboHResumen= new JComboBox<>(listaHResumen);
        TipoNodo[] listaHCapitulos = {TipoNodo.METADATO, TipoNodo.SECCION};
        this.comboHCapitulos= new JComboBox<>(listaHCapitulos);
        TipoNodo[] listaHSecciones = { TipoNodo.PARRAFO };
        this.comboHSecciones= new JComboBox<>(listaHSecciones);
        TipoNodo[] listaHCapMetadatos = { TipoNodo.PALABRA_CLAVE, TipoNodo.EJERCICIOS, TipoNodo.SOLUCIONES};
        this.comboHCapMetadatos= new JComboBox<>(listaHCapMetadatos);
        TipoNodo[] listaArbol = { TipoNodo.TITULO };
        this.comboArbol= new JComboBox<>(listaArbol);
        
        this.txtDato = new JTextField(10);
        this.botonAceptar= new JButton("Aceptar");
        
          
        /**titulo es el que viene como resultado de la busqueda*/
        this.textAutor= new JTextField(10);
        JPanel panelRaiz = new JPanel();
        panelRaiz.setLayout(new FlowLayout());  
        panelRaiz.add(new JLabel("Metadatos: "));
        panelRaiz.add(comboHMetadatos);
        panelRaiz.add(textAutor);
        panelRaiz.add(new JLabel("Resumen "));
        panelRaiz.add(comboHResumen);
      
        panelRaiz.add(new JLabel("Capitulos "));
        panelRaiz.add(comboHCapitulos); 
        
        comboHRaiz.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
          try{
              String eleccion=comboHRaiz.getSelectedItem().toString();
              System.out.println("esto elegi"+eleccion);
          }catch(Exception ex){
            System.out.println("Error");
            }
          }
        });
        
        comboHMetadatos.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
          try{
              String eleccion=comboHMetadatos.getSelectedItem().toString();
              System.out.println("esto elegi"+eleccion);
          }catch(Exception ex){
            System.out.println("Error");
            }
          }
        });
                
                
    
  
        JPanel panelCapitulos = new JPanel();
        panelCapitulos.setLayout(new FlowLayout()); 
        panelCapitulos.add(new JLabel("Solo para capitulos: "));
        panelCapitulos.add(new JLabel(" "));
        panelCapitulos.add(new JLabel("secciones "));
        panelCapitulos.add(comboHSecciones);
        panelCapitulos.add(new JLabel("metadatos "));
        panelCapitulos.add(comboHCapMetadatos);
        
        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new FlowLayout()); 
        panelTexto.add(new JLabel("Cargar dato "));
        panelTexto.add(txtDato);
        panelTexto.add(new JLabel(""));
        panelTexto.add(botonAceptar);
        
        this.setLayout(new GridLayout(7,0, 10, 10));
        this.add(new JLabel("AGREGAR DATO AL MATERIAL (seleccione una opción por linea))"));
         this.add(new JLabel("Agregar como hijo del nodo:"));
        this.add(comboArbol);
        this.add(comboHRaiz);
        this.add(panelRaiz);
        this.add(panelCapitulos);
        this.add(panelTexto);
      
        
 
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
