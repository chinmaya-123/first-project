package com.project.shoppingcart.dto.request;

import lombok.Data;

@Data
public class ProductDto {

	private String name;
	private String description;
	private int categoryId;
	private int qty;	
	private double price;
	private int discount;
	private String createdAt;
	
	
		
}
