
import org.junit.Before;
import org.junit.Test;
import tpfinal.tp.estructuraArbolNario.ArbolNario;
import tpfinal.tp.estructuraArbolNario.Nodo;
import tpfinal.tp.integrador.MaterialCapacitacion;

/**
 * Esta clase es un ejemplo se como funcionaria la busqueda de texto
 * 
 */

public class TestArbol {
    
    ArbolNario<MaterialCapacitacion> arbolN;
    Nodo<MaterialCapacitacion> n1;
    Nodo<MaterialCapacitacion> n2;
    Nodo<MaterialCapacitacion> n3;
    Nodo<MaterialCapacitacion> n4;
    Nodo<MaterialCapacitacion> n5;
    
    
    public TestArbol()
    {
        
    }
    

    
@Test
    public void agregarDato()
    {
        arbolN= new ArbolNario();
        n1= new Nodo("titu1o");
        n2= new Nodo("Metadato");
        n3= new Nodo("Autor");
        
     arbolN.setRaiz(n1);
        n1.addHijo(n2);
       n2.addHijo(n3);

        System.out.println(arbolN);    
    }
    
}
