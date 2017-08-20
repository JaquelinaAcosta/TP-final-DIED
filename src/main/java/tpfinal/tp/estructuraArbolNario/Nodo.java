/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.estructuraArbolNario;

import java.util.ArrayList;
import java.util.List;



public class Nodo<T> {
 
    public String dato;
    private TipoNodo tipo;
    public List<Nodo<T>> Hijos;
 
    /**
     * Default ctor.
     */
    public Nodo()
    {
        
    }
    public Nodo(String d) {
     this.dato=dato;  
    }

      public Nodo(TipoNodo tipoN,String dato) {
        setData(tipoN,dato);
     
      }
 
    public List<Nodo<T>> getHijos() {
        if (this.Hijos == null) {
            return new ArrayList<Nodo<T>>();
        }
        return this.Hijos;
    }
 
    public void setHijos(List<Nodo<T>> Hijos) {
        this.Hijos = Hijos;
    }

    public int getNumberOfChildren() {
        if (Hijos == null) {
            return 0;
        }
        return Hijos.size();
    }

    public void addChild(Nodo<T> child) {
        if (Hijos == null) {
            Hijos = new ArrayList<Nodo<T>>();
        }
        Hijos.add(child);
    }

    public void insertChildAt(int index, Nodo<T> child) throws IndexOutOfBoundsException {
        if (index == getNumberOfChildren()) {
            // this is really an append
            addChild(child);
            return;
        } else {
            Hijos.get(index); //just to throw the exception, and stop here
            Hijos.add(index, child);
        }
    }

    public void removeChildAt(int index) throws IndexOutOfBoundsException {
        Hijos.remove(index);
    }
 
   public TipoNodo getData() {
        return this.tipo;
    }
 
  public String dato()
  {
      return this.dato;
  }
    
    public void setData(TipoNodo tipo,String dato) {
        this.dato=dato;
        this.tipo=tipo;
    }
     
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{NODO -> Tipo : ").append(getData().toString()).append(":").append(dato().toString()).append(",[");
        int i = 0;
        for (Nodo<T> e : getHijos()) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append("{NODO -> Tipo : ").append(e.getData().toString()).append(":").append(e.dato().toString());//
            i++;
        }
        sb.append("]").append("}");
        return sb.toString();
    }
}

