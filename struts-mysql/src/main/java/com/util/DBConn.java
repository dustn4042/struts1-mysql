package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
    private static Connection dbConn;

    public static Connection getConnection() {
        if (dbConn == null) {
            try {

                String url = "jdbc:mysql://localhost:3306/my_database";
                String user = "vagrant"; 
                String pwd = "vagrant"; 

                Class.forName("com.mysql.cj.jdbc.Driver");
                dbConn = DriverManager.getConnection(url, user, pwd);

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return dbConn;
    }

    public static void close() {
        if (dbConn != null) {
            try {
                if (!dbConn.isClosed()) {
                    dbConn.close(); 
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        dbConn = null;
    }
}
