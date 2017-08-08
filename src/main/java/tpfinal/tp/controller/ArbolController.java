/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tpfinal.tp.estructuraArbolNario.ArbolNario;
import tpfinal.tp.estructuraArbolNario.Node;
import tpfinal.tp.estructuraArbolNario.Nodo;
import tpfinal.tp.estructuraArbolNario.TipoNodo;
import tpfinal.tp.estructuraArbolNario.Tree;
import tpfinal.tp.guardarADisco.ArbolDao;
import tpfinal.tp.ventanas.PanelAgregarAArbol;
import tpfinal.tp.ventanas.PanelBusquedaArbol;

/**
 *Esta clase va a controlar las relaciones entre las pantallas de ingresar
 * datos del Arbol y la de buscar los datos
 * 
 */
public class ArbolController {
   private Tree<TipoNodo> arbolN;
   private final PanelAgregarAArbol panelAgregar;
   private final PanelBusquedaArbol panelBusqueda;
   private Map<TipoNodo,String> nodoMetadatos;
   private Node<TipoNodo> nodo;
   private Node<TipoNodo> raiz;
   private List<Node<TipoNodo>> listaNodo;
   private List<Node<TipoNodo>> listaNodoHijos;
     private List<Node<TipoNodo>> listaNodoHijosHijos;
   
   private ArbolDao arbolDao = new ArbolDao();

   
   public ArbolController(PanelAgregarAArbol panelA,PanelBusquedaArbol panelB)
   {
       this.panelAgregar=panelA;
       this.panelBusqueda=panelB;
       this.arbolN= new Tree<>();
       this.nodo= new Node<TipoNodo>();
       this.nodoMetadatos= new LinkedHashMap<>();
       this.listaNodo= new ArrayList<>();
       this.listaNodoHijos= new ArrayList<>();
       this.listaNodoHijosHijos= new ArrayList<>();
   }
  
   //cargamos la raiz al arbol
   public void cargarRaizArbol(String material,TipoNodo tipo)
   {
    this.raiz= new Node(tipo,material);
    this.arbolN.setRootElement(raiz);
   
   }
   
   public List<Node<TipoNodo>> cargarNodoDeRaiz(String material,TipoNodo tipo)
   {
       
       Node<TipoNodo> n= new Node(tipo,material);
        listaNodo.add(n);  
        System.out.println("listaNodo"+listaNodo);
        return listaNodo;
   }
   
   public void unirNodosRaiz()
   {
       this.raiz.setChildren(listaNodo);
       this.cargarNodosHijos();
   }
   
   public void cargarNodosHijos()
   {
      for(int i=0;i<listaNodo.size();i++)
      {
          listaNodo.get(i).setChildren(listaNodoHijos);
          
      }
       
   }
   
   public List<Node<TipoNodo>> agregarHijos(String material,TipoNodo tipo)
   {
        Node<TipoNodo> n= new Node(tipo,material);
        this.listaNodoHijos.add(n);
        return listaNodoHijos;
   }
   
     public void cargarNodosHijosdeHijos()
   {
      for(int i=0;i<listaNodoHijos.size();i++)
      {
          listaNodoHijos.get(i).setChildren(listaNodoHijosHijos);
          
      }
       
   }
    public List<Node<TipoNodo>> agregarHijosdeHijos(String material,TipoNodo tipo)
   {
        Node<TipoNodo> n= new Node(tipo,material);
        this.listaNodoHijosHijos.add(n);
        return listaNodoHijosHijos;
   }
    
    public void cargarArbol()
      {
         this.unirNodosRaiz();
         System.out.println("c argue el arbol"+arbolN.toString());
         arbolDao.agregar(arbolN);
      }
      

        
          
      
}

