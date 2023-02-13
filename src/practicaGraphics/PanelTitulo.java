/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaGraphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author a21nicoletamt
 */
public class PanelTitulo extends JPanel {

    private String titulo;
    private Color color;
    boolean limpiar;

    public PanelTitulo(){
        titulo=new String();
        color=Color.BLACK;
        this.setPreferredSize(new Dimension(100,100));
    }
    
    public PanelTitulo(String titulo,Color color) {
        this.titulo = titulo;
        this.color=color;
        
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
     
     
  
    @Override
     protected void paintComponent(Graphics g) {
         
         super.paintComponent(g);
   
  
           if(limpiar){
          
               g.setColor(Color.LIGHT_GRAY);
               g.drawString("",10,10);
               limpiar=false;

           }else{
                
           
               g.setFont(new Font("Arial",Font.BOLD,22));
               g.setColor(color);
               g.drawString(this.titulo, 130, 90);   

}
}
}
