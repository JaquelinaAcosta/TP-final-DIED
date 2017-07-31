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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelMaterialCapacitacion extends JPanel {
    
    private JButton botonAceptar;
    private Principal principal;
    private JTextField suscritores;
    private JComboBox comboMaterial;

    public PanelMaterialCapacitacion(){
        this.armarPanelMaterial();
    }
    public PanelMaterialCapacitacion(Principal principal){
        this.principal = principal;
        this.armarPanelMaterial();
    }

    
    private void armarPanelMaterial(){
        this.suscritores= new JTextField(10);
        String[] listaMaterial = {"Libro", "Video", "Publicación"};
        this.comboMaterial= new JComboBox<>(listaMaterial);
        this.botonAceptar= new JButton("Aceptar");
        
        this.setLayout(new GridLayout(6,0, 10, 10));
        this.add(new JLabel("MATERIAL DE CAPACITACIÓN"));
        this.add(new JLabel("Elegir un material"));
        this.add(comboMaterial);
        this.add(botonAceptar);
        
        this.botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboMaterial.getSelectedItem().equals("Libro")){
                    principal.cambiarAPanelCrearBuscar("Libro");
                }
                if (comboMaterial.getSelectedItem().equals("Video")){
                    principal.cambiarAPanelCrearBuscar("Video");
                }
                if (comboMaterial.getSelectedItem().equals("Publicación")){
                    principal.cambiarAPanelCrearBuscar("Publicación");
                }
            }
        });
    }
}
