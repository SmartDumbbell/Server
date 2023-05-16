package com.example.smartdumbbell_web.Login.Controller;

import com.example.smartdumbbell_web.Login.DTO.LoginDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@Controller
public class LoginController {

    private WebClient webClient;

    public LoginController(){
        this.webClient = WebClient.create();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");//web에서 받아온 값.
        String password = request.getParameter("password");

        System.out.println("web의 정보 : " + id + " " + password);

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setId(id);
        loginDTO.setPassword(password);

        String LoginAPIURL = "http://localhost:8080/WebRegister/Login";

        // boolean 값을 받기 위해 Void.class 사용
        // 요청이 성공적으로 완료되면 true를 반환
        // 요청이 실패하면 false를 반환

        /***
            String 값을 리턴받기 위해 String.class사용
         */

        String result = webClient.method(HttpMethod.POST)
                .uri(LoginAPIURL)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(loginDTO))
                .retrieve()
                .bodyToMono(String.class)   // API의 리턴을 String으로 받음
                .block();

        System.out.println(result);

        if(result.equals("true"))
            return "redirect:/main";

        return "redirect:/login";

    }

    @GetMapping("/main")
    public String GoMain(){return "main";}

    @GetMapping("/su")
    public String SignUp(){
        return "SignUP";
    }


}

