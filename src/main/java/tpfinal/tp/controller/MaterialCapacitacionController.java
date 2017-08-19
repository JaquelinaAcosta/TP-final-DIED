/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.controller;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tpfinal.tp.guardarADisco.LibrosDao;
import tpfinal.tp.guardarADisco.PublicacionesDao;
import tpfinal.tp.guardarADisco.VideosDao;
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.integrador.Publicacion;
import tpfinal.tp.integrador.TemasMateriales;
import tpfinal.tp.integrador.Video;
import tpfinal.tp.vista.PageRank;
import tpfinal.tp.windows.PanelBorrarMaterial;
import tpfinal.tp.windows.PanelBuscarOrdenar;
import tpfinal.tp.windows.PanelContenedor;
import tpfinal.tp.windows.PanelLibro;
import tpfinal.tp.windows.PanelPublicacion;
import tpfinal.tp.windows.PanelResultadoBusquedaLibro;
import tpfinal.tp.windows.PanelResultadoBusquedaVP;
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
    private String crearBuscarDesde;
    private JFrame ventana;
    private JPanel panelCtrl;
    private ArrayList<MaterialCapacitacion> listaResultado;
    private TemasMateriales temaSeleccionado;
    
    private void inicializarPanelCtrl(){
        panelCtrl.setSize(500, 500);
        ventana.add(panelCtrl);

        ventana.add(panelCtrl, BorderLayout.PAGE_START);

        ventana.pack();
        }
    
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
     
     
     public void mostrarPanelLibro()
     {
      PanelLibro panel= new PanelLibro(this);
        panel.armarPanel();
        this.vistaPrincipal.getContentPane().removeAll();
        this.vistaPrincipal.getContentPane().add(panel);
        this.vistaPrincipal.revalidate();
        this.vistaPrincipal.pack();
     }
     public void mostrarBuscarOrdenar(List<? extends MaterialCapacitacion> listaMateriales, String desde)
     {
      PanelBuscarOrdenar panel= new PanelBuscarOrdenar(this, listaMateriales);
        this.crearBuscarDesde=desde;
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
     
     public void cambiarBuscarLibroVideoPublicacion(List<? extends MaterialCapacitacion> listaMateriales) throws Exception{
        if(crearBuscarDesde.equals("Libro")){
            PanelResultadoBusquedaLibro panelL= new PanelResultadoBusquedaLibro(this, listaMateriales);
            this.vistaPrincipal.getContentPane().removeAll();
            this.vistaPrincipal.getContentPane().add(panelL);
            this.vistaPrincipal.revalidate();
            this.vistaPrincipal.pack();
        }
        //si estamos con video o publicacion va a la ventana de buscar Video o publicacion.
        //donde pasamos la lista de materiales filtrada (esta lista fue filtrada en PanelBuscarOrdenar, metodo filtrar())
        if(crearBuscarDesde.equals("Video")){
            PanelResultadoBusquedaVP panelVP= new PanelResultadoBusquedaVP(this, listaMateriales);
            this.vistaPrincipal.getContentPane().removeAll();
            this.vistaPrincipal.getContentPane().add(panelVP);
            this.vistaPrincipal.revalidate();
            this.vistaPrincipal.pack();
        }
        if(crearBuscarDesde.equals("Publicación")){
            PanelResultadoBusquedaVP panelVP= new PanelResultadoBusquedaVP(this, listaMateriales);
            this.vistaPrincipal.getContentPane().removeAll();
            this.vistaPrincipal.getContentPane().add(panelVP);
            this.vistaPrincipal.revalidate();
            this.vistaPrincipal.pack();
        }      
    }

     public void cambiarAPanelBorrar(MaterialCapacitacion material){      
        if(crearBuscarDesde.equals("Libro")){
            PanelBorrarMaterial panel= new PanelBorrarMaterial(this, material);
            this.vistaPrincipal.getContentPane().removeAll();
            this.vistaPrincipal.getContentPane().add(panel);
            this.vistaPrincipal.revalidate();
            this.vistaPrincipal.pack();
        }
        if(crearBuscarDesde.equals("Video")){
            PanelBorrarMaterial panel= new PanelBorrarMaterial(this, material);
            this.vistaPrincipal.getContentPane().removeAll();
            this.vistaPrincipal.getContentPane().add(panel);
            this.vistaPrincipal.revalidate();
            this.vistaPrincipal.pack();
        }
        if(crearBuscarDesde.equals("Publicación")){
            PanelBorrarMaterial panel= new PanelBorrarMaterial(this, material);
            this.vistaPrincipal.getContentPane().removeAll();
            this.vistaPrincipal.getContentPane().add(panel);
            this.vistaPrincipal.revalidate();
            this.vistaPrincipal.pack();
        }
    }
     
    public void actualizarDatos(MaterialCapacitacion material){        
        if(crearBuscarDesde.equals("Libro")){
            PanelLibro panel= new PanelLibro(this, (Libro) material);
            this.vistaPrincipal.getContentPane().removeAll();
            this.vistaPrincipal.getContentPane().add(panel);
            this.vistaPrincipal.revalidate();
            this.vistaPrincipal.pack();
        }
        if(crearBuscarDesde.equals("Video")){
            PanelVideo panel= new PanelVideo(this, (Video) material);
            this.vistaPrincipal.getContentPane().removeAll();
            this.vistaPrincipal.getContentPane().add(panel);
            this.vistaPrincipal.revalidate();
            this.vistaPrincipal.pack();
        }
        if(crearBuscarDesde.equals("Publicación")){
            PanelPublicacion panel= new PanelPublicacion(this, (Publicacion) material);
            this.vistaPrincipal.getContentPane().removeAll();
            this.vistaPrincipal.getContentPane().add(panel);
            this.vistaPrincipal.revalidate();
            this.vistaPrincipal.pack();
        }
    
}
    
     public void cambiarDibujarNodo(TemasMateriales tema,List<? extends MaterialCapacitacion> listaMateriales) throws Exception{
              this.temaSeleccionado=tema;
              
              this.listaResultado= new ArrayList<MaterialCapacitacion>();
              listaResultado.addAll(listaMateriales);
       /**
        *si filtro desde la pantalla de busqueda de libro segun un TEMA
        * debo filtrar los otros materiales segun el mismo tema
        */
   VideosDao videoDao= new VideosDao();
   List<Video> listaVideo= new ArrayList<Video>();
  listaVideo=videoDao.cargarLista();
  listaVideo.removeIf(elem-> !elem.getTema().equals((TemasMateriales)tema));
 
       
  PublicacionesDao publicacionesDao= new PublicacionesDao();
  List<Publicacion> listaPublicaciones= new ArrayList<Publicacion>();
  listaPublicaciones=publicacionesDao.cargarLista();
  listaPublicaciones.removeIf(elem-> !elem.getTema().equals((TemasMateriales)tema));
  
  LibrosDao libroDao= new LibrosDao();
  List<Libro> listaLibro= new ArrayList<Libro>();
  listaLibro=libroDao.cargarLista();
  listaLibro.removeIf(elem-> !elem.getTema().equals((TemasMateriales)tema));
  
  if(crearBuscarDesde.equals("Libro")){
       listaResultado.addAll(listaVideo);
       listaResultado.addAll(listaPublicaciones);
       System.out.println(listaResultado);
       PanelContenedor panel = new PanelContenedor(this,listaResultado);
       this.vistaPrincipal.getContentPane().removeAll();
        this.vistaPrincipal.getContentPane().add(panel);
        this.vistaPrincipal.revalidate();
        this.vistaPrincipal.pack();
     
          }
           if(crearBuscarDesde.equals("Video")){
       listaResultado.addAll(listaLibro);
       listaResultado.addAll(listaPublicaciones);
       System.out.println(listaResultado);
       PanelContenedor panel= new PanelContenedor(this,listaResultado);
       this.vistaPrincipal.getContentPane().removeAll();
        this.vistaPrincipal.getContentPane().add(panel);
        this.vistaPrincipal.revalidate();
        this.vistaPrincipal.pack();
     
           }
        if(crearBuscarDesde.equals("Publicación")){
       listaResultado.addAll(listaLibro);
       listaResultado.addAll(listaVideo);
       System.out.println(listaResultado);
      PanelContenedor panel= new PanelContenedor(this,listaResultado);
      this.vistaPrincipal.getContentPane().removeAll();
        this.vistaPrincipal.getContentPane().add(panel);
        this.vistaPrincipal.revalidate();
        this.vistaPrincipal.pack();
        }
        }
     
     public void principal(){ 
        this.vistaPrincipal.getContentPane().removeAll();
        this.vistaPrincipal.revalidate();
        this.vistaPrincipal.pack();
    }
     
     public void cambiarPR(List lista){
         
        PageRank panel = new PageRank(this,lista);
        this.vistaPrincipal.getContentPane().removeAll();
        this.vistaPrincipal.getContentPane().add(panel);
        this.vistaPrincipal.revalidate();
        this.vistaPrincipal.pack();
   }
}
