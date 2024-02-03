package com.ecommerce.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="product_id", nullable = false)
	private Product product;
	
	@Column(name = "rating")
	private Double rating;
	
	private LocalDateTime creatAt;
	
	
	public Rating() {
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Double getRating() {
		return rating;
	}


	public void setRating(Double rating) {
		this.rating = rating;
	}


	public LocalDateTime getCreatAt() {
		return creatAt;
	}


	public void setCreatAt(LocalDateTime creatAt) {
		this.creatAt = creatAt;
	}


	public Rating(long id, User user, Product product, Double rating, LocalDateTime creatAt) {
		super();
		this.id = id;
		this.user = user;
		this.product = product;
		this.rating = rating;
		this.creatAt = creatAt;
	}
	
	
	

}













