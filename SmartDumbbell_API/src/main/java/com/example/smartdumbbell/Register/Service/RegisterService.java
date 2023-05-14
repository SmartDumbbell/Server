package com.example.smartdumbbell.Register.Service;


import com.example.smartdumbbell.Register.DTO.DuplicateDTO;
import com.example.smartdumbbell.Register.DTO.FindDTO;
import com.example.smartdumbbell.Register.DTO.SignInDTO;
import com.example.smartdumbbell.Register.DTO.SignUpDTO;
import com.example.smartdumbbell.Register.Entity .User;
import com.example.smartdumbbell.Register.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    public UserRepository userRepository;


    public RegisterService(UserRepository userRepository){
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

    public String forgetPassword(FindDTO findDTO){
        User user = userRepository.findByIdAndForget(findDTO.getId(), findDTO.getForget());

        if(user == null)
            return "Not a member";

        return user.getPassword();
    }

    public String forgetId(FindDTO findDTO){
        User user = userRepository.findByIdAndBirth(findDTO.getId(), findDTO.getBirth());

        if(user == null)
            return "Not a member";

        return user.getId();
    }

    public String duplicateId(DuplicateDTO duplicateDTO){
        User user = userRepository.findById(duplicateDTO.getId());

        if(user == null)
            return "possible";

        return "impossible";
    }

}