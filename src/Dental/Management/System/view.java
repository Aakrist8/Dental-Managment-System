package Dental.Management.System;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 
import javax.swing.JOptionPane;

public class view extends JFrame implements ActionListener{
    
JTable table;
JButton searchbtn, makebillBtn;

    Choice choiceSt;

    view(){

        getContentPane().setBackground(new Color(255,131,122));

        JLabel search = new JLabel("Group by Status"); 
        search.setBounds(20, 20,100, 20);
        add(search);



        choiceSt = new Choice();
        choiceSt.setBounds(140, 20, 150, 20); 
        add(choiceSt);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT DISTINCT status FROM book");     //select only unique status
            while (resultSet.next()){
                choiceSt.add(resultSet.getString("status"));
            }

        } catch (Exception e) {
            
        }

        
        JLabel heading = new JLabel("Data");             //Heading
        heading.setBounds(415, 20, 900, 50);
        heading.setFont(new Font("Raleway", Font.BOLD,25));
        heading.setForeground(Color.black);
        add(heading);
        
        table = new JTable();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM book");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));           //Jar file is imporeted like calender
                  
        } catch (Exception e) {
           e.printStackTrace(); 
        }


        JScrollPane jp = new JScrollPane(table);        //For scrolling when the data gets more
        jp.setBounds(0, 100, 900, 450);
        add(jp);



        searchbtn = new JButton("Search");
        searchbtn.setBounds(20, 70, 80, 20);
        add(searchbtn);
        searchbtn.addActionListener(this);



        


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



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbtn){
            String query = "SELECT * FROM book WHERE status = '"+ choiceSt.getSelectedItem()+"'";
            try {
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        }

      
    }

    
    
    public static void main(String[] args) {
        new view();
    }
}
