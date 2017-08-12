/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.windows;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tpfinal.tp.controller.MaterialCapacitacionController;
import tpfinal.tp.guardarADisco.VideosDao;
import tpfinal.tp.integrador.TemasMateriales;
import tpfinal.tp.integrador.Video;


public class PanelVideo extends JPanel {
    private MaterialCapacitacionController controller;
    private JButton botonAceptar;
    private JButton botonCancelar;
    private JTextField txtTitulo;
    private JTextField txtDuracion;
    private JTextField txtPrecio;
    private JTextField txtCalificacion;
    private JComboBox comboTema;
    private tpfinal.tp.ventanas.Principal principal;
    private VideosDao videosDao = new VideosDao();
    private Video video;
    
      public PanelVideo(MaterialCapacitacionController contrl){
        this.controller = contrl;
    
      }
      
     
    
      public void setController(MaterialCapacitacionController matctrl)
   {
       this.controller=matctrl;
   }
      
      public void armarPanel()
      {
        this.botonCancelar= new JButton("Volver a Principal");
        this.txtCalificacion= new JTextField(20);
        this.txtDuracion=new JTextField(20);
        this.txtPrecio=new JTextField(20);
        TemasMateriales[] listaTemas = {TemasMateriales.ENTRETENIMIENTO, TemasMateriales.MATEMATICA, TemasMateriales.PROGRAMACION};
        this.comboTema= new JComboBox<>(listaTemas);
        this.txtTitulo=new JTextField(20);

      }
}
