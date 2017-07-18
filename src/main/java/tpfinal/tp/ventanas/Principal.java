/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.ventanas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Principal {
    private JFrame ventana;
    private JPanel panelCtrl;
    private String crearBuscarDesde;
    private String panelBuscarOrdenar;
    
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
        
        if(crearBuscarDesde.equals("Libro")){
            panelCtrl= new PanelBuscarOrdenar(this);
        }
        
        if(crearBuscarDesde.equals("Video")){
            panelCtrl= new PanelBuscarOrdenar(this);
        }
        
        if(crearBuscarDesde.equals("Publicación")){
            panelCtrl= new PanelBuscarOrdenar(this);
        }
        
        inicializarPanelCtrl();
    }
    
    public void cambiarAPanelCrearBuscar(String desde) {
        this.ventana.remove(this.panelCtrl);
        crearBuscarDesde = desde;
        panelCtrl = new CrearBuscarPanel(this);
        inicializarPanelCtrl();
    }
    
    
    //para cambiar a la pantalla de buscar y ordenar por.. segun lo que eligió      
    public void cambiarBuscarLibroVideoPublicacion() throws Exception{
        this.ventana.remove(this.panelCtrl);
        
        //si estamos con libros, va a cambiar a la ventana de buscar libro, donde tambien tiene la lista de suscriptores
        if(crearBuscarDesde.equals("Libro")){
            panelCtrl= new PanelBuscarLibro(this);
        }
        //si estamos con video o publicacion va a la ventana de buscar Video o publicacion.
        if(crearBuscarDesde.equals("Video")){
            panelCtrl= new PanelBuscarVideoPublicacion(this);
        }
        if(crearBuscarDesde.equals("Publicación")){
            panelCtrl= new PanelBuscarVideoPublicacion(this);
        }
        inicializarPanelCtrl();        
    }
    
    
    
}
