package com.sapo.ex7_RestfullAPI_Spring.api.output;

import com.sapo.ex7_RestfullAPI_Spring.dto.CategoryDTO;
import com.sapo.ex7_RestfullAPI_Spring.entity.CategoryEntity;

public class CategoryOutput extends BaseOuput<CategoryDTO> {
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}
