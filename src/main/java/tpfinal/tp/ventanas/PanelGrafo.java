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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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
    private JButton dibujarNodos;
private JList listaNombres;//declaramos La Lista
private DefaultListModel modelo;//declaramos el Modelo
private JScrollPane scrollLista;
    private JFrame framePadre;

        
 //constructor
    public PanelGrafo() {
        this.armarPanel();
    }
     public PanelGrafo(Principal principal) {
         this.principal=principal;
        this.armarPanel();
    }
     
//      public PanelGrafo(Principal principal,ArrayList<Video> video,ArrayList<Publicacion> publicacion) {
//         this.principal=principal;
//         this.listaPublicacion=publicacion;
//         this.listaVideo=video;
//        this.armarPanel();
//    }

    PanelGrafo(Principal principal, List<Video> listaVideo, List<Publicacion> listaPublicaciones) {
      this.principal=principal;
         this.listaPublicacion=listaPublicaciones;
         this.listaVideo=listaVideo;
         System.out.println("Estoy en panel"+listaVideo);
          System.out.println(listaPublicacion);
        this.armarPanel();  
    }
     
     
     
   public void armarPanel()
   {
       String nodos[]= {"nodo1","nodos2","nodo3","nodo4","nodo5","nodo6","nodo7","nodo8","nodo9","nodo10"};
        this.framePadre = (JFrame) this.getParent();
       this.resultado= new JList(nodos);
       this.resultado.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
       
       modelo= new DefaultListModel();
       scrollLista= new JScrollPane();
       scrollLista.setBounds(20, 120, 220, 80);
       scrollLista.setViewportView(resultado);//aca le pone el scroll
       
       this.dibujarNodos= new JButton("Dibujar Nodos");
       this.txtNombreVertice1 =new JTextField(20);
        this.txtNombreVertice2 =new JTextField(20);
        this.cantSalto =new JTextField(5); 
        this.boton= new JButton();
        this.add(resultado);
        this.add(scrollLista);
        this.add(dibujarNodos);
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
      
        dibujarNodos.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) { 
            String data = "";
            if (resultado.getSelectedIndex() != -1) {                     
               data = "Selected: " + resultado.getSelectedValue(); 
              System.out.println(data);
            }
            
         }
   });
        
        
        
        
        
        
        
        
                }
   
   
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

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        dibujarVertices(g2d);
        dibujarAristas(g2d);
    }

    public Dimension getPreferredSize() {
        return new Dimension(450, 400);
    }

    public GrafoController getController() {
        return controller;
    }

    public void setController(GrafoController controller) {
        this.controller = controller;
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


