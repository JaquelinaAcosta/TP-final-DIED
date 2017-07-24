/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.persistencia;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class GenericDaoJSON<T> {

    private String nombreArchivo;
    private String directorio;
//Si no definimos nada, los archivos JSON se generan en el directorio donde está ejecutando la aplicación. 
    
    public GenericDaoJSON(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void setDirectorio(String directorio) {
        this.directorio = directorio;
    }
    
    

    private String getArchivo() {
        if (directorio != null) {
            File f = new File(directorio);
            if (f.exists() && f.isDirectory()) {
                return directorio + "/" + nombreArchivo;
            }
        }
        Path currentRelativePath = Paths.get("");
        return currentRelativePath.toAbsolutePath().toString() + "/" + nombreArchivo;
    }

    
    public void guardar(List<T> t) {

        Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("dd/MM/yyyy").create();

        try {
    //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor

            FileWriter file = new FileWriter(getArchivo());
            file.write(gson.toJson(t));
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<T> cargar(Type typeArgs) {
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        List<T> models = null;
        try {
            //Creamos un archivo FileReader que obtiene lo que tenga el archivo
            FileReader lector=new FileReader(getArchivo());
            //El contenido deL TXT se guarda en un BufferedReader
            BufferedReader br = new BufferedReader(lector);
            // Analiza JSON a Java
            models = gson.fromJson(br, typeArgs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return models;
    }
    
    
    public void agregar(Type typeArgs, T nuevo){
        List<T> lista =cargar(typeArgs);
        lista.add(nuevo);
        guardar(lista);
    }
    
    public void borrar(Type typeArgs, T objeto){
        List<T> lista =cargar(typeArgs);
        lista.remove(objeto);
        guardar(lista);
    }
    
    public void editar(Type typeArgs, T viejo, T editar ){
        List<T> lista =cargar(typeArgs);
        lista.remove(viejo);
        lista.add(editar);
        guardar(lista);        
    }

}
