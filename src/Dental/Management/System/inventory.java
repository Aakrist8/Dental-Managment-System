package Dental.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class inventory extends JFrame implements ActionListener {

    JTable table;
    JButton add, update, delete, back;

    inventory() {
        setLayout(null);
        getContentPane().setBackground(new Color(255,240,220));

        JLabel heading = new JLabel("Inventory Data");
        heading.setBounds(415, 20, 900, 50);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        heading.setForeground(Color.black);
        add(heading);

        table = new JTable();                           //Initialize the table
        loadTable();                                    //Load data into the table when the frame is opened

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
        setLocation(250, 100);
        setVisible(true);
    }

    void loadTable() {                                                      //Method to load the table with inventory data from the database
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM inventory");                                          //Query to select all data from inventory table   
            table.setModel(DbUtils.resultSetToTableModel(resultSet));                           //Set the model of the table to the result set obtained from the database query using DbUtils
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {                                             //if add button is clicked open the add inventory frame
            new addinventory();                                                     //Open the add inventory frame
            setVisible(false);
        } else if (e.getSource() == update) {                                       //if update button is clicked open the update inventory frame
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Please select an item to update");                                      //If no row is selected show message dialog to select an item
            } else {
                String id = table.getValueAt(row, 0).toString();                                
                String oldName = table.getValueAt(row, 1).toString();
                String oldCategory = table.getValueAt(row, 2).toString();
                String oldQuantity = table.getValueAt(row, 3).toString();
                String oldSupplier = table.getValueAt(row, 4).toString();
                String oldExpiryDate = table.getValueAt(row, 5).toString();

                String newName = JOptionPane.showInputDialog("Enter Name:", oldName);
                String newCategory = JOptionPane.showInputDialog("Enter Category:", oldCategory);
                String newQuantity = JOptionPane.showInputDialog("Enter Quantity:", oldQuantity);
                String newSupplier = JOptionPane.showInputDialog("Enter Supplier:", oldSupplier);
                String newExpiryDate = JOptionPane.showInputDialog("Enter Expiry Date (YYYY-MM-DD):", oldExpiryDate);

                if (newName != null && newCategory != null && newQuantity != null && newSupplier != null && newExpiryDate != null) {                            //If all input fields are filled, update the inventory item details in the database
                    try {
                        conn c = new conn();
                        String query = "UPDATE inventory SET item_name='" + newName +
                                "', category='" + newCategory +
                                "', quantity='" + newQuantity +
                                "', supplier='" + newSupplier +
                                "', expiry_date='" + newExpiryDate +
                                "' WHERE id='" + id + "'";
                        c.statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Item Updated Successfully");
                        loadTable();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } else if (e.getSource() == delete) {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Please select an item to delete");
            } else {
                String id = table.getValueAt(row, 0).toString();
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this item?", "Delete Item", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        conn c = new conn();
                        String query = "DELETE FROM inventory WHERE id='" + id + "'";
                        c.statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Item Deleted Successfully");
                        loadTable();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } else if (e.getSource() == back) {
           
            setVisible(false);  
            dispose();
        }
    }

    public static void main(String[] args) {
        new inventory();
    }
}