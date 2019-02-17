package com.ensa.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
import lombok.ToString;

@Entity
@Data

public class Category {

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="category")
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Product> products;
	
	
	
	
	
	
	
	
	
	
	public Category(String name, List<Product> products) {
		super();
		this.name = name;
		this.products = products;
	}
	public Category() {
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
	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", products=" + products.toString()+ "]";
	}
	
	
	
	
	
}
