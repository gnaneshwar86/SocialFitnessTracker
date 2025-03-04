package com.gnaneshwar.SocialFitnessTracker.repository;

import com.gnaneshwar.SocialFitnessTracker.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query("SELECT a FROM Activity a")
    List<Activity> findAllActivities();

    List<Activity> findByDurationGreaterThan(double duration);

}
