
package tpfinal.tp.integrador;

import java.util.Comparator;


public class ComparatorPrecio implements Comparator<MaterialCapacitacion> {
    
    @Override
    public int compare(MaterialCapacitacion libro1,MaterialCapacitacion libro2) {
      
      return (libro2.precio().intValue())-(libro1.precio().intValue());
       
    
}
}
