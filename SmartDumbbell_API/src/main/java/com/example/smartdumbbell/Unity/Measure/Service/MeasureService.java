package com.example.smartdumbbell.Unity.Measure.Service;

import com.example.smartdumbbell.Unity.Measure.DTO.CountDTO;
import com.example.smartdumbbell.Unity.Measure.DTO.GripDTO;
import com.example.smartdumbbell.Unity.Measure.Entity.Measure;
import com.example.smartdumbbell.Unity.Measure.Repository.MeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasureService {

    @Autowired
    public MeasureRepository measureRepository;

    public MeasureService(MeasureRepository measureRepository){
        this.measureRepository = measureRepository;
    }

    public void SaveGripData(GripDTO gripDTO){
        Measure measure = Measure.builder()
                .date(gripDTO.getDate())
                .grip_right(gripDTO.getGrip_right())
                .grip_left(gripDTO.getGrip_left())
                .id(gripDTO.getId())
                .build();

        measureRepository.save(measure);
    }

    public void SaveCountData(CountDTO countDTO){
        Measure measure = Measure.builder()
                .date(countDTO.getDate())
                .count_left(countDTO.getCount_left())
                .count_right(countDTO.getCount_right())
                .id(countDTO.getId())
                .build();

        measureRepository.save(measure);
    }

    //로그인 시 악력과 횟수 데이터를 저장할 행을 생성.
    public void CreateDataRow(GripDTO gripDTO){
        Measure measure = Measure.builder()
                .id(gripDTO.getId())
                .date(gripDTO.getDate())
                .build();

        measureRepository.save(measure);
    }
}
