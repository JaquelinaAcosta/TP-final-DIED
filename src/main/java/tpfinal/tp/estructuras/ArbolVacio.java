/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.estructuras;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import tpfinal.tp.integrador.MaterialCapacitacion;


public class ArbolVacio extends Arbol {

    public ArbolVacio() {    }

    @Override
    public boolean esVacio() {
        return true;
    }

    @Override
    public Arbol izquierdo() {
        return new ArbolVacio();
    }

    @Override
    public Arbol derecho() {
        return new ArbolVacio();
    }

    @Override
    public boolean contiene(MaterialCapacitacion unValor) {
        return false;
    }

    @Override
    public boolean equals(Arbol unArbol) {
        return unArbol.esVacio();
    }

    @Override
    public Integer profundidad() {
        return 0;
    }

    @Override
    public void add(MaterialCapacitacion mat) {
        // no hace nada
    }

    @Override
    public List<MaterialCapacitacion> ordenado() {
        return new ArrayList<MaterialCapacitacion>();
    }
    
    @Override
    public List<MaterialCapacitacion> rango(MaterialCapacitacion m1,MaterialCapacitacion m2) {
        return new ArrayList<MaterialCapacitacion>();
    }
    
    @Override
    public List<MaterialCapacitacion> inOrden(){
        return new ArrayList<MaterialCapacitacion>();
    }
    
    @Override
    public void setComparador(Comparator<MaterialCapacitacion> comp){
    }

}
