package com.gnaneshwar.SocialFitnessTracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FitnessGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private GoalType goalType;
    private double targetValue;
    private double currentValue;
    private LocalDate startDate;
    private LocalDate endDate;
}

enum GoalType{
    STEPS, CALORIES, DISTANCE, WORKOUTS
}
