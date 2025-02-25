package com.gnaneshwar.SocialFitnessTracker.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Activity {

    @Id
    private Long id;
    private ActivityType activityType;
    private double duration;
    private double caloriesBurnt;
    private LocalDateTime timeStamp;
}

enum ActivityType{
    WALKING, RUNNING, CYCLING, SWIMMING
}
