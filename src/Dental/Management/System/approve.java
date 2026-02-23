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

import net.proteanit.sql.DbUtils;

import java.sql.ResultSet;


public class approve extends JFrame{
    

JTable table;

        approve(){

            setLayout(null);
            
         JLabel heading = new JLabel("Data");             //Heading
         heading.setBounds(415, 20, 900, 50);
         heading.setFont(new Font("Raleway", Font.BOLD,25));
         heading.setForeground(Color.black);
         add(heading);
            

         table = new JTable();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM book WHERE status= 'pending'");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));           //Jar file is imporeted like calender
                  
        } catch (Exception e) {
           e.printStackTrace(); 
        }


        JScrollPane jp = new JScrollPane(table);        //For scrolling when the data gets more
        jp.setBounds(0, 100, 900, 450);
        add(jp);


        JButton approve = new JButton("Approve");           //Approve btn for approving the given data if admin wants
        approve.setBounds(250, 570, 120, 30);
        add(approve);



        JButton reject = new JButton("Reject");           //Approve btn for approving the given data if admin wants
        reject.setBounds(450, 570, 120, 30);
        add(reject);
      
        setSize(900,700);
        setLayout(null);
        setLocation(300 ,100);
        setVisible(true);

        }
       
        public static void main(String[] args) {
            new approve();
        }
}
