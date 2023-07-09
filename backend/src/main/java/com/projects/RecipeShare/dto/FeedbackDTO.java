package com.projects.RecipeShare.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.projects.RecipeShare.entities.Feedback;

public class FeedbackDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String comment;
	private Integer pontuation;
	private Instant moment;
	private UserDTO user;
	private Long recipeId;
	
	public FeedbackDTO() {}

	public FeedbackDTO(Feedback entity) {
		this.id = entity.getId();
		this.comment = entity.getComment();
		this.pontuation = entity.getPontuation();
		this.moment = entity.getMoment();
		this.user = new UserDTO(entity.getUser());
		this.recipeId = entity.getRecipe().getId();
	}
	
	public FeedbackDTO(Long id, String comment, Integer pontuation, Instant moment, UserDTO user, Long recipeId) {
		super();
		this.id = id;
		this.comment = comment;
		this.pontuation = pontuation;
		this.moment = moment;
		this.user = user;
		this.recipeId = recipeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getPontuation() {
		return pontuation;
	}

	public void setPontuation(Integer pontuation) {
		this.pontuation = pontuation;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeedbackDTO other = (FeedbackDTO) obj;
		return Objects.equals(id, other.id);
	}
}
