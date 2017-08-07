/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tpfinal.tp.estructuraArbolNario.ArbolNario;
import tpfinal.tp.estructuraArbolNario.Nodo;
import tpfinal.tp.estructuraArbolNario.TipoNodo;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.ventanas.PanelAgregarAArbol;
import tpfinal.tp.ventanas.PanelBusquedaArbol;

/**
 *Esta clase va a controlar las relaciones entre las pantallas de ingresar
 * datos del Arbol y la de buscar los datos
 * 
 */
public class ArbolController {
   private final ArbolNario<TipoNodo> arbolN;
   //private final Nodo<MaterialCapacitacion> nodo;
   private final PanelAgregarAArbol panelAgregar;
   private final PanelBusquedaArbol panelBusqueda;
  private Map<TipoNodo,String> nodoMetadatos;
   private Nodo<TipoNodo> nodo;
   private List<Nodo<TipoNodo>> listaNodo;
   
   public ArbolController(PanelAgregarAArbol panelA,PanelBusquedaArbol panelB)
   {
       this.panelAgregar=panelA;
       this.panelBusqueda=panelB;
       this.arbolN= new ArbolNario<>();
       this.nodo= new Nodo<TipoNodo>();
      this.nodoMetadatos= new LinkedHashMap<>();
   }
   
   public void cargarRaizArbol(String material,TipoNodo tipo)
   {
    Nodo<TipoNodo> raiz= new Nodo(tipo,material);
    this.arbolN.setRaiz(raiz);
    System.out.println(arbolN);
       System.out.println("esto recibo "+material+" tipo : "+tipo);
   }    
   
    public void cargarMetadatos(TipoNodo tipoNodo,String txtViene)
    {      
        this.nodoMetadatos.put(tipoNodo, txtViene);
       for (Map.Entry e : nodoMetadatos.entrySet()) {
           System.out.println("NODO -> Tipo "+e.getKey() + ":" + e.getValue());
       }
      
      }
    }

