package com.example.repositories;

import com.example.models.ActivityLogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityLogsRepository extends JpaRepository<ActivityLogs, String> {
}
