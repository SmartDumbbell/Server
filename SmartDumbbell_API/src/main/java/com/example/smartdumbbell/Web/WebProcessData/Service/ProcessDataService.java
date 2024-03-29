package com.example.smartdumbbell.Web.WebProcessData.Service;

import com.example.smartdumbbell.Unity.Auth.DTO.SignUpDTO;
import com.example.smartdumbbell.Unity.Auth.Entity.User;
import com.example.smartdumbbell.Unity.Auth.Repository.UserRepository;
import com.example.smartdumbbell.Web.WebAuth.DTO.WebSignUpDTO;
import com.example.smartdumbbell.Web.WebAuth.Entity.Admin;
import com.example.smartdumbbell.Web.WebAuth.Repository.WebAuthRepository;
import com.example.smartdumbbell.Web.WebProcessData.DTO.TrainerNameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcessDataService {

    private final UserRepository userRepository;
    private final WebAuthRepository webAuthRepository;

    @Autowired
    public ProcessDataService(UserRepository userRepository, WebAuthRepository webAuthRepository){
        this.userRepository = userRepository;
        this.webAuthRepository = webAuthRepository;
    }



    //전체 유저를 전부 리턴
    public List<String> getAllUser(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public List<Admin> getAllTrainers(){
        return webAuthRepository.findByRole("trainer");
    }

    public List<User> getMyUsers(TrainerNameDTO trainerNameDTO){
        return userRepository.findByTrainer(trainerNameDTO.getTrainer());
    }


    private SignUpDTO convertToDto(User user) {
        SignUpDTO dto = new SignUpDTO();
        dto.setName(user.getName());
        return dto;
    }

}
