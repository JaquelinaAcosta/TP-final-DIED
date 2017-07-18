
package tpfinal.tp.integrador;

import java.util.Date;
import java.util.Objects;


public class Video extends MaterialCapacitacion {

    private Integer duracionEnSegundos;
    private static final Double _VALOR_SEGUNDO = 0.15;

    public Video() {
        super();
    }
    
    public Video (String titulo, TemasMateriales tema, Integer duracion, Integer calificacion, Double costo){
        super.titulo=titulo;
        super.tema=tema;
        super.costo=costo;
        super.calificacion=calificacion;
        this.duracionEnSegundos = duracion;
    }
    
     public Video(String titulo, Double precio,Integer duracion){
         this.titulo=titulo;
         this.costo=precio;
         this.duracionEnSegundos=duracion;
         
     }

    public Video(String titulo, Integer calificacion, Double costo, Date fecha) {
        super(titulo, calificacion, costo, fecha);
        this.duracionEnSegundos = 0;
    }

    public Video(String titulo, Integer calificacion, Double costo, Date fecha, Integer duracion) {
        super(titulo, calificacion, costo, fecha);
        this.duracionEnSegundos = duracion;
    }

    public Video(String titulo, int duracion) {
        this.titulo=titulo;
        this.duracionEnSegundos=duracion;
           }

    
    @Override
    public Double precio() {
        return costo + (duracionEnSegundos * _VALOR_SEGUNDO);
    }

    public Integer getDuracionEnSegundos() {
        return duracionEnSegundos;
    }

    public void setDuracionEnSegundos(Integer duracionEnSegundos) {
        this.duracionEnSegundos = duracionEnSegundos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + super.hashCode();
        hash = 97 * hash + Objects.hashCode(this.duracionEnSegundos);
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
        final Video other = (Video) obj;
        if (!Objects.equals(this.duracionEnSegundos, other.duracionEnSegundos)) {
            return false;
        }
        return true;
    }

    @Override
    public void liquidar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

