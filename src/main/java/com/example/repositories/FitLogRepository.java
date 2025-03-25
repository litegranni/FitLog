package com.example.repositories;

import com.example.models.FitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FitLogRepository extends JpaRepository<FitLog, Long> {
    List<FitLog> findByUserId(String userId);
}
