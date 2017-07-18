
package tpfinal.tp.excepcion;


public class CalificacionIncorrectaExcepcion extends Exception{
    public CalificacionIncorrectaExcepcion(Integer calificacion)
    {
        super("La calificación solo puede tomar valores entre 1 y 10");
    }
}

