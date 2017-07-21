/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.estructuras;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.util.ComparadorTitulo;

/**
 *
 * @author jaque
 */
public class ArbolBinarioBusqueda extends Arbol {

    private MaterialCapacitacion valor;
    private Arbol izquierdo;
    private Arbol derecho;
    private static Comparator<MaterialCapacitacion> _COMPARADOR=ComparadorTitulo.getInstance(); 
    
    public ArbolBinarioBusqueda() {
        this.valor = null;
        this.izquierdo = new ArbolVacio();
        this.derecho = new ArbolVacio();
    }
    
    public ArbolBinarioBusqueda(MaterialCapacitacion e) {
        this();
        this.valor = e;
    }


    @Override
    public boolean esVacio() {
        return false;
    }

    @Override
    public Arbol izquierdo() {
        return this.izquierdo;
    }

    @Override
    public Arbol derecho() {
        return this.derecho;
    }

    @Override
    public boolean contiene(MaterialCapacitacion unValor) {
        if(this.valor.equals(unValor)) return true;
        return this.izquierdo.contiene(unValor) || this.derecho.contiene(unValor);
    }

    @Override
    public boolean equals(Arbol unArbol) {
        return unArbol instanceof ArbolBinarioBusqueda && this.valor.equals(((ArbolBinarioBusqueda)unArbol).valor) && this.izquierdo.equals(unArbol.izquierdo()) && this.derecho.equals(unArbol.derecho());
    }

    @Override
    public Integer profundidad() {
        return 1 + Math.max(this.izquierdo.profundidad(), this.derecho.profundidad());
    }      
    
    @Override    
    public void setComparador(Comparator<MaterialCapacitacion> comp){
        if(_COMPARADOR!=comp){
            _COMPARADOR = comp;
            // como cambiamos el comparador rearmarmos el árbol segun el criterio nuevo
            // de comparacion ubicando en el nodo actual que es el árbo raiz el primer elemento
            // de la lista y luego agregando a cada uno de ellos el siguiente elemento
            List<MaterialCapacitacion> lista = this.inOrden();
            this.valor = lista.get(0);
            this.izquierdo = new ArbolVacio();
            this.derecho = new ArbolVacio();
            for(int i=1;i<lista.size();i++){
                this.add(lista.get(i));
            }        
        }
    }

    @Override
    public void add(MaterialCapacitacion mat) {                
        if(this.valor==null) {
            this.valor=mat;
            return;
        } 
        if(_COMPARADOR.compare(mat,this.valor)>0) {
            if(this.derecho.esVacio()) this.derecho= new ArbolBinarioBusqueda(mat);
            else this.derecho.add(mat);
        }else {
            if(this.izquierdo.esVacio()) this.izquierdo= new ArbolBinarioBusqueda(mat);
            else this.izquierdo.add(mat);                    
        }
    }
    
    @Override
    public List<MaterialCapacitacion> inOrden() {
        List<MaterialCapacitacion> lista = new ArrayList<MaterialCapacitacion>();
	lista.addAll(this.izquierdo.inOrden());
	lista.add(this.valor);
	lista.addAll(this.derecho.inOrden());
	return lista;
    }
        
    /**
     * Este método debe recorrer el árbol binario de búsqueda de modo tal que en su resultado se
muestren todos los elementos del árbol ordenados de manera creciente según su
comparador
     * @return 
     */
    @Override
    public List<MaterialCapacitacion> ordenado() {
        List<MaterialCapacitacion> lista = this.inOrden();
        //implementar... lo habiamos hecho mal new List<MsterialCapacitacion>                
        return lista;    
    }
    
    /*
    En la clase ArbolBinarioBusqueda implementar el método rango. El mismo toma dos valores inicial y
final, y busca todos los elementos del rango que sean mayores o iguales que inicial y menor o igual
que final según el criterio de comparación. Notar que el criterio de comparación se setea en un
método setComparador y se almacena en la variable static _COMPARADOR
    */
    
    @Override
    public List<MaterialCapacitacion> rango(MaterialCapacitacion m1,MaterialCapacitacion m2) {
        List<MaterialCapacitacion> lista = new ArrayList<MaterialCapacitacion>();
        //implementar    
        //que sean mayores o iguales que el inicial=m1
        
        if((_COMPARADOR.compare(this.valor,m1)==1)&& (_COMPARADOR.compare(this.valor, m2)==-1)){ //si es la raiz
            lista.addAll(this.izquierdo.rango(m1, this.valor));
            lista.add(this.valor);
            lista.addAll(this.derecho.rango(this.valor, m2));
        }
         if((_COMPARADOR.compare(this.valor,m1)==1)&& (_COMPARADOR.compare(this.valor, m2)==1)){
            lista.addAll(this.izquierdo.rango(m1,m2));
        }
           if((_COMPARADOR.compare(this.valor,m1)==-1)&& (_COMPARADOR.compare(this.valor, m2)==-1)){
               lista.addAll(this.derecho.rango(m1, m2));
           }
         
     return lista;
    }
        
}

