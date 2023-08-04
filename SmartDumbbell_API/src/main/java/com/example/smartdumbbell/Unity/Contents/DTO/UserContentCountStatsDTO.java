package com.example.smartdumbbell.Unity.Contents.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserContentCountStatsDTO {

    private String userId;
    private String date;
    private int contentNumber;
}
