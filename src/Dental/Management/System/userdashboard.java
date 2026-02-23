package Dental.Management.System;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

public class userdashboard extends JFrame{
      
    userdashboard(){

        setTitle("Dental Clinic Management System");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/coverpage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1120, 630);
        add(img);


        JLabel heading = new JLabel("Dental Clinic Management System");             //Heading
        heading.setBounds(230, 80, 800, 80);
        heading.setFont(new Font("Raleway", Font.BOLD,25));
        heading.setForeground(Color.black);
        img.add(heading);


        JButton book = new JButton("Book Appointment");           //Button to approve appointment
        book.setBounds(50, 200, 200, 50);
        book.setForeground(Color.white);
        book.setBackground(Color.black);
        book.setFocusPainted(false);
        book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new book();
            }
        });
        img.add(book);


        JButton status = new JButton("View Status Appointments");                //View all appointments
        status.setBounds(50, 270, 200, 50);
        status.setForeground(Color.white);
        status.setBackground(Color.black);
        status.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });
        img.add(status);


        JButton logout = new JButton("Logout");
        logout.setBounds(300, 270, 200, 50);
        logout.setForeground(Color.white);
        logout.setBackground(Color.black);
           logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               setVisible(false);
                new login(); 
            }
        });
        img.add(logout);




        setSize(1120, 630);
        setLayout(null);
        setVisible(true);
        setLocation(250, 100);
    }
    
    public static void main(String[] args) {
        new userdashboard();
    }
}


