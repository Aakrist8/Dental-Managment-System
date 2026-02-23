package Dental.Management.System;

import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class splash extends JFrame{

    splash(){


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/splash.gif"));          //which image to put
        Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);         //scaling
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1170, 650);
        add(image);


       

        setSize(1170, 650);      //Window Size
        setLocation(200,50);                //Loation Center                                  
        setLayout(null);             
        setVisible(true);                 //Visible making



        try{
            Thread.sleep(4000);
            setVisible(false);
            new login();
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        new splash();
    }
}
