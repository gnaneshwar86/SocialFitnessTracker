package com.gnaneshwar.SocialFitnessTracker.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gnaneshwar.SocialFitnessTracker.enums.ActivityType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
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
    @Positive(message = "ID must be a positive number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Activity type is required")
    private ActivityType activityType;
    @Positive(message = "Duration must be a positive number")
    private double duration;
    @PositiveOrZero(message = "Calories burnt cannot be negative")
    private double caloriesBurnt;
    @NotNull(message = "Timestamp cannot be null")
    @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private LocalDateTime timeStamp;
}

