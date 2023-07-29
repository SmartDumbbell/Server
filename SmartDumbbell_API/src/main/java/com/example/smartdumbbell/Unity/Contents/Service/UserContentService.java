package com.example.smartdumbbell.Unity.Contents.Service;

import com.example.smartdumbbell.Unity.Auth.Entity.User;
import com.example.smartdumbbell.Unity.Auth.Repository.UserRepository;
import com.example.smartdumbbell.Unity.Contents.DTO.UserContentStatsDTO;
import com.example.smartdumbbell.Unity.Contents.Entity.UserContentStats;
import com.example.smartdumbbell.Unity.Contents.Repository.UserContentStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserContentService {

    private final UserContentStatsRepository userContentStatsRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserContentService(UserContentStatsRepository userContentStatsRepository, UserRepository userRepository) {
        this.userContentStatsRepository = userContentStatsRepository;
        this.userRepository = userRepository;
    }

    public void updateContentCount(UserContentStatsDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with the given userId."));

        UserContentStats userContentStats = UserContentStats.builder()
                .user(user)
                .date(dto.getDate())
                .content1Count(dto.getContent1Count())
                .content2Count(dto.getContent2Count())
                .content3Count(dto.getContent3Count())
                .content4Count(dto.getContent4Count())
                .content5Count(dto.getContent5Count())
                .content6Count(dto.getContent6Count())
                .build();

        userContentStatsRepository.save(userContentStats);
    }
}

