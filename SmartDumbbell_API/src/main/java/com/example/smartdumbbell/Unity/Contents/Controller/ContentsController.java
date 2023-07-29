package com.example.smartdumbbell.Unity.Contents.Controller;


import com.example.smartdumbbell.Unity.Contents.DTO.UserContentStatsDTO;
import com.example.smartdumbbell.Unity.Contents.Service.UserContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contents")
public class ContentsController {

    @Autowired
    UserContentService userContentService;

    @PostMapping("/updateData")
    public ResponseEntity<String> dataSave(@RequestBody UserContentStatsDTO userContentStatsDTO,
                                           @RequestHeader("Content-Type") String contentType) {

        if("application/json".equals(contentType)){

            try{
                userContentService.updateContentCount(userContentStatsDTO);
            }catch (Exception e){
                return ResponseEntity.badRequest().body(e.getMessage());
            }

            return ResponseEntity.ok("data update");
        }else{
            return ResponseEntity.badRequest().body("mismatched header");
        }

    }

}

