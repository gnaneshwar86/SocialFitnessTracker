package com.gnaneshwar.SocialFitnessTracker.repository;

import com.gnaneshwar.SocialFitnessTracker.model.InstructionalVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructionalVideoRepository extends JpaRepository<InstructionalVideo,Long>{

    @Query("SELECT v FROM InstructionalVideo v WHERE v.title LIKE :title%")
    List<InstructionalVideo> findByTitleStartingWith(@Param("title") String title);

    List<InstructionalVideo> findByUrlContaining(String keyword);
}
