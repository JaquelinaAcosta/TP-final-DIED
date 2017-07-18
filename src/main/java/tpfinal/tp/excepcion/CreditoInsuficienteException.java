
package tpfinal.tp.excepcion;


public class CreditoInsuficienteException extends Exception{
    public CreditoInsuficienteException(Double precio,Double creditoDisponible){
        super("El suscriptor solo dispone de "+creditoDisponible+" y el material al que se quiere sucribir requiere un monto de "+precio);
    }
}
