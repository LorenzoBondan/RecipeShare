package com.projects.RecipeShare.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projects.RecipeShare.dto.RecipeDTO;
import com.projects.RecipeShare.services.RecipeService;

@RestController
@RequestMapping(value = "/recipes")
public class RecipeResource {

	@Autowired
	private RecipeService service;
	
	@GetMapping
	public ResponseEntity<Page<RecipeDTO>> findAll(@RequestParam(value = "categoryId", defaultValue = "0") Long categoryId,
			@RequestParam(value = "name", defaultValue = "") String name,
			Pageable pageable) {		
		Page<RecipeDTO> list = service.findAllPaged(categoryId, name, pageable);	
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<RecipeDTO> findById(@PathVariable Long id) {
		RecipeDTO dto = service.findById(id);	
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<RecipeDTO> insert (@RequestBody RecipeDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);	
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<RecipeDTO> update(@PathVariable Long id, @RequestBody RecipeDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<RecipeDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/addFavorite/{id}")
	public ResponseEntity<RecipeDTO> addRecipeAsFavorite(@PathVariable Long id) {
		RecipeDTO recipe = service.addRecipeAsFavorite(id);
		return ResponseEntity.ok().body(recipe);
	}
	
	@PutMapping(value = "/removeFavorite/{id}")
	public ResponseEntity<RecipeDTO> removeRecipeAsFavorite(@PathVariable Long id) {
		RecipeDTO recipe = service.removeRecipeAsFavorite(id);
		return ResponseEntity.ok().body(recipe);
	}
}
