package com.example.smartdumbbell.Unity.Measure.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "measure")
public class Measure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto Increment
    private int mid;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private float grip_left;

    @Column(nullable = false)
    private float grip_right;

    @Column(nullable = false)
    private float count_left;

    @Column(nullable = false)
    private float count_right;

    @Column(nullable = false)
    private String id;


    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getGrip_left() {
        return grip_left;
    }

    public void setGrip_left(float grip_left) {
        this.grip_left = grip_left;
    }

    public float getGrip_right() {
        return grip_right;
    }

    public void setGrip_right(float grip_right) {
        this.grip_right = grip_right;
    }

    public float getCount_left() {
        return count_left;
    }

    public void setCount_left(float count_left) {
        this.count_left = count_left;
    }

    public float getCount_right() {
        return count_right;
    }

    public void setCount_right(float count_right) {
        this.count_right = count_right;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
