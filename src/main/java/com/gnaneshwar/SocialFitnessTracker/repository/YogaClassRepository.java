package com.gnaneshwar.SocialFitnessTracker.repository;

import com.gnaneshwar.SocialFitnessTracker.model.FitnessGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YogaClassRepository extends JpaRepository<FitnessGoal,Long>{

}
