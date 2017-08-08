/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import tpfinal.tp.estructuras.grafo.Arista;
import tpfinal.tp.estructuras.grafo.Grafo;
import tpfinal.tp.estructuras.grafo.Vertice;
import tpfinal.tp.integrador.MaterialCapacitacion;

import tpfinal.tp.vista.AristaView;
import tpfinal.tp.vista.ControlPanel;
import tpfinal.tp.vista.GrafoPanel;
import tpfinal.tp.vista.VerticeView;


    

public class GrafoController {
    private final Double factorAmort=0.5;
    private static Integer _GENERADOR_ID=1;
    private Grafo<MaterialCapacitacion> grafo;
    private GrafoPanel vistaGrafo;
    private ControlPanel vistaControl;
    private Map<Vertice<MaterialCapacitacion>,VerticeView> vertices;
    private Map<Arista<MaterialCapacitacion>,AristaView> aristas;
    private Integer coordenadaX;
    private Integer coordenadaY;
    private String t;
    private MaterialCapacitacion material;

    public GrafoController(GrafoPanel panelGrf,ControlPanel panelCtrl) {
        this.vistaGrafo = panelGrf;
        this.vistaControl = panelCtrl;
        this.grafo = new Grafo<>();
        this.vertices = new LinkedHashMap<>();
        this.aristas = new LinkedHashMap<>();
     }
    
    public Integer encontrarPosicionX(Integer x)
    {
        this.coordenadaX=x;
        return coordenadaX; 
    }
      public Integer encontrarPosicionY(Integer y)
    {
        this.coordenadaY=y;
        return coordenadaY; 
    }
    
      public void dibujarEn(Integer x,Integer y,Color color)
      {
         String vieneTitulo=this.titulo(t);
         MaterialCapacitacion m=this.getMaterial(material);
         this.crearVertice(x, y, color, vieneTitulo,m);
      } 
      
      public MaterialCapacitacion getMaterial(MaterialCapacitacion material)
      {
        this.material=material;
            return material;    
      }
      
      public String titulo(String titulo)
      {
          this.t=titulo;
          return t;
      }
      
    public void crearVertice(Integer coordenadaX, Integer coordenadaY,Color color,String titulo,MaterialCapacitacion m){
       this.material=m;
        Vertice v1 = new Vertice(material);
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

    public void mostrarAristas()
    {
        this.grafo.imprimirAristas();
    }
    
    public void buscarCamino(String nodo1,String nodo2,Integer saltos){
        Vertice<MaterialCapacitacion> origen = buscarVerticePorNombre(nodo1);
        Vertice<MaterialCapacitacion> destino = buscarVerticePorNombre(nodo2);
        List<Arista<MaterialCapacitacion>> camino = this.grafo.buscarCamino(origen, destino,saltos);   
    
    
   for(int i=0;i<camino.size();i++)//pinta todo revisar para que sea solo el camino
    {
      
        aristas.values().forEach((a) -> {
            a.setColor(Color.RED);
            this.vistaGrafo.agregar(a);
            });
      
        vertices.values().forEach((vert) -> {
            vert.setColor(Color.RED);
            });

   }
       
        this.vistaGrafo.repaint();  
    }
   
    public void buscarCamino(String nodo1,String nodo2){
        Vertice<MaterialCapacitacion> origen = buscarVerticePorNombre(nodo1);
        Vertice<MaterialCapacitacion> destino = buscarVerticePorNombre(nodo2);
        List<Arista<MaterialCapacitacion>> camino = this.grafo.buscarCamino(origen, destino);   
     
        System.out.println("Este es el camino"+camino);
    for(int i=0;i<camino.size();i++)//pinta todo revisar para que sea solo el camino
    {
        aristas.values().forEach((a) -> {
            a.setColor(Color.RED);
            this.vistaGrafo.agregar(a);
            });
        vertices.values().forEach((vert) -> {
            vert.setColor(Color.RED);
            });
    }
       
        this.vistaGrafo.repaint();
        
    }
    
    
    private Vertice<MaterialCapacitacion> buscarVerticePorNombre(String nombre){
        for(Vertice<MaterialCapacitacion> unVertice: this.vertices.keySet()){
            if(unVertice.getValor().getTitulo().equals(nombre)) return unVertice;
        }
        return null;
    }
    
    public ArrayList calcularPageRank()//no se termino de implementar
    {

        HashMap<Vertice<MaterialCapacitacion>, Double> pageRank=new HashMap<>();
        
        HashMap<String, Double> pageRankAux=new HashMap<>();
        ArrayList lista=new ArrayList();
   
        //carga el pageRank, inicializando con valor 1
        for(Vertice<MaterialCapacitacion> unVertice: grafo.getVertices()){
            pageRank.put(unVertice, 1.0);
            pageRankAux.put(unVertice.getValor().getTitulo(), 1.0);
        }
   
        Double e=0.01;
        Double resultado=0.0;
        Double resAuxiliar=0.0; 
        Boolean bandera=true;

        while(bandera){
            bandera=false;
            for(Vertice<MaterialCapacitacion> unVertice: grafo.getVertices()){
                Double i=0.0;
                Double d=0.5;
                resAuxiliar=pageRank.get(unVertice);

                for(Vertice<MaterialCapacitacion> unVertice1: grafo.getVerticesEntrantes(unVertice)){
                    i += d * (pageRank.get(unVertice1) / grafo.gradoSalida(unVertice1));
                    System.out.println("esto es i: "+i);
                }
                resultado=(1.0 - d)+ i;
                pageRankAux.put(unVertice.getValor().getTitulo(), resultado);
                pageRank.put(unVertice, resultado);
                if(e<Math.abs(resAuxiliar-resultado)){
                    bandera=true;
                }
            }           
             System.out.println("pageRank: "+pageRank);
             System.out.println("pageRankAux: "+pageRankAux);          
        }
        
        //Ordenar los valores del hashMap de mayor a menor 
        LinkedHashMap ordenadoMap = new LinkedHashMap();
        ArrayList values = new ArrayList(pageRankAux.values());
        Comparator<Double> comparador = Collections.reverseOrder();
        Collections.sort(values, comparador);
        Iterator it = values.iterator();
        double tmp=0;
        while(it.hasNext()){
            tmp = (double) it.next();
            for(Map.Entry k : pageRankAux.entrySet()){
                if(tmp == (double)k.getValue())
                    {ordenadoMap.put(k.getKey(), k.getValue());}
            }
        }
        
        System.out.println("hashMap ordenado: "+ ordenadoMap);
        
        lista.add(ordenadoMap);
        
        System.out.println("Lista final: "+lista);
        return lista;
        
             
    }
}
    
    

