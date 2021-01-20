package com.sapo.ex7_RestfullAPI_Spring.converter;

import org.springframework.stereotype.Component;

import com.sapo.ex7_RestfullAPI_Spring.dto.ProductDTO;
import com.sapo.ex7_RestfullAPI_Spring.entity.ProductEntity;
@Component
public class ProductConverter implements IConverter<ProductEntity, ProductDTO>{

	@Override
	public ProductEntity toEntity(ProductDTO dto) {
		 ProductEntity entity = new ProductEntity();
	        entity.setProductCode(dto.getProductCode());
	        entity.setProductName(dto.getProductName());
	        entity.setDescription(dto.getDescription());
	        entity.setUrlImage(dto.getUrlImage());
	        entity.setProductNumber(dto.getProductNumber());
	        entity.setSellNumber(dto.getSellNumber());
	        entity.setCreatedDate(dto.getCreatedDate());
	        entity.setModifiedDate(dto.getModifiedDate());
	        entity.setCategoryId(dto.getCategory());
	        entity.setInventoryId(dto.getInventory());
	        return entity;
	}

	@Override
	public ProductDTO toDTO(ProductEntity entity) {
		ProductDTO dto = new ProductDTO();
        if (entity.getId() > 0) {
            dto.setId(entity.getId());
        }
        dto.setProductCode(entity.getProductCode());
        dto.setProductName(entity.getProductName());;
        dto.setCategory(entity.getCategoryId());
        dto.setInventory(entity.getInventoryId());
        dto.setDescription(entity.getDescription());
        dto.setUrlImage(entity.getUrlImage());    
        dto.setProductNumber(entity.getProductNumber());
        dto.setSellNumber(entity.getSellNumber());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedDate(entity.getModifiedDate());
        return dto;
	}

	@Override
	public ProductEntity toEntity(ProductEntity entity, ProductDTO dto) {
		entity.setProductCode(dto.getProductCode());
        entity.setProductName(dto.getProductName());
        entity.setDescription(dto.getDescription());
        entity.setUrlImage(dto.getUrlImage());  
        entity.setProductNumber(dto.getProductNumber());
        entity.setSellNumber(dto.getSellNumber());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setModifiedDate(dto.getModifiedDate());
        entity.setCategoryId(dto.getCategory());
        entity.setInventoryId(dto.getInventory());
        return entity;
	}

}
