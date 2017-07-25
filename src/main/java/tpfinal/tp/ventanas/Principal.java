/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.ventanas;

import java.awt.BorderLayout;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tpfinal.tp.guardarADisco.LibrosDao;
import tpfinal.tp.guardarADisco.PublicacionesDao;
import tpfinal.tp.guardarADisco.VideosDao;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.integrador.Publicacion;
import tpfinal.tp.integrador.TemasMateriales;
import tpfinal.tp.integrador.Video;


public class Principal {
    private JFrame ventana;
    private JPanel panelCtrl;
    private String crearBuscarDesde;
    private PanelBuscarOrdenar panelBuscarOrdenar;
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Principal principal = new Principal();
                principal.createAndShowGUI();

            }
        });
    }
    
    private void createAndShowGUI() {
        ventana = new JFrame("Biblioteca");
        ventana.setSize(600, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelCtrl = new PanelMaterialCapacitacion(this);    
        inicializarPanelCtrl();
        ventana.setVisible(true);    
    }    
    
    private void inicializarPanelCtrl(){
        panelCtrl.setSize(300, 200);
        ventana.add(panelCtrl);

        ventana.add(panelCtrl, BorderLayout.PAGE_START);

        ventana.pack();
        }

   
    public void crearLibro()
    {
        this.ventana.remove(this.panelCtrl); 
      //   if(crearBuscarDesde.equals("Libro")){
            panelCtrl = new PanelLibro(this);
        }
    

    public void cambiarAPanelCrear() {
        this.ventana.remove(this.panelCtrl);

        if(crearBuscarDesde.equals("Libro")){
            panelCtrl = new PanelLibro(this);
        }
        if(crearBuscarDesde.equals("Video")){
            panelCtrl = new PanelVideo(this);
        }
        if(crearBuscarDesde.equals("Publicación")){
            panelCtrl = new PanelPublicacion(this);
        }
        inicializarPanelCtrl();
    }
    
    public void cambiarAPanelBuscar(){
        this.ventana.remove(this.panelCtrl);
        //como vamos a buscar, necesitamos importar los datos de las listas, segun el material en el que estemos
        //para importar llamamos al metodo cargarLista de las Clases Dao
        if(crearBuscarDesde.equals("Libro")){
            LibrosDao librosDao=new LibrosDao();
            panelCtrl= new PanelBuscarOrdenar(this, librosDao.cargarLista());
        }
        
        if(crearBuscarDesde.equals("Video")){
            VideosDao videosDao = new VideosDao();
            panelCtrl= new PanelBuscarOrdenar(this, videosDao.cargarLista());
        }
        
        if(crearBuscarDesde.equals("Publicación")){
            PublicacionesDao publicacionesDao=new PublicacionesDao();
            panelCtrl= new PanelBuscarOrdenar(this, publicacionesDao.cargarLista());
        }
        
        inicializarPanelCtrl();
    }
    
    public void cambiarAPanelCrearBuscar(String desde) {
        this.ventana.remove(this.panelCtrl);
        crearBuscarDesde = desde;
        panelCtrl = new CrearBuscarPanel(this);
        inicializarPanelCtrl();
    }
    
    
    //para cambiar a la pantalla de buscar y ordenar por.. segun lo que eligió, con la lista filtrada resultado de filtrar() en PanelBuscarOrdenar      
    public void cambiarBuscarLibroVideoPublicacion(List<? extends MaterialCapacitacion> listaMateriales) throws Exception{
        this.ventana.remove(this.panelCtrl);
        
        //si estamos con libros, va a cambiar a la ventana de buscar libro, donde tambien tiene la lista de suscriptores
        //donde pasamos la lista de materiales filtrada (esta lista fue filtrada en PanelBuscarOrdenar, metodo filtrar())
        if(crearBuscarDesde.equals("Libro")){
            panelCtrl= new PanelBuscarLibro(this, listaMateriales);
        }
        //si estamos con video o publicacion va a la ventana de buscar Video o publicacion.
        //donde pasamos la lista de materiales filtrada (esta lista fue filtrada en PanelBuscarOrdenar, metodo filtrar())
        if(crearBuscarDesde.equals("Video")){
            //Para pasar la lista filtrada a la ventana siguiente(PanelBuscarVideoPublicacion), 
            //desde la ventana (PanelBuscarOrdenar)
            panelCtrl= new PanelBuscarVideoPublicacion(this, listaMateriales);
        }
        if(crearBuscarDesde.equals("Publicación")){
            panelCtrl= new PanelBuscarVideoPublicacion(this, listaMateriales);
        }
        inicializarPanelCtrl();        
    }
    
    //esta funcion va a dibujar los nodos segun el tema que se filtro
      public void cambiarDibujarNodo(Enum tema,List<? extends MaterialCapacitacion> listaMateriales) throws Exception{
              this.ventana.remove(this.panelCtrl);
       /**
        *si filtro desde la pantalla de busqueda de libro segun un TEMA
        * debo filtrar los otros materiales segun el mismo tema
        */
          if(crearBuscarDesde.equals("Libro")){
              Video video= new Video();
          VideosDao videoDao= new VideosDao();
            List<? extends MaterialCapacitacion> listaRtdoVideo;
          List<? extends MaterialCapacitacion> listaVideo= videoDao.cargarLista();
         listaVideo.removeIf(x-> x.getTema().equals((TemasMateriales)tema));
     
     // listaMateriales.removeIf(material -> ! material.getTema().equals((TemasMateriales) comboTema.getSelectedItem()));             
          PublicacionesDao publicacionesDao= new PublicacionesDao();
          List<? extends MaterialCapacitacion> listaPublicaciones= publicacionesDao.cargarLista();
         
            }
         LibrosDao librosDao= new LibrosDao();
         List<? extends MaterialCapacitacion> listaLibro= librosDao.cargarLista();
         
        }
      
    
    //ignorar es para borrar, no lo termine de trabajar
    public void cambiarAPanelBorrar(MaterialCapacitacion material){
        this.ventana.remove(this.panelCtrl);
        
        if(crearBuscarDesde.equals("Libro")){
            panelCtrl= new PanelBorrar(this, material);
        }
        if(crearBuscarDesde.equals("Video")){
            panelCtrl= new PanelBorrar(this, material);
        }
        if(crearBuscarDesde.equals("Publicación")){
            panelCtrl= new PanelBorrar(this, material);
        }
        inicializarPanelCtrl();
    }
    
    
    //va al panel de crear (Libro, Video, Publicacion), para actualizar los datos
    public void actualizarDatos(MaterialCapacitacion material){
        this.ventana.remove(this.panelCtrl);
        
//        if(crearBuscarDesde.equals("Libro")){
//            panelCtrl= new PanelLibro(this, listaMateriales);
//        }
        if(crearBuscarDesde.equals("Video")){
            panelCtrl= new PanelVideo(this, (Video) material);
        }
        if(crearBuscarDesde.equals("Publicación")){
            panelCtrl= new PanelPublicacion(this, (Publicacion) material);
        }
        inicializarPanelCtrl();
    
}
    
}
