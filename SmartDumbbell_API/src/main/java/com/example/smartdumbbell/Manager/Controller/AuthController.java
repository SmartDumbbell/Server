package com.example.smartdumbbell.Manager.Controller;


import com.example.smartdumbbell.Manager.DTO.JwtRequestDTO;
import com.example.smartdumbbell.Manager.DTO.JwtResponseDTO;
import com.example.smartdumbbell.Manager.DTO.MemberSignupRequestDTO;
import com.example.smartdumbbell.Manager.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping(value = "login")
    public ResponseEntity<JwtResponseDTO> login(@RequestBody JwtRequestDTO request) {

        try {
            return ResponseEntity.ok().body(authService.login(request));
        }catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(new JwtResponseDTO("failed"));
        }

    }

    @PostMapping(value = "signup")
    public ResponseEntity<String> signup(@RequestBody MemberSignupRequestDTO request) {

        boolean isSignup;

        try {
             isSignup = authService.signup(request);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        if(!isSignup)
            return ResponseEntity.badRequest().body("failed");

        return ResponseEntity.ok().body("success");
    }


}