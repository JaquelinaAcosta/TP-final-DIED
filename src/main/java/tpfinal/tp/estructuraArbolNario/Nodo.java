/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.estructuraArbolNario;

import java.util.ArrayList;
import java.util.List;


public class Nodo {
    public String valor;
    public List<Nodo> hijos;
    public TipoNodo tipo;
 
    
    public Nodo() {
        super();
    }
    
 public Nodo(String valor, TipoNodo tipo) {
        this.tipo=tipo;
        this.valor=valor;
    }
 
   
    public Nodo(String valor) {
        this();
        setValor(valor);
    }
     
    
    public List<Nodo> getHijos() {
        if (this.hijos == null) {
            return new ArrayList<Nodo>();
        }
        return this.hijos;
    }
 
 
    public void setHijos(List<Nodo> hijos) {
        this.hijos = hijos;
    }
 
    public int getCantidadHijos() {
        if (hijos == null) {
            return 0;
        }
        return hijos.size();
    }
     
    public void addHijo(Nodo nuevoHijo) {
        if (hijos == null) {
            hijos = new ArrayList<Nodo>();
        }
        hijos.add(nuevoHijo);
    }
    
    public void inserHijoAt(int index, Nodo nuevoHijo) throws IndexOutOfBoundsException {
        if (index == getCantidadHijos()) {
            // this is really an append
            addHijo(nuevoHijo);
            return;
        } else {
            hijos.get(index); //just to throw the exception, and stop here
            hijos.add(index, nuevoHijo);
        }
    }
    
    public void eliminarHijo(int index) throws IndexOutOfBoundsException {
        hijos.remove(index);
    }
 
    public String getValor() {
        return this.valor;
    }
 
    public void setValor(String valor) {
        this.valor = valor;
    }
     
    public String toString() {

        return  "valor=" + this.valor + " tipo= "+ this.tipo; 
    }
}
    

