/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.estructuraArbolNario;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ArbolNario<T> {
 
    private Nodo<T> raiz;
     
  
    public ArbolNario() {
        super();
    }
 
   
    public Nodo<T> getRaizE() {
        return this.raiz;
    }
 

    
    public void setRaiz(Nodo<T> raiz) {
        this.raiz = raiz;
    }
     

    public List<Nodo<T>> toList() {
        List<Nodo<T>> list = new ArrayList<Nodo<T>>();
        walk(raiz, list);
        return list;
    }
     
  
    public String toString() {
        return toList().toString();
    }
     
 
    private void walk(Nodo<T> element, List<Nodo<T>> list) {
        list.add(element);
        element.getHijos().forEach((data) -> {
            walk(data, list);
        });
    }
}
