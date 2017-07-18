
package tpfinal.tp.excepcion;


public class MaterialNoEncontradoException extends Exception {

    public MaterialNoEncontradoException() {
        super("El material solicitado no fue encontrado");
    }
    
    
    public MaterialNoEncontradoException(Integer precio){
            super("El material " +precio+ " no ha sido encontrado");
        
    }
  
    
}
