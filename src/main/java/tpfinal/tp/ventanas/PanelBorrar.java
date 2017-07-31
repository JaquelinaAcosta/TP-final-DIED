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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import tpfinal.tp.guardarADisco.LibrosDao;
import tpfinal.tp.guardarADisco.PublicacionesDao;
import tpfinal.tp.guardarADisco.VideosDao;
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.integrador.Publicacion;
import tpfinal.tp.integrador.Video;


public class PanelBorrar extends JPanel{
    
    private JButton botonSi;
    private JButton botonNo;
    private Principal principal;
    private MaterialCapacitacion material;
    private VideosDao videosDao;
    private PublicacionesDao publicacionesDao;
    private LibrosDao librosDao;
    
    public PanelBorrar(){
        this.armarPanel();
    }
    
    //para cuando queremos borrar un material de la lista... falta terminar esto
    public PanelBorrar(Principal principal, MaterialCapacitacion material){
        this.principal = principal;
        this.material = material;
        this.armarPanel();
    }
    
    public PanelBorrar(Principal principal){
        this.principal= principal;
        this.armarPanel();
    }
    
    public void armarPanel(){
        this.botonSi = new JButton ("Si");
        this.botonNo = new JButton ("No");
        
        this.setLayout(new GridLayout (2, 1, 10, 10));
        this.add(new JLabel("¿Desea borrar el material?"));
        this.add(new JLabel(" "));
        this.add(botonSi);
        this.add(botonNo);
        
        this.botonSi.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                   if(material.getClass().equals(Video.class)){
                       videosDao = new VideosDao();
                       videosDao.borrar((Video) material);
                   }
                   if(material.getClass().equals(Publicacion.class)){
                       publicacionesDao = new PublicacionesDao();
                       publicacionesDao.borrar((Publicacion) material);
                   }
                   if(material.getClass().equals(Libro.class)){
                       librosDao = new LibrosDao();
                       librosDao.borrar((Libro) material);
                   }
               }
        });
        this.botonNo.addActionListener(new ActionListener(){
              @Override
                 public void actionPerformed (ActionEvent e){
                         principal.principal();
            }
    });
    }
    
    private static void crearBorrarShowGUI(){
        JFrame ventana = new JFrame("Biblioteca");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelBorrar borrarPanel = new PanelBorrar();
        borrarPanel.setSize(300, 200);
        ventana.add(borrarPanel);
    
        ventana.add(borrarPanel, BorderLayout.PAGE_START);
        
        ventana.pack();
        ventana.setVisible(true);
}
//public static void main(String[] args) {
//    javax.swing.SwingUtilities.invokeLater(new Runnable() {
//        public void run() {
//          PanelBorrar panelBorrar = new PanelBorrar();  
//          panelBorrar.crearBorrarShowGUI();
//          
//        }
//    });
//    
//}
}
