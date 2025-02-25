package com.gnaneshwar.SocialFitnessTracker.service;

import java.util.List;
import java.util.Optional;

import com.gnaneshwar.SocialFitnessTracker.model.FitnessGoal;
import com.gnaneshwar.SocialFitnessTracker.repository.YogaClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class YogaClassService {
    @Autowired
    YogaClassRepository yogaClassRepository;

    public List<FitnessGoal> getAllYogaClasses(){
        return yogaClassRepository.findAll();
    }

    public FitnessGoal createYogaClass(FitnessGoal u){
        return yogaClassRepository.save(u);
    }

    public Optional<FitnessGoal> getYogaClassById(Long id) {
        return yogaClassRepository.findById(id);
    }

    public Optional<FitnessGoal> updateYogaClass(Long id, FitnessGoal u) {
        u.setId(id);
        return Optional.of(yogaClassRepository.save(u));
    }

    public boolean deleteYogaClass(Long id) {
        if(yogaClassRepository.existsById(id)){
            yogaClassRepository.deleteById(id);
            return true;
        }
        else    
            return false;
    }

    public Page<FitnessGoal> getYogaClasssByPage(Pageable pageable) {
        return yogaClassRepository.findAll(pageable);
    }

    public List<FitnessGoal> createMultipleClasses(List<FitnessGoal> fitnessGoals){
        return yogaClassRepository.saveAll(fitnessGoals);
    }
}
