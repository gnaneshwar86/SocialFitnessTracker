package com.gnaneshwar.SocialFitnessTracker.controller;

import com.gnaneshwar.SocialFitnessTracker.model.Activity;
import com.gnaneshwar.SocialFitnessTracker.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ActivityController {
    @Autowired
    ActivityService activityService;

    @GetMapping("/activities")
    public ResponseEntity<?> getAllActivities(){
        return new ResponseEntity<>(activityService.getAllActivities(), HttpStatus.OK);
    }

    @GetMapping("/activities/{id}")
    public ResponseEntity<?> getActivityById(@PathVariable Long id){
        Optional<Activity> user = activityService.getActivityById(id);
        if(user.isPresent())
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/activities")
    public ResponseEntity<?> createActivity(@RequestBody Activity u){
        return new ResponseEntity<>(activityService.createActivity(u),HttpStatus.CREATED);
    }

    @PostMapping("/activities/multi")
    public ResponseEntity<?> createMultipleActivities(@RequestBody List<Activity> user){
        return new ResponseEntity<>(activityService.createMultipleActivities(user),HttpStatus.CREATED);
    }

    @PutMapping("/activities")
    public ResponseEntity<?> updateActivity(@RequestParam Long id, @RequestBody Activity u){
        Optional<Activity> user = activityService.getActivityById(id);
        if(user.isPresent())
            return new ResponseEntity<>(activityService.updateActivity(id, u),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/activities")
    public ResponseEntity<?> deleteActivity(@RequestParam Long id){
        if(activityService.deleteActivity(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/activities/paginate")
    public ResponseEntity<?> getActivitiesByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean sortOrder
    ){
        Sort sort = sortOrder ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return new ResponseEntity<>(activityService.getActivitiesByPage(pageable),HttpStatus.OK);
    }
}
