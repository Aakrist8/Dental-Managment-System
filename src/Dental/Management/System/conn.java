package Dental.Management.System;

import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class conn {
    Connection connection;

    Statement statement;


    public conn(){
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dentalmanagementsystem","root","");           //Connecting the database
            statement = connection.createStatement();
                

        } catch (Exception e) {
            e.printStackTrace();                                    // TODO: handle exception
        }
    }


}
