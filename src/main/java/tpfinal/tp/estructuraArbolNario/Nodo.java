/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.estructurasArbolNario;

import java.util.ArrayList;
import java.util.List;


public class Nodo<T> {
    public T data;
    public List<Nodo<T>> hijo;
 
    /**
     * Default ctor.
     */
    public Nodo() {
        super();
    }
 
    /**
     * Convenience ctor to create a Node<T> with an instance of T.
     * @param data an instance of T.
     */
    public Nodo(T dato) {
        this();
        setData(dato);
    }
     
    /**
     * Return the children of Node<T>. The Tree<T> is represented by a single
     * root Node<T> whose children are represented by a List<Node<T>>. Each of
     * these Node<T> elements in the List can have children. The getChildren()
     * method will return the children of a Node<T>.
     * @return the children of Node<T>
     */
    public List<Nodo<T>> getHijos() {
        if (this.hijo == null) {
            return new ArrayList<Nodo<T>>();
        }
        return this.hijo;
    }
 
    /**
     * Sets the children of a Node<T> object. See docs for getChildren() for
     * more information.
     * @param children the List<Node<T>> to set.
     */
    public void setHijos(List<Nodo<T>> hijos) {
        this.hijo = hijos;
    }
 
    /**
     * Returns the number of immediate children of this Node<T>.
     * @return the number of immediate children.
     */
    public int getCantidadHijos() {
        if (hijo == null) {
            return 0;
        }
        return hijo.size();
    }
     
    /**
     * Adds a child to the list of children for this Node<T>. The addition of
     * the first child will create a new List<Node<T>>.
     * @param child a Node<T> object to set.
     */
    public void addHijo(Nodo<T> nuevoHijo) {
        if (hijo == null) {
            hijo = new ArrayList<Nodo<T>>();
        }
        hijo.add(nuevoHijo);
    }
     
    /**
     * Inserts a Node<T> at the specified position in the child list. Will     * throw an ArrayIndexOutOfBoundsException if the index does not exist.
     * @param index the position to insert at.
     * @param child the Node<T> object to insert.
     * @throws IndexOutOfBoundsException if thrown.
     */
    public void inserHijoAt(int index, Nodo<T> nuevoHijo) throws IndexOutOfBoundsException {
        if (index == getCantidadHijos()) {
            // this is really an append
            addHijo(nuevoHijo);
            return;
        } else {
            hijo.get(index); //just to throw the exception, and stop here
            hijo.add(index, nuevoHijo);
        }
    }
     
    /**
     * Remove the Node<T> element at index index of the List<Node<T>>.
     * @param index the index of the element to delete.
     * @throws IndexOutOfBoundsException if thrown.
     */
    public void eliminarHijo(int index) throws IndexOutOfBoundsException {
        hijo.remove(index);
    }
 
    public T getData() {
        return this.data;
    }
 
    public void setData(T data) {
        this.data = data;
    }
     
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(getData().toString()).append(",[");
        int i = 0;
        for (Nodo<T> e : getHijos()) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(e.getData().toString());
            i++;
        }
        sb.append("]").append("}");
        return sb.toString();
    }
}
    

