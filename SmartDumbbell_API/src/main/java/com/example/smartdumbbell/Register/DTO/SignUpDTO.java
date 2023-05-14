package com.example.smartdumbbell.Register.DTO;


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
}
