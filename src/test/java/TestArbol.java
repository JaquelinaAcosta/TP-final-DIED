
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import tpfinal.tp.estructuraArbolNario.ArbolNario;
import tpfinal.tp.estructuraArbolNario.Node;
import tpfinal.tp.estructuraArbolNario.Nodo;
import tpfinal.tp.estructuraArbolNario.TipoNodo;
import tpfinal.tp.estructuraArbolNario.Tree;
import tpfinal.tp.guardarADisco.ArbolDao;
import tpfinal.tp.integrador.MaterialCapacitacion;

/**
 * Esta clase es un ejemplo se como funcionaria la busqueda de texto
 * 
 */

public class TestArbol {
    
   Tree<TipoNodo> arbolN;
    Node<TipoNodo> n1;
    Node<TipoNodo> n2;
    Node<TipoNodo> n3;
    Node<TipoNodo> n4;
//    Nodo<TipoNodo> raiz;
//    
    private ArbolDao arbolDao= new ArbolDao();
    private List<Node<TipoNodo>> arbol;
   private List<Node<TipoNodo>> nodoLista;
  private TipoNodo tipo;
    private Node n5;
    public TestArbol()
    {
        
    }
    

    
@Test
    public void agregarDato()
    {
        this.arbol= new ArrayList<>();
        this.nodoLista= new ArrayList<>();
      this.arbolN= new Tree<>();
         n1= new Node(tipo.TITULO,"Video1");
       
         
        n2= new Node(tipo.METADATO,"");
        n5=new Node(tipo.AUTOR,"Alejandro");
        n3= new Node(tipo.SECCION,"Seccion1");
      
        arbol.add(n2);
        nodoLista.add(n5);
       
      arbolN.setRootElement(n1);
      n1.setChildren(arbol);
      n2.setChildren(nodoLista);
      
      
      
      ArrayList arbol = new ArrayList<Tree>()
                arbol.add(arbolN);
               arbolDao.guardarLista(arbol);
       System.out.println("esrte es el arbol"+arbolN.toString());
      
    }
    
}
