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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tpfinal.tp.excepcion.MaterialNoEncontradoException;
import tpfinal.tp.guardarADisco.PublicacionesDao;
import tpfinal.tp.guardarADisco.VideosDao;
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.integrador.Portal;
import tpfinal.tp.integrador.TemasMateriales;



public class PanelBuscarOrdenar extends JPanel{
    
    private JButton botonBuscar;
    private JButton botonSalir;
     private JButton botonAsignarRelaciones;
    private JCheckBox boxTitulo;
    private JCheckBox boxTituloAlfabetico;
    private JCheckBox boxCalificacionOrden;
    private JCheckBox boxPrecioOrden;
    private JCheckBox boxCalificacion;
    private JCheckBox boxTema;
    private Principal principal;
    private PanelBuscarOrdenar buscarOrdenar;
    private JComboBox comboTema;
    private JComboBox comboCalificacion;
    private JTextField txtTitulo;
   private TemasMateriales tema;  
    private TemasMateriales temaSeleccionado;  
    private Portal portal;
    
    private MaterialCapacitacion material;
    private List<? extends MaterialCapacitacion> listaMateriales;

    public PanelBuscarOrdenar(){
        this.armarPanel();
    }
    
    public PanelBuscarOrdenar (Principal principal){
        this.principal= principal;
        this.armarPanel();
    }
    
    public PanelBuscarOrdenar(PanelBuscarOrdenar buscarOrdenar){
        this.buscarOrdenar = buscarOrdenar;
        this.armarPanel();
    }
   
    public PanelBuscarOrdenar(Principal principal, List<? extends MaterialCapacitacion> listaMateriales){
        this.principal = principal;
        this.listaMateriales = listaMateriales;
        this.armarPanel();
    }
    
    private void armarPanel(){
        this.botonBuscar= new JButton("Buscar");
        this.botonAsignarRelaciones= new JButton("Asignar Relaciones");
        this.botonSalir= new JButton("Salir");
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
        
        
        this.setLayout(new GridLayout(5,4, 10, 10));
        this.add(new JLabel("BUSCAR"));
        this.add(new JLabel(" "));
        this.add(new JLabel(" "));
        this.add(new JLabel(" "));
        this.add(new JLabel("Ordenar por"));
        this.add(new JLabel(" "));
        this.add(new JLabel("Título"));
        this.add(boxTitulo);
        this.add(txtTitulo);
        this.add(new JLabel(" "));
        this.add(new JLabel("Titulo Alfabético"));
        this.add(boxTituloAlfabetico);
        this.add(new JLabel("Calificacion"));
        this.add(boxCalificacion);
        this.add(comboCalificacion);
        this.add(new JLabel(" "));
        this.add(new JLabel("Calificacion"));
        this.add(boxCalificacionOrden);
        this.add(new JLabel("Tema"));
        this.add(boxTema);
        this.add(comboTema);
        this.add(new JLabel(" "));
        this.add(new JLabel("Precio"));
        this.add(boxPrecioOrden);
        this.add(new JLabel(" "));
        this.add(new JLabel(" "));
        this.add(botonBuscar);
        this.add(botonAsignarRelaciones);
        this.add(botonSalir);
/**
 *    comboxSuscriptor.addActionListener((ActionEvent e) -> {
            //JLabel estoSeleccione= new JLabel(comboxSuscriptor.getSelectedItem().toString());
            String suscriptorSeleccionado=comboxSuscriptor.getSelectedItem().toString();
              for(Suscriptor elem: listaSuscriptor)
        {
          String sus=elem.getNombre();
          if(suscriptorSeleccionado.equals(sus))
              System.out.println("este suscriptor soy"+sus+"mi saldo es"+elem.getCredito());
        }
            System.out.println("Esto seleccione"+comboxSuscriptor.getSelectedItem().toString());
        });
       
 */
temaSeleccionado=this.temaSeleccionado();

      System.out.println(temaSeleccionado);
       this.botonBuscar.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                   try {
                       filtrar();
                       principal.cambiarBuscarLibroVideoPublicacion(listaMateriales);
                        //Llama al metodo que estan en la ventana principal, y realiza la accion correspondiente.
                   } catch (MaterialNoEncontradoException ex) {
                       JOptionPane.showMessageDialog(null, ex.getMessage());
                   } catch (Exception ex) {
                       Logger.getLogger(PanelBuscarOrdenar.class.getName()).log(Level.SEVERE, null, ex);
                   } 
               }
        });
       
//        this.botonAsignarRelaciones.addActionListener(new ActionListener(){
//               @Override
//               public void actionPerformed (ActionEvent e){
//                   try {
//                    //   filtrarTema();
//                       principal.cambiarDibujarNodo(tema,listaMateriales);
//                       } catch (MaterialNoEncontradoException ex) {
//                       JOptionPane.showMessageDialog(null, ex.getMessage());
//                         } catch (Exception ex) {
//                       Logger.getLogger(PanelBuscarOrdenar.class.getName()).log(Level.SEVERE, null, ex);
//                   }
//                
//               }
//        });
       //Cierra la ventana
       this.botonSalir.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                   System.exit(0);
               }
        });

        
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

        if(listaMateriales.isEmpty()){
            throw new MaterialNoEncontradoException();
        }
        
   }
    
    //aca filtramos la lista que fue importada en Principal, en el metodo cambiarAPanelBuscar()
   private void filtrar() throws MaterialNoEncontradoException{
        if(boxTitulo.isSelected()){
            //Uso Lambda, en presentacion complementaria de swing está
            //[Lista de Argumentos (seria lista de materiales) ][tokenflecha (->)][cuerpo de la expresión
            //(lo que quiero hacer, buscar los material que por ejemplo el titulo que pasas este en la lista de materiales,
            //para hacer una lista solo con esa caracteriatica)]
            //esa muy bueno para lo que es lista, para las buquedas porque en una linea haces todo
            //te dejo un link que tenes ejemplos de todo
            //https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
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
        
        //IMPORTANE!
        //SI CORRES VIDEO SELECCIONANDO EL CHECK DE TEMA, SELECCIONAS "MATEMATICA"
        //Y SELECCIONAS EL CHECK QUE TE LO ORDENE POR PRECIO SE VE QUE DA EL RESULTADO DE LA LISTA ORDENADA
        
   }

        

     
private static void crearBuscarShowGUI(){
        JFrame ventana = new JFrame("Biblioteca");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelBuscarOrdenar boPanel = new PanelBuscarOrdenar();
        boPanel.setSize(300, 200);
        ventana.add(boPanel);
    
        ventana.add(boPanel, BorderLayout.PAGE_START);
        
        ventana.pack();
        ventana.setVisible(true);
}

public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
           PanelBuscarOrdenar pBuscarOrdenar=new PanelBuscarOrdenar();
          pBuscarOrdenar.crearBuscarShowGUI();
        }
    });
}
    
    
}
