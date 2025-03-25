package com.example.data.mysql;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.*;

@Component
public class MysqlConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/fitlog";
    private static final String USER = "root";
    private static final String PASSWORD ="Norrmejerier4";

    private static Connection connection = null;



    public static Connection getConnection() throws SQLException {

        //kolla om en connection finns
        if (connection == null){
            System.out.println("CONNECTION TO DB");
            //öppna samt spara connection om den inte finns
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        //returnera connection
        return connection;

    }

    public static ResultSet executeSelect(String selectQuery) throws SQLException {
        Connection connection = getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(selectQuery);
        return rs;

    }


    private final JdbcTemplate jdbcTemplate;

    public MysqlConnector(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

}
