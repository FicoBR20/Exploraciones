package Recursos;

import javax.swing.*;
import java.awt.*;

public class Practica_Layouts extends JFrame {


    public Practica_Layouts(){
        setTitle("Practicas Layouts");
        setBounds(600, 350, 600, 300 );
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mi_Layout probadorLayaut = new mi_Layout(); // instancia JPanel de la clae USA FLOW LAYOUT

        otro_Layout esOtro = new otro_Layout(); // instancia JPanel de la clae USA BORDER LAYOUT

/*
Se adicionan los omponentes y a la vez se dispone su layout.
 */

       add(probadorLayaut, BorderLayout.NORTH);
       add(esOtro, BorderLayout.SOUTH);
    }


     public static void main(String[] args) {
         EventQueue.invokeLater(new Runnable() {
             @Override
             public void run() {
                 Practica_Layouts myGUI = new Practica_Layouts();
             }
         });
     }


}

 class  mi_Layout extends JPanel{  // clase para uso local

    public mi_Layout(){



        /*
         usa por default el flowlayout, se puede configurar
         invocando un objeto.
         */

        setLayout(new FlowLayout(FlowLayout.CENTER,10,20)); // establece la separacion o gap.

        add(new JButton("primero"));
        add(new JButton("segundo"));
        add(new JButton("tercero"));
    }


}

class  otro_Layout extends JPanel{  // clase para uso local

    public otro_Layout(){


        /*
        Usando Grid Layaut
         */

        setLayout(new BorderLayout());//default no deja espacio entre los componentes
        setLayout(new BorderLayout(10,20));//CON  espacio entre los componentes



        add(new JButton("primero EAST"),BorderLayout.EAST);
        add(new JButton("segundo SOUTH"), BorderLayout.SOUTH);
        add(new JButton("tercero CENTER"), BorderLayout.CENTER);
        add(new JButton("segundo WEST"), BorderLayout.WEST);
        add(new JButton("segundo NORTH"), BorderLayout.NORTH);



    }


}

