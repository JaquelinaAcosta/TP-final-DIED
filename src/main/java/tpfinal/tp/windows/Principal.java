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
   private JMenu menu;
   private JMenuItem menuLibro,menuPublicacion,menuVideo;

  private MaterialCapacitacionController controller;

    public Principal() {
        
    controller = new MaterialCapacitacionController(this);
        
    menuMaterialCapacitacion = new JMenuBar();

        menu = new JMenu("Material de Capacitacion");
        menuMaterialCapacitacion.add(menu);

     
      menuLibro = new JMenuItem("Libro");
      menuLibro.addActionListener((e) -> {
            controller.mostrarPanelLibro();
        });
      menu.add(menuLibro);
      menu.addSeparator();//para mostrar la rayita que separa
      
      menuVideo = new JMenuItem("Video");
      menu.add(menuVideo);
      menu.addSeparator();
      
      menuPublicacion = new JMenuItem("Publicacion");
      menu.add(menuPublicacion);
      menu.addSeparator();

      
       this.setJMenuBar(menuMaterialCapacitacion);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
    }       
    
}


