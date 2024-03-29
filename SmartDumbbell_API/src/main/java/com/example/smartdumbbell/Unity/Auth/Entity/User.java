package com.example.smartdumbbell.Unity.Auth.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "userinfo")
public class User {

    public static final String changeString = "\u200B";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto Increment
    private int uid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String weight;

    @Column(nullable = false)
    private String height;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false)
    private String gender;

    public String getArm() {
        return arm;
    }

    public void setArm(String arm) {
        this.arm = arm;
    }

    @Column(nullable = false)
    private String arm;

    @Column(nullable = false)
    private int sarc_f;

    @Column
    private String forget;

    @Column(nullable = false)
    private String disease;

    @Column
    private String trainer;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name.replace(changeString,"");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id.replace(changeString,"");
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password.replace(changeString,"");
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWeight() {
        return Integer.parseInt(weight.replace(changeString,""));
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return Integer.parseInt(height.replace(changeString,""));
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBirth() {
        return birth.replace(changeString,"");
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    //생년월일로 나이 계산
    public int getBirthToAge() {

        String yearOfBirth = birth.substring(0, 2);

        String currentYear = LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));

        return Integer.parseInt(currentYear) - Integer.parseInt(yearOfBirth) + 1;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getForget() {
        return forget;
    }

    public void setForget(String forget) {
        this.forget = forget;
    }

    public int getSarc_f() {
        return sarc_f;
    }

    public void setSarc_f(int sarc_f) {
        this.sarc_f = sarc_f;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }



}
