package com.example.smartdumbbell.Manager.Repository;


import com.example.smartdumbbell.Manager.Domain.Manager;
import com.example.smartdumbbell.Manager.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Manager, String> {
    Manager findByEmail(String email);
    boolean existsByEmail(String email);
    List<Manager> findAllByRole(Role role);
    void deleteByEmail(String email);

}
