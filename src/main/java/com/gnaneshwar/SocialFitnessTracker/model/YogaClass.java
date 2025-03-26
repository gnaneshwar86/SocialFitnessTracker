package com.gnaneshwar.SocialFitnessTracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YogaClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("yogaClasses")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "yogaClass")
    @JsonIgnoreProperties("yogaClass")
    private List<InstructionalVideo> instructionalVideos;
}
