package com.revature.Francheska_Pina_P1.Util;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactoryTestSuite {
    @Test
    public void test_getConnection_returnValidConnection_givenProvidedCredentialsAreCorrect(){
        try(Connection connection = ConnectionFactory.getConnectionFactory().getConnection()) {
            System.out.println(connection); // see connection is inside memory
            Assert.assertNotNull(connection);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
