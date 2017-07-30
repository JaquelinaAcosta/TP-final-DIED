/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.estructuras;

import java.util.Comparator;
import java.util.List;
import tpfinal.tp.integrador.MaterialCapacitacion;


public abstract class Arbol {

	public abstract boolean esVacio();
        
        public abstract void add(MaterialCapacitacion mat);

	public abstract Arbol izquierdo();

	public abstract Arbol derecho();

	public abstract boolean contiene(MaterialCapacitacion unValor);

	public abstract boolean equals(Arbol unArbol);
        
        public abstract List<MaterialCapacitacion> inOrden();

	public abstract Integer profundidad();	
        
        public abstract void setComparador(Comparator<MaterialCapacitacion> comp);
                
        public abstract List<MaterialCapacitacion> ordenado();	
	
        public abstract List<MaterialCapacitacion> rango(MaterialCapacitacion m1,MaterialCapacitacion m2) ;
}
