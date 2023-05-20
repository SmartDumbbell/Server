package com.example.smartdumbbell.Web.WebAuth.Repository;

import com.example.smartdumbbell.Web.WebAuth.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebAuthRepository extends JpaRepository<Admin, Long> {

    //ID, Password 가 일치하는 Admin 객체.
    Admin findByIdAndPassword(String id, String password);

    Admin findByNameAndInstitution(String name, String institution);

    List<Admin> findByRole(String role);
}
//😤