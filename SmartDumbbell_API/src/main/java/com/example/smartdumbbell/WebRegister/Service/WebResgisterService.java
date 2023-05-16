package com.example.smartdumbbell.WebRegister.Service;


import com.example.smartdumbbell.WebRegister.DTO.LoginDTO;
import com.example.smartdumbbell.WebRegister.Entity.Admin;
import com.example.smartdumbbell.WebRegister.Repository.WebRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebResgisterService {

    @Autowired
    public WebRegisterRepository webRegisterRepository;


    public WebResgisterService(WebRegisterRepository webRegisterRepository){
        this.webRegisterRepository = webRegisterRepository;
    }

    public String Login(LoginDTO loginDTO){

        Admin admin = webRegisterRepository.findByIdAndPassword(loginDTO.getId(), loginDTO.getPassword());

        if(admin == null)
            return "failed";

        return "Success";

    }

}
