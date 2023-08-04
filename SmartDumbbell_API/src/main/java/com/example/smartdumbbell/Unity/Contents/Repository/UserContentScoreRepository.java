package com.example.smartdumbbell.Unity.Contents.Repository;

import com.example.smartdumbbell.Unity.Contents.Entity.UserContentCountStats;
import com.example.smartdumbbell.Unity.Contents.Entity.UserContentScoreStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface UserContentScoreRepository extends JpaRepository<UserContentScoreStats, Long> {

    UserContentScoreStats findByUserIdAndDate(String userId, LocalDate date);
}
