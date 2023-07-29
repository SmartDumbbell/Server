package com.example.smartdumbbell.Unity.Contents.Entity;

import com.example.smartdumbbell.Unity.Auth.Entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "user_content_stats")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserContentStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // User 엔티티와의 연관 관계를 설정합니다.

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "content_1", nullable = false)
    private int content1Count;

    @Column(name = "content_2", nullable = false)
    private int content2Count;

    @Column(name = "content_3", nullable = false)
    private int content3Count;

    @Column(name = "content_4", nullable = false)
    private int content4Count;

    @Column(name = "content_5", nullable = false)
    private int content5Count;

    @Column(name = "content_6", nullable = false)
    private int content6Count;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getContent1Count() {
        return content1Count;
    }

    public void setContent1Count(int content1Count) {
        this.content1Count = content1Count;
    }

    public int getContent2Count() {
        return content2Count;
    }

    public void setContent2Count(int content2Count) {
        this.content2Count = content2Count;
    }

    public int getContent3Count() {
        return content3Count;
    }

    public void setContent3Count(int content3Count) {
        this.content3Count = content3Count;
    }

    public int getContent4Count() {
        return content4Count;
    }

    public void setContent4Count(int content4Count) {
        this.content4Count = content4Count;
    }

    public int getContent5Count() {
        return content5Count;
    }

    public void setContent5Count(int content5Count) {
        this.content5Count = content5Count;
    }

    public int getContent6Count() {
        return content6Count;
    }

    public void setContent6Count(int content6Count) {
        this.content6Count = content6Count;
    }
}
