
package tpfinal.tp.estructuraArbolNario;

import java.util.ArrayList;
import java.util.List;

public class Nodo<T> {
 
    public T dato;
    public List<Nodo<T>> hijos;
 
   
    public Nodo() {
        super();
    }
 
 
    public Nodo(T dato) {
        this();
        setDato(dato);
    }

    
    public List<Nodo<T>> getHijos() {
        if (this.hijos == null) {
            return new ArrayList<Nodo<T>>();
        }
        return this.hijos;
    }
 
   
    public void setHijos(List<Nodo<T>> hijos) {
        this.hijos = hijos;
    }
 
    /**
     * Returns the number of immediate children of this Node<T>.
     * @return the number of immediate children.
     */
    public int getCantHijos() {
        if (hijos == null) {
            return 0;
        }
        return hijos.size();
    }
     

    public void addHijo(Nodo<T> child) {
        if (hijos == null) {
            hijos = new ArrayList<Nodo<T>>();
        }
        hijos.add(child);
    }
     
  
    public void insertHijoEn(int index, Nodo<T> child) throws IndexOutOfBoundsException {
        if (index == getCantHijos()) {
    
            addHijo(child);
            return;
        } else {
            hijos.get(index);
            hijos.add(index, child);
        }
    }
     
 
    public void eliminarHijoAt(int indice) throws IndexOutOfBoundsException {
        hijos.remove(indice);
    }
 
    public T getDato() {
        return this.dato;
    }
 
    public void setDato(T data) {
        this.dato = data;
    }
     
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(getDato().toString()).append(",[");
        int i = 0;
        for (Nodo<T> e : getHijos()) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(e.getDato().toString());
            i++;
        }
        sb.append("]").append("}");
        return sb.toString();
    }
}