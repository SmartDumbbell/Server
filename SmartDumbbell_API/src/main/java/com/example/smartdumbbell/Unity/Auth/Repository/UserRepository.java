package com.example.smartdumbbell.Unity.Auth.Repository;


import com.example.smartdumbbell.Unity.Auth.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //ID, Password 가 일치하는 User 객체 찾기
    User findByIdAndPassword(String id, String password);

    //비밀번호 찾기를 위한 User 객체 찾기
    User findByNameAndIdAndForget(String name, String id, String forget);

    //아이디 찾기를 위한 User 객체 찾기
    User findByNameAndBirth(String name, String birth);

    //아이디 중복 검사를 위한 User 객체 찾기
    Optional<User> findById(String id);

    //특정 트레이너의 유저 찾기.
    List<User> findByTrainer(String trainer);

    // uid로 User 객체 찾기
    Optional<User> findByUid(Long uid);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.sarc_f = :sarcF WHERE u.id = :id")
    void updateSarcF(String id, int sarcF);
}

