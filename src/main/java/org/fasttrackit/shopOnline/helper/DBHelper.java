package org.fasttrackit.shopOnline.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
    public static Connection getConnection() {
        Properties connectionProperties = new Properties(); //creem un obiect in care punem user si parola
        connectionProperties.put("user", "Luci");
        connectionProperties.put("password", "luci");
        String connString = "jdbc:mysql://localhost:3306/shop_online_jdbc";
        try {
            Connection con = DriverManager.getConnection(connString, connectionProperties); //create SQL Statement. Am creat un obiect din clasa Statement folosind obiectul conn care e de tipul Connection
            System.out.println("Conexiunea la baza de date a fost deschisa");
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
