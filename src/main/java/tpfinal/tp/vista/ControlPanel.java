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
import javax.swing.ListModel;
import tpfinal.tp.controller.GrafoController;
import tpfinal.tp.controller.MaterialCapacitacionController;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.ventanas.Principal;

public class ControlPanel extends JPanel {
    
    private GrafoController controller;
    private JTextField txtNombreVertice1; 
    private JTextField txtNombreVertice2; 
    private JTextField cantSalto; 
    private JButton botonBuscarCamino;
    private JButton botonPR;
    private JComboBox<Object> comboMaterial;
    private ArrayList<MaterialCapacitacion> listaRtdo;
    MaterialCapacitacionController controllerM;
 
    
    
    public ControlPanel(){
        this.armarPanel();
    }
    
    
     public ControlPanel(MaterialCapacitacionController controllerM,ArrayList<MaterialCapacitacion> lista){
         this.controllerM=controllerM;
         this.listaRtdo=lista;
         System.out.println("esta lista recibi"+listaRtdo);
        this.armarPanel();
    }
      public ControlPanel(ArrayList<MaterialCapacitacion> lista){
         this.listaRtdo=lista;
         System.out.println("esta lista recibi"+listaRtdo.get(0).getTitulo());
        this.armarPanel();
    }

      
    private void armarPanel(){
        
       
        this.txtNombreVertice1 =new JTextField(20);
        this.txtNombreVertice2 =new JTextField(20);
        this.cantSalto =new JTextField(5); 
        this.botonBuscarCamino= new JButton("Buscar Camino");
        this.botonPR= new JButton("Page Rank");
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
        this.add(botonBuscarCamino);
        this.add(comboMaterial);
        this.add(botonPR);

        
      
        
        
          addMouseListener(new MouseAdapter() {
            //Se llama cuando se oprime y se suelta un botÃ³n en el mouse.
            public void mouseClicked(MouseEvent event) {
                if (event.getClickCount() == 2 && !event.isConsumed()) {
                    event.consume();
                  
                }
            }
          });
        
        comboMaterial.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
                String seleccion=comboMaterial.getSelectedItem().toString();
                MaterialCapacitacion m=listaRtdo.get(comboMaterial.getSelectedIndex());
                System.out.println("material"+m);
                controller.titulo(seleccion);
                controller.getMaterial(m);
          }
       });
        
        botonBuscarCamino.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            try{
               
            if(cantSalto.getText().isEmpty())//va a la funcion de buscar tdos los caminos
            {
                
           ArrayList lista= new ArrayList();
           lista=controller.buscarCamino(txtNombreVertice1.getText(), txtNombreVertice2.getText());
           controllerM.cambiarPR(lista);
            }
            else
            {
                
                ArrayList lista= new ArrayList();
                lista = controller.buscarCamino(txtNombreVertice1.getText(), txtNombreVertice2.getText(), Integer.parseInt(cantSalto.getText()));
                controllerM.cambiarPR(lista);
            }
            }catch(Exception ex){
            System.out.println("Error");
            }
        }
    });
        
        //Muestra Page Rank
        botonPR.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ArrayList lista=new ArrayList();
                lista=controller.calcularPageRank();
               controllerM.cambiarPR(lista);
                
            
        }
    });
}
    

    public GrafoController getController() {
        return controller;
    }

    public void setController(GrafoController controller) {
        this.controller = controller;
    }

  

    
    
}

