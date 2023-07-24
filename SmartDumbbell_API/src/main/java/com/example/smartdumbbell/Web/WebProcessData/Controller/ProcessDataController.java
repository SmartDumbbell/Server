package com.example.smartdumbbell.Web.WebProcessData.Controller;


import com.example.smartdumbbell.Unity.Auth.DTO.SignUpDTO;
import com.example.smartdumbbell.Unity.Auth.Entity.User;
import com.example.smartdumbbell.Web.WebAuth.Entity.Admin;
import com.example.smartdumbbell.Web.WebProcessData.DTO.TrainerNameDTO;
import com.example.smartdumbbell.Web.WebProcessData.Service.ProcessDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:9090")
@RestController
@RequestMapping("/WebProcess")
public class ProcessDataController {

    private final ProcessDataService processDataService;

    @Autowired
    public ProcessDataController(ProcessDataService processDataService){
        this.processDataService = processDataService;
    }

    @GetMapping("/UserAll")
    public List<String> getAllUsers(){
        return processDataService.getAllUser();
    }

    @GetMapping("/trainerAll")
    public List<Admin> getAllTrainers(){
        return processDataService.getAllTrainers();
    }

    @PostMapping("/myUsers")
    public List<User> getMyUsers(@RequestBody TrainerNameDTO trainerNameDTO){
        return processDataService.getMyUsers(trainerNameDTO);
    }

}
