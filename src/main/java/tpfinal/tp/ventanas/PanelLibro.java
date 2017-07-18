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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tpfinal.tp.guardarADisco.LibrosDao;
import tpfinal.tp.integrador.Libro;



public class PanelLibro extends JPanel{
    
//    private GrafoController controller;
    private JButton botonAceptar;
    private JButton botonCancelar;
    private JTextField txtTitulo;
    private JTextField txtIsbn;
    private JTextField txtPaginas;
    private JTextField txtPrecio;
    private JTextField txtCalificacion;
    private JTextField txtTema;
    private Principal principal;
    private LibrosDao librosDao = new LibrosDao();

    public PanelLibro(){
        this.armarPanel();
    }
    
    public PanelLibro(Principal principal){
        this.principal = principal;
        this.armarPanel();
    }
   
    private void armarPanel(){
        this.botonAceptar= new JButton("Aceptar");
        this.botonCancelar= new JButton("Cancelar");
        this.txtCalificacion= new JTextField(20);
        this.txtIsbn=new JTextField(20);
        this.txtPaginas=new JTextField(20);
        this.txtPrecio=new JTextField(20);
        this.txtTema=new JTextField(20);
        this.txtTitulo=new JTextField(20);
        
        
        
        this.setLayout(new GridLayout(10,1,10,10));
        this.add(new JLabel("LIBRO"));
        this.add(new JLabel("Cargar datos"));
        this.add(new JLabel("Título"));
        this.add(txtTitulo);
        this.add(new JLabel("ISBN"));
        this.add(txtIsbn);
        this.add(new JLabel("Cantidad de pagnas"));
        this.add(txtPaginas);
        this.add(new JLabel("Tema"));
        this.add(txtTema);
        this.add(new JLabel("Calificacion"));
        this.add(txtCalificacion);
        this.add(new JLabel("Precio"));
        this.add(txtPrecio);
        this.add(botonAceptar);
        this.add(botonCancelar);
        
        this.botonAceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                Libro libro = new Libro(txtTitulo.getText(), Double.parseDouble(txtPrecio.getText()), txtIsbn.getText(), Integer.parseInt(txtPaginas.getText()), (txtTema.getText().toString()), Integer.parseInt(txtCalificacion.getText()));
                ArrayList lista = new ArrayList<Libro>(librosDao.cargarLista());
                lista.add(libro);
                librosDao.guardarLista(lista);
            }
        });
    }
    
     
private static void crearLibroShowGUI(){
        JFrame ventana = new JFrame("Biblioteca");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelLibro libroPanel = new PanelLibro();
        libroPanel.setSize(300, 200);
        ventana.add(libroPanel);
    
        ventana.add(libroPanel, BorderLayout.PAGE_START);
        
        ventana.pack();
        ventana.setVisible(true);
}
}
