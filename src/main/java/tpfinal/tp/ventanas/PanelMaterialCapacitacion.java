/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelMaterialCapacitacion extends JPanel {
    
    private JButton botonLibro;
    private JButton botonVideo;
    private JButton botonPublicacion;
    private JButton botonBuscarSuscrip;
    private Principal principal;
    private JTextField suscritores;

    public PanelMaterialCapacitacion(){
        this.armarPanelMaterial();
    }
    public PanelMaterialCapacitacion(Principal principal){
        this.principal = principal;
        this.armarPanelMaterial();
    }

    
    private void armarPanelMaterial(){
        this.suscritores= new JTextField(10);
        this.botonLibro= new JButton("Libro");
        this.botonVideo= new JButton("Video");
        this.botonPublicacion= new JButton("Publicación");
        
        this.setLayout(new GridLayout(6,0));
        this.add(new JLabel("MATERIAL DE CAPACITACION"));
        this.add(new JLabel("Elegir un material"));
        this.add(botonLibro);
        this.add(botonVideo);
        this.add(botonPublicacion);
        
        
        this.botonLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.cambiarAPanelCrearBuscar("Libro");
            }
        });
        this.botonVideo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.cambiarAPanelCrearBuscar("Video");
            }
        });
        this.botonPublicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principal.cambiarAPanelCrearBuscar("Publicación");
            }
        });
    }
}
