/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.guardarADisco;

import com.google.gson.Gson;
import java.util.List;

import org.junit.Test;
import tpfinal.tp.integrador.Suscriptor;
import tpfinal.tp.persistencia.GenericDaoJSON;


public class SuscriptoresDao {
     private final GenericDaoJSON db;
    
    public SuscriptoresDao(){
        db = new GenericDaoJSON("Suscriptores.json");
        //        nombre del archivo donde guardaran los datos.
    }
    
    public void guardarLista(List<Suscriptor> suscriptor){
        db.guardar(suscriptor);
    }

    public List<Suscriptor> cargarLista(){
        return db.cargar(new com.google.gson.reflect.TypeToken<List<Suscriptor>>(){}.getType());
           /* cuando se cargan los datos desde el disco se debe pasar como parámetro
    al método, con el nombre de lo que estamos guardando (por ejemplo Libro o Empleado) 
    */
    }
    
    public void editar(Suscriptor viejo,Suscriptor editar){
        db.editar(new com.google.gson.reflect.TypeToken<List<Suscriptor>>(){}.getType(), viejo, editar);
    }
    
    public void agregar(Suscriptor video){
        db.agregar(new com.google.gson.reflect.TypeToken<List<Suscriptor>>(){}.getType(), video);
    }
    
    public void borrar(Suscriptor borrar){
        db.borrar(new com.google.gson.reflect.TypeToken<List<Suscriptor>>(){}.getType(), borrar);
    }
    
}
