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
    /**
     * Return the children of Node<T>. The Tree<T> is represented by a single
     * root Node<T> whose children are represented by a List<Node<T>>. Each of
     * these Node<T> elements in the List can have children. The getChildren()
     * method will return the children of a Node<T>.
     * @return the children of Node<T>
     */
    public List<Node<TipoNodo>> getChildren() {
        if (this.children == null) {
            return new ArrayList<Node<TipoNodo>>();
        }
        return this.children;
    }
 
    /**
     * Sets the children of a Node<T> object. See docs for getChildren() for
     * more information.
     * @param children the List<Node<T>> to set.
     */
    public void setChildren(List<Node<TipoNodo>> children) {
        this.children = children;
    }
 
    /**
     * Returns the number of immediate children of this Node<T>.
     * @return the number of immediate children.
     */
    public int getNumberOfChildren() {
        if (children == null) {
            return 0;
        }
        return children.size();
    }
     
    /**
     * Adds a child to the list of children for this Node<T>. The addition of
     * the first child will create a new List<Node<T>>.
     * @param child a Node<T> object to set.
     */
    public void addChild(Node<TipoNodo> child) {
        if (children == null) {
            children = new ArrayList<Node<TipoNodo>>();
        }
        children.add(child);
    }
     
    /**
     * Inserts a Node<T> at the specified position in the child list. Will     * throw an ArrayIndexOutOfBoundsException if the index does not exist.
     * @param index the position to insert at.
     * @param child the Node<T> object to insert.
     * @throws IndexOutOfBoundsException if thrown.
     */
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
     
    /**
     * Remove the Node<T> element at index index of the List<Node<T>>.
     * @param index the index of the element to delete.
     * @throws IndexOutOfBoundsException if thrown.
     */
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

