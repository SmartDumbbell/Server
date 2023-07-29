package com.example.smartdumbbell.Unity.Contents.Repository;

import com.example.smartdumbbell.Unity.Auth.Entity.User;
import com.example.smartdumbbell.Unity.Contents.Entity.UserContentStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserContentStatsRepository extends JpaRepository<UserContentStats, Long> {

    UserContentStats findByUserAndDate(User user, LocalDate date);

    // 이 외에 필요한 쿼리 메소드가 있다면 추가 가능합니다.
}

