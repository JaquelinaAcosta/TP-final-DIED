/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.windows;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import tpfinal.tp.controller.MaterialCapacitacionController;
import tpfinal.tp.integrador.TemasMateriales;


public class Principal extends JFrame {
    //Where the GUI is created:
   private JMenuBar menuMaterialCapacitacion;
   private JMenu menu,menuLibro,menuPublicacion,menuVideo;
   private JMenuItem menuCrearVideo,menuEliminarVideo,menuModificarVideo;
   private JMenuItem menuCrearLibro,menuEliminarLibro,menuModificarLibro;
   private JMenuItem menuCrearPublicacion,menuEliminarPublicacion,menuModificarPublicacion;
   private JMenuItem menuBuscarLibro,menuBuscarVideo,menuBuscarPublicacion;

  private MaterialCapacitacionController controller;

    public Principal() {
        
    controller = new MaterialCapacitacionController(this);
        
    menuMaterialCapacitacion = new JMenuBar();
    this.menuCrearLibro= new JMenuItem("Crear");
    this.menuModificarLibro= new JMenuItem("Modificar");
    this.menuEliminarLibro= new JMenuItem("Eliminar");
    this.menuCrearVideo= new JMenuItem("Crear");
    this.menuModificarVideo= new JMenuItem("Modificar");
    this.menuEliminarVideo= new JMenuItem("Eliminar");
    this.menuCrearPublicacion= new JMenuItem("Crear");
    this.menuModificarPublicacion= new JMenuItem("Modificar");
    this.menuEliminarPublicacion= new JMenuItem("Eliminar");
    this.menuBuscarLibro= new JMenuItem("Buscar");
    this.menuBuscarVideo= new JMenuItem("Buscar");
    this.menuBuscarPublicacion= new JMenuItem("Buscar");

        menu = new JMenu("Material de Capacitacion");
        menuMaterialCapacitacion.add(menu);

     
      menuLibro = new JMenu("Libro");
      menuLibro.addActionListener((e) -> {
            controller.mostrarPanelLibro();
        });
      menu.add(menuLibro);
      menu.addSeparator();//para mostrar la rayita que separa
      menuLibro.add(menuCrearLibro);
      menuLibro.addSeparator();
      menuLibro.add(this.menuModificarLibro);
      menuLibro.addSeparator();
      menuLibro.add(this.menuEliminarLibro);
      menuLibro.addSeparator();
      menuLibro.add(this.menuBuscarLibro);
     
      
      
      menuVideo = new JMenu("Video");
      menuVideo.addActionListener((e) -> {
            controller.mostrarPanelVideo();
        });
      menu.add(menuVideo);
      menu.addSeparator();
      menuVideo.add(this.menuCrearVideo);
      menuVideo.addSeparator();
      menuVideo.add(this.menuModificarVideo);
      menuVideo.addSeparator();
      menuVideo.add(this.menuEliminarVideo);
      menuVideo.addSeparator();
      menuVideo.add(this.menuBuscarVideo);
     
      
      
      menuPublicacion = new JMenu("Publicacion");
      menuPublicacion.addActionListener((e) -> {
            controller.mostrarPanelPublicacion();
        });
      menu.add(menuPublicacion);
      menu.addSeparator();
      menuPublicacion.add(this.menuCrearPublicacion);
      menuPublicacion.addSeparator();
      menuPublicacion.add(this.menuModificarPublicacion);
      menuPublicacion.addSeparator();
      menuPublicacion.add(this.menuEliminarPublicacion);
      menuPublicacion.addSeparator();
      menuPublicacion.add(this.menuBuscarPublicacion);

      
      this.setJMenuBar(menuMaterialCapacitacion);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
    }       
    
}


