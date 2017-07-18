/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.guardarADisco;

import java.util.List;
import tpfinal.tp.integrador.Publicacion;
import tpfinal.tp.persistencia.GenericDaoJSON;

/**
 *
 * @author jaque
 */
public class PublicacionesDao {
    private GenericDaoJSON db;
    
    public PublicacionesDao(){
        db = new GenericDaoJSON("Publicacion.json");
        //        nombre del archivo donde guardaran los datos.
    }
    
    public void guardarLista(List<Publicacion> publicacion){
        db.guardar(publicacion);
    }

    public List<Publicacion> cargarLista(){
        return db.cargar(new com.google.gson.reflect.TypeToken<List<Publicacion>>(){}.getType());
           /* cuando se cargan los datos desde el disco se debe pasar como parámetro
    al método, con el nombre de lo que estamos guardando (por ejemplo Libro o Empleado) 
    */
    }
    
}
