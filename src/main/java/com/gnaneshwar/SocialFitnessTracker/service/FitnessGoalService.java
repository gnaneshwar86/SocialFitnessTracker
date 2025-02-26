package com.gnaneshwar.SocialFitnessTracker.service;

import com.gnaneshwar.SocialFitnessTracker.model.FitnessGoal;
import com.gnaneshwar.SocialFitnessTracker.repository.FitnessGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FitnessGoalService {

    @Autowired
    FitnessGoalRepository fitnessGoalRepository;

    public List<FitnessGoal> getAllFitnessGoals(){
        return fitnessGoalRepository.findAll();
    }

    public FitnessGoal createFitnessGoal(FitnessGoal u){
        return fitnessGoalRepository.save(u);
    }

    public Optional<FitnessGoal> getFitnessGoalById(Long id) {
        return fitnessGoalRepository.findById(id);
    }

    public Optional<FitnessGoal> updateFitnessGoal(Long id, FitnessGoal u) {
        u.setId(id);
        return Optional.of(fitnessGoalRepository.save(u));
    }

    public boolean deleteFitnessGoal(Long id) {
        if(fitnessGoalRepository.existsById(id)){
            fitnessGoalRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }

    public Page<FitnessGoal> getFitnessGoalsByPage(Pageable pageable) {
        return fitnessGoalRepository.findAll(pageable);
    }

    public List<FitnessGoal> createMultipleFitnessGoals(List<FitnessGoal> fitnessGoal){
        return fitnessGoalRepository.saveAll(fitnessGoal);
    }
}
