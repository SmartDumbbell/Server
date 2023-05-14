package com.example.smartdumbbell_web.Login.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.io.IOException;

@Controller
public class LoginController {

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/")
    public String loginPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin") && password.equals("password")) {

            HttpSession session = request.getSession();
            session.setAttribute("isLoggedIn", true);

            return "redirect:/";
        } else {

            return "redirect:/login";
        }
    }

    @GetMapping("/su")
    public String SignUp(){
        return "SignUP";
    }
}

