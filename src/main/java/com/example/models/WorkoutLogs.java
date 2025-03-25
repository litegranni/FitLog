package com.example.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "workout_logs")
public class WorkoutLogs {

    int workoutId;
    int userId;
    String exerciseName;
    String type;
    LocalDate date;



    // Constructors
    public WorkoutLogs() {}

    public WorkoutLogs(Users user, String exerciseName, String type, LocalDate date) {
        this.userId = user.getUserId();
        this.exerciseName = exerciseName;
        this.type = type;
        this.date = date;
    }

    // Getters and setters...
}
