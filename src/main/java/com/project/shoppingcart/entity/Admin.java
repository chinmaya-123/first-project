package com.project.shoppingcart.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="admin")
@Data
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="user_name")
	private String userName;
	@Column(name="password")
	private String password;

}
