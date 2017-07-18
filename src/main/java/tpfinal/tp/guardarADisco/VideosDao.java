/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.guardarADisco;

import java.util.List;
import tpfinal.tp.integrador.Video;
import tpfinal.tp.persistencia.GenericDaoJSON;

/**
 *
 * @author jaque
 */
public class VideosDao {
    private GenericDaoJSON db;
    
    public VideosDao(){
        db = new GenericDaoJSON("Video.json");
        //        nombre del archivo donde guardaran los datos.
    }
    
    public void guardarLista(List<Video> videos){
        db.guardar(videos);
    }

    public List<Video> cargarLista(){
        return db.cargar(new com.google.gson.reflect.TypeToken<List<Video>>(){}.getType());
    
        /* cuando se cargan los datos desde el disco se debe pasar como parámetro
    al método, con el nombre de lo que estamos guardando (por ejemplo Libro o Empleado) 
    */
    }
}
