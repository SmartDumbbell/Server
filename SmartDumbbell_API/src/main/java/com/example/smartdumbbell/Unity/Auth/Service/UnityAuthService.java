package com.example.smartdumbbell.Unity.Auth.Service;


import com.example.smartdumbbell.Unity.Auth.DTO.*;
import com.example.smartdumbbell.Unity.Auth.Entity.User;
import com.example.smartdumbbell.Unity.Auth.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnityAuthService {

    @Autowired
    public UserRepository userRepository;


    public UnityAuthService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public void SignUp(SignUpDTO signUpDTO) {
        User user;
        user = new User();
        user.setName(signUpDTO.getName());
        user.setId(signUpDTO.getId());
        user.setPassword(signUpDTO.getPassword());
        user.setWeight(signUpDTO.getWeight());
        user.setHeight(signUpDTO.getHeight());
        user.setBirth(signUpDTO.getBirth());
        user.setGender(signUpDTO.getGender());
        user.setForget(signUpDTO.getForget());
        user.setArm(signUpDTO.getArm());
        user.setSarc_f(0);//기본점수 0
        user.setDisease("");

        userRepository.save(user);
    }

    public String SignIn(SignInDTO signInDTO){
         User user =  userRepository.findByIdAndPassword(signInDTO.getId(),signInDTO.getPassword());

        if(user == null){
            return "failed";
        }

        return "Success";

    }

    public String forgetPassword(FindPWDTO findPWDTO){
        User user = userRepository.findByNameAndIdAndForget(findPWDTO.getName(), findPWDTO.getId(), findPWDTO.getForget());

        if(user == null)
            return "Not a member";

        return user.getPassword();
    }

    public String forgetId(FindIdDTO findIdDTO){
        User user = userRepository.findByNameAndBirth(findIdDTO.getName(), findIdDTO.getBirth());

        if(user == null)
            return "Not a member";

        return user.getId();
    }

    public String duplicateId(DuplicateDTO duplicateDTO){
        User user = userRepository.findById(duplicateDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with the given userId."));

        if(user == null)
            return "possible";

        return "impossible";
    }

    public String sarcUpdate(SarcDTO sarcDTO){
        User user = userRepository.findById(sarcDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with the given userId."));

        if(user==null)
            return "noMember";

        try {
            userRepository.updateSarcF(sarcDTO.getId(), sarcDTO.getSarc_f());
        }catch (Exception e){
            System.out.println(e);
        }

        return "ok";
    }

}