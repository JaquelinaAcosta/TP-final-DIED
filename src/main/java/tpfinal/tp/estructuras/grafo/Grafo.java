package tpfinal.tp.estructuras.grafo;


import java.util.ArrayList;
import java.util.List;



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
            System.out.println(aristas);
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

 
   public List<Arista<T>> buscarCamino(Vertice<T> n1,Vertice<T> n2,Integer saltos){        
        return this.buscarCaminoAux(n1, n2, saltos, new ArrayList<Arista<T>>());
         
    }
    
    public List<Arista<T>> buscarCaminoAux(Vertice<T> n1,Vertice<T> n2,Integer saltos,ArrayList<Arista<T>> resultado){
        ArrayList<Vertice<T>> listaVertice= new ArrayList<>();
        if(saltos==0)
            return new ArrayList<>(); //retorno vacio
        if(esAdyacente(n1, n2)&& saltos ==1) {
            resultado.add(new Arista(n1,n2));
            return resultado;
        }else{
            listaVertice=(ArrayList<Vertice<T>>) this.getAdyacentes(n1);
             
        System.out.println("esta es la lista de vertices ady"+listaVertice);
            for(int i=0;i<listaVertice.size();i++)//empezamos a recorrer la lista de adyacentes de n1
            {
                resultado.add(new Arista(n1,listaVertice.get(i)));
                this.buscarCaminoAux(listaVertice.get(i),n2,saltos-1,resultado);                    
                }        
            }
                
        return resultado;
    }
    
}
