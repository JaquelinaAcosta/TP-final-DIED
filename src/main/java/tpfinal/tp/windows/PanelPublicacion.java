/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tpfinal.tp.controller.MaterialCapacitacionController;
import tpfinal.tp.guardarADisco.PublicacionesDao;
import tpfinal.tp.integrador.Publicacion;
import tpfinal.tp.integrador.TemasMateriales;


public class PanelPublicacion extends JPanel {
  
    
    private JButton botonAceptar;
    private JButton botonCancelar;
    private JTextField txtTitulo;
    private JTextField txtDia;
    private JTextField txtMes;
    private JTextField txtAño;
    
    private JTextField txtPrecio;
    private JTextField txtCalificacion;
    private JTextField txtTema;
    private JComboBox comboTema;
    private PublicacionesDao publicacionesDao = new PublicacionesDao();
    private tpfinal.tp.ventanas.Principal principal;
    private Publicacion publicacion;
    private MaterialCapacitacionController controller;
    
   
    
      public void setController(MaterialCapacitacionController matctrl){
       this.controller=matctrl;
   }
      
  public PanelPublicacion(MaterialCapacitacionController contrl){
        this.controller = contrl;
    
  }
   
    public void armarPanel(){
        
        this.txtDia=new JTextField(6);
        this.txtMes=new JTextField (6);
        this.txtAño=new JTextField (6);
        // Panel de fecha
        JPanel panelFecha = new JPanel();
        panelFecha.setLayout(new FlowLayout());
        panelFecha.add(txtDia);
        panelFecha.add(new JLabel("/"));
        panelFecha.add(txtMes);
        panelFecha.add(new JLabel("/"));
        panelFecha.add(txtAño);        
        
        this.botonAceptar= new JButton("Aceptar");
        this.botonCancelar= new JButton("Volver a Principal");
        this.txtCalificacion= new JTextField(20);
//        this.txtFecha=new JTextField(20);
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
        this.add(panelFecha);
        this.add(new JLabel("Calificacion"));
        this.add(txtCalificacion);
        this.add(new JLabel("Precio"));
        this.add(txtPrecio);
        this.add(botonAceptar);
        this.add(botonCancelar);
               
        this.botonAceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                controller.crearPublicacion(txtTitulo.getText(),(TemasMateriales) comboTema.getSelectedItem(), (new Date((Integer.parseInt(txtAño.getText())-1900), (Integer.parseInt(txtMes.getText())-1), Integer.parseInt(txtDia.getText()))), Integer.parseInt(txtCalificacion.getText()), Double.parseDouble(txtPrecio.getText()));
               
            }
        });
        
        this.botonCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                principal.principal();
            }
    });
    }
    

}


     


