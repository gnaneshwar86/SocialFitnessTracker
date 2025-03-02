package com.gnaneshwar.SocialFitnessTracker.controller;

import com.gnaneshwar.SocialFitnessTracker.model.Challenge;
import com.gnaneshwar.SocialFitnessTracker.service.ChallengeService;
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
public class ChallengeController {
    @Autowired
    ChallengeService challengeService;

    @GetMapping("/challenges")
    public ResponseEntity<?> getAllChallenges(){
        return new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK);
    }

    @GetMapping("/challenges/{id}")
    public ResponseEntity<?> getChallengeById(@PathVariable Long id){
        Optional<Challenge> user = challengeService.getChallengeById(id);
        if(user.isPresent())
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/challenges")
    public ResponseEntity<?> createChallenge(@Valid @RequestBody Challenge u){
        return new ResponseEntity<>(challengeService.createChallenge(u),HttpStatus.CREATED);
    }

    @PostMapping("/challenges/multi")
    public ResponseEntity<?> createMultipleChallenges(@Valid @RequestBody List<Challenge> user){
        return new ResponseEntity<>(challengeService.createMultipleChallenges(user),HttpStatus.CREATED);
    }

    @PutMapping("/challenges")
    public ResponseEntity<?> updateChallenge(@RequestParam Long id, @Valid @RequestBody Challenge u){
        Optional<Challenge> user = challengeService.getChallengeById(id);
        if(user.isPresent())
            return new ResponseEntity<>(challengeService.updateChallenge(id, u),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/challenges")
    public ResponseEntity<?> deleteChallenge(@RequestParam Long id){
        if(challengeService.deleteChallenge(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/challenges/paginate")
    public ResponseEntity<?> getChallengesByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean sortOrder
    ){
        Sort sort = sortOrder ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return new ResponseEntity<>(challengeService.getChallengesByPage(pageable),HttpStatus.OK);
    }
}
