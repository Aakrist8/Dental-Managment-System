package Dental.Management.System;

import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class splash extends JFrame{

    splash(){


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/splash.gif"));          //which image to put
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);         //scaling
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1920, 1080);
        add(image);


       

        setSize(1920, 1080);      //Window Size
        setLocation(200,50);                //Loation Center                                  
        setLayout(null);      
        setLocationRelativeTo(null);       
        setVisible(true);                 //Visible making



        try{
            Thread.sleep(4000);                 //Kati sec samma visible huncha ta 
            setVisible(false);
            new login();                                //yespachi kun file khulcha
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        new splash();
    }
}
