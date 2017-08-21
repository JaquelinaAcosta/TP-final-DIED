/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import tpfinal.tp.controller.MaterialCapacitacionController;
import tpfinal.tp.ventanas.Principal;

/**
 *
 * @author jaque
 */
public class PageRank extends JPanel{
    private JList listaPr;
    private List lista;
    private JButton volver;
    MaterialCapacitacionController controller;
    
    
    public PageRank(){
        this.armarPanel();
    }
    
    public PageRank(MaterialCapacitacionController controller, List lista){
        this.lista=lista;
        this.controller=controller;
        armarPanel();
    }
    
    private void armarPanel(){
         this.listaPr=new JList(lista.toArray());
         this.volver=new JButton("Volver al Inicio");
         
         this.setLayout(new GridLayout(2,1,10,10));
         this.add(listaPr);
         this.add(volver);
         
         this.volver.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
             
                
              controller.principal();
            }
    });
         
         
    }
    
}
