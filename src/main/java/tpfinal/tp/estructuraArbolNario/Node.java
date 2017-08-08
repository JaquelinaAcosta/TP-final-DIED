/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.estructuraArbolNario;

import java.util.ArrayList;
import java.util.List;



    public class Node<TipoNodo> {
 
    public String dato;
    private TipoNodo tipo;
    public List<Node<TipoNodo>> children;
 
    /**
     * Default ctor.
     */
    public Node() {
        super();
    }

    
      public Node(TipoNodo tipoN,String dato) {
        this();
    
        setData(tipoN,dato);
     
      }
 
    public List<Node<TipoNodo>> getChildren() {
        if (this.children == null) {
            return new ArrayList<Node<TipoNodo>>();
        }
        return this.children;
    }
 
    public void setChildren(List<Node<TipoNodo>> children) {
        this.children = children;
    }

    public int getNumberOfChildren() {
        if (children == null) {
            return 0;
        }
        return children.size();
    }

    public void addChild(Node<TipoNodo> child) {
        if (children == null) {
            children = new ArrayList<Node<TipoNodo>>();
        }
        children.add(child);
    }

    public void insertChildAt(int index, Node<TipoNodo> child) throws IndexOutOfBoundsException {
        if (index == getNumberOfChildren()) {
            // this is really an append
            addChild(child);
            return;
        } else {
            children.get(index); //just to throw the exception, and stop here
            children.add(index, child);
        }
    }

    public void removeChildAt(int index) throws IndexOutOfBoundsException {
        children.remove(index);
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
        for (Node<TipoNodo> e : getChildren()) {
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

