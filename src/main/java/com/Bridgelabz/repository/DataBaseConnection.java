package com.Bridgelabz.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {

    public  static Connection getConnection(){
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        Connection connection = null;
        try{
            fileInputStream = new FileInputStream("db.properties");
            properties.load(fileInputStream);

            //register jdbc driver
            Class.forName(properties.getProperty("DB_DRIVER_CLASS"));

            // open a connection
            connection = DriverManager.getConnection(properties.getProperty("DB_URL"),
                    properties.getProperty("DB_USERNAME"), properties.getProperty("DB_PASSWORD"));

        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection){
        try{
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


}