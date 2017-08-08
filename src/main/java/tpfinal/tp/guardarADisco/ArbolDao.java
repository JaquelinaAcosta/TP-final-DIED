/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.guardarADisco;

import java.util.ArrayList;
import java.util.List;
import tpfinal.tp.estructuraArbolNario.ArbolNario;
import tpfinal.tp.estructuraArbolNario.Tree;
import tpfinal.tp.persistencia.GenericDaoJSON;


public class ArbolDao {

    private GenericDaoJSON db;
    
    public ArbolDao(){
        db = new GenericDaoJSON("Arbol.json");
//        nombre del archivo donde guardaran los datos. 
    }
    
    public void guardarLista(List<Tree> arbol){
        db.guardar(arbol);
    }

    public List<Tree> cargarLista(){
        return db.cargar(new com.google.gson.reflect.TypeToken<List<Tree>>(){}.getType());
           /* cuando se cargan los datos desde el disco se debe pasar como parámetro
    al método, con el nombre de lo que estamos guardando (por ejemplo Libro o Empleado) 
    */
    }
    
//     public void editar(ArbolNario viejo,ArbolNario editar){
//        db.editar(new com.google.gson.reflect.TypeToken<List<ArbolNario>>(){}.getType(), viejo, editar);
//    }
//    
    public void agregar(Tree arbol){
        db.agregar(new com.google.gson.reflect.TypeToken<List<Tree>>(){}.getType(), arbol);
    }
    
//    public void borrar(ArbolNario borrar){
//        db.borrar(new com.google.gson.reflect.TypeToken<List<ArbolNario>>(){}.getType(), borrar);
//    }
    
}


