/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.estructuras;

import java.util.Comparator;
import java.util.List;
import tpfinal.tp.integrador.MaterialCapacitacion;

/**
 *En este formato se ingresa la estructura para realizar la busqueda de texto
 * 
 */
public class ArbolNaraio extends Arbol {
      private MaterialCapacitacion valor;
    private Arbol izquierdo;
    private Arbol derecho;

    @Override
    public boolean esVacio() {
        return false;
    }

  public void add(MaterialCapacitacion mat) {                
        if(this.valor==null) {
            this.valor=mat;
            return;
        } 
        
    }

    @Override
    public Arbol izquierdo() {
        return this.izquierdo();
    }

    @Override
    public Arbol derecho() {
      return this.derecho();
    }

    @Override
    public boolean contiene(MaterialCapacitacion unValor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Arbol unArbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MaterialCapacitacion> inOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer profundidad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setComparador(Comparator<MaterialCapacitacion> comp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MaterialCapacitacion> ordenado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MaterialCapacitacion> rango(MaterialCapacitacion m1, MaterialCapacitacion m2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
