package com.gnaneshwar.SocialFitnessTracker.repository;

import java.util.List;

import com.gnaneshwar.SocialFitnessTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query("SELECT s FROM User s WHERE s.username LIKE :name% ")
    List<User> findNameStartingWith(@Param("name") String name);
}
