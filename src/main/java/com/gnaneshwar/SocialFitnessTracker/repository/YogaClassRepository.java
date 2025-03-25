package com.gnaneshwar.SocialFitnessTracker.repository;

import com.gnaneshwar.SocialFitnessTracker.model.YogaClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YogaClassRepository extends JpaRepository<YogaClass,Long>{

    @Query("SELECT y FROM YogaClass y WHERE y.name LIKE :name%")
    List<YogaClass> findByNameStartingWith(@Param("name") String name);

    List<YogaClass> findByDescriptionContaining(String keyword);
}

