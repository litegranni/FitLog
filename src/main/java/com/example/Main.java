package com.example;

import com.example.data.mysql.FitLogDb;
import com.example.data.mysql.MysqlConnector;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
//show FitLogs
        try {
          var FitLog =  FitLogDb.findAll();
           FitLog.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //show first fitLog?

        try{
            var FitLog = FitLogDb.findAll();
            System.out.println(FitLog.get(0));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void showworkout_logs() throws SQLException {
        String query = "SELECT * FROM workout_logs;";
        Connection connection = MysqlConnector.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("id");
            int userId = rs.getInt("user_id");
            String exercise = rs.getString("exercise_name");
            String type = rs.getString("type");
            Timestamp date = rs.getTimestamp("date");

            System.out.println("Workout ID: " + id + ", User ID: " + userId + ", Exercise: " + exercise + ", Type: " + type + ", Date: " + date);
        }

    }


    }
