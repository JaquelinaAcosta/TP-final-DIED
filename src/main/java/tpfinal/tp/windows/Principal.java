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


public class Principal extends JFrame {
    //Where the GUI is created:
   private JMenuBar menuMaterialCapacitacion;
   private JMenu menu, submenu;
   private JMenuItem menuItem;
   
//    private JRadioButtonMenuItem rbMenuItem;
//    private JCheckBoxMenuItem cbMenuItem;
//    private MaterialCapacitacionController controller;

    public Principal() {
        
//        controller = new MaterialCapacitacionController(this);
//        
    menuMaterialCapacitacion = new JMenuBar();

        menu = new JMenu("Material de Capacitacion");
        menuMaterialCapacitacion.add(menu);
//
//        menuItem = new JMenuItem("Libro");
//        menuItem.addActionListener((e) -> {
//            controller.mostrarFormPlato();
//        });

//        menu.add(menuItem);
//        menuItem = new JMenuItem("Publicaciones");
//        menu.add(menuItem);
//        menu.addSeparator();
//
    //    menuItem = new JMenuItem("Video");
//        menuItem.addActionListener((e) -> {
//            controller.mostrarFormPlato();
//        });

//        menuItem = new JMenuItem("Compras", new ImageIcon("imagenes/unicono.png"));
//        menuItem.setMnemonic(KeyEvent.VK_B);
//        menu.add(menuItem);
//
//        
//        menu = new JMenu("Cuenta");
//        menuBar.add(menu);
//
//        menuItem = new JMenuItem("Comanda");
//        menu.add(menuItem);
//
//        submenu = new JMenu("A submenu");
//        menu.add(submenu);
//
//        menuItem = new JMenuItem("Pago");
//        menu.add(menuItem);
//
//        menuItem = new JMenuItem("Cuenta", new ImageIcon("imagenes/unicono.png"));
//        menuItem.setMnemonic(KeyEvent.VK_B);
//        menu.add(menuItem);
//     
//        menuBar.add(menu);
//
//        this.setJMenuBar(menuBar);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//    }       
//    
}

}
