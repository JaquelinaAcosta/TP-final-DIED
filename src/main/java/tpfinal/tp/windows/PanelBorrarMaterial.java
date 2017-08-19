/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import tpfinal.tp.controller.MaterialCapacitacionController;
import tpfinal.tp.guardarADisco.LibrosDao;
import tpfinal.tp.guardarADisco.PublicacionesDao;
import tpfinal.tp.guardarADisco.VideosDao;
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.integrador.Publicacion;
import tpfinal.tp.integrador.Video;

/**
 *
 * @author jaque
 */
public class PanelBorrarMaterial extends JPanel{
    
    private JButton botonSi;
    private JButton botonNo;
    private JButton botonVolver;
    private tpfinal.tp.ventanas.Principal principal;
    private MaterialCapacitacion material;
    private VideosDao videosDao;
    private PublicacionesDao publicacionesDao;
    private LibrosDao librosDao;
    MaterialCapacitacionController controller;
    
    public PanelBorrarMaterial(){
        this.armarPanel();
    }
    
    //para cuando queremos borrar un material de la lista... falta terminar esto
    public PanelBorrarMaterial(MaterialCapacitacionController controller, MaterialCapacitacion material){
        this.controller = controller;
        this.material = material;
        this.armarPanel();
    }
    
    public void armarPanel(){
        this.botonSi = new JButton ("Si");
        this.botonNo = new JButton ("No");
        this.botonVolver = new JButton ("Volver");
        
        this.setLayout(new GridLayout (2, 3, 10, 10));
        this.add(new JLabel("¿Desea borrar el material?"));
        this.add(new JLabel(" "));
        this.add(new JLabel("Despues de borrar, presione Volver "));
        this.add(botonSi);
        this.add(botonNo);
        this.add(botonVolver);
        
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
                         controller.principal();
            }
    });
        this.botonVolver.addActionListener(new ActionListener(){
              @Override
                 public void actionPerformed (ActionEvent e){
                         controller.principal();
            }
    });
    }
}
