package com.project.shoppingcart.service;

import com.project.shoppingcart.dto.request.CategoryRequestDto;
import com.project.shoppingcart.entity.Category;
import com.project.shoppingcart.modelmapper.CategoryMapper;
import com.project.shoppingcart.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    public void create(CategoryRequestDto categoryRequestDto) {
        Category category = categoryMapper.dtoToEntity(categoryRequestDto);
        if (categoryRepository.getByName(category.getName()) != null)
            throw new RuntimeException("category exist");

        categoryRepository.save(category);
    }

    public List<Category> listCategory() {
        return categoryRepository.findAll();
    }

    public Category CategoryById(int theId) {
        Optional<Category> result = categoryRepository.findById(theId);
        Category theCategory;
        if (result.isPresent())
            theCategory = result.get();
        else
            throw new RuntimeException("category Id not found....");
        return theCategory;
    }

    public void updateCategory(int id, CategoryRequestDto theCategory) {
        Category tempCategory = categoryRepository.getById(id);
        tempCategory.setName(theCategory.getName());
        tempCategory.setDescription(theCategory.getDescription());
        categoryRepository.save(tempCategory);
    }

    public void deleteByName(String name) {

        categoryRepository.deleteByName(name);
    }

    public Category getByName(String categoryName)
    {
        return categoryRepository.getByName(categoryName);
    }

}
