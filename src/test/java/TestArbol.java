
import org.junit.Before;
import org.junit.Test;
import tpfinal.tp.estructuraArbolNario.ArbolNario;
import tpfinal.tp.estructuraArbolNario.Nodo;
import tpfinal.tp.integrador.MaterialCapacitacion;


public class TestArbol {
    
    ArbolNario<MaterialCapacitacion> arbolVideo;
    ArbolNario<MaterialCapacitacion> arbolLibro;
    //los nodos no deberian ser String?? Nodo<String>
    Nodo<MaterialCapacitacion> titulo;
    Nodo<MaterialCapacitacion> metadatos;
    Nodo<MaterialCapacitacion> resumen;
    Nodo<MaterialCapacitacion> autor;
    Nodo<MaterialCapacitacion> fechaPublicacion;
    Nodo<MaterialCapacitacion> palabrasClaves;
    Nodo<MaterialCapacitacion> parrafos1;
    Nodo<MaterialCapacitacion> parrafos2;
    Nodo<MaterialCapacitacion> capitulos;
    Nodo<MaterialCapacitacion> seccion1;
    Nodo<MaterialCapacitacion> parrafos3;
    Nodo<MaterialCapacitacion> parrafos4;
    Nodo<MaterialCapacitacion> seccion2;
    Nodo<MaterialCapacitacion> parrafos5;
    Nodo<MaterialCapacitacion> parrafos6;
    Nodo<MaterialCapacitacion> parrafos7;
    Nodo<MaterialCapacitacion> parrafos11;
    Nodo<MaterialCapacitacion> parrafos8;
    Nodo<MaterialCapacitacion> metadatos2;
    Nodo<MaterialCapacitacion> ejercicios;
    Nodo<MaterialCapacitacion> capitulos2;
    Nodo<MaterialCapacitacion> seccion3;
    Nodo<MaterialCapacitacion> seccion4;
    Nodo<MaterialCapacitacion> parrafos9;
    Nodo<MaterialCapacitacion> parrafos10;
    Nodo<MaterialCapacitacion> metadatos3;
    Nodo<MaterialCapacitacion> ejercicios2;
    Nodo<MaterialCapacitacion> soluciones;
    
    
    public TestArbol()
    {
        
    }
    

    
@Test
    public void datosVideo()
    {
        arbolVideo= new ArbolNario();
        titulo= new Nodo("Video1");
        metadatos= new Nodo(" ");
        resumen= new Nodo(" ");
        autor= new Nodo("Martin");
        fechaPublicacion = new Nodo("02/05/2017");
        palabrasClaves= new Nodo("JAVA GRAFO");
        parrafos1= new Nodo("explicación de tema A");
        parrafos2= new Nodo("ejemplo usando IDE X");
        
     arbolVideo.setRaiz(titulo);
        titulo.addHijo(metadatos);
        titulo.addHijo(resumen);
        metadatos.addHijo(autor);
        metadatos.addHijo(fechaPublicacion);
        metadatos.addHijo(palabrasClaves);
        resumen.addHijo(parrafos1);
        resumen.addHijo(parrafos2);
        
        System.out.println(arbolVideo);    
    }
    
    @Test
    public void datosLibro()
    {
        arbolLibro= new ArbolNario();
        titulo= new Nodo("Libro1");
        metadatos= new Nodo(" ");
        resumen= new Nodo(" ");
        autor= new Nodo("Alejandro");
        fechaPublicacion = new Nodo("02/05/2017");
        palabrasClaves= new Nodo("ARBOL COMPLEJIDAD");
        parrafos1= new Nodo("explicación de tema A");
        parrafos2= new Nodo("ejemplo usando IDE X");
        capitulos= new Nodo("Capitulo1");
        seccion1= new Nodo("Seccion 1-1");
        parrafos3= new Nodo("parrafo 3");
        parrafos4= new Nodo("parrafo 4");
        seccion2= new Nodo("Seccion 1-2");
        parrafos5= new Nodo("parrafo 5");
        parrafos6= new Nodo("parrafo 6");
        parrafos7= new Nodo("parrafo 7");
        parrafos8= new Nodo("parrafo 8");
        metadatos2= new Nodo(" ");
        ejercicios= new Nodo("ir al sitio..");
        capitulos2= new Nodo("Capitulo 2");
        seccion3= new Nodo("Seccion 2-1");
        parrafos9= new Nodo("parrafo 9");
        seccion4= new Nodo("Seccion 2-2");
        parrafos10= new Nodo("parrafo 10");
        parrafos11= new Nodo("parrafo 11");
        metadatos3= new Nodo(" ");
        ejercicios2= new Nodo("ir al sitio...");
        soluciones= new Nodo("url..");
        
        
     arbolLibro.setRaiz(titulo);
        titulo.addHijo(metadatos);
        titulo.addHijo(resumen);
        titulo.addHijo(capitulos);
        titulo.addHijo(capitulos2);
        metadatos.addHijo(autor);
        metadatos.addHijo(fechaPublicacion);
        metadatos.addHijo(palabrasClaves);
        resumen.addHijo(parrafos1);
        resumen.addHijo(parrafos2);
        capitulos.addHijo(seccion1);
        capitulos.addHijo(seccion2);
        capitulos.addHijo(metadatos2);
        seccion1.addHijo(parrafos3);
        seccion1.addHijo(parrafos4);
        seccion2.addHijo(parrafos5);
        seccion2.addHijo(parrafos6);
        seccion2.addHijo(parrafos7);
        seccion2.addHijo(parrafos8);
        metadatos2.addHijo(ejercicios);
        capitulos2.addHijo(seccion3);
        capitulos2.addHijo(seccion4);
        capitulos2.addHijo(metadatos);
        seccion3.addHijo(parrafos9);
        seccion4.addHijo(parrafos10);
        seccion4.addHijo(parrafos11);
        metadatos3.addHijo(ejercicios2);
        metadatos3.addHijo(soluciones);
        
        
        System.out.println(arbolLibro);    
    }
    
}
