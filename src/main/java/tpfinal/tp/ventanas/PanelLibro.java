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
        //Para poder seleccion desde un ComboBox unon de los 3 temas que hay
        TemasMateriales[] listaTemas = {TemasMateriales.ENTRETENIMIENTO, TemasMateriales.MATEMATICA, TemasMateriales.PROGRAMACION};
        this.comboTema= new JComboBox<>(listaTemas);
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
                //creamos un libro, poniendo en orden los campos de texto segun como lo tenemos en el constructor de la clase Libro que esta en el paquete Integrador
                // con ctrl y seleccionando libro te lleva al consructor que también lo comenté
                Libro libro = new Libro(txtTitulo.getText(), Double.parseDouble(txtPrecio.getText()), txtIsbn.getText(), Integer.parseInt(txtPaginas.getText()), (TemasMateriales) comboTema.getSelectedItem(), Integer.parseInt(txtCalificacion.getText()));
                //creo un array porque guarda todos los datos en un array
                //ArrayList<Libro>(librosDao.cargarLista()) eso si lo hago ArrayList<Libro>() sin la parte de adentro,o sea sin (librosDao.cargarLista(), me los guarda pero me va a ir borrando lo que tenia anteriormente,
                //por eso llamo a cargarLista y al array que devuelve le agrego el nuevo (osea el array que estoy cargando actualmente)
                ArrayList lista = new ArrayList<Libro>(librosDao.cargarLista());
                lista.add(libro);
                //En guardar lista guardaaas los anteriores y el nuevo
                //cargarLista y guardarLista son de la clase LibrosDao del paquete guardarADisco, la cual es la encargada de exporta los datos al archivo Libros.json automaticacmente
                librosDao.guardarLista(lista);
                //despues todo lo que es exportar y como lo hace es problema de la clase LibrosDao que llama y maneja todo con la clase GenericDaoJSON
                //Lo unico que hace esto es ir guardando datos en una lista, usando la clase LibrosDao, despues lo que es la exportacion es tema de LibrosDao y GenericDao y eso no lo tocas 
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
