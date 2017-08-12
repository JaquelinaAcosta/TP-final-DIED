/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import tpfinal.tp.guardarADisco.VideosDao;
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.integrador.TemasMateriales;
import tpfinal.tp.integrador.Video;

/**
 *Clase que maneja la creacion y modificacion de un Video
 * 
 */
public class PanelVideo extends JPanel{
    
    private JButton botonAceptar;
    private JButton botonCancelar;
    private JTextField txtTitulo;
    private JTextField txtDuracion;
    private JTextField txtPrecio;
    private JTextField txtCalificacion;
    private JComboBox comboTema;
    private Principal principal;
    private VideosDao videosDao = new VideosDao();
    private Video video;

    public PanelVideo(){
        this.armarPanel();
    }
   
    public PanelVideo(Principal principal){
        this.principal = principal;
        this.armarPanel();
    }
    
    //se usa cuando vamos a actualizar un video de la lista de materiales, pasando el video que vamos a modificar
    public PanelVideo(Principal principal, Video video){
        this.principal = principal;
        this.video=video;
        this.armarPanel();
    }

    public PanelVideo(tpfinal.tp.windows.Principal vistaPrincipal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void armarPanel(){
        this.botonAceptar= new JButton("Aceptar");
        this.botonCancelar= new JButton("Volver a Principal");
        this.txtCalificacion= new JTextField(20);
        this.txtDuracion=new JTextField(20);
        this.txtPrecio=new JTextField(20);
        TemasMateriales[] listaTemas = {TemasMateriales.ENTRETENIMIENTO, TemasMateriales.MATEMATICA, TemasMateriales.PROGRAMACION};
        this.comboTema= new JComboBox<>(listaTemas);
        this.txtTitulo=new JTextField(20);

        //para que se visualicen los datos en la pantalla a la hora de actualizar un material de tipo video
        if(video != null){
            txtTitulo.setText(video.getTitulo());
            txtCalificacion.setText(video.getCalificacion().toString());
            txtDuracion.setText(video.getDuracionEnSegundos().toString());
            txtPrecio.setText(video.getCosto().toString());
            comboTema.getModel().setSelectedItem(video.getTema());            
        }


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
                //si es para actualizar, entrar en el if
                if(video!= null){
                    Video video1 = new Video(txtTitulo.getText(), (TemasMateriales) comboTema.getSelectedItem(), Integer.parseInt(txtDuracion.getText()), Integer.parseInt(txtCalificacion.getText()), Double.parseDouble(txtPrecio.getText()));
                    videosDao.editar(video, video1);
                }
                //si es para crear va a entrar al else
                else{
                    Video video1 = new Video(txtTitulo.getText(), (TemasMateriales) comboTema.getSelectedItem(), Integer.parseInt(txtDuracion.getText()), Integer.parseInt(txtCalificacion.getText()), Double.parseDouble(txtPrecio.getText()));
                    videosDao.agregar(video1);
                }
            }
        });
    
    this.botonCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                principal.principal();
            }
    });
    }
       
private static void crearVideoShowGUI(){
        JFrame ventana = new JFrame("Biblioteca");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelVideo videoPanel = new PanelVideo();
        videoPanel.setSize(300, 200);
        ventana.add(videoPanel);
    
        ventana.add(videoPanel, BorderLayout.PAGE_START);
        
        ventana.pack();
        ventana.setVisible(true);
}
//public static void main(String[] args) {
//    javax.swing.SwingUtilities.invokeLater(new Runnable() {
//        public void run() {
//            PanelVideo pVideo=new PanelVideo();
//            pVideo.crearVideoShowGUI();
//        }
//    });
//}
}
