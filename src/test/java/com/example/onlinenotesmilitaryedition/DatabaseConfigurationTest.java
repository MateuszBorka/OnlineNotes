package com.example.onlinenotesmilitaryedition;

import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import static org.junit.Assert.assertEquals;

public class DatabaseConfigurationTest {

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/onlinenotesmilitaryedition";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "12341234";

    @Test
    public void testDatabaseConnection() throws Exception {
        Class.forName(DB_DRIVER);
        try (Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD)) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("ALTER TABLE onlinenotesmilitaryedition\n" +
                    "ADD COLUMN test VARCHAR(255);");
            while (rs.next()) {
                String name = rs.getString("name");
                assertEquals("John Doe", name);
            }
        }
    }
}
