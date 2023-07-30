package com.example.smartdumbbell.Unity.Measure.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class GripDTO {
    String id;
    Date date;
    float grip_left;
    float grip_right;
}
