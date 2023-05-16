package com.example.smartdumbbell.WebRegister.Repository;

import com.example.smartdumbbell.WebRegister.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebRegisterRepository extends JpaRepository<Admin, Long> {

    //ID, Password 가 일치하는 Admin 객체.
    Admin findByIdAndPassword(String id, String password);

}
