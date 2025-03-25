package com.example.data.mysql;

import com.example.models.FitLog;
import org.springframework.context.annotation.Configuration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class FitLogDb {
    public static List<FitLog> findAll() throws SQLException{

    String query = "SELECT * FROM workout_logs";
    ResultSet rs = MysqlConnector.executeSelect(query);

        List<FitLog> logs = new ArrayList<>();

        while (rs.next()) {
            FitLog log = new FitLog();
            log.setId(rs.getLong("id"));
            log.setUserId(rs.getString("user_id"));
            log.setExerciseName(rs.getString("exercise_name"));
            log.setType(rs.getString("type"));
            log.setDate(rs.getDate("date").toLocalDate());
            logs.add(log);
        }
        return logs;
    }
    }
