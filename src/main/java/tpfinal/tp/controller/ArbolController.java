/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import tpfinal.tp.estructuraArbolNario.Nodo;

import tpfinal.tp.estructuraArbolNario.TipoNodo;
import tpfinal.tp.estructuraArbolNario.ArbolNario;
import tpfinal.tp.guardarADisco.ArbolDao;
import tpfinal.tp.windows.PanelAgregarAArbol;
import tpfinal.tp.windows.PanelBusquedaArbol;



/**
 *Esta clase va a controlar las relaciones entre las pantallas de ingresar
 * datos del Arbol y la de buscar los datos
 * 
 */
public class ArbolController {
    
   private ArbolNario<TipoNodo> arbolN;
   private PanelAgregarAArbol panelAgregar;
   private PanelBusquedaArbol panelBusqueda;
   private Map<TipoNodo,String> nodoMetadatos;
   private Nodo nodo;
   private Nodo raiz;
   private List<Nodo<TipoNodo>> listaNodo;
   private List<Nodo<TipoNodo>> listaNodoHijosCapitulo;
   private List<Nodo<TipoNodo>> listaNodoHijosResumen;
   private List<Nodo<TipoNodo>> listaNodoHijosMetadato;
   private List<Nodo<TipoNodo>> listaNodoHijosHijos;
   private TipoNodo tipo;
   private ArbolDao arbolDao = new ArbolDao();

   
   public ArbolController(PanelAgregarAArbol panelA,PanelBusquedaArbol panelB)
   {
       this.panelAgregar=panelA;
       this.panelBusqueda=panelB;
       this.arbolN= new ArbolNario<>();
       this.nodo= new Nodo();
       this.nodoMetadatos= new LinkedHashMap<>();
       this.listaNodo= new ArrayList<>();
       this.listaNodoHijosCapitulo= new ArrayList<>();
       this.listaNodoHijosResumen= new ArrayList<>();
       this.listaNodoHijosMetadato= new ArrayList<>();
       this.listaNodoHijosHijos= new ArrayList<>();
   }

   public ArbolController(PanelBusquedaArbol panelb)
   {
       this.panelBusqueda=panelb;
       this.arbolN= new ArbolNario<>();
       this.nodo= new Nodo();
       this.nodoMetadatos= new LinkedHashMap<>();
       this.listaNodo= new ArrayList<>();
       this.listaNodoHijosCapitulo= new ArrayList<>();
       this.listaNodoHijosResumen= new ArrayList<>();
       this.listaNodoHijosMetadato= new ArrayList<>();
       this.listaNodoHijosHijos= new ArrayList<>();

   }
   
      public ArbolController(PanelAgregarAArbol panelb)
   {
       this.panelAgregar=panelb;
       this.arbolN= new ArbolNario<>();
       this.nodo= new Nodo();
       this.nodoMetadatos= new LinkedHashMap<>();
       this.listaNodo= new ArrayList<>();
       this.listaNodoHijosCapitulo= new ArrayList<>();
       this.listaNodoHijosResumen= new ArrayList<>();
       this.listaNodoHijosMetadato= new ArrayList<>();
       this.listaNodoHijosHijos= new ArrayList<>();

   }
 
  
   //cargamos la raiz al arbol
 public void cargarRaizArbol(String material,TipoNodo tipo)
  {
 this.raiz= new Nodo(tipo,material);
 this.arbolN.setRaiz(raiz);
   
  }
   
   public List<Nodo<TipoNodo>> cargarNodoDeRaiz(String material,TipoNodo tipo)
   {
       
       Nodo<TipoNodo> n= new Nodo(tipo,material);
        listaNodo.add(n);  
        System.out.println("listaNodo"+listaNodo);
        return listaNodo;
   }
   
   public void unirNodosRaiz()
   {
       this.raiz.setHijos(listaNodo);
       this.cargarNodosHijos();
   }
   
   public void cargarNodosHijos()
   {
     for(int i=0;i <listaNodo.size();i++)
     {
          if(listaNodo.get(0).getData().equals(tipo.CAPITULO))
                  {
                     listaNodo.get(0).setHijos(listaNodoHijosCapitulo);  
                      
                   System.out.println("Agregue el hijo correctamente");
                  }
           if(listaNodo.get(1).getData().equals(tipo.METADATO))
                  {
                   listaNodo.get(1).setHijos(listaNodoHijosMetadato);   
                    
                   System.out.println("Agregue el hijo correctamente");
                  }
            if(listaNodo.get(2).getData().equals(tipo.RESUMEN))
                  {
                   listaNodo.get(2).setHijos(listaNodoHijosResumen);     
                   System.out.println("Agregue el hijo correctamente");
                  }
         
     }
      
       
   }
   
   public List<Nodo<TipoNodo>> agregarHijosCapitulo(String material,TipoNodo tipo)
   {
        Nodo<TipoNodo> n= new Nodo(tipo,material);
        this.listaNodoHijosCapitulo.add(n);
        return listaNodoHijosCapitulo;
   }
   
    public List<Nodo<TipoNodo>> agregarHijosMetadato(String material,TipoNodo tipo)
   {
        Nodo<TipoNodo> n= new Nodo(tipo,material);
        this.listaNodoHijosMetadato.add(n);
        return listaNodoHijosMetadato;
   }
    
