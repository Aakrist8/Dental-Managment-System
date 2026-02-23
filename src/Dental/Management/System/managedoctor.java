package Dental.Management.System;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

import java.sql.ResultSet;



public class managedoctor extends JFrame implements ActionListener{
    JTable table;
    JButton add,update,delete,back;

    managedoctor(){
        setLayout(null);
        getContentPane().setBackground(new Color(255,240,220));



     JLabel heading = new JLabel("Doctor Data");             //Heading
     heading.setBounds(415, 20, 900, 50);
     heading.setFont(new Font("Raleway", Font.BOLD,25));
     heading.setForeground(Color.black);
     add(heading);
        

     table = new JTable();    
     loadTable();       //Load data into the table when the frame is opened
    
    JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 100, 800, 450);
        add(scrollPane);

        add = new JButton("Add");
        add.setBounds(150, 570, 100, 30);
        add.addActionListener(this);
        add(add);

        update = new JButton("Edit");
        update.setBounds(300, 570, 100, 30);
        update.addActionListener(this);
        add(update);

        delete = new JButton("Delete");
        delete.setBounds(450, 570, 100, 30);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(600, 570, 100, 30);
        back.addActionListener(this);
        add(back);

    
       setSize(1120, 630);
        setLayout(null);
        setVisible(true);
        setLocation(250, 100);
    
    }



    void loadTable() {
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM doctor");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new managedoctor();
    }
}



