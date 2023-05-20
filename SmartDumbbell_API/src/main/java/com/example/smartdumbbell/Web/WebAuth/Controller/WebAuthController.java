package com.example.smartdumbbell.Web.WebAuth.Controller;

import com.example.smartdumbbell.Web.WebAuth.DTO.WebLoginDTO;
import com.example.smartdumbbell.Web.WebAuth.DTO.WebSignUpDTO;
import com.example.smartdumbbell.Web.WebAuth.Service.WebAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/WebRegister")
public class WebAuthController {

    @Autowired
    private WebAuthService webAuthService;

    @PostMapping("/Login")
    public boolean Login(@RequestBody WebLoginDTO webLoginDTO){

        String res = webAuthService.Login(webLoginDTO);

        if(res.equals("Success"))
            return true;

        return false;
    }

    @PostMapping("/SignUp")
    public boolean SignUp(@RequestBody WebSignUpDTO webSignUpDTO){

        boolean res = webAuthService.SignUp(webSignUpDTO);

        if(res)
            return true;

        return false;
    }



}
