package com.revature.Francheska_Pina_P1.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final ConnectionFactory connectionFactory = new ConnectionFactory();

    private ConnectionFactory(){

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
