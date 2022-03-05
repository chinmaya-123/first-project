package com.project.shoppingcart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne()
	@JoinColumn(name="id",insertable=false,updatable=false)
	private Category categoryId;
	
	@Column(name="qty")
	private int qty;
	
	@NotBlank
	@NotNull
	@Column(name="price")
	private double price;
	
	@Column(name="discount")
	private int discount;
	
	@Column(name="created_at")
	private String createdAt;
}
