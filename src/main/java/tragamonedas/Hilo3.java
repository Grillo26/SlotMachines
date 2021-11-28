
package tragamonedas;
import java.util.*;
import javax.swing.*;

public class Hilo3 extends Thread{
    boolean activo=true;
    Random img = new Random();
    Random tiem = new Random();
    int i=0;
    int tiempo=0;
    int c=0;
    @Override
    public void run(){
        while(activo==true){
        i=img.nextInt(4);
        tiempo=tiem.nextInt(100);
        if(i==1){
            Interface.tres.setIcon(new ImageIcon(Interface.img1));
            c=1;
        }
        if(i==2){
            Interface.tres.setIcon(new ImageIcon(Interface.img2));
            c=2;
        }
        if(i==3){
            Interface.tres.setIcon(new ImageIcon(Interface.img3));
            c=3;
        }
        try{
        sleep(tiempo);
        }catch(InterruptedException e){}
    }
}
    
}
