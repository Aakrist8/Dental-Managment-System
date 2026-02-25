package Dental.Management.System;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener{

    JTextField tusername;
    JPasswordField tpassword;
    JButton login,back,signin;

    login(){

         setUndecorated(true);

        JLabel username = new JLabel("Username");                        //Making Text visible in the Frame
        username.setForeground(Color.black);       
        username.setBounds(40, 20,100, 30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150, 20, 150, 30);
        add(tusername);


        JLabel password = new JLabel("Password");                        //Making Text visible in the Frame
        password.setForeground(Color.black);
        password.setBounds(40, 70,100, 30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150, 70, 150, 30);
        add(tpassword);


        login = new JButton("Login");                                             //Making Login Button
        login.setBounds(150,110, 150, 30);
        login.setBackground(Color.red);
        login.setForeground(Color.white);
        login.addActionListener(this);                                  //Action listner to listen when button is clicked
        add(login);

        back = new JButton("Back");                               //Making Back Button
        back.setBounds(150,150, 150, 30);
        back.setBackground(Color.red);
        back.setForeground(Color.white);
        back.addActionListener(this);                                     //Action listner to listen when back is clicked
        add(back);



        signin = new JButton("Sign In");                                     //Sign In Button
        signin.setBounds(150, 190, 150, 30);
        signin.setBackground(Color.red);
        signin.setForeground(Color.white);
        signin.addActionListener(this);                                           //Action listner to listen if signin is clicked
        add(signin);
        
                                                                                                                          //Putting Background

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/loginpage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0,600, 300);
        add(img);



        setSize(600, 300);                                      //Size determination of window
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){                                                         //Condition if login button is clicked

            
                String username = tusername.getText();                                                 //extract gardai text
                String password = new String(tpassword.getPassword());                                    //extract pass
                try {
                    if(username.equals("admin")&& password.equals("admin")){            //Simple logic yedi admin admin bhaye ta main class kholne 
                        setVisible(false);
                        new main_class();                                                           //Admin pass match bhaye admin panel kholne
                    }else{
                    
                conn conn = new conn();                                                                                                   //establishing connection

                String query = "SELECT * FROM login WHERE username = '"+username+"' AND password = '"+password+"'";                     //Login garna id pass check from database
        
        
                ResultSet resultSet = conn.statement.executeQuery(query);                   //Then query to be executed 
                if (resultSet.next()){                                                  //Milyo bhane userdashboard kholne
                    setVisible(false);
                    new userdashboard();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }

            } catch (Exception E) {
                E.printStackTrace();
            }


        }
        else if (e.getSource() == back) {           //If back is clicked 
            System.exit(67);
        }

        else if (e.getSource()== signin) {                                                                           //if sign is is clicked
                String username = tusername.getText();
                String password = new String(tpassword.getPassword());

                if(username.isEmpty() || password.isEmpty()){                                                        // yedi khali bhako bhaye 
                    JOptionPane.showMessageDialog(null,"Please enter username and password");
                    return;
                }


                try {           
                    conn conn = new conn();                                                                             //Naya account bancha 
                    String query = "INSERT INTO login(username, password) VALUES('"+username+"','"+password+"')" ;
                     conn.statement.executeUpdate(query);
                     JOptionPane.showMessageDialog(null, "Acoount Created Successfully");
                     tusername.setText("");
                     tpassword.setText("");
                    } catch (Exception E) {
                    E.printStackTrace();
                }
        }
    }


    public static void main(String[] args) {
        new login();
    }
}
