package com.example.smartdumbbell.Config.CORSConfig;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("https://web-template-3prof2llkxuyz4l.sel4.cloudtype.app", "http://localhost:3000","*")
                .allowedMethods("GET", "POST", "DELETE");

    }
}
