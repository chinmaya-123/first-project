package com.project.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.shoppingcart.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public Category deleteByName(String name);
	public Category findByName(String name);
}
