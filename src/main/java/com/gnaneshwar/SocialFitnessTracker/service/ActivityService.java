package com.gnaneshwar.SocialFitnessTracker.service;

import com.gnaneshwar.SocialFitnessTracker.model.Activity;
import com.gnaneshwar.SocialFitnessTracker.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;

    public List<Activity> getAllActivities(){
        return activityRepository.findAll();
    }

    public Activity createActivity(Activity u){
        return activityRepository.save(u);
    }

    public Optional<Activity> getActivityById(Long id) {
        return activityRepository.findById(id);
    }

    public Optional<Activity> updateActivity(Long id, Activity u) {
        u.setId(id);
        return Optional.of(activityRepository.save(u));
    }

    public boolean deleteActivity(Long id) {
        if(activityRepository.existsById(id)){
            activityRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }

    public Page<Activity> getActivitiesByPage(Pageable pageable) {
        return activityRepository.findAll(pageable);
    }

    public List<Activity> createMultipleActivities(List<Activity> user){
        return activityRepository.saveAll(user);
    }

    public List<Activity> findAllActivities() {
        return activityRepository.findAllActivities();
    }

    public List<Activity> findByDurationGreaterThan(double duration) {
        return activityRepository.findByDurationGreaterThan(duration);
    }
}
