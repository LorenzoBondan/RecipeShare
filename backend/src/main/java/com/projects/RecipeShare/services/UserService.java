package com.projects.RecipeShare.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projects.RecipeShare.dto.RecipeDTO;
import com.projects.RecipeShare.dto.RoleDTO;
import com.projects.RecipeShare.dto.UserDTO;
import com.projects.RecipeShare.dto.UserInsertDTO;
import com.projects.RecipeShare.dto.UserUpdateDTO;
import com.projects.RecipeShare.entities.Feedback;
import com.projects.RecipeShare.entities.Recipe;
import com.projects.RecipeShare.entities.Role;
import com.projects.RecipeShare.entities.User;
import com.projects.RecipeShare.repositories.FeedbackRepository;
import com.projects.RecipeShare.repositories.RecipeRepository;
import com.projects.RecipeShare.repositories.RoleRepository;
import com.projects.RecipeShare.repositories.UserRepository;
import com.projects.RecipeShare.services.exceptions.DataBaseException;
import com.projects.RecipeShare.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService {

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class); 

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository repository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(String name, Pageable pageable) {
		Page<User> list = repository.find(name, pageable);
		return list.map(x -> new UserDTO(x));
	}

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found."));
		return new UserDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public UserDTO findByEmail(String email) {
		Optional<User> obj = Optional.ofNullable(repository.findByEmail(email));
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found."));
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO insert(UserInsertDTO dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);

		entity.setPassword(passwordEncoder.encode(dto.getPassword()));

		entity = repository.save(entity);
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO update(Long id, UserUpdateDTO dto) {
		try {
			User entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new UserDTO(entity);
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

	private void copyDtoToEntity(UserDTO dto, User entity) {

		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setImgUrl(dto.getImgUrl());

		for (RoleDTO rolDto : dto.getRoles()) {
			Role role = roleRepository.getOne(rolDto.getId());
			entity.getRoles().add(role);
		}
		
		for (RecipeDTO recipeDto : dto.getRecipes()) {
			Recipe recipe = recipeRepository.getOne(recipeDto.getId());
			entity.getRecipes().add(recipe);
		}
		
		for (Long favoriteId : dto.getFavoritesId()) {
			Recipe recipe = recipeRepository.getOne(favoriteId);
			entity.getFavorites().add(recipe);
		}
		
		for (Long feedbackId : dto.getFeedbacksId()) {
			Feedback feedback = feedbackRepository.getOne(feedbackId);
			entity.getFeedbacks().add(feedback);
		}

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);

		if (user == null) {
			logger.error("User not found: " + username);
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info("User found: " + username);
		return user;
	}
	
	

}
