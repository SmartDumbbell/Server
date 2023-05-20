package com.example.smartdumbbell.Unity.Auth.Controller;


import com.example.smartdumbbell.Unity.Auth.DTO.DuplicateDTO;
import com.example.smartdumbbell.Unity.Auth.DTO.FindDTO;
import com.example.smartdumbbell.Unity.Auth.DTO.SignInDTO;
import com.example.smartdumbbell.Unity.Auth.DTO.SignUpDTO;
import com.example.smartdumbbell.Unity.Auth.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Register")
public class AuthController {

    @Autowired
    private AuthService authService;

    //회원가입
    @PostMapping("/SignUp")
    public ResponseEntity<String> createUser(@RequestBody SignUpDTO signUpDTO,
                                             @RequestHeader("Content-Type") String contentType) {

        if("application/json".equals(contentType)){
            authService.SignUp(signUpDTO);

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
            String res = authService.SignIn(signInDTO);

            return ResponseEntity.ok().body(res);
        }else{
            return ResponseEntity.badRequest().body("mismatched header");
        }
    }

    //비밀번호 찾기
    @PostMapping("/ForgetPassword")
    public ResponseEntity<String> ForgetPassword(@RequestBody FindDTO findDTO,
                                         @RequestHeader("Content-Type") String contentType){

        if("application/json".equals(contentType)){
            String res = authService.forgetPassword(findDTO);

            return ResponseEntity.ok().body(res);
        }else{
            return ResponseEntity.badRequest().body("mismatched header");
        }
    }

    //아이디 찾기
    @PostMapping("/ForgetID")
    public ResponseEntity<String> ForgetID(@RequestBody FindDTO findDTO,
                                           @RequestHeader("Content-Type") String contentType){
        if("application/json".equals(contentType)){
            String res = authService.forgetId(findDTO);

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
            String res = authService.duplicateId(duplicateDTO);

            return ResponseEntity.ok().body(res);
        }else{
            return ResponseEntity.badRequest().body("mismatched header");
        }
    }

}