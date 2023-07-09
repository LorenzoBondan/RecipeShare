package com.projects.RecipeShare.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_recipe")
public class Recipe implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String ingredients;
	private String preparation;
	private Integer time;
	private String imgUrl;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private User author;
	
	@OneToMany(mappedBy = "recipe")
	private List<Feedback> feedbacks = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_recipe_category",
				joinColumns = @JoinColumn(name = "recipe_id"), 
				inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_recipe_favorited",
				joinColumns = @JoinColumn(name = "recipe_id"), 
				inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> usersFavorited = new HashSet<>();
	
	public Recipe() {}

	public Recipe(Long id, String name, String ingredients, String preparation, Integer time, String imgUrl,
			User author) {
		super();
		this.id = id;
		this.name = name;
		this.ingredients = ingredients;
		this.preparation = preparation;
		this.time = time;
		this.imgUrl = imgUrl;
		this.author = author;
	}
	
	public Double getPontuationAverage() {
		double avg = 0;
		for(Feedback feedback : feedbacks) {
			avg += feedback.getPontuation();
		}
		avg /= feedbacks.size();
		return Math.round(avg * 100.0) / 100.0;
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

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
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
		Recipe other = (Recipe) obj;
		return Objects.equals(id, other.id);
	}
}
