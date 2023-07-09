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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projects.RecipeShare.dto.FeedbackDTO;
import com.projects.RecipeShare.services.FeedbackService;

@RestController
@RequestMapping(value = "/feedbacks")
public class FeedbackResource {

	@Autowired
	private FeedbackService service;
	
	@GetMapping
	public ResponseEntity<Page<FeedbackDTO>> findAll(Pageable pageable) {		
		Page<FeedbackDTO> list = service.findAllPaged(pageable);	
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FeedbackDTO> findById(@PathVariable Long id) {
		FeedbackDTO dto = service.findById(id);	
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<FeedbackDTO> insert (@RequestBody FeedbackDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);	
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<FeedbackDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
