package Dental.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class addinventory extends JFrame implements ActionListener {

    JTextField iname, icategory, iquantity, isupplier,iexpiry_date;
    JButton add, back;

    addinventory() {

        setLayout(null);
        getContentPane().setBackground(new Color(255,240,220));

        JLabel heading = new JLabel("Add Inventory Item");
        heading.setBounds(160, 20, 200, 30);
        heading.setFont(new Font("Raleway", Font.BOLD, 22));
        add(heading);

        // Name
        JLabel name = new JLabel("Name");
        name.setBounds(50, 80, 100, 30);
        add(name);

        iname = new JTextField();
        iname.setBounds(180, 80, 200, 30);
        add(iname);

        // Category
        JLabel category = new JLabel("Category");
        category.setBounds(50, 130, 100, 30);
        add(category);

        icategory = new JTextField();
        icategory.setBounds(180, 130, 200, 30);
        add(icategory);

        // Quantity
        JLabel quantity = new JLabel("Quantity");
        quantity.setBounds(50, 180, 100, 30);
        add(quantity);

        iquantity = new JTextField();
        iquantity.setBounds(180, 180, 200, 30);
        add(iquantity);

        // Supplier
        JLabel supplier = new JLabel("Supplier");
        supplier.setBounds(50, 230, 120, 30);
        add(supplier);

        isupplier = new JTextField();
        isupplier.setBounds(180, 230, 200, 30);
        add(isupplier);

        // Expiry Date
        JLabel expiry_date = new JLabel("Expiry Date");
        expiry_date.setBounds(50, 280, 120, 30);
        add(expiry_date);

        iexpiry_date = new JTextField();
        iexpiry_date.setBounds(180, 280, 200, 30);
        add(iexpiry_date);
        


        // Add Button
        add = new JButton("Add");
        add.setBounds(100, 330, 100, 30);
        add.addActionListener(this);
        add(add);

        // Back Button
        back = new JButton("Back");
        back.setBounds(220, 330, 100, 30);
        back.addActionListener(this);
        add(back);

        setSize(450, 420);
        setLocation(400, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {

            String name = iname.getText();
            String category = icategory.getText();
            String quantity = iquantity.getText();
            String supplier = isupplier.getText();
            String expiry_date = iexpiry_date.getText();

            if (name.equals("") || category.equals("") || 
                quantity.equals("") || supplier.equals("") || expiry_date.equals("")) {

                JOptionPane.showMessageDialog(null, "Please fill all fields");

            } else {

                try {
                    conn c = new conn();

                    String query = "INSERT INTO inventory (name, category, quantity, supplier, expiry_date) VALUES ('"
                            + name + "', '" + category + "', '" + quantity + "', '" + supplier + "', '" + expiry_date + "')";

                    c.statement.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Inventory Item Added Successfully");

                    new inventory();
                    setVisible(false);

                } catch (Exception E) {
                    E.printStackTrace();
                }
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