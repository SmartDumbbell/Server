package com.example.smartdumbbell.Unity.Contents.Repository;

import com.example.smartdumbbell.Unity.Contents.Entity.UserContentCountStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UserContentStatsRepository extends JpaRepository<UserContentCountStats, Long> {

    UserContentCountStats findByUserIdAndDate(String userId, LocalDate date);

    List<UserContentCountStats> findAllByUserId(String userId);
}
