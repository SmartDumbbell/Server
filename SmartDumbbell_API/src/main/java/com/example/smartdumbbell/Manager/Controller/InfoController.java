package com.example.smartdumbbell.Manager.Controller;


import com.example.smartdumbbell.Manager.Domain.Manager;
import com.example.smartdumbbell.Manager.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
public class InfoController {


    private final AuthService authService;

    @Autowired
    public InfoController(AuthService authService){
        this.authService = authService;
    }

    //내정보 표시(마이 페이지)
    @GetMapping("/view")
    public ResponseEntity<Manager> viewMemberInfo(@RequestParam String email){

        Manager info = authService.userDetailInfo(email);

        return ResponseEntity.ok().body(info);
    }

    //정보 변경
    @PostMapping("/update")
    public ResponseEntity<String> updateMemberInfo(@RequestBody Manager member) {
        authService.updateMember(member);
        return ResponseEntity.ok().body("Member 정보가 업데이트되었습니다.");
    }
}
