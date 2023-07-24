package com.example.smartdumbbell.Unity.Auth.DTO;


import lombok.Data;

@Data
public class SignUpDTO {
    String name;
    String id;
    String password;
    String weight;
    String height;
    String birth;
    String gender;
    String forget;
    String armlength;
}
