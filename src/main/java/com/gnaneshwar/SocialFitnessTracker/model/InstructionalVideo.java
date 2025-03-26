package com.gnaneshwar.SocialFitnessTracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructionalVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("instructionalVideos")
    private User user;

    @ManyToOne
    @JoinColumn(name = "yoga_class_id")
    @JsonIgnoreProperties("instructionalVideos")
    private YogaClass yogaClass;
}