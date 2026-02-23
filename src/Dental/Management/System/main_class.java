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
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/loading1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1120, 630);
        add(img);


        JLabel heading = new JLabel("Dental Clinic Management System");             //Heading
        heading.setBounds(230, 80, 800, 80);
        heading.setFont(new Font("Raleway", Font.BOLD,25));
        img.add(heading);


        JButton manage = new JButton("Manage Appointment");           //Button to approve appointment
        manage.setBounds(50, 200, 200, 50);
        manage.setForeground(Color.white);
        manage.setBackground(Color.black);
        manage.setFocusPainted(false);
        manage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new approve();
            }
        });
        img.add(manage);


        JButton view = new JButton("View All Appointments");                //View all appointments
        view.setBounds(300, 200, 200, 50);
        view.setForeground(Color.white);
        view.setBackground(Color.black);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new view();
            }
        });
        img.add(view);



        JButton doctor = new JButton("Manage Doctors");         //Doctor Management
        doctor.setBounds(50, 270, 200, 50);
        doctor.setForeground(Color.white);
        doctor.setBackground(Color.black);
           doctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });
        img.add(doctor);



        JButton reject = new JButton("Reject Appointment");               //Approving the pending ones
        reject.setBounds(300, 200, 200, 50);
        reject.setForeground(Color.white);
        reject.setBackground(Color.black);
           reject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });
        img.add(reject);


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
        new main_class();
    }
}
