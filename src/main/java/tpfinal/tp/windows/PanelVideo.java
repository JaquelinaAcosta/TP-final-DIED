/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
        this.botonAceptar= new JButton("Aceptar");
        
        this.setLayout(new GridLayout(10,1,10,10));
        this.add(new JLabel("VIDEO"));
        this.add(new JLabel("Cargar datos"));
        this.add(new JLabel("Título"));
        this.add(txtTitulo);
        this.add(new JLabel("Tema"));
        this.add(comboTema);
        this.add(new JLabel("Duración"));
        this.add(txtDuracion);
        this.add(new JLabel("Calificacion"));
        this.add(txtCalificacion);
        this.add(new JLabel("Precio"));
        this.add(txtPrecio);
        this.add(botonAceptar);
        this.add(botonCancelar);
    
        this.botonAceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
   
      controller.crearVideo(txtTitulo.getText(), (TemasMateriales) comboTema.getSelectedItem(), Integer.parseInt(txtDuracion.getText()), Integer.parseInt(txtCalificacion.getText()), Double.parseDouble(txtPrecio.getText()));
            }
        });
               
    }
      
}