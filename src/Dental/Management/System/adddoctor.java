package Dental.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adddoctor extends JFrame implements ActionListener {

    JTextField dname, dspecialization, dphone, demail;
    JButton add, back;

    adddoctor() {

        setLayout(null);
        getContentPane().setBackground(new Color(255,240,220));

        JLabel heading = new JLabel("Add Doctor");                                      //heading for the frame
        heading.setBounds(160, 20, 200, 30);
        heading.setFont(new Font("Raleway", Font.BOLD, 22));
        add(heading);

        // Name
        JLabel name = new JLabel("Name");                                           
        name.setBounds(50, 80, 100, 30);
        add(name);

        dname = new JTextField();
        dname.setBounds(180, 80, 200, 30);
        add(dname);

        // Specialization
        JLabel specialization = new JLabel("Specialization");
        specialization.setBounds(50, 130, 120, 30);
        add(specialization);

        dspecialization = new JTextField();
        dspecialization.setBounds(180, 130, 200, 30);
        add(dspecialization);

        // Phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(50, 180, 100, 30);
        add(phone);

        dphone = new JTextField();
        dphone.setBounds(180, 180, 200, 30);
        add(dphone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 230, 100, 30);
        add(email);

        demail = new JTextField();
        demail.setBounds(180, 230, 200, 30);
        add(demail);

        // Add Button
        add = new JButton("Add");
        add.setBounds(100, 300, 100, 30);
        add.addActionListener(this);                                    //Action listener for add button
        add(add);

        // Back Button
        back = new JButton("Back");
        back.setBounds(220, 300, 100, 30);
        back.addActionListener(this);                           //Action listener for back button
        add(back);

        setSize(450, 420);
        setLocation(400, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {                                         //condition if add button is clicked

            String name = dname.getText();
            String specialization = dspecialization.getText();
            String phone = dphone.getText();
            String email = demail.getText();

            if (name.equals("") || specialization.equals("") ||                             // yedi kunai pani field khali bhaye tya error message dekhauxa
                phone.equals("") || email.equals("")) {

                JOptionPane.showMessageDialog(null, "Please fill all fields");

            } else {

                try {   
                    conn c = new conn();                                            //establishing connection

                    String query = "INSERT INTO doctors (name, specialization, phone, email) VALUES ('"                 //query to insert doctor details into database
                            + name + "', '" + specialization + "', '" + phone + "', '" + email + "')";

                    c.statement.executeUpdate(query);                                   //Executing the query for inserting the data

                    JOptionPane.showMessageDialog(null, "Doctor Added Successfully");                       //message

                    new managedoctor();
                    setVisible(false);

                } catch (Exception E) {
                    E.printStackTrace();                //print stack trace for any exceptions
                }
            }
        }

        else if (e.getSource() == back) {                       //condition if back button is clicked
            new managedoctor();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new adddoctor();
    }
}