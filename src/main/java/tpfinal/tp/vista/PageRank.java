/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.vista;

import java.util.List;
import javax.swing.JList;
import javax.swing.JPanel;
import tpfinal.tp.ventanas.Principal;

/**
 *
 * @author jaque
 */
public class PageRank extends JPanel{
    private JList listaPr;
    private List lista;
    private Principal principal;
    
    public PageRank(){
        this.armarPanel();
    }
    
    public PageRank(Principal principal, List lista){
        this.lista=lista;
        this.principal=principal;
        armarPanel();
    }
    
    private void armarPanel(){
         this.listaPr=new JList(lista.toArray());
         
         this.add(listaPr);
         
         
    }
    
}
