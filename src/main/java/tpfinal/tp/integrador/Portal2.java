/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.integrador;

import java.util.ArrayList;
import java.util.Collections;
import tpfinal.tp.excepcion.MaterialNoEncontradoException;
import tpfinal.tp.ordenamiento.Ordenable;


public class Portal2 extends Portal{
    protected ArrayList<MaterialCapacitacion> array; 

    public Portal2(ArrayList<MaterialCapacitacion> array) {
        this.array = array;
    }

  
 public ArrayList<MaterialCapacitacion> listar(){
   Collections.sort(array);
   return array;
}

   
   
    public ArrayList<MaterialCapacitacion> listar(TipoOrdenamiento tipo){
      
        if(tipo.equals(TipoOrdenamiento.ALFABETICO_FECHA)) {//si esto es verdadero
            return this.listar();
        }
        else {
            ComparatorPrecio cp = new ComparatorPrecio();
            Collections.sort(array,cp);
            return array;
        }
        
    }
    
    
    Portal2() {
        this.array= new ArrayList();
    }

   
    
    public void agregar(MaterialCapacitacion m){
        this.array.add(m);
        super.biblioteca1.agregarEnPosicion((this.array.size()- 1), (Ordenable) m);
      
     
    }
  /**  a) Implementar en la clase Portal2 el mÃ©todo â€œpublic MaterialCapacitacion buscar(Integer prcio)â€�
que busca el primer material de capacitaciÃ³n encontrado que posee el precio solicitado en valor
entero.*/
    
    
    public MaterialCapacitacion buscar(Integer precio)  throws MaterialNoEncontradoException
   {
      
        this.listar(TipoOrdenamiento.PRECIO); //ordenamos por precio
        MaterialCapacitacion resultado= busquedaBinaria(0,array.size()-1,precio);
        if(resultado==null){
            throw new MaterialNoEncontradoException(precio);
        }
        return resultado; //devuelve el material de capacitacion que tiene ese precio
        
   }
 

   private MaterialCapacitacion busquedaBinaria(Integer inicio,Integer fin,Integer precio)     
   {

       while(inicio<=fin){
           Integer medio = (fin + inicio) / 2;
           if(array.get(medio).precio()== (double)precio){
               return array.get(medio);
            }
            else if(array.get(medio).precio()<(double)precio)
               return busquedaBinaria(medio+1,fin,precio);
            else
               return busquedaBinaria(inicio,medio-1,precio);
            }
        return null;
       
   }
    
  
/***

     * @param array)*/
   

   
}//fin de tdo
