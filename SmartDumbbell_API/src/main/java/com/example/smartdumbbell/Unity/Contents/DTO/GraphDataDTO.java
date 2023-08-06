package com.example.smartdumbbell.Unity.Contents.DTO;


import lombok.Data;

import java.time.LocalDate;

@Data
public class GraphDataDTO {

    String id;
    LocalDate date;
    int content1Count;
    int content2Count;
    int content3Count;
    int content4Count;
    int content5Count;
    int content6Count;
}
