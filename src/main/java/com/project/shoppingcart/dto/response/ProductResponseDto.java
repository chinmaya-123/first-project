package com.project.shoppingcart.dto.response;

import lombok.Data;

@Data
public class ProductResponseDto {
    private String name;
    private String description;
    private int qty;
    private double price;
    private double discount;
}
