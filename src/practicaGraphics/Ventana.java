/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaGraphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author a21nicoletamt
 */
public class Ventana extends JFrame implements ActionListener, FocusListener, ItemListener, MouseListener, ListSelectionListener {

    JLabel et1, et2, et3, et4;
    JTextField caja1, caja2, caja3, caja4;
    JPanel panelN, panelS, panelC, panelD;
    Container c;
    JButton calcular, limpiar, dibujar;
    JTextArea dibujarRect;
    PanelPunto panelDibujar;
    JLabel punto1, titulo;
    JLabel punto2;
    JPanel panelCoord1, panelCoord2, botones, panelDrc;
    PanelTitulo panelTitulo;
    JRadioButton ovalo, cuadrado, linea;
    ButtonGroup formas;
    GridBagConstraints gbc;
//    
//    JList<Double> distancia;
//    DefaultListModel<Double> dlm;

    JList distancia;
    DefaultListModel dlm;

    Ventana() {
        c = this.getContentPane();
        c.setLayout(new BorderLayout());

        //  panel norte
        panelN = new JPanel();
        panelN.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();

        punto1 = new JLabel("Punto 1");
        punto1.setFont(new Font("SansSerif", Font.BOLD, 16));
        punto1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        punto2 = new JLabel("Punto 2");
        punto2.setFont(new Font("SansSerif", Font.BOLD, 16));
        punto2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panelCoord1 = new JPanel();
        panelCoord2 = new JPanel();
        et1 = new JLabel("x :");
        et2 = new JLabel("y :");
        caja1 = new JTextField();
        caja1.requestFocus();
        caja1.setToolTipText("Introduce la coordenada x del punto 1");
        caja2 = new JTextField();
        caja2.setToolTipText("Introduce la coordenada y del punto 1");

        //panel donde se encuentran las coordenadas del punto 1
        panelCoord1.setLayout(new GridLayout(2, 2));
        panelCoord1.add(et1);
        panelCoord1.add(caja1);
        panelCoord1.add(et2);
        panelCoord1.add(caja2);
        panelCoord1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Coordenadas"));

        et3 = new JLabel("x :");
        et4 = new JLabel("y :");
        caja3 = new JTextField();
        caja3.setToolTipText("Introduce la coordenada x del punto 2");
        caja4 = new JTextField();
        caja4.setToolTipText("Introduce la coordenada y del punto 2");

        //panel donde se encuentran las coordenadas del punto 2
        panelCoord2.setLayout(new GridLayout(2, 2, 0, 0));
        panelCoord2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Coordenadas"));
        panelCoord2.add(et3);
        panelCoord2.add(caja3);
        panelCoord2.add(et4);
        panelCoord2.add(caja4);

        //panel donde se encuentran los JRadioButton
        ovalo = new JRadioButton("Ovalo");
        cuadrado = new JRadioButton("Cuadrado");
        linea = new JRadioButton("Linea");
        formas = new ButtonGroup();
        formas.add(ovalo);
        formas.add(cuadrado);
        formas.add(linea);

        botones = new JPanel();
        botones.add(ovalo);
        botones.add(cuadrado);
        botones.add(linea);
        botones.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Figura geometrica"));
        botones.setLayout(new GridLayout(3, 1));

        //añado los componentes del panel norte con GridBagLayout
        panelN.add(punto1, createConstraints(0, 0, 1, 1, 0.5, 1.0, GridBagConstraints.WEST, new Insets(2, 2, 2, 2)));
        panelN.add(punto2, createConstraints(0, 1, 1, 1, 0.5, 1.0, GridBagConstraints.WEST, new Insets(2, 2, 2, 2)));
        panelN.add(panelCoord1, createConstraints(1, 0, 2, 1, 1.0, 1.0, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1)));
        panelN.add(panelCoord2, createConstraints(1, 1, 2, 1, 1.0, 1.0, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1)));
        panelN.add(botones, createConstraints(3, 0, 2, 2, 1.0, 1.0, GridBagConstraints.BOTH, new Insets(2, 4, 4, 2)));

        //añado panel norte al contenedor con BorderLayout
        c.add(panelN, BorderLayout.NORTH);

        //panel Central en el que se encuentra JList, panel titulo y panelDibujar(donde voy a dibujar)
        panelC = new JPanel();
        panelDrc = new JPanel();
        panelTitulo = new PanelTitulo();

        dlm = new DefaultListModel();

        distancia = new JList(dlm);

        panelDibujar = new PanelPunto();
        panelDrc.setLayout(new BorderLayout());
        panelDrc.add(panelTitulo,BorderLayout.NORTH);
        panelDrc.add(panelDibujar,BorderLayout.CENTER);

        panelDrc.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelDrc.setBackground(Color.LIGHT_GRAY);

        panelC.setLayout(new GridLayout(1, 2));
        panelC.add(distancia);
        panelC.add(panelDrc);

        panelDibujar.setBackground(Color.GRAY);
        panelDibujar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelDibujar.setFocusable(true);

        //añado el panel central al contenedor con BorderLayout
        c.add(panelC, BorderLayout.CENTER);

        //panel sur en el que se encuentran los botones
        panelS = new JPanel();

        calcular = new JButton("Calcular");
        calcular.setEnabled(false);

        limpiar = new JButton("Limpiar");
        limpiar.setEnabled(false);

        panelS.add(calcular);
        panelS.add(limpiar);

        // añado los botones al panel central con GridLayout
        panelS.setLayout(new GridLayout(1, 3));

        // añado el panel sur al contenedor con BorderLayout
        c.add(panelS, BorderLayout.SOUTH);

        //estoy creando dos instancias de Punto
        Punto punto1 = new Punto();
        Punto punto2;

        //pongo a la escucha los componentes
        calcular.addActionListener(this);
        limpiar.addActionListener(this);
        ovalo.addItemListener(this);
        cuadrado.addItemListener(this);
        linea.addItemListener(this);
        panelDibujar.addMouseListener(this);
        distancia.addListSelectionListener(this);
        caja1.addFocusListener(this);
        caja2.addFocusListener(this);
        caja3.addFocusListener(this);
        caja4.addFocusListener(this);

    }

    //ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {

        // si seleccionamos el boton calcular,se calcula la distancia entre los dos puntos
        if (e.getSource() == calcular) {
            try {
                panelDibujar.p1.asignarX(Double.parseDouble(caja1.getText()));
                panelDibujar.p1.asignarY(Double.parseDouble(caja2.getText()));

                panelDibujar.p2.asignarX(Double.parseDouble(caja3.getText()));
                panelDibujar.p2.asignarY(Double.parseDouble(caja4.getText()));

            } catch (Exception ex) {
                System.out.println("ha ocurrido un error");
            }
            Double distanciaPuntos = Math.round(panelDibujar.p1.calcularDistancia(panelDibujar.p2) * 100.0) / 100.0;

            dlm.addElement(" Distancia entre p1 (x1= /" + caja1.getText() + "/,  y1= /" + caja2.getText() + "/) y p2 (x2= /" + caja3.getText() + "/, y2= /" + caja4.getText() + "/) es : " + distanciaPuntos);
            caja1.requestFocus();

            caja1.setEnabled(true);
            caja1.selectAll();
            caja2.setEnabled(true);
            caja2.selectAll();
            caja3.setEnabled(true);
            caja3.selectAll();
            caja4.setEnabled(true);
            caja4.selectAll();

        } else if(e.getSource()==limpiar){

            // si seleccionamos el boton limpiar, se borra la figura dibujada en panelDibujar y el titulo del panel titulo
            try {
                panelDibujar.limpiar = true;
                panelDibujar.repaint();
                panelTitulo.limpiar = true;
                panelTitulo.repaint();
                formas.clearSelection();

            } catch (Exception eep) {
                System.out.println("error");

            }
        }

    }

    // metodos de FocusListener
    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

        if (e.getSource() == caja4) {
            if ((caja1.getText().matches("[0-9]*")) && (caja2.getText().matches("[0-9]*")) && (caja3.getText().matches("[0-9]*")) && (caja4.getText().matches("[0-9]*"))) {
                calcular.setEnabled(true);

            }
        }else{
            System.out.println("Hay que introducir las coordenadas en formato numerico");
         
        }
    }

    // metodos de ItemListener
    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getSource() == ovalo) {
            panelDibujar.figura = "Ovalo";
            panelTitulo.setTitulo("Ovalo");
            limpiar.setEnabled(true);
        }

        if (e.getSource() == linea) {
            panelDibujar.figura = "Linea";
            panelTitulo.setTitulo("Linea");
            limpiar.setEnabled(true);
        }

        if (e.getSource() == cuadrado) {
            panelDibujar.figura = "Cuadrado";
            panelTitulo.setTitulo("Cuadrado");
            limpiar.setEnabled(true);
        }
        if (e.getSource() == limpiar) {
            panelTitulo.setTitulo("");
            panelTitulo.repaint();

        }
    }

    // metodos de MouseListener
    @Override
    public void mouseClicked(MouseEvent e) {

        //metodo para dibujar en el panelDibujar si se ha hecho click
        if (e.getSource() == panelDibujar) {

            try {

                panelDibujar.p1.asignarX(Double.parseDouble(caja1.getText()));
                panelDibujar.p1.asignarY(Double.parseDouble(caja2.getText()));

                panelDibujar.p2.asignarX(Double.parseDouble(caja3.getText()));
                panelDibujar.p2.asignarY(Double.parseDouble(caja4.getText()));

                panelDibujar.limpiar = false;

            } catch (Exception ex) {
                System.out.println("error");
            }

            Color color = JColorChooser.showDialog(this, "Elige el color", Color.RED);  
            panelTitulo.setColor(color);
            panelDibujar.setColor(color);
            panelDibujar.repaint();
            panelTitulo.repaint();

        }
        caja1.setEnabled(false);
        caja2.setEnabled(false);
        caja3.setEnabled(false);
        caja4.setEnabled(false);

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //metodo de listselectionlistener
    @Override
    public void valueChanged(ListSelectionEvent e) {

        try {
            System.out.println("Seleccionado= " + dlm.get(distancia.getSelectedIndex()));
        } catch (Exception ex) {
            ex.getStackTrace();
        }
      
       String cadena="Seleccionado " + dlm.get(distancia.getSelectedIndex()).toString();
       String []cadenaDist=cadena.split(":");
       String []cadenaValores=cadena.split("/");
      
        int distanciaReal = 0;
        panelDibujar.setDistancia((int) Math.round(Double.parseDouble(cadenaDist[1])));
        System.out.println(distanciaReal);
        
        System.out.println(cadenaDist[1]);

        String[] valoresD = new String[4];
        int indiceD = 0;
        for (int i = 0; i < cadenaValores.length; i++) {
            if (cadenaValores[i].matches("[0-9]{0,5}")) {
                valoresD[indiceD] = cadenaValores[i];
                indiceD++;
            } 
        }
        
        panelDibujar.setCoor1x(Integer.parseInt(valoresD[0]));
        panelDibujar.setCoor2x(Integer.parseInt(valoresD[1]));
        panelDibujar.setCoory1(Integer.parseInt(valoresD[2]));
        panelDibujar.setCoory2(Integer.parseInt(valoresD[3]));
         
        
        caja1.setText(valoresD[0]);
        caja2.setText(valoresD[1]);
        caja3.setText(valoresD[2]);
        caja4.setText(valoresD[3]);

    }
  

    // metodo para introducir las restricciones de GridBagLayout
    private static GridBagConstraints createConstraints(int gridx, int gridy, int gridwidth, int gridheight,
            double weightx, double weighty, int fill, Insets insets) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.fill = fill;

        gbc.insets = insets;
        return gbc;
    }

}




