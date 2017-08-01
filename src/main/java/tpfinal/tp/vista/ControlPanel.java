/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tpfinal.tp.controller.GrafoController;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.ventanas.Principal;

public class ControlPanel extends JPanel {
    
    private GrafoController controller;
    private JTextField txtNombreVertice1; 
     private JTextField txtNombreVertice2; 
     private JTextField cantSalto; 
    private JButton boton;
    private JComboBox<Object> comboMaterial;
    private Principal principal;
    private ArrayList<MaterialCapacitacion> listaRtdo;
    private JList enList;
    
    
    public ControlPanel(){
        this.armarPanel();
    }
    
     public ControlPanel(Principal principal,ArrayList<MaterialCapacitacion> lista){
         this.principal=principal;
         this.listaRtdo=lista;
         System.out.println("esta lista recibi"+listaRtdo);
        this.armarPanel();
    }
      public ControlPanel(ArrayList<MaterialCapacitacion> lista){
         this.listaRtdo=lista;
         System.out.println("esta lista recibi"+listaRtdo.get(0).getTitulo());
        this.armarPanel();
    }
    /*En la clase ControlPanel, agregar los campos de ingresos de texto y el botÃ³n para poder indicar al
sistema que se necesita buscar un camino entre una arista origen, y una arista destino en
exactamente N saltos.*/
    private void armarPanel(){
        
      String nodo[]={"nodo1","nodo2","nodo3"};
        
         this.enList= new JList();      
        this.txtNombreVertice1 =new JTextField(20);
        this.txtNombreVertice2 =new JTextField(20);
        this.cantSalto =new JTextField(5); 
        this.boton= new JButton("Buscar Camino");
       this.comboMaterial= new JComboBox<>();
          for(int i=0;i<listaRtdo.size();i++)
        {
            comboMaterial.addItem(listaRtdo.get(i).getTitulo());
        }
        this.add(new JLabel("Vertice Origen"));
        this.add(txtNombreVertice1);
        this.add(new JLabel("Vertice Destino"));
        this.add(txtNombreVertice2);  
        this.add(new JLabel("Cantidad de saltos"));   
        this.add(cantSalto);
        this.add(boton);
         this.add(comboMaterial);
     //   this.add(enList);
      
        
        
          addMouseListener(new MouseAdapter() {
            //Se llama cuando se oprime y se suelta un botÃ³n en el mouse.
            public void mouseClicked(MouseEvent event) {
                if (event.getClickCount() == 2 && !event.isConsumed()) {
                    event.consume();
                    System.out.println("posicion x "+event.getX());
                    System.out.println("posicion y "+event.getY());
                    // controller.crearVertice(event.getX(),event.getY(), Color.yellow, "seleccion");
                }
            }
          });
        
        comboMaterial.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
//            try{
                String seleccion=comboMaterial.getSelectedItem().toString();
                MaterialCapacitacion m=listaRtdo.get(comboMaterial.getSelectedIndex());
                System.out.println("material"+m);
                controller.titulo(seleccion);
                controller.getMaterial(m);
                controller.mostrarAristas();
     
                
//            }catch(Exception ex){
//            System.out.println("Error");
//            }
          }
       });
        
        boton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            try{
            if(cantSalto.getText().isEmpty())//va a la funcion de buscar tdos los caminos
            {
            
            }
            else
            {
      controller.buscarCamino(txtNombreVertice1.getText(), txtNombreVertice2.getText(), Integer.parseInt(cantSalto.getText()));
          
            }
            }catch(Exception ex){
            System.out.println("Error");
            }
        }
    });
}
    
    /*Capturar el evento en el botÃ³n, validar los datos (los 3 valores son obligatorios y la cantidad de
saltos debe coincidir con un valor entero) e invocar al mÃ©todo del controlador â€œpublic void
buscarCamino(String nodo1,String nodo2,Integer saltos)â€, para que se realice una bÃºsqueda.*/

    public GrafoController getController() {
        return controller;
    }

    public void setController(GrafoController controller) {
        this.controller = controller;
    }

  

    
    
}

