
package tpfinal.tp.integrador;

import java.util.Date;
import java.util.Objects;


public class Libro extends MaterialCapacitacion{
    private Double precioCompra;
    private String isbn;
    private Integer paginas;
 
    public Libro(String titulo,Double costo,String isbn,Integer pagina) {
        super.titulo=titulo;
        this.precioCompra=costo;
//        este era el precioCmpra? porque estaba como this.costo=costo
        this.isbn= isbn;
        this.paginas=pagina;
        this.estado=EstadoPromocion.ACCESO_TEMPRANO;
    } 
    public Libro(String titulo,Double costo,String isbn,Integer pagina, TemasMateriales tema, Integer calificacion){
        super.titulo=titulo;
        this.precioCompra=costo;
        this.isbn= isbn;
        this.paginas=pagina;
        super.calificacion=calificacion;
        super.tema=tema;
    }

    
    public Libro() {
    }
    
    public Libro(Integer id,String titulo){
        super(id,titulo);
        this.precioCompra=0.0;
        this.paginas=0;
    }
      
    public Libro(String titulo,Integer calificacion,Double costo,Date fecha,Double precioCompra, String isbn,Integer paginas) {
        super( titulo,calificacion,costo,fecha);
        this.precioCompra = precioCompra;
        this.isbn = isbn;
        this.paginas = paginas;
    }    

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + super.hashCode();
        hash = 19 * hash + Objects.hashCode(this.isbn);
        hash = 19 * hash + Objects.hashCode(this.paginas);
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
        final Libro other = (Libro) obj;
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.paginas, other.paginas)) {
            return false;
        }
        return true;
    }

    private Double factorPagina(){
        return  1.0 +(0.03*(this.paginas /150));
    }    

    @Override
    public Double precio() {
        return this.costo+(this.precioCompra*this.factorPagina()  * 0.9);            
    }

    @Override
    public void liquidar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
