package com.gnaneshwar.SocialFitnessTracker.service;

import java.util.List;
import java.util.Optional;

import com.gnaneshwar.SocialFitnessTracker.model.InstructionalVideo;
import com.gnaneshwar.SocialFitnessTracker.repository.InstructionalVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InstructionalVideoService {
    @Autowired
    InstructionalVideoRepository instructionalVideoRepository;

    public List<InstructionalVideo> getAllInstructionalVideos(){
        return instructionalVideoRepository.findAll();
    }

    public InstructionalVideo createInstructionalVideo(InstructionalVideo u){
        return instructionalVideoRepository.save(u);
    }

    public Optional<InstructionalVideo> getInstructionalVideoById(Long id) {
        return instructionalVideoRepository.findById(id);
    }

    public Optional<InstructionalVideo> updateInstructionalVideo(Long id, InstructionalVideo u) {
        u.setId(id);
        return Optional.of(instructionalVideoRepository.save(u));
    }

    public boolean deleteInstructionalVideo(Long id) {
        if(instructionalVideoRepository.existsById(id)){
            instructionalVideoRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }

    public Page<InstructionalVideo> getInstructionalVideosByPage(Pageable pageable) {
        return instructionalVideoRepository.findAll(pageable);
    }

    public List<InstructionalVideo> createMultipleVideos(List<InstructionalVideo> video){
        return instructionalVideoRepository.saveAll(video);
    }
}
