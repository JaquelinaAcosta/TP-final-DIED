
package tpfinal.tp.integrador;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import tpfinal.tp.excepcion.CreditoInsuficienteException;


public final class Suscriptor {
    private String nombre; 
    private String apellido; 
    private Integer nroDocumento; 
    private Double credito;
    private List<Libro> material;
    
  private Map<MaterialCapacitacion, Integer> suscriptores;
//    
//     
//    public Suscriptor(){
//        credito=0.0;
//        this.suscriptores= new LinkedHashMap();
//    }    
//    
    public Suscriptor(String nombre,String apellido,Integer dni,Double credito){
      
        this.nombre=nombre;
        this.apellido=apellido;
        this.nroDocumento=dni;
        this.credito=credito;
    }       
    
      

    public Double getCredito() {
        return credito;
    }

    public void setCredito(Double credito) {
        this.credito = credito;
    }
    public void addCredito(Double cantidad){
        this.credito+=cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }
    
    public Integer getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(Integer nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public Suscriptor(){
        credito=0.0;
        this.suscriptores= new LinkedHashMap();
        this.material= new ArrayList<>();
    }
    public void suscribir(MaterialCapacitacion m) throws CreditoInsuficienteException{
        if(this.credito-m.precio()>0){
            this.credito-=m.precio();
            m.suscribir(this);
           suscriptores.put(m, null);
        }else{
            throw new CreditoInsuficienteException(m.precio(),this.credito);
        }
    }

    
    public Integer calificacion(MaterialCapacitacion m){
        return this.suscriptores.get(m);
    }

     public Double calificacionPromedio(){
         Integer sum=0;
         Double contador=0.0;
         for(MaterialCapacitacion m : suscriptores.keySet()){
             if(calificacion(m)!=null){
                 sum= calificacion(m) + sum;
                 contador++;
                 }
            }
         return Double.valueOf(sum/contador);
     }
     
     /**
      * Retorna la lista de materiales de capacitación en el orden histórico en que se insertaron
      * @return 
      */
     public List<MaterialCapacitacion> listar(){
         List<MaterialCapacitacion> lista = new ArrayList<MaterialCapacitacion>();
          for(MaterialCapacitacion m : suscriptores.keySet()){
             lista.add(m);
             }
         return lista;
     }

     @Override
    public String toString() {
        return "Suscriptor{" + "nombre " + nombre + ", " + "apellido " + apellido + "," + "dni " + nroDocumento + ",credito " + credito + '}';
    }

    public void agregar(MaterialCapacitacion d)throws CreditoInsuficienteException{
        // implementar el mÃ©todo agregar documentos que agrega un documento a la biblioteca solamente
        // si hay presupuesto disponible
        if(this.credito> d.precio())
        {
            material.add((Libro) d);
            this.credito-= d.precio();
        }
        else{
            throw new CreditoInsuficienteException(d.precio(), this.credito);
        }
    }   
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Suscriptor other = (Suscriptor) obj;
        if (!Objects.equals(this.nroDocumento, other.nroDocumento)) {
            return false;
        }
        return true;
    }
            
    public void quitar(MaterialCapacitacion d){
      // implementar el metodo
      d.cancelarSuscripcion();
      this.credito=disponible()+d.precio();
    }   
    
      private Double costo(){
        Double totalizador = 0.0;
        for(MaterialCapacitacion d:this.material){
            if(d!=null)totalizador +=d.precio();
        }
        return totalizador;
    }
     public Double disponible(){
        return this.credito-costo();
    }
     
    public void listarSuscripciones(){
         System.out.println("SUSCRIPCIONES DEL USUARIO");       
         for(MaterialCapacitacion unMaterial: this.material){
             if(unMaterial!=null){
                 System.out.println("     >"+unMaterial.getTitulo());
             }
         }
    }
    
  

}

