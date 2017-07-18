
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tpfinal.tp.estructuras.grafo.Arista;

import tpfinal.tp.estructuras.grafo.Grafo;
import tpfinal.tp.estructuras.grafo.Vertice;
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.integrador.MaterialCapacitacion;

public class GrafoTest {
    
    Grafo grafo;
    Vertice<MaterialCapacitacion> vA;
    Vertice<MaterialCapacitacion> vB;
    Vertice<MaterialCapacitacion> vC;
    Vertice<MaterialCapacitacion> vD;
    
    
    public GrafoTest() {
    }
    
    @Before
    public void setUp() {
        grafo = new Grafo();
        vA = new Vertice(new Libro(1,"A"));
        vB = new Vertice(new Libro(2,"B"));
        vC = new Vertice(new Libro(3,"C"));
        vD = new Vertice(new Libro(4,"D"));
       grafo.conectar(vA, vB);
      //  grafo.conectar(vA, vC);
        grafo.conectar(vA, vD);
        grafo.conectar(vB, vD);
        grafo.conectar(vB, vC);
        grafo.conectar(vD, vB);
        
    }
    
    @After
    public void tearDown() {
    }

   @Test
    public void testBuscarCamino() {
        List<Arista<MaterialCapacitacion>> aristas = grafo.buscarCamino(vA, vC);
       
        System.out.println(aristas);
        Integer tam=aristas.size();
        System.out.println("cant saltos"+tam);
        
        
//        assertEquals("A", aristas.get(0).getInicio().getValor().getTitulo());
//        assertEquals("C", aristas.get(0).getFin().getValor().getTitulo());
//        assertTrue(aristas.size()==1);

//        List<Arista<MaterialCapacitacion>> aristas1 = grafo.buscarCamino(vA, vC, 2);
//        System.out.println(aristas1);
//        assertTrue(aristas1.size()==2);
//        
//        List<Arista<MaterialCapacitacion>> aristas2 = grafo.buscarCamino(vA, vC, 3);
//        System.out.println(aristas2);
//        assertTrue(aristas2.size()==3);
//        
//        List<Arista<MaterialCapacitacion>> aristas3 = grafo.buscarCamino(vB, vD, 1);
//        System.out.println("aristas3:"+aristas3);
//        assertTrue(!aristas3.isEmpty());
//        
//        
//        List<Arista<MaterialCapacitacion>> aristas4 = grafo.buscarCamino(vB, vA, 3);
//        System.out.println(aristas4);
//        assertTrue(aristas4.isEmpty());
        
    }
    
}