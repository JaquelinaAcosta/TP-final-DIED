/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.vista;

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
import javax.swing.JFrame;
import javax.swing.JPanel;
import tpfinal.tp.controller.GrafoController;


public class GrafoPanel extends JPanel {

    private JFrame framePadre;
    private Queue<Color> colaColores;
    private GrafoController controller;
    
    private List<VerticeView> vertices;
    private List<AristaView> aristas;

    private AristaView auxiliar;

    public GrafoPanel() {
        this.framePadre = (JFrame) this.getParent();
        
        this.vertices = new ArrayList<>();
        this.aristas = new ArrayList<>();

        
        this.colaColores = new LinkedList<Color>();
        this.colaColores.add(Color.RED);
        this.colaColores.add(Color.BLUE);
        this.colaColores.add(Color.ORANGE);
        this.colaColores.add(Color.CYAN);

        addMouseListener(new MouseAdapter() {
            //Se llama cuando se oprime y se suelta un botÃ³n en el mouse.
            public void mouseClicked(MouseEvent event) {
                if (event.getClickCount() == 2 && !event.isConsumed()) {
                    event.consume();
                        Color aux = colaColores.remove();
                        Integer x=controller.encontrarPosicionX(event.getX());
                        Integer y=controller.encontrarPosicionY(event.getY());
                        controller.dibujarEn(x,y,aux);
           
                        colaColores.add(aux);
                    }
                }
           // }
 //Ocurre cuando se suelta un botÃ³n en el Mouse
            public void mouseReleased(MouseEvent event) {
                VerticeView vDestino = clicEnUnNodo(event.getPoint());
                if (auxiliar!=null && vDestino != null) {
                    auxiliar.setDestino(vDestino);
                    controller.crearArista(auxiliar);
                    auxiliar = null;
                }
            }

        });
//ocurre cuando el boton del raton se oprime mientras el cursor esta sobre un componente 
//y se mueve mientras se mantiene presionado.
        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent event) {
                VerticeView vOrigen = clicEnUnNodo(event.getPoint());
                if (auxiliar==null && vOrigen != null) {
                    auxiliar = new AristaView();                    
                    auxiliar.setOrigen(vOrigen);
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
    
    
}

