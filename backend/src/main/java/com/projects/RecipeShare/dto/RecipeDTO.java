package com.projects.RecipeShare.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.projects.RecipeShare.entities.Recipe;

public class RecipeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String ingredients;
	private String preparation;
	private Integer time;
	private String imgUrl;
	private Double pontuationAverage;
	private Long authorId;

	private List<FeedbackDTO> feedbacks = new ArrayList<>();
	
	private List<CategoryDTO> categories = new ArrayList<>();
	
	private List<Long> usersFavoritedId = new ArrayList<>();
	
	public RecipeDTO() {}
	
	public RecipeDTO(Recipe entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.ingredients = entity.getIngredients();
		this.preparation = entity.getPreparation();
		this.time = entity.getTime();
		this.imgUrl = entity.getImgUrl();
		this.pontuationAverage = entity.getPontuationAverage();
		this.authorId = entity.getAuthor().getId();
		
		entity.getFeedbacks().forEach(feed -> this.feedbacks.add(new FeedbackDTO(feed)));
		entity.getCategories().forEach(cat -> this.categories.add(new CategoryDTO(cat)));
		entity.getUsersFavorited().forEach(user -> this.usersFavoritedId.add(user.getId()));
	}

	public RecipeDTO(Long id, String name, String ingredients, String preparation, Integer time, String imgUrl,
			Double pontuationAverage, Long authorId) {
		super();
		this.id = id;
		this.name = name;
		this.ingredients = ingredients;
		this.preparation = preparation;
		this.time = time;
		this.imgUrl = imgUrl;
		this.pontuationAverage = pontuationAverage;
		this.authorId = authorId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getPreparation() {
		return preparation;
	}

	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Double getPontuationAverage() {
		return pontuationAverage;
	}

	public void setPontuationAverage(Double pontuationAverage) {
		this.pontuationAverage = pontuationAverage;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public List<FeedbackDTO> getFeedbacks() {
		return feedbacks;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public List<Long> getUsersFavoritedId() {
		return usersFavoritedId;
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
		RecipeDTO other = (RecipeDTO) obj;
		return Objects.equals(id, other.id);
	}
}
