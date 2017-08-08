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
import tpfinal.tp.ventanas.PanelAgregarAArbol;
import tpfinal.tp.ventanas.PanelBusquedaArbol;

/**
 *Esta clase va a controlar las relaciones entre las pantallas de ingresar
 * datos del Arbol y la de buscar los datos
 * 
 */
public class ArbolController {
   private Tree<TipoNodo> arbolN;
   //private final Nodo<MaterialCapacitacion> nodo;
   private final PanelAgregarAArbol panelAgregar;
   private final PanelBusquedaArbol panelBusqueda;
  private Map<TipoNodo,String> nodoMetadatos;
   private Nodo<TipoNodo> nodo;
   private List<Node<TipoNodo>> listaNodo;
   
   public ArbolController(PanelAgregarAArbol panelA,PanelBusquedaArbol panelB)
   {
       this.panelAgregar=panelA;
       this.panelBusqueda=panelB;
       this.arbolN= new Tree<>();
       this.nodo= new Nodo<TipoNodo>();
      this.nodoMetadatos= new LinkedHashMap<>();
   }
   
   public void cargarRaizArbol(String material,TipoNodo tipo)
   {
    Node<TipoNodo> raiz= new Node(tipo,material);
    this.arbolN.setRootElement(raiz);
    System.out.println(arbolN);
      
   }
   
    public void cargarMetadatosRaiz(TipoNodo tipoNodo,String txtViene)
    {      
      this.listaNodo= new ArrayList<>();
      Node<TipoNodo> nodo= new Node(tipoNodo,txtViene);
      listaNodo.add(nodo);
    }
    
      public void cargarMetadatos(TipoNodo tipoNodo,String txtViene)
    {      
      this.listaNodo= new ArrayList<>();
      Node<TipoNodo> nodo= new Node(tipoNodo,txtViene);
      listaNodo.add(nodo);
    }
}

