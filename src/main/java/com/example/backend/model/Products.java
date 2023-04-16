package com.example.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "product")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id ")
	private long product_id ;

	@Column(name = "product_name")
	private String product_name;

	@Column(name = "price")
	private String price;

	@Column(name = "description")
	private String description;

	/*@Column(name = "image")
	private String image;*/

	@Column(name = "category_id")
	private int category_id;
	
}
