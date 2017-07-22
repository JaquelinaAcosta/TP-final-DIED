/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import tpfinal.tp.controller.GrafoController;
import tpfinal.tp.guardarADisco.SuscriptoresDao;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.integrador.Suscriptor;
import tpfinal.tp.vista.ControlPanel;
import tpfinal.tp.vista.GrafoPanel;
import tpfinal.tp.vista.PrincipalGrafo;


public class PanelBuscarLibro extends JPanel{
    
    private JComboBox comboxSuscriptor;
    private JLabel libro;
    private JLabel suscriptor;
    private JList listLibros;
    private JButton botonAgregar,botonActualizar,botonBorrar,botonSalir;
    private JButton asignarRelaciones;
    private JPanel nuevoLibro;
    private SuscriptoresDao suscriptorDao= new SuscriptoresDao();//aca voy a leer todos los 
    private Principal principal;
    private List<? extends MaterialCapacitacion> listaMateriales;
    
    public PanelBuscarLibro() throws Exception{
        this.armarPanel();
    }
    
    public PanelBuscarLibro(Principal principal) throws Exception{
        this.principal= principal;
        this.armarPanel();
    }
    
    public PanelBuscarLibro(Principal principal, List<? extends MaterialCapacitacion> listaMateriales) throws Exception{
        this.principal = principal;
        this.listaMateriales = listaMateriales;
        this.armarPanel();
    }

   
    private void armarPanel() throws Exception{
        
        
       
       String[] mensaje=this.leerFichero("C:\\Suscriptor.txt");

        this.libro= new JLabel("Libro");
        this.suscriptor=new JLabel("Suscriptor");
        this.botonActualizar= new JButton("Actualizar");
        this.botonSalir= new JButton("Salir");
        this.botonAgregar= new JButton("Agregar");
        this.botonBorrar= new JButton("Borrar");
        this.comboxSuscriptor= new JComboBox(mensaje);//aca muestra el suscriptor
        this.asignarRelaciones= new JButton("Asigar Relaciones");
        this.setLayout(new GridLayout(3,3, 10, 10));
        this.add(libro);
        this.add(suscriptor);

        this.add(comboxSuscriptor);//agrego la lista
    //     this.lista= new JList(listaMateriales.toArray(new MaterialCapacitacion[listaMateriales.size()]));
      //  ObjectMapper mapper = new ObjectMapper();


       
        comboxSuscriptor.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e) {
                try{
                    
                }catch(Exception ex){
                    System.out.println("Error");
                }
            }
        });
        
  //agrega un material a la lista del suscriptor si tiene credito
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try{
                            }catch(Exception ex){
                    System.out.println("Error");
                }
            }
        });
                
        asignarRelaciones.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e) {
                try{
                   
                   JFrame f = new JFrame();
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ControlPanel panelCtrl = new ControlPanel();
                    GrafoPanel panelGrf = new GrafoPanel();
                    GrafoController gf = new GrafoController(panelGrf, panelCtrl);
                    panelGrf.setController(gf);
                    panelCtrl.setController(gf);

                    f.add(panelCtrl, BorderLayout.PAGE_START);
                    f.add(panelGrf);

                    f.pack();
                    f.setVisible(true);
                }catch(Exception ex){
                    System.out.println("Error");
                }
            }
        });
                    //cargar los uscriptores Suscriptores.json
           ///  ArrayList lista = new ArrayList<Suscriptor>(suscriptorDao.cargarLista());
          
   //   JsonArray gsonArr = parser.parse(Suscriptores.json).getAsJsonArray();
//   JsonParser parser = new JsonParser();
//   Object obj = parser.parse(new FileReader("C:\\Users\\hp\\Documents\\UTN\\TP-final-DIED\\Suscriptores.json"));
//
//			JsonObject jsonObject = (JsonObject) obj;
//
//			String nombre = (String)jsonObject.get("Nombre");
//			System.out.println(nombre);
//
//			String temas = (String) JsonObject.get("Temas");
//			System.out.println(temas);
//			
//			long inicio = (Long) JsonObject.get("Inicio");
//		 	System.out.println(inicio);
//
//			JSONObject innerObject = (JSONObject) jsonObject.get("Posts");
//			System.out.println(innerObject.toJSONString());
//			
//			// loop array
//			JSONArray tags = (JSONArray) jsonObject.get("Tags");
//			Iterator<String> iterator = tags.iterator();
//			while (iterator.hasNext()) {
//				System.out.println(iterator.next());


           
                   
        //me lleva agregar un material de capacitacion*/
      
        this.add(asignarRelaciones);
        this.add(botonAgregar);
        this.add(botonActualizar);
        this.add(botonBorrar);
        this.add(botonSalir);
        
        //Sale de todo
        this.botonSalir.addActionListener(new ActionListener(){
               @Override
               public void actionPerformed (ActionEvent e){
                   System.exit(0);
               }
        });

    }
      

    /*
    Funcion para leer los suscriptores desde el txt
    directorio es el lugar donde esta el txt
    */
     public String[] leerFichero(String directorio) throws Exception {

         FileReader fr = null;
          ArrayList<String> txt= new ArrayList<String>();
        String linea;
        try {
            File fichero = new File(directorio);
            fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
        linea = br.readLine();
        while (linea != null) {
            System.out.println(linea);
            linea = br.readLine();
            txt.add(linea);
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
         String[] array = new String[txt.size()];
         array = txt.toArray(array);
        return array;
    }
   
private static void crearBuscarShowGUI() throws Exception{
        JFrame ventana = new JFrame("Biblioteca");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelBuscarLibro blPanel = new PanelBuscarLibro();
        blPanel.setSize(300, 200);
        ventana.add(blPanel);
      
        ventana.add(blPanel, BorderLayout.PAGE_START);
        
        ventana.pack();
        ventana.setVisible(true);
}

public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          PanelBuscarLibro pBuscarLibro = null;
            try {
                pBuscarLibro = new PanelBuscarLibro();
            } catch (Exception ex) {
                Logger.getLogger(PanelBuscarLibro.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                pBuscarLibro.crearBuscarShowGUI();
            } catch (Exception ex) {
                Logger.getLogger(PanelBuscarLibro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
}
    
}
