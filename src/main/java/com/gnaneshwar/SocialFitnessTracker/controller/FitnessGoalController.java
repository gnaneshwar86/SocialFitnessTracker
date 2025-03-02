package com.gnaneshwar.SocialFitnessTracker.controller;

import com.gnaneshwar.SocialFitnessTracker.model.FitnessGoal;
import com.gnaneshwar.SocialFitnessTracker.service.FitnessGoalService;
import jakarta.validation.Valid;
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
public class FitnessGoalController {
    @Autowired
    FitnessGoalService fitnessGoalService;

    @GetMapping("/goals")
    public ResponseEntity<?> getAllFitnessGoals(){
        return new ResponseEntity<>(fitnessGoalService.getAllFitnessGoals(), HttpStatus.OK);
    }

    @GetMapping("/goals/{id}")
    public ResponseEntity<?> getFitnessGoalById(@PathVariable Long id){
        Optional<FitnessGoal> user = fitnessGoalService.getFitnessGoalById(id);
        if(user.isPresent())
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/goals")
    public ResponseEntity<?> createFitnessGoal(@Valid @RequestBody FitnessGoal u){
        return new ResponseEntity<>(fitnessGoalService.createFitnessGoal(u),HttpStatus.CREATED);
    }

    @PostMapping("/goals/multi")
    public ResponseEntity<?> createMultipleFitnessGoals(@Valid @RequestBody List<FitnessGoal> user){
        return new ResponseEntity<>(fitnessGoalService.createMultipleFitnessGoals(user),HttpStatus.CREATED);
    }

    @PutMapping("/goals")
    public ResponseEntity<?> updateFitnessGoal(@RequestParam Long id, @Valid @RequestBody FitnessGoal u){
        Optional<FitnessGoal> user = fitnessGoalService.getFitnessGoalById(id);
        if(user.isPresent())
            return new ResponseEntity<>(fitnessGoalService.updateFitnessGoal(id, u),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/goals")
    public ResponseEntity<?> deleteFitnessGoal(@RequestParam Long id){
        if(fitnessGoalService.deleteFitnessGoal(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/goals/paginate")
    public ResponseEntity<?> getFitnessGoalsByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean sortOrder
    ){
        Sort sort = sortOrder ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return new ResponseEntity<>(fitnessGoalService.getFitnessGoalsByPage(pageable),HttpStatus.OK);
    }

}
