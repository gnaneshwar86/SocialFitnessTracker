package com.gnaneshwar.SocialFitnessTracker.repository;

import com.gnaneshwar.SocialFitnessTracker.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    @Query("SELECT c FROM Challenge c WHERE c.endDate >= CURRENT_DATE")
    List<Challenge> findActiveChallenges();

    List<Challenge> findByChallengeNameContaining(String challenge);


}
