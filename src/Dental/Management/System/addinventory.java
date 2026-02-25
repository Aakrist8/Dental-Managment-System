package Dental.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class addinventory extends JFrame implements ActionListener {

    JTextField iname, icategory, iquantity, isupplier, iexpiry_date;
    JButton add, back;

    addinventory() {

        setLayout(null);
        getContentPane().setBackground(new Color(255,240,220));

        JLabel heading = new JLabel("Add Inventory Item");                      //heading for the frame
        heading.setBounds(160, 20, 200, 30);
        heading.setFont(new Font("Raleway", Font.BOLD, 22));
        add(heading);

        JLabel name = new JLabel("Name");                       //Label for name field
        name.setBounds(50, 80, 100, 30); 
        add(name);
        
        iname = new JTextField();
        iname.setBounds(180, 80, 200, 30);
        add(iname);

        JLabel category = new JLabel("Category");               //Label for category field
        category.setBounds(50, 130, 100, 30);
        add(category);
        
        icategory = new JTextField(); 
        icategory.setBounds(180, 130, 200, 30);
        add(icategory);

        JLabel quantity = new JLabel("Quantity");                   //Label for quantity field
        quantity.setBounds(50, 180, 100, 30); 
        add(quantity);
       
        iquantity = new JTextField(); 
        iquantity.setBounds(180, 180, 200, 30); 
        add(iquantity);

        JLabel supplier = new JLabel("Supplier");               //Label for supplier field
        supplier.setBounds(50, 230, 120, 30); 
        add(supplier);
        
        isupplier = new JTextField(); 
        isupplier.setBounds(180, 230, 200, 30); 
        add(isupplier);

        JLabel expiry_date = new JLabel("Expiry Date");                 //Label for expiry date field   
        expiry_date.setBounds(50, 280, 120, 30); 
        add(expiry_date);
       
        iexpiry_date = new JTextField(); 
        iexpiry_date.setBounds(180, 280, 200, 30); 
        add(iexpiry_date);

        add = new JButton("Add");                                   //Add button to add inventory item
        add.setBounds(100, 330, 100, 30); 
        add.addActionListener(this);                                //action listener for add button
        add(add);
        
        back = new JButton("Back");                             //Back button to go back to inventory management screen
        back.setBounds(220, 330, 100, 30); 
        back.addActionListener(this);                       //action listener for back button
        add(back);

        setSize(450, 420); 
        setLocation(400, 200); 
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {                                 //condition if add button is clicked
            String name = iname.getText();
            String category = icategory.getText();                      //extracting text from the text fields
            String quantity = iquantity.getText();
            String supplier = isupplier.getText();
            String expiry_date = iexpiry_date.getText();

            try {
                conn c = new conn();
                String query = "INSERT INTO inventory (item_name, category, quantity, supplier, expiry_date) VALUES ('"                                     //query to insert inventory item details into database
                        + name + "', '" + category + "', '" + quantity + "', '" + supplier + "', '" + expiry_date + "')";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Inventory Item Added Successfully");                   //message dialog to show success message
                new inventory();
                setVisible(false);

            } catch (Exception E) {
                E.printStackTrace();
            }
        }

        else if (e.getSource() == back) {
            new inventory();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new addinventory();
    }
}