    public List<Nodo<TipoNodo>> agregarHijosResumen(String material,TipoNodo tipo)
   {
        Nodo<TipoNodo> n= new Nodo(tipo,material);
        this.listaNodoHijosResumen.add(n);
        return listaNodoHijosResumen;
   }
    
    
  
    
    public void cargarArbol()
      {
         this.unirNodosRaiz();
         System.out.println("c argue el arbol"+arbolN.toString());
         arbolDao.agregar(arbolN);
      }
      
public void dibujarArbol()
{
        DefaultMutableTreeNode abuelo = new DefaultMutableTreeNode(this.raiz.dato());
        DefaultTreeModel modelo = new DefaultTreeModel(abuelo);
        JTree tree = new JTree(modelo);

        // Construccion de los datos del arbol
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode(this.listaNodo.get(0).dato());
        DefaultMutableTreeNode tio1 = new DefaultMutableTreeNode(this.listaNodo.get(1).dato());
        DefaultMutableTreeNode tio2 = new DefaultMutableTreeNode(this.listaNodo.get(2).dato());
        modelo.insertNodeInto(padre, abuelo, 0);
        modelo.insertNodeInto(tio1, abuelo, 1);
        modelo.insertNodeInto(tio2, abuelo, 2);

        for(int i=0;i<this.listaNodoHijosCapitulo.size();i++)
        {
        DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(this.listaNodoHijosCapitulo.get(i).dato());
        modelo.insertNodeInto(hijo, padre, i);
        }
        
        for(int k=0;k<this.listaNodoHijosMetadato.size();k++)
        {
            DefaultMutableTreeNode hijo1 = new DefaultMutableTreeNode(this.listaNodoHijosMetadato.get(k).dato());
            modelo.insertNodeInto(hijo1,tio1, k);
        }
        
        for(int j=0;j<this.listaNodoHijosResumen.size();j++)
        {
             DefaultMutableTreeNode hijo2 = new DefaultMutableTreeNode(this.listaNodoHijosResumen.get(j).dato());
             modelo.insertNodeInto(hijo2, tio2, j);
        }
        
        // Construccion y visualizacion de la ventana
        JFrame v = new JFrame();
        JScrollPane scroll = new JScrollPane(tree);
        v.getContentPane().add(scroll);
        v.pack();
        v.setVisible(true);
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}
    
  public void buscarNodo(String titulo,TipoNodo tipoViene)
       {
           System.out.println("Hola entreeeeee");
        List<ArbolNario> listaArbol= new ArrayList<ArbolNario>();
        listaArbol= arbolDao.cargarLista();  
       
       //  System.out.println("esta es mi lista "+listaArbol);
         for(int i=0;i<listaArbol.size();i++)
        {
           Nodo<TipoNodo> n= listaArbol.get(i).getRaiz();
           System.out.println("este es mi nodo "+n);
           
           List<Nodo<TipoNodo>> listaHijo= n.getHijos();
           if((n.dato().equals(titulo))&&(n.getData().equals(tipoViene)))//si hay coincidencia en la raiz
           {
                  System.out.println("HUBO COINCIDENCIA del padre"); 
                  /*creo el arbol*/
                  
                    DefaultMutableTreeNode abuelo = new DefaultMutableTreeNode(n.dato());
                    DefaultTreeModel modelo = new DefaultTreeModel(abuelo);
                    JTree tree = new JTree(modelo);
                    //si tiene mas de un hijo exploro tdo el arbol   
                        for(int z=0;z< listaHijo.size();z++)
                        {
                      DefaultMutableTreeNode padre = new DefaultMutableTreeNode(listaHijo.get(z).dato());
                      modelo.insertNodeInto(padre, abuelo, z); 
                        }
                         JFrame v = new JFrame();
                        JScrollPane scroll = new JScrollPane(tree);
                        v.getContentPane().add(scroll);
                        v.pack();
                        v.setVisible(true);
                        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                        
           }
           
           for(int k=0;k< listaHijo.size();k++)
           {
//           Nodo<TipoNodo> nHijo= listaArbol.get(k).getRaiz();
//           System.out.println("este es mi nodo de mi hijo "+nHijo);
//           List<Nodo<TipoNodo>> listaSubHijo= nHijo.getHijos();
          if((listaHijo.get(k).dato().equals(titulo))&&(listaHijo.get(k).getData().equals(tipoViene)))
               {
                    DefaultMutableTreeNode abuelo = new DefaultMutableTreeNode(listaHijo.get(k).dato());
                    DefaultTreeModel modelo = new DefaultTreeModel(abuelo);
                    JTree tree = new JTree(modelo);
//                     for(int w=0;w< listaSubHijo.size();w++)
//                        {
//                      DefaultMutableTreeNode padre = new DefaultMutableTreeNode(listaSubHijo.get(w).dato());
//                      modelo.insertNodeInto(padre, abuelo, w); 
//                        }
                         JFrame v = new JFrame();
                        JScrollPane scroll = new JScrollPane(tree);
                        v.getContentPane().add(scroll);
                        v.pack();
                        v.setVisible(true);
                        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                   System.out.println("HUBO COINCIDENCIAaaaaaaaaaaaaa del hijo ");  
               }
           }
       }
         
    }
     
}
