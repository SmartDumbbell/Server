package com.example.smartdumbbell.Unity.Measure.DTO;


import lombok.Data;

import java.sql.Date;

@Data
public class CountDTO {
    String name;
    Date date;
    int count_left;
    int count_right;
}