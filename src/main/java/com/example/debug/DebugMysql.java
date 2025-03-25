package com.example.debug;

import com.example.data.mysql.FitLogDb;
import com.example.data.mysql.TrainerDb;
import com.example.data.mysql.WorkoutInfoDb;

import java.sql.SQLException;

public class DebugMysql {

    public static void main(String[] args) throws SQLException {

        var FitLog = FitLogDb.findAll();
        FitLog.forEach(System.out::println);

        var Trainer = TrainerDb.findAll();
        Trainer.forEach(System.out::println);


        var workoutInfoList = WorkoutInfoDb.findAll();
        workoutInfoList.forEach(System.out::println);

    }
}
