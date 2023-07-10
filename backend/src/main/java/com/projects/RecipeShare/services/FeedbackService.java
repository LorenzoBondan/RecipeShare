package com.projects.RecipeShare.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projects.RecipeShare.dto.FeedbackDTO;
import com.projects.RecipeShare.entities.Feedback;
import com.projects.RecipeShare.entities.User;
import com.projects.RecipeShare.repositories.FeedbackRepository;
import com.projects.RecipeShare.repositories.RecipeRepository;
import com.projects.RecipeShare.repositories.UserRepository;
import com.projects.RecipeShare.services.exceptions.DataBaseException;
import com.projects.RecipeShare.services.exceptions.ResourceNotFoundException;

@Service
public class FeedbackService{

	@Autowired
	private FeedbackRepository repository;
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public Page<FeedbackDTO> findAllPaged(Pageable pageable) {
		Page<Feedback> list = repository.findAll(pageable);
		return list.map(x -> new FeedbackDTO(x));
	}

	@Transactional(readOnly = true)
	public FeedbackDTO findById(Long id) {
		Optional<Feedback> obj = repository.findById(id);
		Feedback entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found."));
		return new FeedbackDTO(entity);
	}

	@Transactional
	public FeedbackDTO insert(FeedbackDTO dto) {
		Feedback entity = new Feedback();
		User user = authService.authenticated();
		
		// an user just can make one feedback for each recipe
		boolean found = false;
		for(Feedback feedback : user.getFeedbacks()) {
			if(feedback.getRecipe().getId() == dto.getRecipeId()) {
				found = true;
			}
		}
		if(!found) {
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new FeedbackDTO(entity);
		}
		else {
			throw new DataBaseException("The user have already done a feedback about this recipe");
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

	private void copyDtoToEntity(FeedbackDTO dto, Feedback entity) {
		entity.setComment(dto.getComment());
		entity.setPontuation(dto.getPontuation());
		entity.setMoment(dto.getMoment());
		entity.setRecipe(recipeRepository.getOne(dto.getRecipeId()));
		entity.setUser(userRepository.getOne(dto.getUser().getId()));
	}
}
