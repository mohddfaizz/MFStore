package com.mfstore.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Jewellery {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String metalType;
	private String metalColor;
	private String gender;
	private String productCategory;
	private int weight;
	private double price;
	private boolean active=true;
	
	@Column(columnDefinition="text")
	private String description;
	private int inStockNumber;
	
	@Transient
	private MultipartFile jewelleryImage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMetalType() {
		return metalType;
	}

	public void setMetalType(String metalType) {
		this.metalType = metalType;
	}

	public String getMetalColor() {
		return metalColor;
	}

	public void setMetalColor(String metalColor) {
		this.metalColor = metalColor;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
    
	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getInStockNumber() {
		return inStockNumber;
	}

	public void setInStockNumber(int inStockNumber) {
		this.inStockNumber = inStockNumber;
	}

	public MultipartFile getJewelleryImage() {
		return jewelleryImage;
	}

	public void setJewelleryImage(MultipartFile jewelleryImage) {
		this.jewelleryImage = jewelleryImage;
	}


}
