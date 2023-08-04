package com.example.smartdumbbell.Unity.Contents.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "user_content_score_stats")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserContentScoreStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "content_1_score", nullable = false)
    private int content1Score;

    @Column(name = "content_2_score", nullable = false)
    private int content2Score;

    @Column(name = "content_3_score", nullable = false)
    private int content3Score;

    @Column(name = "content_4_score", nullable = false)
    private int content4Score;

    @Column(name = "content_5_score", nullable = false)
    private int content5Score;

    @Column(name = "content_6_score", nullable = false)
    private int content6Score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getContent1Score() {
        return content1Score;
    }

    public void setContent1Score(int content1Score) {
        this.content1Score = content1Score;
    }

    public int getContent2Score() {
        return content2Score;
    }

    public void setContent2Score(int content2Score) {
        this.content2Score = content2Score;
    }

    public int getContent3Score() {
        return content3Score;
    }

    public void setContent3Score(int content3Score) {
        this.content3Score = content3Score;
    }

    public int getContent4Score() {
        return content4Score;
    }

    public void setContent4Score(int content4Score) {
        this.content4Score = content4Score;
    }

    public int getContent5Score() {
        return content5Score;
    }

    public void setContent5Score(int content5Score) {
        this.content5Score = content5Score;
    }

    public int getContent6Score() {
        return content6Score;
    }

    public void setContent6Score(int content6Score) {
        this.content6Score = content6Score;
    }
// Constructors, getters, and setters (omitted for brevity)
}
