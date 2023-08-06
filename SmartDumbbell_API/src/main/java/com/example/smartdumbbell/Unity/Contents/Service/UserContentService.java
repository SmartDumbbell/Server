package com.example.smartdumbbell.Unity.Contents.Service;

import com.example.smartdumbbell.Unity.Auth.Entity.User;
import com.example.smartdumbbell.Unity.Auth.Repository.UserRepository;
import com.example.smartdumbbell.Unity.Contents.DTO.*;
import com.example.smartdumbbell.Unity.Contents.Entity.UserContentCountStats;
import com.example.smartdumbbell.Unity.Contents.Entity.UserContentScoreStats;
import com.example.smartdumbbell.Unity.Contents.Repository.UserContentScoreRepository;
import com.example.smartdumbbell.Unity.Contents.Repository.UserContentStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserContentService {

    private UserContentStatsRepository contentStatsRepository;
    private UserRepository userRepository;
    private UserContentScoreRepository userContentScoreRepository;
    @Autowired
    public UserContentService(UserContentStatsRepository contentStatsRepository
                                ,UserRepository userRepository
                                ,UserContentScoreRepository userContentScoreRepository) {
        this.contentStatsRepository = contentStatsRepository;
        this.userRepository = userRepository;
        this.userContentScoreRepository = userContentScoreRepository;
    }

    @Transactional
    public void updateContentCount(UserContentCountStatsDTO contentDTO) {
        UserContentCountStats contentStats = getContentStats(contentDTO.getUserId(), contentDTO.getDate());

        // 전송된 번호의 컨텐츠 횟수를 더해줍니다.
        switch (contentDTO.getContentNumber()) {
            case 1:
                contentStats.setContent1Count(contentStats.getContent1Count() + 1);
                break;
            case 2:
                contentStats.setContent2Count(contentStats.getContent2Count() + 1);
                break;
            case 3:
                contentStats.setContent3Count(contentStats.getContent3Count() + 1);
                break;
            case 4:
                contentStats.setContent4Count(contentStats.getContent4Count() + 1);
                break;
            case 5:
                contentStats.setContent5Count(contentStats.getContent5Count() + 1);
                break;
            case 6:
                contentStats.setContent6Count(contentStats.getContent6Count() + 1);
                break;
            default:
                // 유효하지 않은 컨텐츠 번호가 전송된 경우에 대한 예외 처리
                throw new IllegalArgumentException("Invalid content number: " + contentDTO.getContentNumber());
        }

        // 업데이트된 컨텐츠 횟수를 데이터베이스에 저장합니다.
        contentStatsRepository.save(contentStats);
    }
    @Transactional
    public void updateContentScore(UserContentScoreDTO scoreDTO) {
        String userId = scoreDTO.getUserId();
        LocalDate date= scoreDTO.getDate();
        int contentNumber = scoreDTO.getContentNumber();
        int score = scoreDTO.getScore();


        //현재 내 DB에 존재하는 컨텐츠 점수
        UserContentScoreStats user = userContentScoreRepository.findByUserIdAndDate(userId, date);


        //플레이 기록이 없다면
        if (user == null) {

            UserContentScoreStats tempData = UserContentScoreStats.builder()
                    .userId(userId)
                    .date(date)
                    .content1Score(0)
                    .content2Score(0)
                    .content3Score(0)
                    .content4Score(0)
                    .content5Score(0)
                    .content6Score(0)
                    .build();

            switch (contentNumber) {
                case 1 -> tempData.setContent1Score(score);
                case 2 -> tempData.setContent2Score(score);
                case 3 -> tempData.setContent3Score(score);
                case 4 -> tempData.setContent4Score(score);
                case 5 -> tempData.setContent5Score(score);
                case 6 -> tempData.setContent6Score(score);
            }
            userContentScoreRepository.save(tempData);
            return;
        }

        //기록이 존재한다면
        switch (contentNumber) {
            case 1 -> {
                int currentScore = user.getContent1Score();
                if (score > currentScore) {
                    user.setContent1Score(score);
                    userContentScoreRepository.save(user);
                }
            }
            case 2 -> {
                int currentScore = user.getContent2Score();
                if (score > currentScore) {
                    user.setContent2Score(score);
                    userContentScoreRepository.save(user);
                }
            }
            case 3 -> {
                int currentScore = user.getContent3Score();
                if (score > currentScore) {
                    user.setContent3Score(score);
                    userContentScoreRepository.save(user);
                }
            }
            case 4 -> {
                int currentScore = user.getContent4Score();
                if (score > currentScore) {
                    user.setContent4Score(score);
                    userContentScoreRepository.save(user);
                }
            }
            case 5 -> {
                int currentScore = user.getContent5Score();
                if (score > currentScore) {
                    user.setContent5Score(score);
                    userContentScoreRepository.save(user);
                }
            }
            case 6 -> {
                int currentScore = user.getContent6Score();
                if (score > currentScore) {
                    user.setContent6Score(score);
                    userContentScoreRepository.save(user);
                }
            }
            default -> throw new IllegalArgumentException("Invalid content number: " + contentNumber);
        }

    }

    // 유저 ID와 날짜로 해당 유저의 컨텐츠 횟수 행을 찾는 메서드
    private UserContentCountStats getContentStats(String userId, String dateString) {
        LocalDate date = LocalDate.parse(dateString);
        UserContentCountStats contentStats = contentStatsRepository.findByUserIdAndDate(userId, date);

        if (contentStats == null) {
            // 해당 날짜에 해당 유저의 컨텐츠 횟수 행이 없는 경우 새로 생성합니다.

            contentStats = UserContentCountStats.builder()
                    .userId(userId)
                    .date(date)
                    .content1Count(0)
                    .content2Count(0)
                    .content3Count(0)
                    .content4Count(0)
                    .content5Count(0)
                    .content6Count(0)
                    .build();

        }
        return contentStats;
    }

    public UserContentCountStats getGraphDataByUserIdAndDate(String userId, LocalDate date) {

        return contentStatsRepository.findByUserIdAndDate(userId, date);
    }



    public List<ClusteringDataDTO> clusteringDataToSaveDTO() {
        List<ClusteringDataDTO> dataEntries = new ArrayList<>();

        // user_content_stats 테이블에서 데이터 가져오기
        List<UserContentCountStats> userContentCountStatsList = contentStatsRepository.findAll();

        for (UserContentCountStats userContentCountStats : userContentCountStatsList) {
            ClusteringDataDTO dto = new ClusteringDataDTO();
            dto.setUser_id(Long.parseLong((userContentCountStats.getUserId())));
            dto.setC1(userContentCountStats.getContent1Count());
            dto.setC2(userContentCountStats.getContent2Count());
            dto.setC3(userContentCountStats.getContent3Count());
            dto.setC4(userContentCountStats.getContent4Count());
            dto.setC5(userContentCountStats.getContent5Count());
            dto.setC6(userContentCountStats.getContent6Count());

            // userinfo 테이블에서 User 정보 가져오기
            User user = userRepository.findByUid(Long.valueOf(String.valueOf(userContentCountStats.getUserId())))
                    .orElseThrow(() -> new IllegalArgumentException("User not found for id: " + userContentCountStats.getUserId()));

            dto.setHeight(user.getHeight());
            dto.setWeight(user.getWeight());
            dto.setAge(user.getBirthToAge());
            dto.setGender(user.getGender());
            dto.setFitness_level(4);
            dto.setDisease(user.getDisease());

            dataEntries.add(dto);
        }

        return dataEntries;
    }
}
