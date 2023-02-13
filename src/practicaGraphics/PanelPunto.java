/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaGraphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Mirela
 */
public class PanelPunto extends JPanel {

    Punto p1;
    Punto p2;
    Boolean limpiar;
    String figura;
    int distancia;
    int coor1x;
    int coor2x;
    int coory1;
    int coory2;
    private final int WIDTH = 200;
    private final int HEIGHT = 200;
    Color color;

    public PanelPunto() {
        p1 = new Punto();
        p2 = new Punto();
        this.limpiar = false;
        this.distancia=0;
        color=Color.BLACK;
       
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public PanelPunto(int coor1x, int coor2x, int coory1, int coory2, Color color) {
        this.coor1x = coor1x;
        this.coor2x = coor2x;
        this.coory1 = coory1;
        this.coory2 = coory2;
        this.color = color;
    }
    
    


    public PanelPunto(Punto p1, Punto p2,Color color,int distancia) {
        this.p1 = p1;
        this.p2 = p2;
        this.limpiar = false;
        this.color = color;
        this.distancia=distancia;
        
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public void asignarPunto(Punto p1, Punto p2) {
        this.p1.asignarX(p1.obtenerX());
        this.p1.asignarY(p1.obtenerY());
        this.p2.asignarX(p2.obtenerX());
        this.p2.asignarY(p2.obtenerY());
    }

    public Punto obtenerPunto1() {
        return this.p1;
    }

    public Punto obtenerPunto2() {
        return this.p2;
    }

    public void setLimpiar(Boolean limpiar) {
        this.limpiar = limpiar;
    }

    public boolean getLimpiar() {
        return this.limpiar;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getCoor1x() {
        return coor1x;
    }

    public void setCoor1x(int coor1x) {
        this.coor1x = coor1x;
    }

    public int getCoor2x() {
        return coor2x;
    }

    public void setCoor2x(int coor2x) {
        this.coor2x = coor2x;
    }

    public int getCoory1() {
        return coory1;
    }

    public void setCoory1(int coory1) {
        this.coory1 = coory1;
    }

    public int getCoory2() {
        return coory2;
    }

    public void setCoory2(int coory2) {
        this.coory2 = coory2;
    }
    
    
    
    
    
    

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        

        try {

            if (figura.equalsIgnoreCase("Ovalo")) {

                int ancho = this.getWidth();
                int alto = this.getHeight();
               
               
                g.setColor(color);
                g.drawOval(coor1x, coory1, distancia, distancia);
                g.fillOval(coor1x, coory1, distancia, distancia);
                
             
               
            }
            if (figura.equalsIgnoreCase("Linea")) {

                g.setColor(color);
                g.drawLine(coor1x, coor2x, coory1,coory2);
            }

            if (figura.equalsIgnoreCase("Cuadrado")) {

                int lado = distancia;
                g.setColor(color);
               // g.fillRect((int) (this.p1.obtenerX()), (int) (this.p2.obtenerY()), lado, lado);
                   g.fillRect(coor1x, coory2, lado, lado);

            }
            if (limpiar) {
                int ancho = this.getWidth();
                int alto = this.getHeight();

                g.setColor(Color.GRAY);
                g.fillRect(0, 0, ancho, alto);
                
                

            }
        } catch (Exception e) {
            System.out.println("Introduce coordenadas");;

        }
       
    }
}
