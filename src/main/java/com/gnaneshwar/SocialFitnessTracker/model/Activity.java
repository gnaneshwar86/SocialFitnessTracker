package com.gnaneshwar.SocialFitnessTracker.model;

import com.gnaneshwar.SocialFitnessTracker.enums.ActivityType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

    @Id
    private Long id;
    private ActivityType activityType;
    private double duration;
    private double caloriesBurnt;
    private LocalDateTime timeStamp;
}

