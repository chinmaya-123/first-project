package com.project.shoppingcart.controller;

import java.util.List;

import javax.validation.Valid;

import com.project.shoppingcart.common.ApiResponse;
import com.project.shoppingcart.dto.response.CategoryResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.shoppingcart.dto.request.CategoryRequestDto;
import com.project.shoppingcart.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @PostMapping("/create")
    public ApiResponse createCategory(@Valid @RequestBody CategoryRequestDto categoryDto) {
        categoryService.create(categoryDto);
        return new ApiResponse(true, "category created successfully");
    }

    @GetMapping(value = "/get")
    public List<CategoryResponseDto> listCategory() {
        return categoryService.listCategory();
    }

    @GetMapping("/{id}")
    public CategoryResponseDto CategoryById(@PathVariable int id) {
        return categoryService.CategoryById(id);
    }

    @DeleteMapping("/{name}")
    public ApiResponse delete(@PathVariable String name) {
        categoryService.delete(name);
        return new ApiResponse(true
                , name + " category deleted successfully");
    }

    @PutMapping("/{id}")
    public ApiResponse update(@RequestBody CategoryRequestDto category, @PathVariable int id) {
        categoryService.updateCategory(id, category);
        return new ApiResponse(true,
                category.getName() + " category updated successfully");
    }

}

