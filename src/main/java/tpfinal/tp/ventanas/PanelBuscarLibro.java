/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.ventanas;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import tpfinal.tp.controller.GrafoController;
import tpfinal.tp.guardarADisco.SuscriptoresDao;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.integrador.Suscriptor;
import tpfinal.tp.vista.ControlPanel;
import tpfinal.tp.vista.GrafoPanel;
import tpfinal.tp.vista.PrincipalGrafo;


public class PanelBuscarLibro extends JPanel{
    
    private JComboBox comboxSuscriptor;
    private JLabel libro;
    private JLabel suscriptor;
    private JList listLibros;
       private JList listSuscriptores;
    private JButton botonAgregar,botonActualizar,botonBorrar,botonSalir;
    private JButton asignarRelaciones;
    private JPanel nuevoLibro;
    private SuscriptoresDao suscriptorDao= new SuscriptoresDao();//aca voy a leer todos los 
    private Principal principal;
    private List<? extends MaterialCapacitacion> listaMateriales;
    
    public PanelBuscarLibro() throws Exception{
        this.armarPanel();
    }
    
    public PanelBuscarLibro(Principal principal) throws Exception{
        this.principal= principal;
        this.armarPanel();
    }
    
    public PanelBuscarLibro(Principal principal, List<? extends MaterialCapacitacion> listaMateriales) throws Exception{
        this.principal = principal;
        this.listaMateriales = listaMateriales;
        this.armarPanel();
    }

   
    private void armarPanel() throws Exception{
        

        this.libro= new JLabel("Libro");
        this.suscriptor=new JLabel("Suscriptor");
        this.botonActualizar= new JButton("Actualizar");
        this.botonSalir= new JButton("Salir");
        this.botonAgregar= new JButton("Agregar");
        this.botonBorrar= new JButton("Borrar");
        this.comboxSuscriptor= new JComboBox<String>();//aca muestra el suscriptor
        this.asignarRelaciones= new JButton("Asigar Relaciones");
        this.setLayout(new GridLayout(3,3, 10, 10));
        this.add(libro);
        this.add(suscriptor);
        this.listSuscriptores=  new JList();
              

      
  
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
  
  
                   
        //me lleva agregar un material de capacitacion*/
        this.add(comboxSuscriptor);
        this.add(listSuscriptores);
        this.add(asignarRelaciones);
        this.add(botonAgregar);
        this.add(botonActualizar);
        this.add(botonBorrar);
        this.add(botonSalir);
        
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
      

private static void crearBuscarShowGUI() throws Exception{
        JFrame ventana = new JFrame("Biblioteca");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelBuscarLibro blPanel = new PanelBuscarLibro();
        blPanel.setSize(300, 200);
        ventana.add(blPanel);
      
        ventana.add(blPanel, BorderLayout.PAGE_START);
        
        ventana.pack();
        ventana.setVisible(true);
}

public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          PanelBuscarLibro pBuscarLibro = null;
            try {
                pBuscarLibro = new PanelBuscarLibro();
            } catch (Exception ex) {
                Logger.getLogger(PanelBuscarLibro.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                pBuscarLibro.crearBuscarShowGUI();
            } catch (Exception ex) {
                Logger.getLogger(PanelBuscarLibro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
}
    
}
