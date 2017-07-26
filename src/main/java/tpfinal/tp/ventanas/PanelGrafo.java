/*
 * Esta clase va a manejar toda la logica de los grafos
 */
package tpfinal.tp.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import tpfinal.tp.controller.GrafoController;
import tpfinal.tp.integrador.Publicacion;
import tpfinal.tp.integrador.Video;
import tpfinal.tp.vista.AristaView;
import tpfinal.tp.vista.VerticeView;


public class PanelGrafo extends JPanel {
   private Queue<Color> colaColores;
    private GrafoController controller;

    private List<VerticeView> vertices;
    private List<AristaView> aristas;
    //private GrafoController controller;
    private JTextField txtNombreVertice1; 
    private JTextField txtNombreVertice2; 
    private JTextField cantSalto; 
    private JButton boton;
    private Principal principal;
    private AristaView auxiliar;
    private List<Video> listaVideo;
    private List<Publicacion> listaPublicacion;
    private JList resultado;
 //constructor
    public PanelGrafo() {
        this.armarPanel();
    }
     public PanelGrafo(Principal principal) {
         this.principal=principal;
        this.armarPanel();
    }
     
      public PanelGrafo(Principal principal,ArrayList<Video> video,ArrayList<Publicacion> publicacion) {
         this.principal=principal;
         this.listaPublicacion=publicacion;
         this.listaVideo=video;
        this.armarPanel();
    }

    PanelGrafo(Principal principal, List<Video> listaVideo, List<Publicacion> listaPublicaciones) {
      this.principal=principal;
         this.listaPublicacion=listaPublicaciones;
         this.listaVideo=listaVideo;
        this.armarPanel();  
    }
     
     
     
   public void armarPanel()
   {
       this.resultado= new JList((ListModel) listaVideo);
       this.txtNombreVertice1 =new JTextField(20);
        this.txtNombreVertice2 =new JTextField(20);
        this.cantSalto =new JTextField(5); 
        this.boton= new JButton();
        this.add(resultado);
        this.add(new JLabel("Vertice Origen"));
        this.add(txtNombreVertice1);
        this.add(new JLabel("Vertice Destino"));
        this.add(txtNombreVertice2);  
        this.add(new JLabel("Cantidad de saltos"));   
        this.add(cantSalto);
        this.add(new JButton("Buscar Camino"));
        this.add(boton);
        this.vertices = new ArrayList<>();
        this.aristas = new ArrayList<>();

        
        this.colaColores = new LinkedList<Color>();
        this.colaColores.add(Color.RED);
        this.colaColores.add(Color.BLUE);
        this.colaColores.add(Color.ORANGE);
        this.colaColores.add(Color.CYAN);
        }
   private static void crearPanelShowGUI(){
        JFrame ventana = new JFrame("Biblioteca");
        ventana.setSize(500, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelGrafo panel = new PanelGrafo();
        panel.setSize(500, 500);
        ventana.add(panel);
    
        ventana.add(panel, BorderLayout.PAGE_START);
        
        ventana.pack();
        ventana.setVisible(true);
}
   public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
           PanelGrafo panel=new PanelGrafo();
         panel.crearPanelShowGUI();
        }
    });
}
   
}

      //  addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent event) {
//                if (event.getClickCount() == 2 && !event.isConsumed()) {
//                    event.consume();
//                   // String titulo = JOptionPane.showInputDialog(framePadre, "Nombre del nodo");
//                    System.out.println(titulo);
//                    if (titulo != null) {
//                        // quito un color de la cola
//                        Color aux = colaColores.remove();
//
//                        // COMPLETAR --> invocar al controlador y crear el vertice.
//                        controller.crearVertice(event.getX(), event.getY(), aux, titulo);               
//                        colaColores.add(aux);
//                    }
 //               }
//            
//
//            public void mouseReleased(MouseEvent event) {
//                VerticeView vDestino = clicEnUnNodo(event.getPoint());
//                if (auxiliar!=null && vDestino != null) {
//                    auxiliar.setDestino(vDestino);
//                    controller.crearArista(auxiliar);
//                    auxiliar = null;
//                }
//            }
//
//        });
//
//        addMouseMotionListener(new MouseAdapter() {
//            public void mouseDragged(MouseEvent event) {
//                VerticeView vOrigen = clicEnUnNodo(event.getPoint());
//                if (auxiliar==null && vOrigen != null) {
//                    auxiliar = new AristaView();                    
//                    auxiliar.setOrigen(vOrigen);
//                }
//            }
//        });
//    }
//
//    public void agregar(AristaView arista){
//        this.aristas.add(arista);
//    }    
//    
//    public void agregar(VerticeView vert){
//        this.vertices.add(vert);
//    }
//    
//    private void dibujarVertices(Graphics2D g2d) {
//        for (VerticeView v : this.vertices) {
//            g2d.setPaint(Color.BLUE);
//            g2d.drawString(v.getVertice().getValor().getTitulo(),v.getCoordenadaX()-5,v.getCoordenadaY()-5);
//            g2d.setPaint(v.getColor());
//            g2d.fill(v.getNodo());
//        }
//    }
//
//    private void dibujarAristas(Graphics2D g2d) {
//        for (AristaView a : this.aristas) {
//            g2d.setPaint(a.getColor());
//            g2d.setStroke ( a.getFormatoLinea());
//            g2d.draw(a.getLinea());
//            //dibujo una flecha al final
//            // con el color del origen para que se note
//            g2d.setPaint(Color.BLACK);
//            Polygon flecha = new Polygon();  
//            flecha.addPoint(a.getDestino().getCoordenadaX(), a.getDestino().getCoordenadaY()+7);
//            flecha.addPoint(a.getDestino().getCoordenadaX()+20, a.getDestino().getCoordenadaY()+10);
//            flecha.addPoint(a.getDestino().getCoordenadaX(), a.getDestino().getCoordenadaY()+18);
//            g2d.fillPolygon(flecha);
//        }
//    }

//    private VerticeView clicEnUnNodo(Point p) {
//        for (VerticeView v : this.vertices) {
//            if (v.getNodo().contains(p)) {
//                return v;
//            }
//        }
//        return null;
//    }

//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D) g.create();
//        dibujarVertices(g2d);
//        dibujarAristas(g2d);
//    }
//
//    public Dimension getPreferredSize() {
//        return new Dimension(450, 400);
//    }
//
//    public GrafoController getController() {
//        return controller;
//    }
//
//    public void setController(GrafoController controller) {
//        this.controller = controller;
//    }
//    
     

