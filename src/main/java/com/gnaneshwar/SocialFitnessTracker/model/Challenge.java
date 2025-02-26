package com.gnaneshwar.SocialFitnessTracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Challenge {

    @Id
    private Long Id;
    private String challengeName;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private double targetValue;

}
