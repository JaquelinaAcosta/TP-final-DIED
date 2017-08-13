/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.controller;

import java.util.Date;
import tpfinal.tp.guardarADisco.LibrosDao;
import tpfinal.tp.guardarADisco.PublicacionesDao;
import tpfinal.tp.guardarADisco.VideosDao;
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.integrador.Publicacion;
import tpfinal.tp.integrador.TemasMateriales;
import tpfinal.tp.integrador.Video;

import tpfinal.tp.windows.PanelLibro;
import tpfinal.tp.windows.PanelPublicacion;
import tpfinal.tp.windows.PanelVideo;
import tpfinal.tp.windows.Principal;




public class MaterialCapacitacionController {


    // clases del modelo manejadas por el controlador
    
    private MaterialCapacitacion libro;
    private MaterialCapacitacion video;
    private MaterialCapacitacion publicacion;
    private MaterialCapacitacion material;
    private LibrosDao librosDao = new LibrosDao();
    private VideosDao videosDao = new VideosDao();
    private PublicacionesDao publicacionesDao = new PublicacionesDao();
     // clase principal de la vista manejada pro el controlador
    private Principal vistaPrincipal;
    
    public MaterialCapacitacionController()
    {
        libro = new Libro();
        video= new Video();
        publicacion= new Publicacion();
    }
    
      public MaterialCapacitacionController(Principal ppal){
        this();
        this.vistaPrincipal = ppal;
    }
      
     public void crearLibro(String titulo,Double costo,String isbn,Integer pagina, TemasMateriales tema, Integer calificacion){
       Libro libro1 = new Libro(titulo,costo,isbn,pagina,tema,calificacion);
       librosDao.agregar(libro1);
  
    }
     
     public void modificarLibro()
     {
         
         
     }
     
     public void eliminarLibro()
     {
         
     }
     
     
     public void mostrarPanelLibro()
     {
      PanelLibro panel= new PanelLibro(this);
        panel.armarPanel();
        this.vistaPrincipal.getContentPane().removeAll();
        this.vistaPrincipal.getContentPane().add(panel);
        this.vistaPrincipal.revalidate();
        this.vistaPrincipal.pack();
     }
     
     public void crearVideo(String titulo, TemasMateriales tema, Integer duracion, Integer calificacion, Double costo)
     {
         Video video= new Video(titulo,tema,duracion,calificacion,costo);
         videosDao.agregar(video);
     }
     
     public void eliminarVideo()
     {
         
        
     }
     
     public void modificarVideo()
     {
         
     }
     
     public void mostrarPanelVideo()
     {
        PanelVideo panel= new PanelVideo(this);
        panel.armarPanel();
        this.vistaPrincipal.getContentPane().removeAll();
        this.vistaPrincipal.getContentPane().add(panel);
        this.vistaPrincipal.revalidate();
        this.vistaPrincipal.pack();
     }
     
     public void crearPublicacion(String titulo, TemasMateriales tema,Date fecha, Integer calificacion,Double costo)
     {
         
         Publicacion publicacion= new Publicacion(titulo,tema,fecha,calificacion,costo);
         publicacionesDao.agregar(publicacion);
     }
     
     public void modificarPublicacion()
     {
         
     }
     
     public void eliminarPublicacion()
     {
         
     }
     
     public void mostrarPanelPublicacion()
     {
        PanelPublicacion panel= new PanelPublicacion(this);
        panel.armarPanel();
        this.vistaPrincipal.getContentPane().removeAll();
        this.vistaPrincipal.getContentPane().add(panel);
        this.vistaPrincipal.revalidate();
        this.vistaPrincipal.pack();   
     }

}
