package com.revature.Francheska_Pina_P1.Util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final ConnectionFactory connectionFactory = new ConnectionFactory();
    private Properties properties = new Properties();

    private ConnectionFactory(){
        try {
            properties.load(new FileReader("src/main/resources/db.properties"));
        } catch (IOException e) {
            e.printStackTrace(); // let know if file is there
        }

    }

    static {
        try {
            Class.forName("org.postgres.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionFactory getConnectionFactory(){
        return connectionFactory;
    }

    public Connection getConnection(){
        try {
            return DriverManager.getConnection("", "","");
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // will know if not connected to the data
        }
    }


}
