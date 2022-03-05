package com.project.shoppingcart.modelmapper;

import com.project.shoppingcart.dto.request.CategoryRequestDto;
import com.project.shoppingcart.dto.response.CategoryResponseDto;
import com.project.shoppingcart.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    @Autowired
    ModelMapper mapper;

    public Category dtoToEntity(CategoryRequestDto categoryRequestDto) {
        Category category = mapper.map(categoryRequestDto, Category.class);
        return category;
    }

    public CategoryResponseDto entityToDto(Category category) {
        CategoryResponseDto theCategory = mapper.map(category, CategoryResponseDto.class);
        return theCategory;
    }

    public List<CategoryResponseDto> entityToDto(List<Category> theCategory) {
        List<CategoryResponseDto> tempCategory = new ArrayList<>();
        for (Category category : theCategory)
            tempCategory.add(mapper.map(category, CategoryResponseDto.class));
        return tempCategory;
    }
}
