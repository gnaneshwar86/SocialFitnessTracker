package com.gnaneshwar.SocialFitnessTracker.service;

import java.util.List;
import java.util.Optional;

import com.gnaneshwar.SocialFitnessTracker.model.User;
import com.gnaneshwar.SocialFitnessTracker.model.YogaClass;
import com.gnaneshwar.SocialFitnessTracker.repository.UserRepository;
import com.gnaneshwar.SocialFitnessTracker.repository.YogaClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class YogaClassService {
    @Autowired
    YogaClassRepository yogaClassRepository;

    @Autowired
    UserRepository userRepository;

    public List<YogaClass> getAllYogaClasses(){
        return yogaClassRepository.findAll();
    }

    public ResponseEntity<?> createYogaClass(Long userid, YogaClass yogaClass){
        Optional<User> user = userRepository.findById(userid);
        if(user.isPresent()) {
            yogaClass.setUser(user.get());
            return ResponseEntity.ok(yogaClassRepository.save(yogaClass));
        }
        else
            return ResponseEntity.badRequest().body("User Not Found");

    }

    public Optional<YogaClass> getYogaClassById(Long id) {
        return yogaClassRepository.findById(id);
    }

    public Optional<YogaClass> updateYogaClass(Long id, YogaClass u) {
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

    public Page<YogaClass> getYogaClasssByPage(Pageable pageable) {
        return yogaClassRepository.findAll(pageable);
    }

    public List<YogaClass> createMultipleClasses(List<YogaClass> yogaClass){
        return yogaClassRepository.saveAll(yogaClass);
    }
}

