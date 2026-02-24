package Dental.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import com.toedter.calendar.JDateChooser;

public class book extends JFrame implements ActionListener{

    JTextField tname, tage, taddress, tphone, tproblem; 
    JDateChooser tdate;

    JButton book,back;

    book(){


        JLabel heading = new JLabel("Add Booking Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("Name");           //Name
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);


        tname = new JTextField();                       //Box for entering name
        tname.setBounds(200, 150, 150, 30);
        add(tname);


        JLabel age = new JLabel("Age");     //age
        age.setBounds(400, 150, 150, 30);
        age.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(age);


        tage = new JTextField();            //box age
        tage.setBounds(600, 150, 150, 30);
        add(tage);


        JLabel date = new JLabel("Date");
        date.setBounds(50, 200, 150, 30);
        date.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(date);

        
        tdate = new JDateChooser();
        tdate.setBounds(200, 200, 150, 30);
        add(tdate);


         JLabel address = new JLabel("Address");     //address
        address.setBounds(400, 200, 150, 30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);


        taddress = new JTextField();            //box for address
        taddress.setBounds(600, 200, 150, 30);
        add(taddress);



           JLabel phone = new JLabel("Phone");     //phone
        phone.setBounds(50, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);


        tphone = new JTextField();            //box for phone
        tphone.setBounds(200, 250, 150, 30);
        add(tphone);


        JLabel problem = new JLabel("Problem");     //address
        problem.setBounds(400, 250, 150, 30);
        problem.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(problem);


        tproblem = new JTextField();            //box for address
        tproblem.setBounds(600, 250, 150, 30);
        add(tproblem);



        book = new JButton("Book");         //Button for booking 
        book.setBounds(450,550,150,40);
        book.setBackground(Color.black);
        book.setForeground(Color.white);
        book.addActionListener(this);
        add(book);



        back = new JButton("Back");             //Button for back 
        back.setBounds(250,550,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        setSize(1170, 650);      //Window Size
        setLocation(200,50);                //Loation Center                                  
        setLayout(null);             
        setVisible(true);                 //Visible making

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == book){          //If add button clicked
            String name = tname.getText();
            String age = tage.getText();
            String date = ((JTextField)tdate.getDateEditor().getUiComponent()).getText();
            String address = taddress.getText(); 
            String phone = tphone.getText();
            String problem = tproblem.getText();


            try {
                conn c = new conn();
                
                String query = "INSERT INTO BOOK(name, age, date, address, phone, problem, status) VALUES('"+name+"', '"+age+"', '"+date+"', '"+address+"', '"+phone+"','"+problem+"', 'Pending')";
                c.statement.executeUpdate(query);       //Executing the query for inserting the data
                JOptionPane.showMessageDialog(null, "Booked Successfully");
                setVisible(false);
                new userdashboard();
            } catch (Exception E) {
                
            }
        }
        else if (e.getSource() == back){           //If back button clicked
            setVisible(false);
            new userdashboard();
        }
    }
    public static void main(String[] args) {
        new book();
    }
}
