package com.example.smartdumbbell.Unity.Measure.Repository;


import com.example.smartdumbbell.Unity.Measure.Entity.Measure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasureRepository extends JpaRepository<Measure, Long> {
}
