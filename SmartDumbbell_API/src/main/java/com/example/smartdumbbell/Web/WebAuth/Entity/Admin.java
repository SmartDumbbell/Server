package com.example.smartdumbbell.Web.WebAuth.Entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "admin")
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String institution;
}
