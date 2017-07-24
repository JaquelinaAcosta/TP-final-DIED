/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.util;

import java.util.Comparator;
import tpfinal.tp.integrador.MaterialCapacitacion;

public class ComparadorPrecio implements Comparator<MaterialCapacitacion>{
        @Override
        public int compare(MaterialCapacitacion o1, MaterialCapacitacion o2) {
            return o1.precio().compareTo(o2.precio());
        };

        private static ComparadorPrecio _instancia = null;
        private ComparadorPrecio(){}
        
        public static ComparadorPrecio getInstance(){
            if(_instancia==null) _instancia = new ComparadorPrecio();
            return _instancia;
        }
}
