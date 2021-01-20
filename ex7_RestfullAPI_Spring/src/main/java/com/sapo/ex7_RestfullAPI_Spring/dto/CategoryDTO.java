package com.sapo.ex7_RestfullAPI_Spring.dto;

public class CategoryDTO extends BaseDto{
   private String categoryCode;
   private String categoryName;
   private String description;
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
