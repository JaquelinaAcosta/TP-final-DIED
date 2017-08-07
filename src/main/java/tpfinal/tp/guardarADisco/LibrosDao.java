/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.guardarADisco;

import java.util.List;
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.persistencia.GenericDaoJSON;


public class LibrosDao {
    private GenericDaoJSON db;
    
    public LibrosDao(){
        db = new GenericDaoJSON("Libros.json");
//        nombre del archivo donde guardaran los datos. 
    }
    
    public void guardarLista(List<Libro> libro){
        db.guardar(libro);
    }

    public List<Libro> cargarLista(){
        return db.cargar(new com.google.gson.reflect.TypeToken<List<Libro>>(){}.getType());
           /* cuando se cargan los datos desde el disco se debe pasar como parámetro
    al método, con el nombre de lo que estamos guardando (por ejemplo Libro o Empleado) 
    */
    }
    
     public void editar(Libro viejo,Libro editar){
        db.editar(new com.google.gson.reflect.TypeToken<List<Libro>>(){}.getType(), viejo, editar);
    }
    
    public void agregar(Libro video){
        db.agregar(new com.google.gson.reflect.TypeToken<List<Libro>>(){}.getType(), video);
    }
    
    public void borrar(Libro borrar){
        db.borrar(new com.google.gson.reflect.TypeToken<List<Libro>>(){}.getType(), borrar);
    }
    
}
