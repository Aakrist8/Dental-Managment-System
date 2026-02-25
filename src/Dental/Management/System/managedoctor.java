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
    



    void loadTable() {                          //Method to load data from the database into the table
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM doctors");                        //Query to select all data from doctors table
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception E) { 
            E.printStackTrace();
        }
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            new adddoctor();                        //Open the add doctor frame when the add button is clicked
            setVisible(false);
        } else if (e.getSource() == update) {
              int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Please select a doctor to update");                    //If no row is selected show message dialog to select a doctor
        } 
        else {

            String id = table.getValueAt(row, 0).toString();
            String oldName = table.getValueAt(row, 1).toString();
            String oldSpecialization = table.getValueAt(row, 2).toString();
            String oldPhone = table.getValueAt(row, 3).toString();
            String oldEmail = table.getValueAt(row, 4).toString();

            String newName = JOptionPane.showInputDialog("Enter Name:", oldName);
            String newSpecialization = JOptionPane.showInputDialog("Enter Specialization:", oldSpecialization);
            String newPhone = JOptionPane.showInputDialog("Enter Phone:", oldPhone);
            String newEmail = JOptionPane.showInputDialog("Enter Email:", oldEmail);

            if (newName != null && newSpecialization != null && 
                newPhone != null && newEmail != null) {

                try {
                    conn c = new conn();

                    String query = "UPDATE doctors SET name='" + newName +
                            "', specialization='" + newSpecialization +
                            "', phone='" + newPhone +
                            "', email='" + newEmail +
                            "' WHERE id='" + id + "'";

                    c.statement.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Doctor Updated Successfully");

                    loadTable();   // refresh table

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        }
    }
       
  else if (e.getSource() == delete) {

        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Please select a doctor to delete");
        } 
        else {

            String id = table.getValueAt(row, 0).toString();

            int confirm = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete this doctor?",
                    "Delete Doctor",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                try {
                    conn c = new conn();

                    String query = "DELETE FROM doctors WHERE id='" + id + "'";
                    c.statement.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Doctor Deleted Successfully");

                    loadTable();   // refresh table

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        }
    }

    else if (e.getSource() == back) {
        
        setVisible(false);
        dispose();
    }
}
    public static void main(String[] args) {
        new managedoctor();
    }
}



