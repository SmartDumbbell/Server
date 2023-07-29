package com.example.smartdumbbell.Unity.Contents.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserContentStatsDTO {

    private Long userId;
    private LocalDate date;
    private int content1Count;
    private int content2Count;
    private int content3Count;
    private int content4Count;
    private int content5Count;
    private int content6Count;
}
