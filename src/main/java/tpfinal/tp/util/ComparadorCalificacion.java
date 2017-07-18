/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.util;

import java.util.Comparator;
import tpfinal.tp.integrador.MaterialCapacitacion;


public class ComparadorCalificacion implements Comparator<MaterialCapacitacion>{
        @Override
        public int compare(MaterialCapacitacion o1, MaterialCapacitacion o2) {
            return o1.getCalificacion().compareTo(o2.getCalificacion());
        };

        private static ComparadorCalificacion _instancia = null;
        private ComparadorCalificacion(){}
        
        public static ComparadorCalificacion getInstance(){
            if(_instancia==null) _instancia = new ComparadorCalificacion();
            return _instancia;
        }
}

