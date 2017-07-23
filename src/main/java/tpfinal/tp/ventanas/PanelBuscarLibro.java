/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.lllll
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import tpfinal.tp.controller.GrafoController;
import tpfinal.tp.guardarADisco.LibrosDao;
import tpfinal.tp.guardarADisco.SuscriptoresDao;
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.integrador.Suscriptor;
import tpfinal.tp.vista.ControlPanel;
import tpfinal.tp.vista.GrafoPanel;


public class PanelBuscarLibro extends JPanel{
    
    private JComboBox comboxSuscriptor;
    private JLabel libro;
  private JLabel estoSeleccione;
    private JLabel suscriptor;
    private JList listLibros;
    private JButton botonAgregar,botonActualizar,botonBorrar,botonSalir;
    private JButton asignarRelaciones;
    private JPanel nuevoLibro;
    private SuscriptoresDao suscriptorDao= new SuscriptoresDao();//aca voy a leer todos los suscrip
    private LibrosDao libroDao= new LibrosDao();
    private Principal principal;
    private List<? extends MaterialCapacitacion> listaMateriales;
    private JComboBox comboxLibro;
    
    public PanelBuscarLibro(){
        this.armarPanel();
    }
    
    public PanelBuscarLibro(Principal principal){
        this.principal= principal;
        this.armarPanel();
    }
    
    public PanelBuscarLibro(Principal principal, List<? extends MaterialCapacitacion> listaMateriales){
        this.principal = principal;
        this.listaMateriales = listaMateriales;
        this.armarPanel();
    }

   
    private void armarPanel(){
        
        this.estoSeleccione= new JLabel();
        this.libro= new JLabel("Libro");
        this.suscriptor=new JLabel("Suscriptor");
        this.botonActualizar= new JButton("Actualizar");
        this.botonSalir= new JButton("Salir");
        this.botonAgregar= new JButton("Agregar");
        this.botonBorrar= new JButton("Borrar");
        this.comboxSuscriptor= new JComboBox<String>();//aca muestra el suscriptor
        this.comboxLibro= new JComboBox<String>();
        this.asignarRelaciones= new JButton("Asigar Relaciones");
//        this.listLibros=new JList(listaMateriales.toArray(new MaterialCapacitacion[listaMateriales.size()]));
        this.setLayout(new GridLayout(2,2, 5, 2));
       
    //    this.add(listLibros);
      
    //Cargo la lista de libros resultado de la busqueda
    
        List<Libro> listaLibro= libroDao.cargarLista();
        for(Libro lib: listaLibro)
        {
            String nombres = null;
            Libro book=lib;
            for(int i=0;i<listaLibro.size()-1;i++)
            {
                comboxLibro.addItem(book.getTitulo());
            } 
        }     

//Cargo la lista de Suscriptores
        List<Suscriptor> listaSuscriptor= suscriptorDao.cargarLista();
        for(Suscriptor elem: listaSuscriptor)
        {
            String nombres = null;
            Suscriptor elemento=elem;
            for(int i=0;i<listaSuscriptor.size()-1;i++)
            {
                comboxSuscriptor.addItem(elem.getNombre());
            } 
        }     

      
        this.add(libro);
        this.add(comboxLibro);
        this.add(suscriptor);
        this.add(comboxSuscriptor);
        this.add(botonAgregar);
        this.add(asignarRelaciones);
        this.add(botonActualizar);
        this.add(botonBorrar);
        this.add(botonSalir);
        
 

        //toma el Suscriptor que seleccione,lo muestro en un JLabel
        comboxSuscriptor.addActionListener((ActionEvent e) -> {
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
       
          //agrega un material a la lista del suscriptor si tiene credito
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try{
                           
                }catch(Exception ex){
                    System.out.println("Error");
                }
            }
        });
                
        
          asignarRelaciones.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e) {
                try{
                   
                   JFrame f = new JFrame();
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ControlPanel panelCtrl = new ControlPanel();
                    GrafoPanel panelGrf = new GrafoPanel();
                    GrafoController gf = new GrafoController(panelGrf, panelCtrl);
                    panelGrf.setController(gf);
                    panelCtrl.setController(gf);

                    f.add(panelCtrl, BorderLayout.PAGE_START);
                    f.add(panelGrf);

                    f.pack();
                    f.setVisible(true);
                }catch(Exception ex){
                    System.out.println("Error");
                }
            }
        });
        //Sale de todo
        this.botonSalir.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                   System.exit(0);
               }
        });

    }
       public void buscarSuscriptor(String nombreSuscrip,Suscriptor sus)
    {
        if(sus.getNombre().toString().equals(nombreSuscrip))
            System.out.println("Estee doyy");
    }
      

 
    
private static void crearBuscarShowGUI(){
        JFrame ventana = new JFrame("Biblioteca");
        ventana.setSize(500, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelBuscarLibro blPanel = new PanelBuscarLibro();
        blPanel.setSize(500, 300);
        ventana.add(blPanel);
        ventana.add(blPanel, BorderLayout.PAGE_START);
        ventana.pack();
        ventana.setVisible(true);
}

public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          PanelBuscarLibro pBuscarLibro = new PanelBuscarLibro();
                pBuscarLibro.crearBuscarShowGUI();
           
        }
    });
}
    
}
