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
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tpfinal.tp.guardarADisco.PublicacionesDao;
import tpfinal.tp.integrador.Publicacion;
import tpfinal.tp.integrador.TemasMateriales;


public class PanelPublicacion extends JPanel{
    
    private JButton botonAceptar;
    private JButton botonCancelar;
    private JTextField txtTitulo;
    private JTextField txtFecha;
    private JTextField txtPrecio;
    private JTextField txtCalificacion;
    private JTextField txtTema;
    private JComboBox comboTema;
    private PublicacionesDao publicacionesDao = new PublicacionesDao();
    private Principal principal;
    
    public PanelPublicacion(){
        this.armarPanel();
    }
    
    public PanelPublicacion(Principal principal){
        this.principal = principal;
        this.armarPanel();
    }
   
    private void armarPanel(){
        this.botonAceptar= new JButton("Aceptar");
        this.botonCancelar= new JButton("Cancelar");
        this.txtCalificacion= new JTextField(20);
        this.txtFecha=new JTextField(20);
        this.txtPrecio=new JTextField(20);
        //Para poder seleccion desde un ComboBox unon de los 3 temas que hay
        TemasMateriales[] listaTemas = {TemasMateriales.ENTRETENIMIENTO, TemasMateriales.MATEMATICA, TemasMateriales.PROGRAMACION};
        this.comboTema= new JComboBox<>(listaTemas);

        this.txtTitulo=new JTextField(20);
        
        
        
        this.setLayout(new GridLayout(10,1,10,10));
        this.add(new JLabel("PUBLICACION"));
        this.add(new JLabel("Cargar datos"));
        this.add(new JLabel("Título"));
        this.add(txtTitulo);
        this.add(new JLabel("Tema"));
        this.add(comboTema);
        this.add(new JLabel("Fecha"));
        this.add(txtFecha);
        this.add(new JLabel("Calificacion"));
        this.add(txtCalificacion);
        this.add(new JLabel("Precio"));
        this.add(txtPrecio);
        this.add(botonAceptar);
        this.add(botonCancelar);
        
        this.botonAceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                Publicacion publicacion = new Publicacion(txtTitulo.getText(),(TemasMateriales) comboTema.getSelectedItem(), (txtFecha.getText()), Integer.parseInt(txtCalificacion.getText()), Double.parseDouble(txtPrecio.getText()));
                ArrayList lista = new ArrayList<>(publicacionesDao.cargarLista());
                lista.add(publicacion);
                publicacionesDao.guardarLista(lista);
            }
        });
    }
    
     
    private static void crearPublicacionShowGUI(){
        JFrame ventana = new JFrame("Biblioteca");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelPublicacion publicacionPanel = new PanelPublicacion();
        publicacionPanel.setSize(300, 200);
        ventana.add(publicacionPanel);
    
        ventana.add(publicacionPanel, BorderLayout.PAGE_START);
        
        ventana.pack();
        ventana.setVisible(true);
}
}
