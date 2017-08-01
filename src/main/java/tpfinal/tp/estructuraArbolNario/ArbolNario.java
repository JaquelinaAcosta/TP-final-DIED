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


public class ArbolNario {

    private Nodo raiz;
    private LinkedList lista; 
    private LinkedHashSet listaNodo;
   
    public ArbolNario() {
        super();
    }
 
    public Nodo getTaiz() {
        return this.raiz;
    }

    public void setRaiz(Nodo root) {
        this.raiz = root;
    }

    public List<Nodo> toList() {
        List<Nodo> list = new ArrayList<Nodo>();
        walk(raiz, list);//(para iterar en los contenidos de los directorios)
        return list;
    }
    
    public String toString() {
        return toList().toString();
    }
     
    private void walk(Nodo element, List<Nodo> list) {
        list.add(element);
        for (Nodo valor : element.getHijos()) {
            walk(valor, list);
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
        final ArbolNario other = (ArbolNario) obj;
        if (!Objects.equals(this.raiz, other.raiz)) {
            return false;
        }
        return true;
    }
}

