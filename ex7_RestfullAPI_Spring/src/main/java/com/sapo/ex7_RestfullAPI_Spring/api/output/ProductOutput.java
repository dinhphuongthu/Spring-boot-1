package com.sapo.ex7_RestfullAPI_Spring.api.output;

import com.sapo.ex7_RestfullAPI_Spring.dto.ProductDTO;
import com.sapo.ex7_RestfullAPI_Spring.entity.ProductEntity;

public class ProductOutput extends BaseOuput<ProductDTO> {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
