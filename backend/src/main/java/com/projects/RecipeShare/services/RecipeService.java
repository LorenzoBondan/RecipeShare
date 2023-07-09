package com.projects.RecipeShare.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projects.RecipeShare.dto.CategoryDTO;
import com.projects.RecipeShare.dto.FeedbackDTO;
import com.projects.RecipeShare.dto.RecipeDTO;
import com.projects.RecipeShare.entities.Category;
import com.projects.RecipeShare.entities.Feedback;
import com.projects.RecipeShare.entities.Recipe;
import com.projects.RecipeShare.entities.User;
import com.projects.RecipeShare.repositories.CategoryRepository;
import com.projects.RecipeShare.repositories.FeedbackRepository;
import com.projects.RecipeShare.repositories.RecipeRepository;
import com.projects.RecipeShare.repositories.UserRepository;
import com.projects.RecipeShare.services.exceptions.DataBaseException;
import com.projects.RecipeShare.services.exceptions.ResourceNotFoundException;

@Service
public class RecipeService{

	@Autowired
	private RecipeRepository repository;
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public Page<RecipeDTO> findAllPaged(String name, Pageable pageable) {
		Page<RecipeDTO> list = repository.find(name, pageable);
		return list;
	}

	@Transactional(readOnly = true)
	public RecipeDTO findById(Long id) {
		Optional<Recipe> obj = repository.findById(id);
		Recipe entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found."));
		return new RecipeDTO(entity);
	}

	@Transactional
	public RecipeDTO insert(RecipeDTO dto) {
		Recipe entity = new Recipe();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new RecipeDTO(entity);
	}

	@Transactional
	public RecipeDTO update(Long id, RecipeDTO dto) {
		try {
			Recipe entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new RecipeDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
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

	private void copyDtoToEntity(RecipeDTO dto, Recipe entity) {
		entity.setName(dto.getName());
		entity.setIngredients(dto.getIngredients());
		entity.setPreparation(dto.getPreparation());
		entity.setTime(dto.getTime());
		entity.setImgUrl(dto.getImgUrl());

		for (FeedbackDTO fedDto : dto.getFeedbacks()) {
			Feedback feedback = feedbackRepository.getOne(fedDto.getId());
			entity.getFeedbacks().add(feedback);
		}
		
		for (CategoryDTO catDto : dto.getCategories()) {
			Category category = categoryRepository.getOne(catDto.getId());
			entity.getCategories().add(category);
		}
		
		for (Long userFavoritedId : dto.getUsersFavoritedId()) {
			User userFavorited = userRepository.getOne(userFavoritedId);
			entity.getUsersFavorited().add(userFavorited);
		}
	}

	@Transactional
	public RecipeDTO addRecipeAsFavorite(Long id) {
		try {
			Recipe entity = repository.getOne(id);
			User user = authService.authenticated();
			
			if(!entity.getUsersFavorited().contains(user)) {
				entity.getUsersFavorited().add(user);
				entity = repository.save(entity);
			}
			
			return new RecipeDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}
	
	@Transactional
	public RecipeDTO removeRecipeAsFavorite(Long id) {
		try {
			Recipe entity = repository.getOne(id);
			User user = authService.authenticated();
			
			if(entity.getUsersFavorited().contains(user)) {
				entity.getUsersFavorited().remove(user);
				entity = repository.save(entity);
			}
			
			return new RecipeDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}
	
	

}
