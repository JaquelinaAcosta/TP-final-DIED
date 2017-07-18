
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import tpfinal.tp.excepcion.CalificacionIncorrectaExcepcion;
import tpfinal.tp.excepcion.CreditoInsuficienteException;
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.integrador.Portal;
import tpfinal.tp.integrador.Suscriptor;
import tpfinal.tp.integrador.Video;


//TALLER 4
public class SuscriptorTest {
    
   Portal portal;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    MaterialCapacitacion l1,l2,l3,l4,l5,v1,v2,v3,v4,v5;  
    Suscriptor s1,s2,s3;
    
    public SuscriptorTest() {

    }
    
    @Before
    public void setUp() {
        try {
            portal = new Portal();
            l1 = new Libro("Java8", 8, 5.0, sdf.parse("02/05/2017"),99.0, "1234", 506);
            l2 = new Libro("Python", 7, 8.5, sdf.parse("02/05/2017"), 47.5, "5285", 258);
            l3 = new Libro("ANgular 2", 4, 6.0, sdf.parse("02/05/2017"), 108.3, "9536", 394);
            l4 = new Libro("JavaScript Bible", 5, 12.0, sdf.parse("02/05/2017"), 75.6, "7541", 35);
            l5 = new Libro("Angular", 9, 15.0, sdf.parse("02/05/2017"), 122.8, "8642", 152);
            v1 = new Video("intro estructuras", 10, 5.3, sdf.parse("02/05/2017"), 38);
            v2 = new Video("ZRX", 3, 5.3, sdf.parse("02/05/2017"),16);
            v3 = new Video("Reactj",  10, 5.3, sdf.parse("02/05/2017"),20);
            v4 = new Video("C++", 4, 5.3, sdf.parse("02/05/2017"),14);  
            v5 = new Video("Smalltalk 8", 10, 5.3, sdf.parse("02/05/2017"),47);
        } catch (ParseException ex) {
            Logger.getLogger(PortalTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        s1 = new Suscriptor("Lucas",123);
        s2 = new Suscriptor("Pablo",825);
        s3 = new Suscriptor("Martin",466);
    }
    
    
    @Test(expected=CreditoInsuficienteException.class)
    public void agregarSinCredito() throws CreditoInsuficienteException {
        s1.addCredito(1.0);
        s1.suscribir(l1);
    }
    
    
    @Test
    public void agregarConCredito() throws CreditoInsuficienteException {
        s1.addCredito(500.0);
        s1.suscribir(l1);
        assertEquals(Double.valueOf(500.0-l1.precio()),s1.getCredito());
    }
    
    
    @Test
    public void agregarYCalificar() throws CreditoInsuficienteException, CalificacionIncorrectaExcepcion {
        s1.addCredito(5000.0);
        s1.suscribir(l1);
        s1.suscribir(l2);
        s1.suscribir(l3);
        s1.suscribir(l4);
        s1.suscribir(l5);
        s1.calificar(l1, 9);
        s1.calificar(l2, 3);
        s1.calificar(l3, 8);
        s1.calificar(l4, 6);
        assertEquals(Double.valueOf(6.5), s1.calificacionPromedio());
        List<MaterialCapacitacion> res = s1.listar();
        assertEquals(l1, res.get(0));
        assertEquals(l2, res.get(1));
        assertEquals(l3, res.get(2));
        assertEquals(l4, res.get(3));
    }
    
    @Test(expected=CalificacionIncorrectaExcepcion.class)
    public void calificacionFueraRango() throws Exception {
        s1.addCredito(5000.0);
        s1.suscribir(l4);
        s1.calificar(l4, 25);
    }
    
}
