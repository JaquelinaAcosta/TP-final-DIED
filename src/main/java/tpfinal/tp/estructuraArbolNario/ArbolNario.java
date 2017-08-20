/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.estructuraArbolNario;

import java.util.ArrayList;
import java.util.List;



   public class ArbolNario<T> {
 
    private Nodo<T> raiz;

  
    public ArbolNario() {

    }

    public Nodo<T> getRaiz() {
        return this.raiz;
    }
    

 
 
    public void setRaiz(Nodo<TipoNodo> raiz) {
        this.raiz = (Nodo<T>) raiz;
    }
     
  
    public List<Nodo<T>> toList() {
        List<Nodo<T>> list = new ArrayList<Nodo<T>>();
        listarNodos(raiz, list);
        return list;
    }
  
    public String toString() {
        return toList().toString();
      
    }
 
    public void listarNodos(Nodo<T> element, List<Nodo<T>> list) {
        list.add(element);
        for (Nodo<T> data : element.getHijos()) {
            listarNodos(data, list);
        }
    }
    
    }
