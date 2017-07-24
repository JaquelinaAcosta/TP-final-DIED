
package tpfinal.tp.integrador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import tpfinal.tp.estructuras.ArbolBinarioBusqueda;
import tpfinal.tp.util.ComparadorCalificacion;
import tpfinal.tp.util.ComparadorPrecio;
import tpfinal.tp.util.ComparadorTitulo;

public class Portal{
    private ArbolBinarioBusqueda bibliotecaOrdenada;
    protected Collection<MaterialCapacitacion> biblioteca;
    private Collection<Suscriptor> suscriptores;
//    protected ArregloDied biblioteca1;
    
    public Portal(){
        super();
        this.bibliotecaOrdenada = new ArbolBinarioBusqueda();
        //a) crear e inicializar biblioteca con la estructura adecuada
        this.biblioteca = new HashSet();
//        // crear e inicializar suscriptores con la estructura adecuada
//        this.suscriptores= new LinkedHashSet();
//        biblioteca1=new ArregloDied(10);
    }
//     public void agregarMaterial(Integer i,Ordenable m){
//        this.biblioteca1.agregarEnPosicion(i, m);
//    }
    
    public void agregar(MaterialCapacitacion m){     
        this.biblioteca.add(m);
        this.bibliotecaOrdenada.add(m);
    }
       
    public List<MaterialCapacitacion> ordenadaAlfabeticamente(){
        this.bibliotecaOrdenada.setComparador(ComparadorTitulo.getInstance());
        return this.bibliotecaOrdenada.ordenado();
    }
    
    public List<MaterialCapacitacion> ordenadaPorPrecio(){
        this.bibliotecaOrdenada.setComparador(ComparadorPrecio.getInstance());
        return this.bibliotecaOrdenada.ordenado();
    }
    
    public List<MaterialCapacitacion> ordenadaPorCalificacionEditor(){
        this.bibliotecaOrdenada.setComparador(ComparadorCalificacion.getInstance());
        return this.bibliotecaOrdenada.ordenado();
    }   
    
//    public List<MaterialCapacitacion> rangoDeCalificacion(Integer c1,Integer c2){
//        this.bibliotecaOrdenada.setComparador(ComparadorCalificacion.getInstance());  
//        Video dummy1 = new Video();
//        Video dummy2 = new Video();
//        dummy1.setCalificacion(c1);
//        dummy2.setCalificacion(c2);
//        return this.bibliotecaOrdenada.rango(dummy1, dummy2);
//    } 
    
    /**
     * Retorna una copia de la biblioteca ordenada por Nombre y Precio empleando
     * el algoritmo recibido como parÃ¡metro
     * @param servicio
     * @return 
     */
//    public ArregloDied listarBiblioteca(OrdenadorService servicio){
//        this.biblioteca1.setOrdenador(servicio);
//        return this.biblioteca1.ordenar();
//    }
//    /**
//     * Si no recibe algoritmo de ordenamiento la retorna tal cual estÃ¡ cargada
//     * @return 
//     */
//    public ArregloDied listarBiblioteca(){
//        return this.biblioteca1;
//    }

}
