package com.example.smartdumbbell.Web.WebAuth.DTO;

import lombok.Data;

@Data
public class WebSignUpDTO {
    String id;
    String password;
    String name;
    String role;
    String institution;
}