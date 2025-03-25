package com.example.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "activity_logs")
public class FitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String type; // training

    @Column(nullable = false)
    private int duration; // minuter

    @Column(name = "exercise_name")
    private String exerciseName;

    @Column(nullable = false)
    private LocalDate date;

    @Override
    public String toString() {
        return "FitLog{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", type='" + type + '\'' +
                ", duration=" + duration +
                ", exerciseName='" + exerciseName + '\'' +
                ", date=" + date +
                '}';
    }
}



