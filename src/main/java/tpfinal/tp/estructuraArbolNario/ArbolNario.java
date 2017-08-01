/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.estructuraArbolNario;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ArbolNario<T> {
 
    private Nodo<T> raiz;
     
    /**
     * Default ctor.
     */
    public ArbolNario() {
        super();
    }
 
    /**
     * Return the root Node of the tree.
     * @return the root element.
     */
    public Nodo<T> getRaizE() {
        return this.raiz;
    }
 
    /**
     * Set the root Element for the tree.
     * @param rootElement the root element to set.
     */
    public void setRaiz(Nodo<T> raiz) {
        this.raiz = raiz;
    }
     
    /**
     * Returns the Tree<T> as a List of Node<T> objects. The elements of the
     * List are generated from a pre-order traversal of the tree.
     * @return a List<Node<T>>.
     */
    public List<Nodo<T>> toList() {
        List<Nodo<T>> list = new ArrayList<Nodo<T>>();
        walk(raiz, list);
        return list;
    }
     
    /**
     * Returns a String representation of the Tree. The elements are generated
     * from a pre-order traversal of the Tree.
     * @return the String representation of the Tree.
     */
    public String toString() {
        return toList().toString();
    }
     
    /**
     * Walks the Tree in pre-order style. This is a recursive method, and is
     * called from the toList() method with the root element as the first
     * argument. It appends to the second argument, which is passed by reference     * as it recurses down the tree.
     * @param element the starting element.
     * @param list the output of the walk.
     */
    private void walk(Nodo<T> element, List<Nodo<T>> list) {
        list.add(element);
        for (Nodo<T> data : element.getChildren()) {
            walk(data, list);
        }
    }
}
