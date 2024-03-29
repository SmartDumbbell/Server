package com.example.smartdumbbell.Unity.Measure.Controller;


import com.example.smartdumbbell.Unity.Measure.DTO.CountDTO;
import com.example.smartdumbbell.Unity.Measure.DTO.GripDTO;
import com.example.smartdumbbell.Unity.Measure.DTO.SARCDTO;
import com.example.smartdumbbell.Unity.Measure.Service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Measure")
public class MeasureController {

    @Autowired
    private MeasureService measureService;

    //악력 측정 데이터 저장
    @PostMapping("/Grip")
    public ResponseEntity<String> Grip(@RequestBody GripDTO gripDTO,
                                            @RequestHeader("Content-Type") String contentType){
        if("application/json".equals(contentType)){

            try {
                measureService.SaveGripData(gripDTO);
                return ResponseEntity.ok().body("save data");
            }catch (Exception e ){
                return ResponseEntity.badRequest().body(e.toString());
            }
        }else{
            return ResponseEntity.badRequest().body("mismatched header");
        }
    }

    //횟수 측정 데이터 저장
    @PostMapping("/Count")
    public ResponseEntity<String> Count (@RequestBody CountDTO countDTO,
                                            @RequestHeader("Content-Type") String contentType){

        if("application/json".equals(contentType)){
            try {
                measureService.SaveCountData(countDTO);
                return ResponseEntity.ok().body("save data");
            }catch (Exception e ){
                return ResponseEntity.badRequest().body(e.toString());
            }
        }else{
            return ResponseEntity.badRequest().body("mismatched header");
        }
    }

    //올바른 로그인 시 이름과 금일 날짜로 행 생성
    @PostMapping("/CreateRow")
    public ResponseEntity<String> CreateRow(@RequestBody GripDTO gripDTO,
                                            @RequestHeader("Content-Type") String contentType){
        if("application/json".equals(contentType)){


            try {
                measureService.CreateDataRow(gripDTO);
                return ResponseEntity.ok().body("Create Success");
            }catch (Exception e){
                return ResponseEntity.badRequest().body(e.toString());
            }
        }else{
            return ResponseEntity.badRequest().body("mismatched header");
        }
    }


}
