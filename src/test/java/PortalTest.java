
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.integrador.Portal;
import tpfinal.tp.integrador.Suscriptor;
import tpfinal.tp.integrador.Video;



//TALLER 4
public class PortalTest {
    Portal portal;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    MaterialCapacitacion l1,l2,l3,l4,l5,v1,v2,v3,v4,v5;  
    Suscriptor s1,s2,s3;
    public PortalTest() {

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
    
    @Test
    public void testOrdenSuscriptores(){
        portal.agregar(s1);
        portal.agregar(s3);
        portal.agregar(s2);
        portal.agregar(s2);
        portal.agregar(s3);
        List<Suscriptor> lista = portal.listarSuscriptores();
        assertEquals(s1, lista.get(0));
        assertEquals(s3, lista.get(1));
        assertEquals(s2, lista.get(2));
        assertEquals(3, lista.size());
    }

    /**
     * Test of agregar method, of class Portal.
     */
    @Ignore
    public void testAgregar_MaterialCapacitacion() {
        System.out.println("agregar MATERIAL");
        assertEquals(0, portal.cantidadMateriales().intValue());
        portal.agregar(l1);
        assertEquals(1, portal.cantidadMateriales().intValue());
    }

    /**
     * Test of agregar method, of class Portal.
     */
    @Ignore
    public void testAgregar_Suscriptor() {
        System.out.println("agregar SUSCRIPTOR");
        assertEquals(0, portal.cantidadSuscriptores().intValue());
        portal.agregar(s1);
        assertEquals(1, portal.cantidadSuscriptores().intValue());
    }
    
    @Test
    public void testOrdenAlfabetico(){
        System.out.println("testOrdenAlfabetico");
        portal.agregar(l1);
        portal.agregar(l2);
        portal.agregar(l3);
        portal.agregar(v1);
        portal.agregar(v2);
        List<MaterialCapacitacion> resultado = portal.ordenadaAlfabeticamente();
        System.out.println(resultado );
        for(int i=1;i<resultado.size();i++){
            System.out.println(resultado.get(i).getTitulo()+ " --- "+resultado.get(i-1).getTitulo());
            assertTrue(resultado.get(i).getTitulo().compareTo(resultado.get(i-1).getTitulo())>=0);
        }
    }
    
    @Test
    public void testOrdenPrecio(){
        System.out.println("testOrdenPrecio");
        portal.agregar(l1);
        portal.agregar(l2);
        portal.agregar(l3);
        portal.agregar(l4);
        portal.agregar(l5);
        portal.agregar(v1);
        portal.agregar(v2);
        portal.agregar(v3);
        List<MaterialCapacitacion> resultado = portal.ordenadaPorPrecio();
        System.out.println(resultado );
        for(int i=1;i<resultado.size();i++){
            assertTrue(resultado.get(i).precio()>resultado.get(i-1).precio());
        }
    }
    
    @Test
    public void testRangoCalificacion(){
        System.out.println("testRangoCalificacion");
        portal.agregar(l1);
        portal.agregar(l2);
        portal.agregar(l3);
        portal.agregar(l4);
        portal.agregar(l5);
        portal.agregar(v1);
        portal.agregar(v2);
        portal.agregar(v3);
        List<MaterialCapacitacion> resultado = portal.ordenadaPorCalificacionEditor();
        System.out.println(resultado );
        resultado = portal.rangoDeCalificacion(5, 8);
        System.out.println(resultado );
        for(MaterialCapacitacion m : resultado){
            assertTrue(m.getCalificacion()>=5);
            assertTrue(m.getCalificacion()<=8);
        }
        
    }
}
