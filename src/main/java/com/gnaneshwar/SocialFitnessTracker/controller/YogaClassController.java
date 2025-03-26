package com.gnaneshwar.SocialFitnessTracker.controller;

import java.util.List;
import java.util.Optional;

import com.gnaneshwar.SocialFitnessTracker.model.YogaClass;
import com.gnaneshwar.SocialFitnessTracker.service.YogaClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
public class YogaClassController {
    @Autowired
    YogaClassService yogaClassService;

    @GetMapping("/classes")
    public ResponseEntity<?> getAllYogaClasses(){
        return new ResponseEntity<>(yogaClassService.getAllYogaClasses(),HttpStatus.OK);
    }

    @GetMapping("/classes/{id}")
    public ResponseEntity<?> getYogaClassById(@PathVariable Long id){
        Optional<YogaClass> yogaClass = yogaClassService.getYogaClassById(id);
        if(yogaClass.isPresent())
            return new ResponseEntity<>(yogaClass.get(),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/classes/{userid}")
    public ResponseEntity<?> createYogaClass(@PathVariable Long userid,@RequestBody YogaClass yogaClass){
        return yogaClassService.createYogaClass(userid,yogaClass);
    }

    @PostMapping("/classes/multi")
    public ResponseEntity<?> createMultipleClasses(@RequestBody List<YogaClass> yogaClass){
        return new ResponseEntity<>(yogaClassService.createMultipleClasses(yogaClass),HttpStatus.CREATED);
    }

    @PutMapping("/classes")
    public ResponseEntity<?> updateYogaClass(@RequestParam Long id, @RequestBody YogaClass u){
        Optional<YogaClass> yogaClass = yogaClassService.getYogaClassById(id);
        if(yogaClass.isPresent())
            return new ResponseEntity<>(yogaClassService.updateYogaClass(id, u),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/classes")
    public ResponseEntity<?> deleteYogaClass(@RequestParam Long id){
        if(yogaClassService.deleteYogaClass(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/classes/paginate")
    public ResponseEntity<?> getYogaClassesByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean sortOrder
    ){
        Sort sort = sortOrder ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return new ResponseEntity<>(yogaClassService.getYogaClasssByPage(pageable),HttpStatus.OK);
    }
}
