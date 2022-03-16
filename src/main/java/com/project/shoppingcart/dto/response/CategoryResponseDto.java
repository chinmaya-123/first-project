package com.project.shoppingcart.dto.response;

import com.project.shoppingcart.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class CategoryResponseDto {
    private String name;
    private String description;
    private List<Product> products;
}
