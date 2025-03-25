package com.example.models;

public class Trainer {
    private int trainerId;
    private String trainerName;
    private String trainerSpecialty;
    private String trainerEmail;

    public Trainer() {
    }

    public Trainer(int trainerId, String trainerName, String trainerSpecialty, String trainerEmail) {
        this.trainerId = trainerId;
        this.trainerName = trainerName;
        this.trainerSpecialty = trainerSpecialty;
        this.trainerEmail = trainerEmail;
    }

    // Getter och Setter för ID
    public int getId() {
        return trainerId;
    }
    public void setId(int id) {
        this.trainerId = id;
    }

    // Getter och Setter för namn
    public String getName() {
        return trainerName;
    }
    public void setName(String name) {
        this.trainerName = name;
    }

    // Getter och Setter för specialty
    public String getSpecialty() {
        return trainerSpecialty;
    }
    public void setSpecialty(String specialty) {
        this.trainerSpecialty = specialty;
    }

    // Getter och Setter för email
    public String getEmail() {
        return trainerEmail;
    }
    public void setEmail(String email) {
        this.trainerEmail = email;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + trainerId +
                ", name='" + trainerName + '\'' +
                ", specialty='" + trainerSpecialty + '\'' +
                ", email='" + trainerEmail + '\'' +
                '}';
    }
}
