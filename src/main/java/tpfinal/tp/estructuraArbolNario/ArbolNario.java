/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.estructurasArbolNario;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class ArbolNario<T> {

   

    private Nodo<T> raiz;
    private LinkedList lista; 
    private LinkedHashSet listaNodo;
   
    public ArbolNario() {
        super();
    }
 
    /**
     * 
     * @return la raiz
     */
    public Nodo<T> getTaiz() {
        return this.raiz;
    }
 
  
    public void setRaiz(Nodo<T> root) {
        this.raiz = root;
    }
     
    /**
     * Devuelve el árbol <T> como una lista de objetos Nodo <T>
     */
    public List<Nodo<T>> toList() {
        List<Nodo<T>> list = new ArrayList<Nodo<T>>();
        walk(raiz, list);//(para iterar en los contenidos de los directorios)
        return list;
    }
     
    /**
     * Returns a String representation of the Tree. The elements are generated
     *
     */
    public String toString() {
        return toList().toString();
    }
     
    /**
     * Walks the Tree in pre-order style. This is a recursive method, and is
     * called from the toList() method with the root element as the first
     * argument. It appends to the second argument, which is passed by reference     * as it recurses down the tree.
     * @param element the starting element.
     * @param list the output of the walk.
     */
    private void walk(Nodo<T> element, List<Nodo<T>> list) {
        list.add(element);
        for (Nodo<T> data : element.getHijos()) {
            walk(data, list);
        }
    }
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.raiz);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArbolNario<?> other = (ArbolNario<?>) obj;
        if (!Objects.equals(this.raiz, other.raiz)) {
            return false;
        }
        return true;
    }
}

