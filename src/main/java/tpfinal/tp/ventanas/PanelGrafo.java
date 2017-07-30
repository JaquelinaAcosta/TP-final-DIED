/*
 * Esta clase va a manejar toda la logica de los grafos
 */
package tpfinal.tp.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import tpfinal.tp.estructuras.grafo.Grafo;
import tpfinal.tp.integrador.Libro;
import tpfinal.tp.integrador.MaterialCapacitacion;
import tpfinal.tp.integrador.Publicacion;
import tpfinal.tp.integrador.Video;
import tpfinal.tp.vista.AristaView;
import tpfinal.tp.vista.VerticeView;


public final class PanelGrafo extends JPanel {
   private Queue<Color> colaColores;
    
   private PanelControlGrafo controller;
  private Grafo<MaterialCapacitacion> grafo;
    private List<VerticeView> vertices;
    private List<AristaView> aristas;
   //   private Map<Vertice<MaterialCapacitacion>,VerticeView> Mapvertices;
    //private GrafoController controller;
   
    private JButton boton;
    private Principal principal;
    private AristaView auxiliar;
    private List<Video> listaVideo;
    private List<Publicacion> listaPublicacion;
    private JList resultado;
    private JButton dibujarNodos;
    private JList listaNombres;//declaramos La Lista
    private DefaultListModel modelo;//declaramos el Modelo
    private JScrollPane scrollLista;
    private JFrame framePadre;
    private List<Libro> listaLibro;
    private List<MaterialCapacitacion> materiales;
    private List<MaterialCapacitacion> listaRtdo;
    private JComboBox<String> comboMaterial;
 //constructor
    public PanelGrafo() {
        this.armarPanel();
    }
     public PanelGrafo(Principal principal) {
         this.principal=principal;
        this.armarPanel();
    }
     
 public PanelGrafo(PanelControlGrafo panelControl) {
         this.controller=panelControl;
        this.armarPanel();
    }

    PanelGrafo(Principal principal, List<MaterialCapacitacion> listaMateriales) {
         this.principal=principal;
         this.listaRtdo=listaMateriales;
        System.out.println("esta es la lista Rtdo"+listaRtdo);
       
        this.armarPanel();  
        System.out.println("estoy en panel");
    }
    PanelGrafo(Principal principal, List<MaterialCapacitacion> listaMateriales,PanelControlGrafo control) {
         this.principal=principal;
         this.listaRtdo=listaMateriales;
         this.controller=control;
        System.out.println("esta es la lista Rtdo"+listaRtdo);
       
        this.armarPanel();  
        System.out.println("estoy en panel");
    }
      
     
     
   public void armarPanel()
   {
    //   controller= new PanelControlGrafo();
       this.comboMaterial= new JComboBox<String>();
       this.dibujarNodos= new JButton("Dibujar Nodos");
//       this.txtNombreVertice1 =new JTextField(20);
//        this.txtNombreVertice2 =new JTextField(20);
//        this.cantSalto =new JTextField(5); 
        this.boton= new JButton();
        this.add(comboMaterial);
        this.add(dibujarNodos);
//        this.add(new JLabel("Vertice Origen"));
//        this.add(txtNombreVertice1);
//        this.add(new JLabel("Vertice Destino"));
//        this.add(txtNombreVertice2);  
//        this.add(new JLabel("Cantidad de saltos"));   
//        this.add(cantSalto);
//        this.add(new JButton("Buscar Camino"));
//        this.add(boton);
        this.vertices = new ArrayList<>();
        this.aristas = new ArrayList<>();

        //this.add(controller,BorderLayout.PAGE_END);
        this.colaColores = new LinkedList<Color>();
        this.colaColores.add(Color.RED);
        this.colaColores.add(Color.BLUE);
        this.colaColores.add(Color.ORANGE);
        this.colaColores.add(Color.CYAN);
        
//       if(!listaRtdo.isEmpty())
//       {
//        listaRtdo.forEach((m) -> {
//            comboMaterial.addItem(m.getTitulo());
//       });
//       
//       }
      
        dibujarNodos.addActionListener((ActionEvent e) -> { 
            String data = comboMaterial.getSelectedItem().toString();
            
            if (comboMaterial.getSelectedIndex() != -1) {
                   System.out.println("tengo que dibujar este nodo"+comboMaterial.getSelectedItem());          
            }
       });
      
        System.out.println("fin armarPanel");
        
                }
                
//   protected void paintComponent(Graphics g) {
//super.paintComponent(g);
//Graphics2D g2d = (Graphics2D) g.create();
//dibujarCuadrado(g2d);
//}
//   private void dibujarCuadrado(Graphics2D g2d){
//int squareX= 50;
//int squareY= 50;
//int squareW= 20;
//int squareH= 20;
//g2d.drawString("Panel Personalizado!",10,20);
//g2d.setColor(Color.BLUE);
//g2d.fillRect(squareX,squareY,squareW,squareH);
//
//g2d.drawRect(squareX,squareY,squareW,squareH);
//}
//   

   
   public void agregar(AristaView arista){
        this.aristas.add(arista);
    }    
    
    public void agregar(VerticeView vert){
        this.vertices.add(vert);
    }

    /**
     *
     * @param vert
     */

    private void dibujarVertices(Graphics2D g2d) {
        for (VerticeView v : this.vertices) {
            g2d.setPaint(Color.BLUE);
            g2d.drawString(v.getVertice().getValor().getTitulo(),v.getCoordenadaX()-5,v.getCoordenadaY()-5);
            g2d.setPaint(v.getColor());
            g2d.fill(v.getNodo());
        }
    }

    private void dibujarAristas(Graphics2D g2d) {
        for (AristaView a : this.aristas) {
            g2d.setPaint(a.getColor());
            g2d.setStroke ( a.getFormatoLinea());
            g2d.draw(a.getLinea());
            //dibujo una flecha al final
            // con el color del origen para que se note
            g2d.setPaint(Color.BLACK);
            Polygon flecha = new Polygon();  
            flecha.addPoint(a.getDestino().getCoordenadaX(), a.getDestino().getCoordenadaY()+7);
            flecha.addPoint(a.getDestino().getCoordenadaX()+20, a.getDestino().getCoordenadaY()+10);
            flecha.addPoint(a.getDestino().getCoordenadaX(), a.getDestino().getCoordenadaY()+18);
            g2d.fillPolygon(flecha);
        }
    }

    private VerticeView clicEnUnNodo(Point p) {
        for (VerticeView v : this.vertices) {
            if (v.getNodo().contains(p)) {
                return v;
            }
        }
        return null;
    }

//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D) g.create();
//        dibujarVertices(g2d);
//        dibujarAristas(g2d);
//    }

    public Dimension getPreferredSize() {
        return new Dimension(450, 400);
    }


   
   private static void crearPanelShowGUI(){
        JFrame ventana = new JFrame("Biblioteca");
        ventana.setSize(500, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       // PanelControlGrafo panelControl= new PanelControlGrafo();
        PanelGrafo panel = new PanelGrafo();
       // PanelControlGrafo panelControl= new PanelControlGrafo();
        panel.setSize(500, 500);
       //  panel.add(panelControl);
      ventana.add(panel,BorderLayout.PAGE_START);
      //ventana.add(panelControl);
     // panelControl.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
      //  this.vistaPrincipal.getContentPane().add(panel);
       // ventana.add(panelControl, BorderLayout.PAGE_END);
        ventana.pack();
        ventana.setVisible(true);
}

   public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          // PanelGrafo panel=new PanelGrafo();
        crearPanelShowGUI();
        }
    });
}
   
}


