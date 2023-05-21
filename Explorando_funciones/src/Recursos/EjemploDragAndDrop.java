package Recursos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EjemploDragAndDrop extends JFrame {

    private JLabel jlabel; // contiene la imagen
    private Escucha escucha;

    private JButton botom; // activa la imagen en el panel.

    private  JPanel panel;// contiene a todos

  Point puntoInicial;


   // private ImageIcon dadopregunton;


    public EjemploDragAndDrop(){
        initComponentes();

        this.setTitle("Ejemplo Drag and Drop");
        this.setSize(800, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

   //

    public void initComponentes(){
        ;
//        ImageIcon dadoPregunton = new ImageIcon(getClass().getResource("Images/99-caraPregunta.png"));

        escucha = new Escucha();
        jlabel = new JLabel();
        jlabel.setSize(100,100);
        botom = new JButton("Lanza la imagen");
        panel = new JPanel();

        botom.addActionListener(escucha);
        botom.addMouseListener(escucha);
        jlabel.addMouseListener(escucha);
        jlabel.addMouseMotionListener(escucha);


       // panel.setLayout(new GridLayout(2,1));
        panel.add(jlabel);
        panel.add(botom);
        panel.revalidate();
        panel.repaint();

        this.add(panel);

        pack();


    }

    private class Escucha implements MouseListener, ActionListener, MouseMotionListener {

        private ImageIcon iconoFinal;

        @Override
        public void actionPerformed(ActionEvent e) {
//            if (e.getSource()==botom){
//               ImageIcon dadoPregunton = new ImageIcon("/Users/federicobarbetti/Documents/UV_fils/__Programacion Orientada a Eventos/Proyectos_POE/Exploraciones/Explorando_funciones/src/Images/99-caraPregunta.png");
//
//
//                jlabel = new JLabel();
//                panel.add(jlabel);
//            }

        }

        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getSource()==botom){

                this.iconoFinal = new ImageIcon("/Users/federicobarbetti/Documents/UV_fils/__Programacion Orientada a Eventos/Proyectos_POE/Exploraciones/Explorando_funciones/src/Images/99-caraPregunta.png");

                jlabel.setIcon(iconoFinal);

                panel.add(jlabel);
                System.out.print(" vale chavo");
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

            puntoInicial = SwingUtilities.convertPoint(jlabel, e.getPoint(), jlabel.getParent());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            puntoInicial = null;

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {

            Point localizado = SwingUtilities.convertPoint(jlabel, e.getPoint(), jlabel.getParent());
            if(jlabel.getParent().getBounds().contains(localizado)){
                Point nuevaLocalizacion = jlabel.getLocation();
                nuevaLocalizacion.translate(localizado.x - puntoInicial.x, localizado.y - puntoInicial.y);
                nuevaLocalizacion.x = Math.max(nuevaLocalizacion.x, 0);
                nuevaLocalizacion.y = Math.max(nuevaLocalizacion.y, 0);
                nuevaLocalizacion.x = Math.min(nuevaLocalizacion.x, jlabel.getParent().getWidth() - jlabel.getWidth());
                nuevaLocalizacion.y = Math.min(nuevaLocalizacion.y, jlabel.getParent().getHeight() - jlabel.getHeight());
                jlabel.setLocation(nuevaLocalizacion);
                puntoInicial = nuevaLocalizacion;
            }

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null,"Bienvenido \n a aprender Java");
                EjemploDragAndDrop myGUI = new EjemploDragAndDrop();
            }
        });
    }
}
