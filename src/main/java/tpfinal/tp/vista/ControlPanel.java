/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tpfinal.tp.controller.GrafoController;


public class ControlPanel extends JPanel {
    
    private GrafoController controller;
    private JTextField txtNombreVertice1; 
     private JTextField txtNombreVertice2; 
     private JTextField cantSalto; 
    private JButton boton;

    public ControlPanel(){
        this.armarPanel();
    }
    /*En la clase ControlPanel, agregar los campos de ingresos de texto y el botón para poder indicar al
sistema que se necesita buscar un camino entre una arista origen, y una arista destino en
exactamente N saltos.*/
    private void armarPanel(){
        this.txtNombreVertice1 =new JTextField(20);
        this.txtNombreVertice2 =new JTextField(20);
        this.cantSalto =new JTextField(5); 
        this.boton= new JButton();
        
        this.add(new JLabel("Vertice Origen"));
        this.add(txtNombreVertice1);
        this.add(new JLabel("Vertice Destino"));
        this.add(txtNombreVertice2);  
        this.add(new JLabel("Cantidad de saltos"));   
        this.add(cantSalto);
        this.add(new JButton("Buscar Camino"));
        this.add(boton);
        
        boton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            try{
            
             controller.buscarCamino(txtNombreVertice1.getText(), txtNombreVertice2.getText(), Integer.parseInt(cantSalto.getText()));
          //  controller.buscarCamino(txtNombreVertice1, txtNombreVertice2, cantSalto);
            }catch(Exception ex){
            System.out.println("Error");
            }
        }
    });
}
    
    /*Capturar el evento en el botón, validar los datos (los 3 valores son obligatorios y la cantidad de
saltos debe coincidir con un valor entero) e invocar al método del controlador “public void
buscarCamino(String nodo1,String nodo2,Integer saltos)”, para que se realice una búsqueda.*/

    public GrafoController getController() {
        return controller;
    }

    public void setController(GrafoController controller) {
        this.controller = controller;
    }

    
    
}

