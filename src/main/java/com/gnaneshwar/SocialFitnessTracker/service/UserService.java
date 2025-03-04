package com.gnaneshwar.SocialFitnessTracker.service;

import java.util.List;
import java.util.Optional;

import com.gnaneshwar.SocialFitnessTracker.model.User;
import com.gnaneshwar.SocialFitnessTracker.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(@Valid User u){
        return userRepository.save(u);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> updateUser(Long id, User u) {
        u.setId(id);
        return Optional.of(userRepository.save(u));
    }

    public boolean deleteUser(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        else    
            return false;
    }

    public List<User> findNameStartingWith(String name) {
        return userRepository.findNameStartingWith(name);
    }

    public Page<User> getUsersByPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public List<User> createMultipleUsers(List<User> user){
        return userRepository.saveAll(user);
    }

    public List<User> findNyphoneNumber(String phone) {
        return userRepository.findByphoneNumber(phone);
    }
}
