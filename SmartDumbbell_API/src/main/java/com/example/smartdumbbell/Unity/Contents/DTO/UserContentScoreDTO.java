package com.example.smartdumbbell.Unity.Contents.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserContentScoreDTO {

    private String userId;
    private LocalDate date;
    private int contentNumber;
    private int score;
}
