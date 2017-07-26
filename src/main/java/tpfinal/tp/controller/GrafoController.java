/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.controller;

import java.awt.Color;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tpfinal.tp.estructuras.grafo.Arista;
import tpfinal.tp.estructuras.grafo.Grafo;
import tpfinal.tp.estructuras.grafo.Vertice;
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.vista.AristaView;
import tpfinal.tp.vista.ControlPanel;
import tpfinal.tp.vista.GrafoPanel;
import tpfinal.tp.vista.VerticeView;


public class GrafoController {
    
    private static Integer _GENERADOR_ID=1;
    private Grafo<MaterialCapacitacion> grafo;
    private GrafoPanel vistaGrafo;
    private ControlPanel vistaControl;
    private Map<Vertice<MaterialCapacitacion>,VerticeView> vertices;
    private Map<Arista<MaterialCapacitacion>,AristaView> aristas;

    public GrafoController(GrafoPanel panelGrf,ControlPanel panelCtrl) {
        this.vistaGrafo = panelGrf;
        this.vistaControl = panelCtrl;
        this.grafo = new Grafo<MaterialCapacitacion>();
        this.vertices = new LinkedHashMap<Vertice<MaterialCapacitacion>,VerticeView>();
        this.aristas = new LinkedHashMap<Arista<MaterialCapacitacion>,AristaView>();
     }
    
    
    
    public void crearVertice(Integer coordenadaX, Integer coordenadaY,Color color,String titulo){
        MaterialCapacitacion m = new Libro(_GENERADOR_ID++,titulo);
        Vertice v1 = new Vertice(m);
        grafo.addNodo(v1);        
        VerticeView v = new VerticeView(coordenadaX, coordenadaY, color);
        v.setVertice(v1);
        this.vistaGrafo.agregar(v);
        this.vertices.put(v1, v);
        this.vistaGrafo.repaint();
    }

    public void crearArista(AristaView arista){
        Arista a1 = this.grafo.conectar(arista.getOrigen().getVertice(), arista.getDestino().getVertice());
        this.aristas.put(a1, arista);
        this.vistaGrafo.agregar(arista);
        this.vistaGrafo.repaint();
    }

    public void buscarCamino(String nodo1,String nodo2,Integer saltos){
        Vertice<MaterialCapacitacion> origen = buscarVerticePorNombre(nodo1);
        Vertice<MaterialCapacitacion> destino = buscarVerticePorNombre(nodo2);
      //  List<Arista<MaterialCapacitacion>> camino = this.grafo.buscarCamino(origen, destino, saltos);      
        //COMPLETAR
        //COMPLETAR
        //COMPLETAR DE MODO TAL QUE CUANDO TENGA EL CAMINO RESULTADO se muestre el camino (aristas y vertice en rojo)
        //COMPLETAR
        //COMPLETAR
        this.vistaGrafo.repaint();
        
    }
    
    private Vertice<MaterialCapacitacion> buscarVerticePorNombre(String nombre){
        for(Vertice<MaterialCapacitacion> unVertice: this.vertices.keySet()){
            if(unVertice.getValor().getTitulo().equals(nombre)) return unVertice;
        }
        return null;
    }
}