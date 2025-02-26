package com.gnaneshwar.SocialFitnessTracker.repository;

import com.gnaneshwar.SocialFitnessTracker.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
