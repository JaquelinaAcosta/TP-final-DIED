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
    
    public PanelPublicacion(){
        this.armarPanel();
    }
      public void setController(MaterialCapacitacionController matctrl)
   {
       this.controller=matctrl;
   }
  public PanelPublicacion(MaterialCapacitacionController contrl){
        this.controller = contrl;
    
  }
   
    private void armarPanel(){
        
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
        
        
//        //para que se visualicen los datos en la pantalla a la hora de actualizar un material de tipo publicacion
//        if(publicacion != null){
//            txtTitulo.setText(publicacion.getTitulo());
//            txtCalificacion.setText(publicacion.getCalificacion().toString());
//            txtPrecio.setText(publicacion.getCosto().toString());
//            comboTema.getModel().setSelectedItem(publicacion.getTema());  
//            txtDia.setText(String.valueOf(publicacion.getFechaPublicacion().getDate()));
//            txtMes.setText(String.valueOf(publicacion.getFechaPublicacion().getMonth()+1));
//            txtAño.setText(String.valueOf(publicacion.getFechaPublicacion().getYear()+1900));
//        }
        
        
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
                //si es para actualizar, va a entrar al if
                if(publicacion != null){
                Publicacion publicacion1 = new Publicacion(txtTitulo.getText(),(TemasMateriales) comboTema.getSelectedItem(), (new Date((Integer.parseInt(txtAño.getText())-1900), (Integer.parseInt(txtMes.getText())-1), Integer.parseInt(txtDia.getText()))), Integer.parseInt(txtCalificacion.getText()), Double.parseDouble(txtPrecio.getText()));
                publicacionesDao.editar(publicacion, publicacion1);
                }
                //si es para crear va a entrar al else
                else{
                    Publicacion publicacion1 = new Publicacion(txtTitulo.getText(),(TemasMateriales) comboTema.getSelectedItem(), (new Date((Integer.parseInt(txtAño.getText())-1900), (Integer.parseInt(txtMes.getText())-1), Integer.parseInt(txtDia.getText()))), Integer.parseInt(txtCalificacion.getText()), Double.parseDouble(txtPrecio.getText()));
                    publicacionesDao.agregar(publicacion);
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
//     public static void main(String[] args) {
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                crearPublicacionShowGUI();
//
//            }
//        });
//    }
}


     


