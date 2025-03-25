package com.example.data.mysql;

import com.example.models.Trainer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainerDb {

    public static List<Trainer> findAll() throws SQLException{
// connect and prepare query
        String query = "SELECT * FROM trainers";
        ResultSet rs = MysqlConnector.executeSelect(query);


       //create empty list of trainers
        List<Trainer> trainers = new ArrayList<>();

        //get trainer data
        while (rs.next()){
            Trainer trainer = new Trainer(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("specialty"),
                    rs.getString("email")
            );
            //add trainer to list
            trainers.add(trainer);


        }
        //return teacher list
        return trainers;

    }
}
