
package tpfinal.tp.integrador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.Objects;




public abstract class MaterialCapacitacion implements Comparable<MaterialCapacitacion>{
    

    
    protected TemasMateriales tema;
    protected Integer id;
    protected String titulo;
    private Integer suscripciones;
    
    public abstract void liquidar();
    
    /**
     * Es la calificacion que le pone el revisor al material disponible
     */
    protected Integer calificacion; 
    /**
     * Costo básico que debe sumarse al precio por el mero hecho de publicarlo en el portal
     */
    protected Double costo;
    
    /**
     * Fecha a partir de la cual está disponible para los suscriptores
     */
    protected Date fechaPublicacion;
    
    /**
     * Listado de suscriptores que seleccionaron este material entre sus materiales de capacitacion
     */
    protected Collection<Suscriptor> suscriptores;
    
    public MaterialCapacitacion() {
        this.fechaPublicacion = new Date();
        suscriptores = new LinkedHashSet<>();
    }       
    public MaterialCapacitacion(String titulo) {
        this();
        this.titulo = titulo;
    }

    public MaterialCapacitacion(Integer id,String titulo){
        this();
        this.id=id;
        this.titulo=titulo;
        this.costo =100.0;
        this.calificacion=6;
        this.fechaPublicacion = new Date();
    }
    
    public MaterialCapacitacion(String titulo,Integer calificacion,Double costo,Date fecha) {
        this();
        this.titulo = titulo;
        this.calificacion = calificacion;
        this.costo = costo;
        this.fechaPublicacion = fecha;
    } 

    public String getTitulo() {
        return titulo;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public Double getCosto() {
        return costo;
    }
    
    public TemasMateriales getTema(){
        return tema;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setSuscriptores(Collection<Suscriptor> suscriptores) {
        this.suscriptores = suscriptores;
    }
       

    
    @Override
    public String toString() {
        return "{" + "titulo=" + titulo + " calificacion= "+this.calificacion + " fecha=" + this.fechaPublicacion() + " precio=" + this.precio() + "tema=" + this.tema + '}'+"\r\n";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.titulo);
        hash = 53 * hash + Objects.hashCode(this.calificacion);
        hash = 53 * hash + Objects.hashCode(this.costo);
        return hash;
    }

    @Override
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
        final MaterialCapacitacion other = (MaterialCapacitacion) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.calificacion, other.calificacion)) {
            return false;
        }
        if (!Objects.equals(this.costo, other.costo)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(MaterialCapacitacion o) {
        int dif = this.titulo.compareTo(o.getTitulo());
        if(dif == 0) return this.costo.compareTo(o.costo);
        else return dif;
    }
    
    
    
    public final String fechaPublicacion(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(this.fechaPublicacion);
    }
    
    /**
     * El precio de un material se define según el tipo del material y toma como base el costo del mismo
     * @return 
     */
    public abstract Double precio();

     //Agregamos del taller 1 parte 2, ORDENAMIENTO 
    public Long valorOrdenamiento() {
        return Long.valueOf(numerarString(this.titulo) + "" + formatoPrecio(this.precio()));
    }
    
    private Long formatoPrecio(Double precio) {
        Long precioEntero = Math.round(precio);
        Long x = precioEntero % 10000;
        Long formato = 10000 + x;
        return formato;
    }
    
     private Long numerarString(String arg) {
        String origen = arg.toUpperCase();
        String resultado = "";
        char unChar;
        for (int i = 0; i < 4; i++) {
            Integer aux;
            if (i > origen.length() - 1) {
                aux = 37;
            } else {
                unChar = origen.charAt(i);
                if (unChar >= 'A' && unChar <= 'Z') {
                    aux = unChar - 54;
                } else {
                    aux = 38;
                }
            }
            resultado += aux;
        }
        return Long.valueOf(resultado);
    }

    
    public void suscribir(Suscriptor s){
        this.suscriptores.add(s);
    }
    
    
        
    public void publicar(String f){
     try{
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("DD/MM/YYYY");
        GregorianCalendar dias45, hoy;
        dias45 = new GregorianCalendar();
        dias45.add(GregorianCalendar.DAY_OF_YEAR, -45);
        hoy = new GregorianCalendar();
        hoy.setTime(formato.parse(f));
        if(hoy.after(dias45)){
        }   
        }catch(ParseException e){
        System.out.println("Ocurrio un error de parseo de fechas");
     }
       
    }
    public void suscribir() {
        this.suscripciones = this.suscripciones + 1;
    }
    
    public Integer suscripciones() {
        return this.suscripciones;
    }
    
     public void cancelarSuscripcion() {
        this.suscripciones = this.suscripciones - 1;
    }

    
}

