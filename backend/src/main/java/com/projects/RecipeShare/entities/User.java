package com.projects.RecipeShare.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "tb_user")
public class User implements UserDetails, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	@Column(columnDefinition = "TEXT")
	private String imgUrl;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_user_role",
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private Set<Role> roles = new HashSet<>();
	
	@OneToMany(mappedBy = "user")
	private List<Feedback> feedbacks = new ArrayList<>();
	
	@OneToMany(mappedBy = "author")
	private List<Recipe> recipes = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "usersFavorited")
	private Set<Recipe> favorites = new HashSet<>();
	
	public User() {
	}
	
	public User(Long id, String name, String email, String password, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.imgUrl = imgUrl;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public Set<Recipe> getFavorites() {
		return favorites;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	/// ---------- METODOS GERADOS PELO IMPLEMENTS USERDETAILS
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// PERCORRER CADA ELEMENTO DA LISTA DE ROLES E CONVERTER ELE PARA GRANTEDAUTHOTIRY
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getAuthority()))
				.collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return email;
	}
	

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	// MÉTODO USADO PARA O SERVICE AUTHSERVICE, PARA SABER SE O USUÁRIO LOGADO É ADMIN
	public boolean hasRole(String roleName) {
		for (Role role : roles) {
			if(role.getAuthority().equals(roleName)) {
				return true; // ENCONTROU O QUE ESTAVA PROCURANDO
			}
		}
		return false;
	}
}
