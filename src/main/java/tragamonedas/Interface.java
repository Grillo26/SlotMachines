
package tragamonedas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Interface extends JFrame {
    JButton detener1 = new JButton(new ImageIcon("btndetener3.png"));
    JButton detener2 = new JButton(new ImageIcon("btndetener2.png"));
    JButton detener3 = new JButton(new ImageIcon("btndetener3.png"));
    JButton iniciar = new JButton(new ImageIcon("PLAY.png"));
    JButton detenerTodo = new JButton(new ImageIcon("ESTOP.png"));
    public static String img1="cassal.png",img2="jheni.png",img3="yeber.png";
    public static JLabel uno = new JLabel();
    public static JLabel dos = new JLabel();
    public static JLabel tres = new JLabel();
    JPanel controles = new JPanel();
    JPanel imagenes = new JPanel();
    Hilo1 hilo1 = new Hilo1();
    Hilo2 hilo2 =new Hilo2();
    Hilo3 hilo3 = new Hilo3();

int z=0;

    public Interface(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        detener1.setBackground(Color.black);
        detener2.setBackground(Color.black);
        detener3.setBackground(Color.black);
        iniciar.setBackground(Color.black);
        detenerTodo.setBackground(Color.black);
        imagenes.setBackground(Color.black);
        controles.setBackground(Color.black);
        detener1.setBorder(null);
        detener2.setBorder(null);
        detener3.setBorder(null);
        iniciar.setBorder(null);
        detenerTodo.setBorder(null);
        
        uno.setIcon(new ImageIcon(img1));
        dos.setIcon(new ImageIcon(img2));
        tres.setIcon(new ImageIcon(img3));
        imagenes.setLayout(new FlowLayout());
        imagenes.add(uno);
        imagenes.add(dos);
        imagenes.add(tres);
        controles.setLayout(new GridLayout(2,3));
        controles.add(detener1);
        controles.add(detener2);
        controles.add(detener3);
        controles.add(iniciar);
        controles.add(detenerTodo);
        add("Center",imagenes);
        add("South",controles);
        
        //Controles
        iniciar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(hilo1.isAlive() == false){
                    if(hilo2.isAlive() == false){
                        if(hilo3.isAlive() == false){
                            hilo1 = new Hilo1();
                            hilo2 = new Hilo2();
                            hilo3 = new Hilo3();
                            hilo1.activo=true;
                            hilo2.activo=true;
                            hilo3.activo=true;
                            hilo1.start();
                            hilo2.start();
                            hilo3.start();
                            z=1;
                        }
                    }
                }
            }
        });
        
        detenerTodo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(z==1){
                    hilo1.activo=false;
                    hilo2.activo=false;
                    hilo3.activo=false;
                    if(hilo1.c==hilo2.c){
                        if(hilo2.c==hilo3.c){
                        JOptionPane.showMessageDialog(Interface.this," Ganador ! ! ! ");
                        }
                    }
                }
            }
        });
        
        detener1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                hilo1.activo=false;
            }
        });
        
        detener2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                hilo2.activo=false;
            }
        });
        
        detener3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                hilo3.activo=false;
            }
        });
    }
}
    
