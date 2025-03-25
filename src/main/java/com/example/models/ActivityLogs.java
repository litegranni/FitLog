package com.example.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "activity_logs")
public class ActivityLogs {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    public ActivityLogs() {
        this.id = UUID.randomUUID().toString();
    }

    public ActivityLogs(Users user, String type, int duration, Date date) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.type = type;
        this.duration = duration;
        this.date = date;
    }

    public String getId() { return id; }
    public Users getUser() { return user; }
    public void setUser(Users user) { this.user = user; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}
