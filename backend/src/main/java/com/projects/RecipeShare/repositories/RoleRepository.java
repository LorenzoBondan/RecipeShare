package com.projects.RecipeShare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.RecipeShare.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

}
