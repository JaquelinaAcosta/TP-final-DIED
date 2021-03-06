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
        
    this.botonAceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                Suscriptor suscriptor = new Suscriptor(nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()), Double.parseDouble(credito.getText()));
             
                ArrayList lista = new ArrayList<Suscriptor>(SuscriptorDao.cargarLista());
                lista.add(suscriptor);
               SuscriptorDao.guardarLista(lista);
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
