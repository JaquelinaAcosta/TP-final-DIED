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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tpfinal.tp.guardarADisco.SuscriptoresDao;
import tpfinal.tp.integrador.Suscriptor;

/**
 *Clase creada para cargar los suscriptores en un archivo json
 * para poder realizar la parte 3,solo se usa como clase auxiliar
 * 
 */
public class PanelSuscriptor extends JPanel {
 
    private JButton botonAceptar;
    private JButton botonCancelar;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField credito;
    private JTextField dni;
    private SuscriptoresDao SuscriptorDao = new SuscriptoresDao();

    
    public PanelSuscriptor(){
        this.armarPanel();
    }
    
    public void armarPanel(){
    
        this.botonAceptar= new JButton("Aceptar");
        this.nombre= new JTextField();
        this.apellido= new JTextField();
        this.dni= new JTextField();
        this.credito= new JTextField();
        this.add(new JLabel("Suscriptor"));
           this.add(new JLabel("Nombre"));
        this.add(nombre);
           this.add(new JLabel("Apellido"));
        this.add(apellido);
           this.add(new JLabel("DNI"));
        this.add(dni);
           this.add(new JLabel("Credito"));
        this.add(credito);
        this.add(botonAceptar);
       
        this.setLayout(new GridLayout (20, 10, 10, 10));

        this.add(new JLabel("Cargar datos"));
        
     //Al presionar el boton Aceptar te guarda todos los datos que ingrasas en un archivo JSON 
    //(como estamos trabajando con libro) el archivo se va a llamar Libros.jason y se va a guardar automaticamente en la carpeta de netbeans donde tenemos el tp integrador
    this.botonAceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                //creamos un Suscriptor, poniendo en orden los campos de texto segun como lo tenemos en el constructor
                //de la clase suscriptor que esta en el paquete Integrador
                // con ctrl y seleccionando libro te lleva al consructor que también lo comenté
                Suscriptor suscriptor = new Suscriptor(nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()), Double.parseDouble(credito.getText()));
                //creo un array porque guarda todos los datos en un array
                //ArrayList<Suscriptor>(SuscriptorDao.cargarLista())
                //eso si lo hago ArrayList<sUSCRIPTOR>() sin la parte de adentro,o sea sin (librosDao.cargarLista(), me los guarda pero me va a ir borrando lo que tenia anteriormente,
                //por eso llamo a cargarLista y al array que devuelve le agreg//o el nuevo (osea el array que estoy cargando actualmente)
 // Libro libro = new Libro(txtTitulo.getText(), Double.parseDouble(txtPrecio.getText()), txtIsbn.getText(), Integer.parseInt(txtPaginas.getText()), (TemasMateriales) comboTema.getSelectedItem(), Integer.parseInt(txtCalificacion.getText()));

                ArrayList lista = new ArrayList<Suscriptor>(SuscriptorDao.cargarLista());
                lista.add(suscriptor);
                //En guardar lista guardaaas los anteriores y el nuevo
                //cargarLista y guardarLista son de la clase LibrosDao del paquete guardarADisco, la cual es la encargada de exporta los datos al archivo Libros.json automaticacmente
                SuscriptorDao.guardarLista(lista);
                //despues todo lo que es exportar y como lo hace es problema de la clase LibrosDao que llama y maneja todo con la clase GenericDaoJSON
                //Lo unico que hace esto es ir guardando datos en una lista, usando la clase LibrosDao, despues lo que es la exportacion es tema de LibrosDao y GenericDao y eso no lo tocas 
            }
        });
    }

    
    private static void crear(){
        JFrame ventana = new JFrame("Suscriptor");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelSuscriptor susPanel = new PanelSuscriptor();
        susPanel.setSize(300, 200);
        ventana.add(susPanel);
        ventana.add(susPanel, BorderLayout.PAGE_START);        
        ventana.pack();
        ventana.setVisible(true);
}
    
 public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          PanelSuscriptor suscriptorPanel = new PanelSuscriptor();  
          suscriptorPanel.crear();
          
        }
    });
    
}
    
}//fin de tdoo
