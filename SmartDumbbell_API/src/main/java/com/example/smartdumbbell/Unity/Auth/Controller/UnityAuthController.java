package com.example.smartdumbbell.Unity.Auth.Controller;


import com.example.smartdumbbell.Unity.Auth.DTO.*;
import com.example.smartdumbbell.Unity.Auth.Repository.UserRepository;
import com.example.smartdumbbell.Unity.Auth.Service.UnityAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class UnityAuthController {

    @Autowired
    private UnityAuthService unityAuthService;
    private UserRepository userRepository;

    //회원가입
    @PostMapping("/SignUp")
    public ResponseEntity<String> createUser(@RequestBody SignUpDTO signUpDTO,
                                             @RequestHeader("Content-Type") String contentType) {

        if("application/json".equals(contentType)){
            unityAuthService.SignUp(signUpDTO);

            return ResponseEntity.ok("SignUp Complete");
        }else{
            return ResponseEntity.badRequest().body("mismatched header");
        }
    }

    //로그인
    @PostMapping("/SignIn")
    public ResponseEntity<String> Login(@RequestBody SignInDTO signInDTO,
                                        @RequestHeader("Content-Type") String contentType){

        if("application/json".equals(contentType)){
            String res = unityAuthService.SignIn(signInDTO);

            return ResponseEntity.ok().body(res);
        }else{
            return ResponseEntity.badRequest().body("mismatched header");
        }
    }

    //비밀번호 찾기
    @PostMapping("/ForgetPassword")
    public ResponseEntity<String> ForgetPassword(@RequestBody FindPWDTO findPWDTO,
                                         @RequestHeader("Content-Type") String contentType){

        if("application/json".equals(contentType)){
            String res = unityAuthService.forgetPassword(findPWDTO);

            return ResponseEntity.ok().body(res);
        }else{
            return ResponseEntity.badRequest().body("mismatched header");
        }
    }

    //아이디 찾기
    @PostMapping("/ForgetID")
    public ResponseEntity<String> ForgetID(@RequestBody FindIdDTO findIdDTO,
                                           @RequestHeader("Content-Type") String contentType){
        if("application/json".equals(contentType)){
            String res = unityAuthService.forgetId(findIdDTO);

            return ResponseEntity.ok().body(res);
        }else{
            return ResponseEntity.badRequest().body("mismatched header");
        }
    }

    //아이디 중복 확인
    @PostMapping("/DuplicateID")
    public ResponseEntity<String> DuplicateID(@RequestBody DuplicateDTO duplicateDTO,
                                              @RequestHeader("Content-Type") String contentType) {
        if("application/json".equals(contentType)){
            String res = unityAuthService.duplicateId(duplicateDTO);

            return ResponseEntity.ok().body(res);
        }else{
            return ResponseEntity.badRequest().body("mismatched header");
        }
    }

    //Sarc-f 점수 업데이트
    @PostMapping("/sarc")
    public ResponseEntity<String> upSarc(@RequestBody SarcDTO sarcDTO,
                                           @RequestHeader("Content-Type") String contentType) {
        if("application/json".equals(contentType)){
            String res = unityAuthService.sarcUpdate(sarcDTO);

            return ResponseEntity.ok().body(res);
        }else{
            return ResponseEntity.badRequest().body("mismatched header");
        }
    }

}
