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


public class approve extends JFrame implements ActionListener{
    

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
        approve.setBounds(200, 570, 120, 30);
        approve.addActionListener(this);
        add(approve);



        JButton reject = new JButton("Reject");           //Approve btn for approving the given data if admin wants
        reject.setBounds(520, 570, 120, 30);
        reject.addActionListener(this);
        add(reject);

        
        JButton back = new JButton("Back");           //Approve btn for approving the given data if admin wants
        back.setBounds(360, 570, 120, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                dispose();
            }
        });
        
        add(back);
      
        setSize(900,700);
        setLayout(null);
        setLocation(300 ,100);
        setVisible(true);

        }


        void loadTable() {                      //Method to load the table with pending appointments from the database
        try {
            conn c = new conn();                            //Database connection
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM book WHERE status='pending'");                            //Query to select pending appointments
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




        @Override
        public void actionPerformed(ActionEvent e){         
                
               int row = table.getSelectedRow();                                                //Get the selected row from the table
                if (row == -1) {
                     JOptionPane.showMessageDialog(null, "Please select an appointment to approve.");                       //If no row is selected show message dialog to select an appointment
                     return;
           
                }
           
              try {
        conn c = new conn();                                            //Database connection

        
        String id = table.getValueAt(row, 0).toString();        //Tyo row select garni ho 



        if (e.getActionCommand().equals("Approve")) {                                       //If approve button is clicked update the status of the selected appointment to approved in the database
            String query = "UPDATE book SET status='Approved' WHERE id='" + id + "'";                   //Query to update the status of the selected appointment to approved
            c.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Appointment Approved");
        } 
         else if (e.getActionCommand().equals("Reject")) {                                              //If reject button is clicked update the status of the selected appointment to rejected in the database
            String query = "UPDATE book SET status='Rejected' WHERE id='" + id + "'";                   //Query to update the status of the selected appointment to rejected
            c.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Appointment Rejected");                        
        }

        
        loadTable();            //yesle chai table load garcha after approval or rejection

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
        
        
        public static void main(String[] args) {
            new approve();
        }
}
