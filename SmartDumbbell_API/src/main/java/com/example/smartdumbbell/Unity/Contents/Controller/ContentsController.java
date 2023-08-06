package com.example.smartdumbbell.Unity.Contents.Controller;

import com.example.smartdumbbell.Unity.Contents.DTO.ClusteringDataDTO;
import com.example.smartdumbbell.Unity.Contents.DTO.GraphInfoDTO;
import com.example.smartdumbbell.Unity.Contents.DTO.UserContentCountStatsDTO;
import com.example.smartdumbbell.Unity.Contents.DTO.UserContentScoreDTO;
import com.example.smartdumbbell.Unity.Contents.Entity.UserContentCountStats;
import com.example.smartdumbbell.Unity.Contents.Service.UserContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/contents")
public class ContentsController {

    private UserContentService userContentService;

    @Autowired
    public ContentsController(UserContentService userContentService) {
        this.userContentService = userContentService;
    }


    //컨텐츠 플레이 횟수 및 점수 갱신
    @PostMapping("/updateCount")
    public ResponseEntity<String> CountDataSave(@RequestBody UserContentCountStatsDTO userContentCountStatsDTO,
                                           @RequestHeader("Content-Type") String contentType) {

        if ("application/json".equals(contentType)) {
            try {
                userContentService.updateContentCount(userContentCountStatsDTO);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }

            return ResponseEntity.ok("data update");
        } else {
            return ResponseEntity.badRequest().body("mismatched header");
        }

    }

    @PostMapping("updateScore")
    public ResponseEntity<String> ScoreDataSave(@RequestBody UserContentScoreDTO userContentScoreDTO,
                                                @RequestHeader("Content-Type") String contentType) {
        if ("application/json".equals(contentType)) {

            userContentService.updateContentScore(userContentScoreDTO);

            return ResponseEntity.ok("data update");
        } else {
            return ResponseEntity.badRequest().body("mismatched header");
        }
    }

    @PostMapping("/graphData")
    public UserContentCountStats GraphDataSend(@RequestBody GraphInfoDTO graphInfoDTO,
                                               @RequestHeader("Content-Type") String contentType){

        if("application/json".equals(contentType)){
            System.out.println(graphInfoDTO.getUserId() + " " + graphInfoDTO.getDate());


            return userContentService.getGraphDataByUserIdAndDate(graphInfoDTO.getUserId(), graphInfoDTO.getDate());
        }

        return new UserContentCountStats();
    }



    @PostMapping("/send_clustering_data")
    public ResponseEntity<String> sendClusteringData() {
        // ClusteringDataDTO 리스트 생성
        List<ClusteringDataDTO> dataEntries = userContentService.clusteringDataToSaveDTO();

        // Flask API 호출 및 데이터 전송
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:5000/learning"; // Flask API의 URL을 지정해주세요.
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List<ClusteringDataDTO>> requestEntity = new HttpEntity<>(dataEntries, headers);

        ResponseEntity<ClusteringDataDTO> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, ClusteringDataDTO.class);
        ClusteringDataDTO responseBody = responseEntity.getBody();

        //클러스터링 결과 응답 DTO 구성해서 결과 분리해야함.
        //플라스크쪽은 건들거 없고 spring에서 받은 데이터 분리
        //0804
        // 응답 결과를 사용하거나 필요한 로직을 추가하세요.

        System.out.println(responseBody);

        return ResponseEntity.ok("Clustering data sent successfully");
    }
}
