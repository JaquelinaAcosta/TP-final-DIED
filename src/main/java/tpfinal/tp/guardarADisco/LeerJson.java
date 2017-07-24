/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.guardarADisco;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.util.List;
import tpfinal.tp.integrador.Suscriptor;


public class LeerJson {
   
    
    public static void main(String args[]) throws java.io.IOException {
        SuscriptoresDao suscriptores;
        JsonParser parser = new JsonParser();
        suscriptores=new SuscriptoresDao();
        List<Suscriptor> listaSuscriptor= suscriptores.cargarLista();
        for(Suscriptor elem: listaSuscriptor)
        {
            Suscriptor elemento=elem;
            System.out.println(elemento.getNombre());
        }
//        FileReader fr = new FileReader("C:\\Users\\hp\\Documents\\UTN\\TP-final-DIED\\Suscriptores.json");
//        JsonElement datos = parser.parse(fr);
//        dumpJSONElement(datos);
    }
 

//       public static void dumpJSONElement(JsonElement elemento) {
//        //   JsonObject jsonObject = (JsonObject) elemento;
//    if (elemento.isJsonObject()) {
//        // Es un conjunto de pares clave, valor
//        // Para cada par, imprimir la clave y llamar a dumpJSONElement(valor)
//        System.out.println("Soy ubjeto");
//    }
//    else if (elemento.isJsonNull()) {
//        System.out.println("Es NULL");
//     } else {
//            System.out.println("Es otra cosa");
//        }
//    }
}//fin de tdo
    

