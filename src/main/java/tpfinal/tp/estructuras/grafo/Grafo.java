package tpfinal.tp.estructuras.grafo;


import java.util.ArrayList;
import java.util.List;
import tpfinal.tp.estructuras.grafo.Arista;
import tpfinal.tp.estructuras.grafo.Vertice;




public class Grafo<T> {

	protected List<Arista<T>> aristas;
	protected List<Vertice<T>> vertices;

	
	public Grafo(){
		this.aristas = new ArrayList<Arista<T>>();
		this.vertices = new ArrayList<Vertice<T>>();
	}

	/**
	 * @param nodo
	 */
	public void addNodo(T nodo){
		this.addNodo(new Vertice<T>(nodo));
	}

	/**
	 * @param nodo
	 */
	public void addNodo(Vertice<T> nodo){
		this.vertices.add(nodo);
	}
        public void addArista(Arista<T> arista){
		this.aristas.add(arista);
	}
	
	/**
	 * @param n1
	 * @param n2
	 */
	public void conectar(T n1,T n2){
		this.conectar(getNodo(n1), getNodo(n2), 0.0);
	}

        /**
	 * @param nodo1
	 * @param nodo2
	 */
	public Arista<T> conectar(Vertice<T> nodo1,Vertice<T> nodo2){
            Arista<T> arista = new Arista<T>(nodo1,nodo2,0.0);
            this.aristas.add(arista);
            return arista;
	}
        
	/**
	 * @param n1
	 * @param n2
	 * @param valor
	 */
	public void conectar(T n1,T n2,Number valor){
		this.conectar(getNodo(n1), getNodo(n2), valor);
	}

	/**
	 * @param nodo1
	 * @param nodo2
	 * @param valor
	 */
	public void conectar(Vertice<T> nodo1,Vertice<T> nodo2,Number valor){
		this.aristas.add(new Arista<T>(nodo1,nodo2,valor));
	}
	
	/**
	 * @param valor
	 * @return
	 */
	public Vertice<T> getNodo(T valor){
		return this.vertices.get(this.vertices.indexOf(new Vertice<T>(valor)));
	}

	/**
	 * @param valor
	 * @return
	 */
	public List<T> getAdyacentes(T valor){ 
		Vertice<T> unNodo = this.getNodo(valor);
		List<T> salida = new ArrayList<T>();
		for(Arista<T> enlace : this.aristas){
			if( enlace.getInicio().equals(unNodo)){
				salida.add(enlace.getFin().getValor());
			}
		}
		return salida;
	}
	

	/**
	 * @param unNodo
	 * @return
	 */
	protected List<Vertice<T>> getAdyacentes(Vertice<T> unNodo){ 
		List<Vertice<T>> salida = new ArrayList<Vertice<T>>();
		for(Arista<T> enlace : this.aristas){
			if( enlace.getInicio().equals(unNodo)){
				salida.add(enlace.getFin());
			}
		}
		return salida;
	}
                
	
	public void imprimirAristas(){
		System.out.println(this.aristas.toString());
	}

	
	public Integer gradoEntrada(Vertice<T> vertice){
		Integer res =0;
		for(Arista<T> arista : this.aristas){
			if(arista.getFin().equals(vertice)) ++res;
		}
		return res;
	}

	/**
	 * @param vertice
	 * @return
	 */
	public Integer gradoSalida(Vertice<T> vertice){
		Integer res =0;
		for(Arista<T> arista : this.aristas){
			if(arista.getInicio().equals(vertice)) ++res;
		}
		return res;
	}
        
	/**
	 * @param v1
	 * @param v2
	 * @return
	 */
	protected boolean esAdyacente(Vertice<T> v1,Vertice<T> v2){
            List<Vertice<T>> ady = this.getAdyacentes(v1);
            for(Vertice<T> unAdy : ady){
                if(unAdy.equals(v2)) return true;
            }
            return false;
    }
        
    public Boolean esVacio(){
    	if(this.vertices!= null && !this.vertices.isEmpty()) return false;
    	return true;
    }

 
  public List<Arista<T>> buscarCamino(Vertice<T> n1,Vertice<T> n2)
  {
      ArrayList listaRtdo=new ArrayList<>();
       buscarCaminoAux(n1,n2,listaRtdo);
            return listaRtdo;   
  }
    
