package com.projects.RecipeShare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.RecipeShare.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{

}
