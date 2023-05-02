package Recursos;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class Usando_2D extends JFrame {

    // atributos

    private JButton bt_1;

    private JLabel lb_1;

    private JPanel jp_1;

    private Graphics gf;





    // metodos

    public Usando_2D(){ // constructor

        bt_1 = new JButton("Boton 1");

        lb_1 = new JLabel("Practica 2D");

        jp_1 = new JPanel();



       // jp_1.add(bt_1);
       // jp_1.add(lb_1);
       //jp_1.getGraphics();



        jp_1.setBorder(BorderFactory.createTitledBorder(
               BorderFactory.createLineBorder(Color.BLUE,3),"Practica en Graficos"));

        setTitle(" Practica con Graphics 2D");
        setSize(500, 250);
        setVisible(true);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //this.add(jp_1);





    }

    public void paint (Graphics g){
        //super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(0,0,500,250);
        g2d.setColor(Color.ORANGE);
        g2d.drawRect(20,30,100,33);

        int[]xpoints ={50, 250, 490};
        int[]ypoints ={125, 10, 125};
        g2d.drawPolygon(xpoints,ypoints,3);



    }



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null,"Bienvenido \n a aprender Java");
                Usando_2D myGUI = new Usando_2D();
            }
        });
    }








}
