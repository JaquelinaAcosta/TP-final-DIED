
package tpfinal.tp.estructuraArbolNario;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Nodo<T> {
 
    private T dato;
    private List<Nodo<T>> hijos;
    private Map<TipoNodo,String> listaNodos;
    private TipoNodo tipo;
   
    public Nodo() {
        super();
    }
 
 
    public Nodo(TipoNodo tipoN,T dato) {
        this();
       this.dato=(T) dato;
       this.tipo=tipoN;
       this.listaNodos= new EnumMap<>(TipoNodo.class);
            
      //  setDato(dato);
    }
    public void setDato(T hijo)
    {
        this.dato=hijo;
    }
    public void setDato(T hijo,TipoNodo tipo)
    {
        this.dato=hijo;
        this.tipo=tipo;
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

 
    public void eliminarHijoAt(int indice) throws IndexOutOfBoundsException {
        hijos.remove(indice);
    }
 

     
    public String toString() {
  return "(Nodo->Tipo: "+this.tipo+":"+this.dato+")";
         }
}