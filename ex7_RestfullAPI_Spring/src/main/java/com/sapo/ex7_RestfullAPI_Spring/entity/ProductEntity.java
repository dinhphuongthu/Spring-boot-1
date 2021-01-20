package com.sapo.ex7_RestfullAPI_Spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="product")

public class ProductEntity extends BaseEntity {
    @Column(name="product_code")
	private String productCode;
	
//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name="category_id")
//    private CategoryEntity category;
    
//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name="inventory_id")
//    private InventoryEntity inventory;
    
    @Column(name="product_name")
    private String productName;
    
    @Column(name="description")
    private String description;
    
    @Column(name="image")
    private String urlImage;
    
    @Column(name="product_number")
    private int productNumber;
    
    @Column(name="sell_number")
    private int sellNumber;
    
    @Column(name="category_id")
    private int categoryId;
    
    @Column(name="inventory_id")
    private int inventoryId;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}
	public int getSellNumber() {
		return sellNumber;
	}
	public void setSellNumber(int sellNumber) {
		this.sellNumber = sellNumber;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}	
}
