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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tpfinal.tp.controller.MaterialCapacitacionController;
import tpfinal.tp.excepcion.MaterialNoEncontradoException;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.integrador.Portal;
import tpfinal.tp.integrador.TemasMateriales;

/**
 *
 * @author jaque
 */
public class PanelBuscarOrdenar extends JPanel{
    
   private JMenuBar menuMaterialCapacitacion;
   private JMenu menu,menuBuscarMaterial,menuGrafo;
   private JMenuItem menuBuscar;
   private JMenuItem menuSalir;
   private JMenuItem menuVolver;
   private JMenuItem menuAsignarRelaciones;
//    private JButton botonBuscar;
//    private JButton botonSalir;
//    private JButton botonVolver;
//     private JButton botonAsignarRelaciones;
    private JCheckBox boxTitulo;
    private JCheckBox boxTituloAlfabetico;
    private JCheckBox boxCalificacionOrden;
    private JCheckBox boxPrecioOrden;
    private JCheckBox boxCalificacion;
    private JCheckBox boxTema;
    private tpfinal.tp.ventanas.Principal principal;
    private tpfinal.tp.ventanas.PanelBuscarOrdenar buscarOrdenar;
    private JComboBox comboTema;
    private JComboBox comboCalificacion;
    private JTextField txtTitulo;
   private TemasMateriales tema;  
    private TemasMateriales temaSeleccionado;  
    private Portal portal;
    MaterialCapacitacionController controller;
    
    private MaterialCapacitacion material;
    private List<? extends MaterialCapacitacion> listaMateriales;

    public PanelBuscarOrdenar(){
        this.armarPanel();
    }
    
   
    public PanelBuscarOrdenar(MaterialCapacitacionController controller, List<? extends MaterialCapacitacion> listaMateriales){
        this.controller = controller;
        this.listaMateriales = listaMateriales;
        this.armarPanel();
    }
    
    public void armarPanel(){
        
        menuMaterialCapacitacion = new JMenuBar();
        this.menuBuscar= new JMenuItem("Buscar Material");   
        this.menuAsignarRelaciones= new JMenuItem("Asignar Relaciones");   
        this.menuVolver= new JMenuItem("Volver");
        this.menuSalir= new JMenuItem("Salir");
        
        this.boxCalificacion= new JCheckBox();
        this.boxTituloAlfabetico=new JCheckBox();
        this.boxPrecioOrden=new JCheckBox();
        this.boxCalificacionOrden=new JCheckBox();
        this.boxTema=new JCheckBox();
        this.boxTitulo=new JCheckBox();
        TemasMateriales[] listaTemas = {TemasMateriales.ENTRETENIMIENTO, TemasMateriales.MATEMATICA, TemasMateriales.PROGRAMACION};
        this.comboTema= new JComboBox<>(listaTemas);
        this.txtTitulo=new JTextField(20);
        Integer[] listaCalificacion = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        this.comboCalificacion = new JComboBox<>(listaCalificacion);
        
        
        menu = new JMenu("Material de Capacitacion");
        menuMaterialCapacitacion.add(menu);
        
        menuBuscarMaterial = new JMenu("Buscar Material de Capacitación");
     
        menu.add(menuBuscarMaterial);
        menuBuscarMaterial.add(menuBuscar);
        this.menuBuscar.addActionListener((e) ->{
            try {
                filtrar();
                controller.cambiarBuscarLibroVideoPublicacion(listaMateriales);
                //Llama al metodo que estan en la ventana principal, y realiza la accion correspondiente.
                   } catch (MaterialNoEncontradoException ex) {
                       JOptionPane.showMessageDialog(null, ex.getMessage());
                   } catch (Exception ex) {
                       Logger.getLogger(tpfinal.tp.ventanas.PanelBuscarOrdenar.class.getName()).log(Level.SEVERE, null, ex);
                   } 
             });
        menuBuscarMaterial.add(menuVolver);
        this.menuVolver.addActionListener((e) ->{
            controller.principal();
        });
        menu.addSeparator();
        menuBuscarMaterial.add(menuSalir);
        this.menuSalir.addActionListener((e) ->{
            System.exit(0);
      });
        
        menuGrafo = new JMenu("Grafo");
        menu.add(menuGrafo);
        menuGrafo.add(menuAsignarRelaciones);
        this.menuAsignarRelaciones.addActionListener((e) ->{
            try {
                      filtrarTema();
                       controller.cambiarDibujarNodo(temaSeleccionado(),listaMateriales);
                       } catch (MaterialNoEncontradoException ex) {
                       JOptionPane.showMessageDialog(null, ex.getMessage());
                         } catch (Exception ex) {
                       Logger.getLogger(tpfinal.tp.ventanas.PanelBuscarOrdenar.class.getName()).log(Level.SEVERE, null, ex);
                   }
      });
    
        
        
        
        this.setLayout(new GridLayout(5,4, 10, 10));
        this.add(new JLabel("BUSCAR"));
        this.add(new JLabel(" "));
        this.add(new JLabel(" "));
        this.add(new JLabel("Ordenar por"));
        this.add(new JLabel(" "));
        this.add(new JLabel("Título"));
        this.add(boxTitulo);
        this.add(txtTitulo);
        this.add(new JLabel("Titulo Alfabético"));
        this.add(boxTituloAlfabetico);
        this.add(new JLabel("Calificación"));
        this.add(boxCalificacion);
        this.add(comboCalificacion);
        this.add(new JLabel("Calificación"));
        this.add(boxCalificacionOrden);
        this.add(new JLabel("Tema"));
        this.add(boxTema);
        this.add(comboTema);
        this.add(new JLabel("Precio"));
        this.add(boxPrecioOrden);
        this.add(new JLabel(" "));
        this.add(new JLabel(" "));
        this.add(new JLabel(" "));
        this.add(menuMaterialCapacitacion);


temaSeleccionado=this.temaSeleccionado();
  
    }
    
