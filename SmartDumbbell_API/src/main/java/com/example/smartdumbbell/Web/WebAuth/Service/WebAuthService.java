package com.example.smartdumbbell.Web.WebAuth.Service;


import com.example.smartdumbbell.Web.WebAuth.DTO.WebLoginDTO;
import com.example.smartdumbbell.Web.WebAuth.DTO.WebSignUpDTO;
import com.example.smartdumbbell.Web.WebAuth.Entity.Admin;
import com.example.smartdumbbell.Web.WebAuth.Repository.WebAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebAuthService {

    @Autowired
    public WebAuthRepository webAuthRepository;


    public WebAuthService(WebAuthRepository webAuthRepository){
        this.webAuthRepository = webAuthRepository;
    }

    public String Login(WebLoginDTO webLoginDTO){

        Admin admin = webAuthRepository.findByIdAndPassword(webLoginDTO.getId(), webLoginDTO.getPassword());

        if(admin == null)
            return "failed";

        return "Success";

    }

    public boolean SignUp(WebSignUpDTO webSignUpDTO){
        Admin admin = new Admin();

        admin.setId(webSignUpDTO.getId());
        admin.setPassword(webSignUpDTO.getPassword());
        admin.setName(webSignUpDTO.getName());
        admin.setRole(webSignUpDTO.getRole());
        admin.setInstitution(webSignUpDTO.getInstitution());

        if(webAuthRepository
                .findByNameAndInstitution(webSignUpDTO.getName(), webSignUpDTO.getInstitution()) == null){
            //null 일시 신규회원

            webAuthRepository.save(admin);
            return true;
        }

        return false;


    }

}