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

public class main_class extends JFrame{
    
    main_class(){

        setTitle("Dental Clinic Management System");

     
        setSize(1920, 1080);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/loading1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1920, 1080);
        add(img);

        JLabel heading = new JLabel("Dental Clinic Management System");
        heading.setBounds(230, 80, 800, 80);
        heading.setFont(new Font("Raleway", Font.BOLD,25));
        img.add(heading);

        JButton manage = new JButton("Manage Appointment");                             //Button to manage appointments, which opens the approve frame when clicked
        manage.setBounds(100, 250, 300, 70);
        manage.setFont(new Font("Arial", Font.BOLD, 18));
        manage.setForeground(Color.white);
        manage.setBackground(Color.black);
        manage.setFocusPainted(false);                                          //Remove the focus border around the button when clicked
        manage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(true);
                new approve();
            }
        });
        img.add(manage);                                //Add the manage button to the image label

        JButton view = new JButton("View All Appointments");
        view.setBounds(450, 250, 300, 70);
        view.setFont(new Font("Arial", Font.BOLD, 18));
        view.setForeground(Color.white);
        view.setBackground(Color.black);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(true);
                new view();
            }
        });
        img.add(view);

        JButton doctor = new JButton("Manage Doctors");
        doctor.setBounds(100, 350, 300, 70);
        doctor.setFont(new Font("Arial", Font.BOLD, 18));
        doctor.setForeground(Color.white);
        doctor.setBackground(Color.black);
        doctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(true);
                new managedoctor();
            }   
        });
        img.add(doctor);

        JButton inventory = new JButton("Inventory Management");
        inventory.setBounds(450, 350, 300, 70);
        inventory.setFont(new Font("Arial", Font.BOLD, 18));      
          inventory.setForeground(Color.white);
        inventory.setBackground(Color.black);
        inventory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(true);
                new inventory();
                
            }

        });
        img.add(inventory);

        JButton logout = new JButton("Logout");
        logout.setBounds(100, 450, 300, 70);
        logout.setFont(new Font("Arial", Font.BOLD, 18));
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

        setVisible(true);
    }
    
    public static void main(String[] args) {
        new main_class();
    }
}