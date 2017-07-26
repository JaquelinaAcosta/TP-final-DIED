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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tpfinal.tp.guardarADisco.LibrosDao;
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.integrador.TemasMateriales;



public class PanelLibro extends JPanel{
    
//    private GrafoController controller;
    private JButton botonAceptar;
    private JButton botonCancelar;
    private JTextField txtTitulo;
    private JTextField txtIsbn;
    private JTextField txtPaginas;
    private JTextField txtPrecio;
    private JTextField txtCalificacion;
    private JComboBox comboTema;
    private Principal principal;
    private LibrosDao librosDao = new LibrosDao();
    private Libro libro;

    public PanelLibro(){
        this.armarPanel();
    }
    
    public PanelLibro(Principal principal){
        this.principal = principal;
        this.armarPanel();
    }
    
    //se usa cuando vamos a actualizar un libro de la lista de materiales, pasando el libro que vamos a modificar
    public PanelLibro(Principal principal, Libro libro){
        this.principal = principal;
        this.libro=libro;
        this.armarPanel();
    }
   
    private void armarPanel(){
        this.botonAceptar= new JButton("Aceptar");
        this.botonCancelar= new JButton("Cancelar");
        this.txtCalificacion= new JTextField(20);
        this.txtIsbn=new JTextField(20);
        this.txtPaginas=new JTextField(20);
        this.txtPrecio=new JTextField(20);
        //Para poder seleccion desde un ComboBox unon de los 3 temas que hay
        TemasMateriales[] listaTemas = {TemasMateriales.ENTRETENIMIENTO, TemasMateriales.MATEMATICA, TemasMateriales.PROGRAMACION};
        this.comboTema= new JComboBox<>(listaTemas);
        this.txtTitulo=new JTextField(20);
        
        
        //para que se visualicen los datos en la pantalla a la hora de actualizar un material de tipo video
        if(libro != null){
            txtTitulo.setText(libro.getTitulo());
            txtCalificacion.setText(libro.getCalificacion().toString());
            txtIsbn.setText(libro.getIsbn());
            txtPrecio.setText(libro.getCosto().toString());
            comboTema.getModel().setSelectedItem(libro.getTema()); 
            txtPaginas.setText(libro.getPaginas().toString());
        }
        
        
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
        this.add(comboTema);
        this.add(new JLabel("Calificacion"));
        this.add(txtCalificacion);
        this.add(new JLabel("Precio"));
        this.add(txtPrecio);
        this.add(botonAceptar);
        this.add(botonCancelar);
        
        //Al presionar el boton Aceptar te guarda todos los datos que ingrasas en un archivo JSON 
        //(como estamos trabajando con libro) el archivo se va a llamar Libros.jason y se va a guardar automaticamente en la carpeta de netbeans donde tenemos el tp integrador
        this.botonAceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                //si es para actualizar, entra en el if
                if(libro!=null){
                    Libro libro1 = new Libro(txtTitulo.getText(), Double.parseDouble(txtPrecio.getText()), txtIsbn.getText(), Integer.parseInt(txtPaginas.getText()), (TemasMateriales) comboTema.getSelectedItem(), Integer.parseInt(txtCalificacion.getText()));
                    librosDao.editar(libro, libro1);
                }
                else{
                    Libro libro1 = new Libro(txtTitulo.getText(), Double.parseDouble(txtPrecio.getText()), txtIsbn.getText(), Integer.parseInt(txtPaginas.getText()), (TemasMateriales) comboTema.getSelectedItem(), Integer.parseInt(txtCalificacion.getText()));
                    librosDao.agregar(libro1);
                }
            
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
