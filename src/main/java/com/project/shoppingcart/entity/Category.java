package com.project.shoppingcart.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;


@Entity
@Table(name = "category")
@Data
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "created_at", updatable = false)
	@CreationTimestamp
	private OffsetDateTime createdAt;

	@Column(name = "updated_at", insertable = false)
	@UpdateTimestamp
	private OffsetDateTime updatedAt;
}
