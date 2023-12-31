package com.projects.RecipeShare.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projects.RecipeShare.dto.CategoryDTO;
import com.projects.RecipeShare.entities.Category;
import com.projects.RecipeShare.entities.Recipe;
import com.projects.RecipeShare.repositories.CategoryRepository;
import com.projects.RecipeShare.repositories.RecipeRepository;
import com.projects.RecipeShare.services.exceptions.DataBaseException;
import com.projects.RecipeShare.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService{

	@Autowired
	private CategoryRepository repository;
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Transactional(readOnly = true)
	public Page<CategoryDTO> findAllPaged(Pageable pageable) {
		Page<Category> list = repository.findAll(pageable);
		return list.map(x -> new CategoryDTO(x));
	}

	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found."));
		return new CategoryDTO(entity);
	}

	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		Category entity = new Category();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new CategoryDTO(entity);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}

		catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity Violation");
		}
	}

	private void copyDtoToEntity(CategoryDTO dto, Category entity) {
		entity.setName(dto.getName());

		for (Long recipeId : dto.getRecipesId()) {
			Recipe recipe = recipeRepository.getOne(recipeId);
			entity.getRecipes().add(recipe);
		}
	}
}
