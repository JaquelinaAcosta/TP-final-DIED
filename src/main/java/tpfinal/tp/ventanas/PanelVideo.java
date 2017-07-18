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
 *
 * @author jaque
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

    public PanelVideo(){
        this.armarPanel();
    }
   
    public PanelVideo(Principal principal){
        this.principal = principal;
        this.armarPanel();
    }
    
    private void armarPanel(){
        this.botonAceptar= new JButton("Aceptar");
        this.botonCancelar= new JButton("Cancelar");
        this.txtCalificacion= new JTextField(20);
        this.txtDuracion=new JTextField(20);
        this.txtPrecio=new JTextField(20);
        TemasMateriales[] listaTemas = {TemasMateriales.ENTRETENIMIENTO, TemasMateriales.MATEMATICA, TemasMateriales.PROGRAMACION};
        this.comboTema= new JComboBox<>(listaTemas);
        this.txtTitulo=new JTextField(20);



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
                Video video = new Video(txtTitulo.getText(), (TemasMateriales) comboTema.getSelectedItem(), Integer.parseInt(txtDuracion.getText()), Integer.parseInt(txtCalificacion.getText()), Double.parseDouble(txtPrecio.getText()));
                ArrayList lista = new ArrayList<Video>(videosDao.cargarLista());
                lista.add(video);
                videosDao.guardarLista(lista);
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
