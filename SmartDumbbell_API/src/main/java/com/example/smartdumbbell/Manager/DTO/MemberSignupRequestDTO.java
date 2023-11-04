package com.example.smartdumbbell.Manager.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSignupRequestDTO {

    private String role;
    private String password;
    private String name;
    private String birth;
    private String gender;
    private String email;
    private String phone;
    private String institution;
}