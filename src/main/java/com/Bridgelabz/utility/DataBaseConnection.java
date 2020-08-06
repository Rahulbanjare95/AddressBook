package com.Bridgelabz.utility;

import com.google.gson.internal.$Gson$Preconditions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {
    public  static Connection getConnection(){
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        Connection con = null;
        try{
            fileInputStream = new FileInputStream("db.properties");
            properties.load(fileInputStream);

            //load the driver class
            Class.forName(properties.getProperty("DB_DRIVER_CLASS"));
            con = DriverManager.getConnection(properties.getProperty("DB_URL"),
                    properties.getProperty("DB_USERNAME"), properties.getProperty("DB_PASSWORD"));

        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
}
