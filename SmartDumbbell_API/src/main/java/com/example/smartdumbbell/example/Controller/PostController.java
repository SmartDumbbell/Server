package com.example.smartdumbbell.example.Controller;


import com.example.smartdumbbell.Unity.Auth.DTO.SignUpDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @PostMapping("/postMethod")
    public ResponseEntity<String> processData(
            @RequestBody SignUpDTO signUpDTO, @RequestHeader("Content-Type") String contentType) {

         if ("application/json".equals(contentType)) {
            String result = signUpDTO.getId();

            return ResponseEntity.ok(result);
        }
        return null;
    }

    /*@JsonAutoDetect
    public static class UnityData{
        private String id;
        private String password;

        public UnityData(String id, String password){
            this.id = id;
            this.password = password;
        }

        public String getId() {return id;}

        public String getPassword() {return password;}

        public void setId(String id) {this.id = id;}

        public void setPassword(String password) {this.password = password;}

        public String Login(){
            if(correctID.equals(id)){
                if(correctPassword.equals(password)){
                    return "로그인 성공";
                }else{
                    return "비밀번호가 일치하지 않습니다.";
                }
            }else{
                return "아이디가 존재하지 않습니다.";
            }
        }

        //toString 오버라이드
        @Override
        public String toString(){
            return "유니티 데이터{" +
                    "이름 ='" + id + "'" +
                    ", age =" + password +
                    '}';
        }

    }*/
}
