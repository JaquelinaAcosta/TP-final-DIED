/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal.tp.vista;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import tpfinal.tp.estructuras.grafo.Vertice;
import tpfinal.tp.integrador.MaterialCapacitacion;


public class VerticeView {
    private Paint color;
    private Color colorBase;

    private Integer coordenadaX;
    private Integer coordenadaY;
    private final Integer RADIO = 20;
    private Shape nodo;
    private Vertice<MaterialCapacitacion> vertice;

    public VerticeView() {
    }

    public VerticeView(Integer coordenadaX, Integer coordenadaY,Color color) {
        this.colorBase = color;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.nodo= new Ellipse2D.Double(coordenadaX,coordenadaY,RADIO,RADIO);
    }

    public boolean pertenece(Point2D p){
        return this.nodo.contains(p);
    }

    public Paint getColor() {
        if(color==null) color = new GradientPaint(coordenadaX,coordenadaY,colorBase,coordenadaX+RADIO, coordenadaY+RADIO,Color.WHITE);
        return color;
    }

    public void setColor(Paint color) {
        this.color = color;
    }

    
    public Integer getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(Integer coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public Integer getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(Integer coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public Shape getNodo() {
        return nodo;
    }

    public void setNodo(Shape nodo) {
        this.nodo = nodo;
    }

    public Vertice<MaterialCapacitacion> getVertice() {
        return vertice;
    }

    public void setVertice(Vertice<MaterialCapacitacion> vertice) {
        this.vertice = vertice;
    }
    

    
    public Color getColorBase() {
        return colorBase;
    }

    public void setColorBase(Color colorBase) {
        this.colorBase = colorBase;
    }
    
    @Override
    public String toString() {
        return "Vertice{" + "coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + '}';
    }

    
    
}