  private List<Arista<T>> buscarCaminoAux(Vertice<T> n1,Vertice<T> n2,List<Arista<T>> listaArista){
    ArrayList<Vertice<T>> adyacente= new ArrayList<>();
    ArrayList<Vertice<T>> copiaMarcados = new ArrayList<>();
      
    adyacente=(ArrayList<Vertice<T>>) this.getAdyacentes(n1);
   
          if(esAdyacente(n1,n2)) //creo la arista
            {
           listaArista.add(new Arista(n1,n2));
         //  this.buscarCaminoAux(n1, adyacente.get(0), listaArista);
             }
      else
        {
      for(int i=0; i<= adyacente.size()-1;i++)
        {
            listaArista.add(new Arista(n1,adyacente.get(i)));
            this.buscarCaminoAux(adyacente.get(i), n2,listaArista);  
        }
       
        }
         
           return listaArista;
  }

}
  
    //  ArrayList listaRtdo=new ArrayList<>();
//       buscarCaminoAux(n1,n2,new ArrayList<>(),listaRtdo,0);
//            return listaRtdo;   
//              public List<Arista<T>> buscarCamino(Vertice<T> n1,Vertice<T> n2)
//    public List<Arista<T>> buscarCamino(Vertice<T> n1,Vertice<T> n2)
//      {
//      ArrayList listaRtdo=new ArrayList<>();
//      ArrayList<Vertice<T>> ady=new ArrayList<>();
//      ady=(ArrayList<Vertice<T>>) this.getAdyacentes(n1);
//       buscarCaminoAux(n1,n2,ady,listaRtdo);
//            return listaRtdo;   
//  }
//    
//  private List<Arista<T>> buscarCaminoAux(Vertice<T> n1,Vertice<T> n2,ArrayList<Vertice<T>> ady,List<Arista<T>> listaArista){
//    ArrayList<Vertice<T>> adyacente= new ArrayList<>();
//    adyacente=(ArrayList<Vertice<T>>) ady.clone();
//    ArrayList<Vertice<T>> copiaMarcados = new ArrayList<>();
//      
//   // adyacente=(ArrayList<Vertice<T>>) this.getAdyacentes(n1);
//     // System.out.println("adyacente:"+adyacente);
//   for(int i=0; i<= adyacente.size()-1;i++)//recorro los ady
//        {
//   
//       if(n2.equals(adyacente.get(i)))//si es igual q el fin
//       {
//       listaArista.add(new Arista(n1,n2));
//       adyacente.remove(i);
//       copiaMarcados=(ArrayList<Vertice<T>>) adyacente.clone();
//       this.buscarCaminoAux(n1, n2, copiaMarcados, listaArista);
//        }//fin del for
//       else
//       {
//       listaArista.add(new Arista(n1,adyacente.get(i)));  
//       this.buscarCaminoAux(adyacente.get(i), n2,adyacente, listaArista);
//       
//       }
//   }
//           return listaArista;
//  }

  

//    
//  private List<Arista<T>> buscarCaminoAux(Vertice<T> n1,Vertice<T> n2,ArrayList<Vertice<T>> marcado,List<Arista<T>> listaArista,Integer Iteracion){
//    ArrayList<Vertice<T>> adyacente= new ArrayList<>();
//    ArrayList<Vertice<T>> copiaMarcados = new ArrayList<>();
//    adyacente=(ArrayList<Vertice<T>>) this.getAdyacentes(n1);
//    System.out.println("adyacente:"+adyacente);
//    for(int i=0; i<= adyacente.size()-1;i++)
//        {
//            Vertice<T> aux=adyacente.get(i);
//            System.out.println("este vertice soy"+aux);
//            System.out.println("Iteracion i="+i);
//            System.out.println("marcado:"+marcado);
//            if(!marcado.contains(aux))//si no contiene el nodo l
//            {
//               marcado.add(aux);
//               System.out.println("marcado despues del add:"+marcado);
//               if(n2!=aux)
//               {
//                  listaArista.add(new Arista(n1,aux));
//                  System.out.println("listaarista:"+listaArista);
//                  this.buscarCaminoAux(aux, n2,marcado,listaArista,0);   
//                    }
//               else
//               {
//                 listaArista.add(new Arista(n1,n2));
//                 System.out.println("listaArista"+listaArista);
//               }
//           //    System.out.println( "esto remuevo"+marcado.remove(0));
//        marcado.remove(marcado.size()-1);
//        System.out.println( "esto remuevo"+marcado);
//        }
//       
//        }//del for
//         
//           return listaArista;
  






