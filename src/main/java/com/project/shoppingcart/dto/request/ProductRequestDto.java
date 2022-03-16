package com.project.shoppingcart.dto.request;

import com.project.shoppingcart.entity.Category;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductRequestDto {
	@NotBlank
	private String name;
	@NotBlank
	private String description;
	@NotNull
	private int qty;
	@NotNull
	private double price;
	private double discount;

	
	
		
}
