package com.gnaneshwar.SocialFitnessTracker.repository;

import com.gnaneshwar.SocialFitnessTracker.enums.GoalType;
import com.gnaneshwar.SocialFitnessTracker.model.FitnessGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FitnessGoalRepository extends JpaRepository<FitnessGoal, Long> {

    @Query("SELECT f FROM FitnessGoal f WHERE f.endDate >= CURRENT_DATE")
    List<FitnessGoal> findActiveGoals();

    List<FitnessGoal> findByGoalType(GoalType goalType);

}
