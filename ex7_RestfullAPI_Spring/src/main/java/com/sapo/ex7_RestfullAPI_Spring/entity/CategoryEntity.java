package com.sapo.ex7_RestfullAPI_Spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="category")
public class CategoryEntity extends BaseEntity{
    @Column(name="category_code")
	private String categoryCode;
	
    @Column(name="category_name")
    private String categoryName;
    
    @Column(name="description")
    private String description;
    
//    @OneToMany(mappedBy="category")
//    @JsonIgnore
    //private List<ProductEntity> products = new ArrayList<>();
     
	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	


}
