package com.example.models;

public class WorkoutInfo {
    private String userName;
    private String exerciseName;
    private String type;
    private String trainerName;
    private String date;

    public WorkoutInfo(String userName, String exerciseName, String type, String trainerName) {
        this.userName = userName;
        this.exerciseName = exerciseName;
        this.type = type;
        this.trainerName = trainerName;
        this.date = date;
    }

    // Getters & setters...

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "WorkoutInfo{" +
                "userName='" + userName + '\'' +
                ", exerciseName='" + exerciseName + '\'' +
                ", type='" + type + '\'' +
                ", trainerName='" + trainerName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
