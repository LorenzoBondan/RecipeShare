package com.projects.RecipeShare.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projects.RecipeShare.entities.Category;
import com.projects.RecipeShare.entities.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long>{

	@Query("SELECT DISTINCT obj FROM Recipe obj "
	        + "INNER JOIN obj.categories cats "
	        + "WHERE (COALESCE(:categories) IS NULL OR cats IN :categories) "
	        + "AND (UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%')))")
	Page<Recipe> find(List<Category> categories, String name, Pageable pageable);
	
	@Query("SELECT obj FROM Recipe obj JOIN FETCH obj.categories WHERE obj IN :recipes") 
	List<Recipe> findRecipesWithCategories(List<Recipe> recipes);
}
