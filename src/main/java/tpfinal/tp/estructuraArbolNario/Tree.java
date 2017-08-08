/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.estructuraArbolNario;

import java.util.ArrayList;
import java.util.List;



    public class Tree<T> {
 
    private Node<T> rootElement;
     
  
    public Tree() {
        super();
    }

    public Node<T> getRootElement() {
        return this.rootElement;
    }
 
 
    public void setRootElement(Node<T> rootElement) {
        this.rootElement = rootElement;
    }
     
  
    public List<Node<T>> toList() {
        List<Node<T>> list = new ArrayList<Node<T>>();
        listarNodos(rootElement, list);
        return list;
    }
  
    public String toString() {
        return toList().toString();
    }
 
    public void listarNodos(Node<T> element, List<Node<T>> list) {
        list.add(element);
        for (Node<T> data : element.getChildren()) {
            listarNodos(data, list);
        }
    }
    

    
    public List<Node<T>> buscarDato(Node<T> nodo)
    {
        List<Node<T>> lista = new ArrayList<Node<T>>();
        lista=toList();
      
        for(int i=0;i<lista.size();i++)
        {
            if(lista.get(i).children.get(i).equals(nodo))
            System.out.println("esta es la lista "+toList().get(i).children.get(i));    
        }
      
       return lista;
       
               }
    }
