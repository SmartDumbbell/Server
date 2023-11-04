package com.example.smartdumbbell.Manager.Domain;



import com.example.smartdumbbell.Manager.DTO.MemberSignupRequestDTO;
import com.example.smartdumbbell.Manager.Model.Role;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Manager {

    @Id
    private String email;

    private String password;

    private String name;

    private String birth;

    private String gender;

    private String phone;

    private String institution;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Transient
    private boolean approved = false;

    public Manager(MemberSignupRequestDTO request) {
        email = request.getEmail();
        password = request.getPassword();
        name = request.getName();
        birth = request.getBirth();
        gender = request.getGender();
        phone = request.getPhone();
        institution = request.getInstitution();
        role = Role.USER; // 회원가입하는 사용자 권한 기본 USER (임시)
    }


    public void encryptPassword(PasswordEncoder passwordEncoder) {
        password = passwordEncoder.encode(password);
    }
}