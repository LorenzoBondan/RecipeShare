package com.projects.RecipeShare.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projects.RecipeShare.dto.RecipeDTO;
import com.projects.RecipeShare.entities.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long>{

	@Query("SELECT DISTINCT obj FROM RecipeDTO obj "
			+ "WHERE (UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%')) ) ORDER BY obj.pontuationAverage")
	Page<RecipeDTO> find(String name, Pageable pageable);
}
