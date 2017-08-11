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
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.integrador.TemasMateriales;


public class PanelLibro extends JPanel {
    MaterialCapacitacionController controller;
    private JButton botonAceptar;
    private JButton botonCancelar;
    private JTextField txtCalificacion;
    private JTextField txtIsbn;
    private JTextField txtPaginas;
    private JTextField txtPrecio;
    private JComboBox<TemasMateriales> comboTema;
    private JTextField txtTitulo;
    
   
    
   public void setController(MaterialCapacitacionController matctrl)
   {
       this.controller=matctrl;
   }
   
    public PanelLibro(MaterialCapacitacionController contrl){
        this.controller = contrl;
    }
    
   public void armarPanel(){
       this.botonAceptar= new JButton("Aceptar");
        this.botonCancelar= new JButton("Volver a Principal");
        this.txtCalificacion= new JTextField(20);
        this.txtIsbn=new JTextField(20);
        this.txtPaginas=new JTextField(20);
        this.txtPrecio=new JTextField(20);
        //Para poder seleccion desde un ComboBox unon de los 3 temas que hay
        TemasMateriales[] listaTemas = {TemasMateriales.ENTRETENIMIENTO, TemasMateriales.MATEMATICA, TemasMateriales.PROGRAMACION};
        this.comboTema= new JComboBox<>(listaTemas);
        this.txtTitulo=new JTextField(20);
        
        
        //para que se visualicen los datos en la pantalla a la hora de actualizar un material de tipo video
//        if(libro != null){
//            txtTitulo.setText(libro.getTitulo());
//            txtCalificacion.setText(libro.getCalificacion().toString());
//            txtIsbn.setText(libro.getIsbn());
//            txtPrecio.setText(libro.getCosto().toString());
//            comboTema.getModel().setSelectedItem(libro.getTema()); 
//            txtPaginas.setText(libro.getPaginas().toString());
//        }
        
        
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
//        this.botonAceptar.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed (ActionEvent e){
//                //si es para actualizar, entra en el if
//                if(libro!=null){
//                    Libro libro1 = new Libro(txtTitulo.getText(), Double.parseDouble(txtPrecio.getText()), txtIsbn.getText(), Integer.parseInt(txtPaginas.getText()), (TemasMateriales) comboTema.getSelectedItem(), Integer.parseInt(txtCalificacion.getText()));
//                  //  librosDao.editar(libro, libro1);
//                }
//                else{
//                    Libro libro1 = new Libro(txtTitulo.getText(), Double.parseDouble(txtPrecio.getText()), txtIsbn.getText(), Integer.parseInt(txtPaginas.getText()), (TemasMateriales) comboTema.getSelectedItem(), Integer.parseInt(txtCalificacion.getText()));
//                   // librosDao.agregar(libro1);
//                }
//            
//            }
 //       });
        this.botonCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
               // principal.principal();
            }
    });

    }
   }

