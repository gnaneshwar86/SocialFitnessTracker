package com.gnaneshwar.SocialFitnessTracker.service;

import com.gnaneshwar.SocialFitnessTracker.model.Activity;
import com.gnaneshwar.SocialFitnessTracker.model.Challenge;
import com.gnaneshwar.SocialFitnessTracker.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {
    @Autowired
    ChallengeRepository challengeRepository;

    public List<Challenge> getAllChallenges(){
        return challengeRepository.findAll();
    }

    public Challenge createChallenge(Challenge u){
        return challengeRepository.save(u);
    }

    public Optional<Challenge> getChallengeById(Long id) {
        return challengeRepository.findById(id);
    }

    public Optional<Challenge> updateChallenge(Long id, Challenge u) {
        u.setId(id);
        return Optional.of(challengeRepository.save(u));
    }

    public boolean deleteChallenge(Long id) {
        if(challengeRepository.existsById(id)){
            challengeRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }

    public Page<Challenge> getChallengesByPage(Pageable pageable) {
        return challengeRepository.findAll(pageable);
    }

    public List<Challenge> createMultipleChallenges(List<Challenge> user){
        return challengeRepository.saveAll(user);
    }

    public List<Challenge> findActiveChallenges() {
        return challengeRepository.findActiveChallenges();
    }

    public List<Challenge> findByChallengeNameContaining(String challenge) {
        return challengeRepository.findByChallengeNameContaining(challenge);
    }
}
