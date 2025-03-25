package com.example.data.mysql;

import com.example.models.WorkoutInfo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkoutInfoDb {

    public static List<WorkoutInfo> findAll() throws SQLException {
        String query = """
                SELECT u.name AS user_name, wl.exercise_name, wl.type, wl.date
                FROM workout_logs wl
                JOIN users u ON wl.user_id = u.id
                """;

        Connection conn = MysqlConnector.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        List<WorkoutInfo> workoutInfos = new ArrayList<>();

        while (rs.next()) {
            WorkoutInfo info = new WorkoutInfo(
                    rs.getString("user_name"),
                    rs.getString("exercise_name"),
                    rs.getString("type"),
                    rs.getString("date")
            );
            workoutInfos.add(info);
        }

        rs.close();
        stmt.close();
        conn.close();

        return workoutInfos;
    }
}
