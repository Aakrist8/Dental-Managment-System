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

public class userdashboard extends JFrame{
      
    userdashboard(){

        setTitle("Dental Clinic Management System");

        
        setSize(1920, 1080);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/coverpage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1920, 1080);
        add(img);

        JLabel heading = new JLabel("Dental Clinic Management System");
        heading.setBounds(650, 80, 800, 80);
        heading.setFont(new Font("Raleway", Font.BOLD, 40));
        heading.setForeground(Color.black);
        img.add(heading);

        
        JButton book = new JButton("Book Appointment");
        book.setBounds(200, 300, 350, 80);
        book.setFont(new Font("Arial", Font.BOLD, 20));
        book.setForeground(Color.white);
        book.setBackground(Color.black);
        book.setFocusPainted(false);
        book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(true);
                new book();
            }
        });
        img.add(book);

        JButton loginout = new JButton("Logout");
        loginout.setBounds(200, 420, 350, 80);
        loginout.setFont(new Font("Arial", Font.BOLD, 20));
        loginout.setForeground(Color.white);
        loginout.setBackground(Color.black);
        loginout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new login();
            }
        });
        img.add(loginout);

       

        setVisible(true);
    }
    
    public static void main(String[] args) {
        new userdashboard();
    }
}