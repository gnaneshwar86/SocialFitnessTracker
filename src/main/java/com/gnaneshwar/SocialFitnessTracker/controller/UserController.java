package com.gnaneshwar.SocialFitnessTracker.controller;

import java.util.List;
import java.util.Optional;

import com.gnaneshwar.SocialFitnessTracker.model.User;
import com.gnaneshwar.SocialFitnessTracker.service.UserService;
import jakarta.validation.Valid;
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
public class UserController {
    @Autowired
    UserService userService;
     
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent())
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody User u){
        return new ResponseEntity<>(userService.createUser(u),HttpStatus.CREATED);
    }

    @PostMapping("/users/multi")
    public ResponseEntity<?> createMultipleClasses(@Valid @RequestBody List<User> user){
        return new ResponseEntity<>(userService.createMultipleUsers(user),HttpStatus.CREATED);
    }
    
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @Valid @RequestBody User u){
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent())
            return new ResponseEntity<>(userService.updateUser(id, u),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        if(userService.deleteUser(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/users/paginate")
    public ResponseEntity<?> getUsersByPage(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "true") boolean sortOrder
    ){
        Sort sort = sortOrder ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return new ResponseEntity<>(userService.getUsersByPage(pageable),HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<User> findNameStartingWith(@RequestParam String name){
        return userService.findNameStartingWith(name);
    }

    @GetMapping("/findByPhone")
    public List<User> findByphoneNumber(@RequestParam String phone){
        return userService.findNyphoneNumber(phone);
    }
    
}
