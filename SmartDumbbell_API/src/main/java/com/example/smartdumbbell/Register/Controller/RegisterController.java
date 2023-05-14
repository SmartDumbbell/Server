package com.example.smartdumbbell.Register.Controller;


import com.example.smartdumbbell.Register.DTO.DuplicateDTO;
import com.example.smartdumbbell.Register.DTO.FindDTO;
import com.example.smartdumbbell.Register.DTO.SignInDTO;
import com.example.smartdumbbell.Register.DTO.SignUpDTO;
import com.example.smartdumbbell.Register.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    //회원가입
    @PostMapping("/SignUp")
    public ResponseEntity<String> createUser(@RequestBody SignUpDTO signUpDTO,
                                             @RequestHeader("Content-Type") String contentType) {

        if("application/json".equals(contentType)){
            registerService.SignUp(signUpDTO);

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
            String res = registerService.SignIn(signInDTO);

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
            String res = registerService.forgetPassword(findDTO);

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
            String res = registerService.forgetId(findDTO);

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
            String res = registerService.duplicateId(duplicateDTO);

            return ResponseEntity.ok().body(res);
        }else{
            return ResponseEntity.badRequest().body("mismatched header");
        }
    }

}
