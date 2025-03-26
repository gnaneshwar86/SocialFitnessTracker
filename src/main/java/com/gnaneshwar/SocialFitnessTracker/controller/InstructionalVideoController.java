package com.gnaneshwar.SocialFitnessTracker.controller;

import java.util.List;
import java.util.Optional;

import com.gnaneshwar.SocialFitnessTracker.model.InstructionalVideo;
import com.gnaneshwar.SocialFitnessTracker.service.InstructionalVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class InstructionalVideoController {
    @Autowired
    InstructionalVideoService instructionalVideoService;

    @GetMapping("/videos")
    public ResponseEntity<?> getAllInstructionalVideos(){
        return new ResponseEntity<>(instructionalVideoService.getAllInstructionalVideos(),HttpStatus.OK);
    }

    @GetMapping("/videos/{id}")
    public ResponseEntity<?> getInstructionalVideoById(@PathVariable Long id){
        Optional<InstructionalVideo> instructionalVideo = instructionalVideoService.getInstructionalVideoById(id);
        if(instructionalVideo.isPresent())
            return new ResponseEntity<>(instructionalVideo.get(),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/videos")
    public ResponseEntity<?> createInstructionalVideo(@RequestBody InstructionalVideo u){
        return new ResponseEntity<>(instructionalVideoService.createInstructionalVideo(u),HttpStatus.CREATED);
    }

    @PostMapping("/videos/multi")
    public ResponseEntity<?> createMultipleVideos(@RequestBody List<InstructionalVideo> video){
        return new ResponseEntity<>(instructionalVideoService.createMultipleVideos(video),HttpStatus.CREATED);
    }

    @PutMapping("/videos")
    public ResponseEntity<?> updateInstructionalVideo(@RequestParam Long id, @RequestBody InstructionalVideo u){
        Optional<InstructionalVideo> instructionalVideo = instructionalVideoService.getInstructionalVideoById(id);
        if(instructionalVideo.isPresent())
            return new ResponseEntity<>(instructionalVideoService.updateInstructionalVideo(id, u),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/videos")
    public ResponseEntity<?> deleteInstructionalVideo(@RequestParam Long id){
        if(instructionalVideoService.deleteInstructionalVideo(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/videos/paginate")
    public ResponseEntity<?> getInstructionalVideosByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean sortOrder
    ){
        Sort sort = sortOrder ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return new ResponseEntity<>(instructionalVideoService.getInstructionalVideosByPage(pageable),HttpStatus.OK);
    }
}

