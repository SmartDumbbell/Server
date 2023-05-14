package com.example.smartdumbbell.Register.Repository;


import com.example.smartdumbbell.Register.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //ID, Password 가 일치하는 User 객체 찾기
    User findByIdAndPassword(String id, String password);

    //비밀번호 찾기를 위한 User 객체 찾기
    User findByIdAndForget(String id, String forget);

    //아이디 찾기를 위한 User 객체 찾기
    User findByIdAndBirth(String id, String birth);

    //아이디 중복 검사를 위한 User 객체 찾기
    User findById(String id);
}