    private TemasMateriales temaSeleccionado()
    {
     comboTema.addActionListener((ActionEvent e) -> {
      tema= (TemasMateriales) comboTema.getSelectedItem();
      System.out.println(tema);
});
        return tema;
    }
   private void filtrarTema() throws MaterialNoEncontradoException{
       if(boxTema.isSelected()){
     listaMateriales.removeIf(material -> ! material.getTema().equals((TemasMateriales) comboTema.getSelectedItem()));
      
       }
   }   
    //aca filtramos la lista que fue importada en Principal, en el metodo cambiarAPanelBuscar()
    public void filtrar() throws MaterialNoEncontradoException{
        if(boxTitulo.isSelected()){
      
            listaMateriales.removeIf(material -> ! material.getTitulo().equals(txtTitulo.getText()));
        }
        if(boxCalificacion.isSelected()){
            listaMateriales.removeIf(material -> ! material.getCalificacion().equals((Integer) comboCalificacion.getSelectedItem()));
        }
        if(boxTema.isSelected()){
            listaMateriales.removeIf(material -> ! material.getTema().equals((TemasMateriales) comboTema.getSelectedItem()));
        }
        
        //Uso la clase Portal para ordenar la listaMateriales
        portal = new Portal();
        //Cargo la lista con los materiales para que la ordene
        for(MaterialCapacitacion material: listaMateriales){
            portal.agregar(material);
        }
        //en estos ordenas las listas con los metodos que estaban en portal, segun lo que elegimos en el checkBox
        if(boxTituloAlfabetico.isSelected()){
            listaMateriales = portal.ordenadaAlfabeticamente();
        }
        if(boxCalificacionOrden.isSelected()){
            listaMateriales = portal.ordenadaPorCalificacionEditor();
        }
        if(boxPrecioOrden.isSelected()){
            listaMateriales = portal.ordenadaPorPrecio();
        }
        if(listaMateriales.isEmpty()){
            throw new MaterialNoEncontradoException();
        }
        
       
   }

}

    

