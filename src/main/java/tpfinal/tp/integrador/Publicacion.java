
package tpfinal.tp.integrador;

import java.util.Date;
import java.util.Objects;


public class Publicacion extends MaterialCapacitacion{
    private String doi;
    private Double factorImpacto;
    private Double valorSuscripcionAnual;

    public Publicacion(){
        super();
    }
    
    public Publicacion(String titulo,Integer calificacion,Double costo,Date fecha,String doi,Double valorSuscripcionAnual,Double factorImpacto) {
        super( titulo,calificacion,costo,fecha);        
        this.doi = doi;
    }   
    
    public Publicacion(String titulo, TemasMateriales tema,Date fecha, Integer calificacion,Double costo) {
        super.titulo=titulo;    
        super.tema=tema;
        super.fechaPublicacion=fecha;
        super.calificacion=calificacion;
        super.costo=costo;
    }  

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public Double getFactorImpacto() {
        return factorImpacto;
    }

    public void setFactorImpacto(Double factorImpacto) {
        this.factorImpacto = factorImpacto;
    }

    public Double getValorSuscripcionAnual() {
        return valorSuscripcionAnual;
    }

    public void setValorSuscripcionAnual(Double valorSuscripcionAnual) {
        this.valorSuscripcionAnual = valorSuscripcionAnual;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + super.hashCode();
        hash = 97 * hash + Objects.hashCode(this.doi);
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
        final Publicacion other = (Publicacion) obj;
        if (!Objects.equals(this.doi, other.doi)) {
            return false;
        }
        return true;
    }
   
    
    
    public Double precio(){
        return costo + ( 0.03*(valorSuscripcionAnual/12) * 1+(0.1*factorImpacto));
    }

    @Override
    public void liquidar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

