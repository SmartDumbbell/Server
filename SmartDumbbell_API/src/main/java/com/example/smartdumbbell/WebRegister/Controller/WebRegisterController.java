package com.example.smartdumbbell.WebRegister.Controller;

import com.example.smartdumbbell.WebRegister.DTO.LoginDTO;
import com.example.smartdumbbell.WebRegister.Service.WebResgisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/WebRegister")
public class WebRegisterController {

    @Autowired
    private WebResgisterService webResgisterService;

    @PostMapping("/Login")
    public boolean Login(@RequestBody LoginDTO loginDTO){

        String res = webResgisterService.Login(loginDTO);

        if(res.equals("Success"))
            return true;

        return false;

    }



}
