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
import tpfinal.tp.guardarADisco.LibrosDao;
import tpfinal.tp.guardarADisco.PublicacionesDao;
import tpfinal.tp.guardarADisco.VideosDao;
import tpfinal.tp.integrador.TemasMateriales;


public class Principal extends JFrame {
    //Where the GUI is created:
   private JMenuBar menuMaterialCapacitacion;
   private JMenu menu,menuLibro,menuPublicacion,menuVideo;
   private JMenuItem menuCrearVideo;
   private JMenuItem menuCrearLibro;
   private JMenuItem menuCrearPublicacion;
   private JMenuItem menuBuscarLibro,menuBuscarVideo,menuBuscarPublicacion;

  private MaterialCapacitacionController controller;

    public Principal() {
        this.armarPanel();
    }
    
        
    private void armarPanel(){    
    controller = new MaterialCapacitacionController(this);
        
    menuMaterialCapacitacion = new JMenuBar();
    this.menuCrearLibro= new JMenuItem("Crear");   
    this.menuCrearVideo= new JMenuItem("Crear");   
    this.menuCrearPublicacion= new JMenuItem("Crear");
    this.menuBuscarLibro= new JMenuItem("Buscar");
    this.menuBuscarVideo= new JMenuItem("Buscar");
    this.menuBuscarPublicacion= new JMenuItem("Buscar");

        menu = new JMenu("Material de Capacitacion");
        menuMaterialCapacitacion.add(menu);

     
      menuLibro = new JMenu("Libro");
     
      menu.add(menuLibro);
      menu.addSeparator();//para mostrar la rayita que separa
      menuLibro.add(menuCrearLibro);
      this.menuCrearLibro.addActionListener((e) -> {
            controller.mostrarPanelLibro();
        });
      menuLibro.addSeparator();
      menuLibro.add(this.menuBuscarLibro);
      this.menuBuscarLibro.addActionListener((e) ->{
          LibrosDao librosDao=new LibrosDao();
          controller.mostrarBuscarOrdenar(librosDao.cargarLista(), "Libro");
      });
     
      
      
      menuVideo = new JMenu("Video");
      
      menu.add(menuVideo);
      menu.addSeparator();
      menuVideo.add(this.menuCrearVideo);
      this.menuCrearVideo.addActionListener((e) -> {
            controller.mostrarPanelVideo();
        });
      menuVideo.addSeparator();
      menuVideo.add(this.menuBuscarVideo);
      this.menuBuscarVideo.addActionListener((e) ->{
          VideosDao videosDao = new VideosDao();
          controller.mostrarBuscarOrdenar(videosDao.cargarLista(), "Video");
      });
     
      
      
      menuPublicacion = new JMenu("Publicacion");
     
      menu.add(menuPublicacion);
      menu.addSeparator();
      menuPublicacion.add(this.menuCrearPublicacion);
      this.menuCrearPublicacion.addActionListener((e) -> {
            controller.mostrarPanelPublicacion();
        });
      menuPublicacion.addSeparator();
      menuPublicacion.add(this.menuBuscarPublicacion);
      this.menuBuscarPublicacion.addActionListener((e) ->{
          PublicacionesDao publicacionesDao=new PublicacionesDao();
          controller.mostrarBuscarOrdenar(publicacionesDao.cargarLista(), "Publicación");
      });

      
      this.setJMenuBar(menuMaterialCapacitacion);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
    }       
    
    
}


