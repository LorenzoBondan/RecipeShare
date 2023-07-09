package com.projects.RecipeShare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.RecipeShare.entities.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long>{

}
