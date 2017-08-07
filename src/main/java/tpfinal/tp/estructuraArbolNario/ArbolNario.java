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
 
    private Nodo<TipoNodo> raiz;
    protected List<Nodo<TipoNodo>> listaNodo; 
  
    
    public ArbolNario() {
        this.listaNodo= new ArrayList<Nodo<TipoNodo>>();
    }
     public ArbolNario(Nodo<TipoNodo> nodo) {
        this.raiz=nodo;
        this.listaNodo= new ArrayList<Nodo<TipoNodo>>();
       raiz.setHijos(listaNodo);
    }
   
    public void addHijo(Nodo<TipoNodo> nodo){
		this.listaNodo.add(nodo);
	}
   
   
    public Nodo<TipoNodo> getRaizE() {
        return this.raiz;
    }
  
    public void setRaiz(Nodo<TipoNodo> raiz) {
        this.raiz = raiz;
    }
 
    public List<Nodo<T>> addNodoList(Nodo<T> nodo, List<Nodo<T>> list) {
        if(list==null)
        {
            list=new ArrayList<>();
            list.add(nodo);
        }
        else  
        {
     list.add(nodo);
        }
        return list;
    }
      public String toString() {
        return toList().toString();
    }
      public List<Nodo<T>> toList() {
        List<Nodo<T>> list = new ArrayList<Nodo<T>>();
        walk((Nodo<T>) raiz, list);
        return list;
    }

    private void walk(Nodo<T> element, List<Nodo<T>> list) {
        list.add(element);
        for (Nodo<T> data : element.getHijos()) {
            walk(data, list);
        }
    }
  
}
