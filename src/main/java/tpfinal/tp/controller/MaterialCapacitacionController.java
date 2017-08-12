/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.controller;

import tpfinal.tp.guardarADisco.LibrosDao;
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.integrador.Publicacion;
import tpfinal.tp.integrador.TemasMateriales;
import tpfinal.tp.integrador.Video;
import tpfinal.tp.ventanas.PanelVideo;
import tpfinal.tp.windows.PanelLibro;
import tpfinal.tp.windows.Principal;




public class MaterialCapacitacionController {


    // clases del modelo manejadas por el controlador
    
    private MaterialCapacitacion libro;
    private MaterialCapacitacion video;
    private MaterialCapacitacion publicacion;
    private MaterialCapacitacion material;
    private LibrosDao librosDao = new LibrosDao();
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
     public void mostrarPanelLibro()
     {
      PanelLibro panel= new PanelLibro(this);
        panel.armarPanel();
        this.vistaPrincipal.getContentPane().removeAll();
        this.vistaPrincipal.getContentPane().add(panel);
        this.vistaPrincipal.revalidate();
        this.vistaPrincipal.pack();
     }
     
     public void crearVideo()
     {
         
     }
     
     public void mostrarPanelVideo()
     {
        PanelVideo panel= new PanelVideo(this.vistaPrincipal);
        panel.armarPanel();
        this.vistaPrincipal.getContentPane().removeAll();
        this.vistaPrincipal.getContentPane().add(panel);
        this.vistaPrincipal.revalidate();
        this.vistaPrincipal.pack();
     }

}
