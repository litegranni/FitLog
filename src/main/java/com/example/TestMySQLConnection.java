package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMySQLConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/fitlog?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root";
        String password = "Norrmejerier4";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ Anslutning till MySQL fungerar!");
        } catch (SQLException e) {
            System.out.println("❌ Anslutning misslyckades: " + e.getMessage());
        }
    }
}
