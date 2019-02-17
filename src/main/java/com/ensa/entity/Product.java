package com.ensa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@Entity
@Data

public class Product {

	
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	private String name;
	
	@Column(unique=true)
	private long serie;
	
	private Double price;
	
	
	
	
	//Constructor
	public Product(Category category,String name, long serie, Double price) {
		super();
		this.category=category;
		this.name = name;
		this.serie = serie;
		this.price = price;
		
	}
	public Product() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSerie() {
		return serie;
	}
	public void setSerie(long serie) {
		this.serie = serie;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", serie=" + serie + ", price=" + price + "]";
	}
	
	
	
	
	
}
