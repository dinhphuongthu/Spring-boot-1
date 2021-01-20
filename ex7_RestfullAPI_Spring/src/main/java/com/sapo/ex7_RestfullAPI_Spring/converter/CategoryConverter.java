package com.sapo.ex7_RestfullAPI_Spring.converter;

import org.springframework.stereotype.Component;

import com.sapo.ex7_RestfullAPI_Spring.dto.CategoryDTO;
import com.sapo.ex7_RestfullAPI_Spring.entity.CategoryEntity;
@Component
public class CategoryConverter implements IConverter<CategoryEntity,CategoryDTO>{

	@Override
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		entity.setCategoryCode(dto.getCategoryCode());
		entity.setCategoryName(dto.getCategoryName());
		entity.setDescription(dto.getDescription());
		entity.setCreatedDate(dto.getCreatedDate());
		entity.setModifiedDate(dto.getModifiedDate());
		return entity;
	}

	@Override
	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO dto = new CategoryDTO();
		if(entity.getId()>0) {
			dto.setId(entity.getId());
		}
		dto.setCategoryCode(entity.getCategoryCode());
		dto.setCategoryName(entity.getCategoryName());
		dto.setDescription(entity.getDescription());
		dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}

	@Override
	public CategoryEntity toEntity(CategoryEntity entity, CategoryDTO dto) {
		entity.setCategoryCode(dto.getCategoryCode());
		entity.setCategoryName(dto.getCategoryName());
		entity.setDescription(dto.getDescription());
		entity.setCreatedDate(dto.getCreatedDate());
		entity.setModifiedDate(dto.getModifiedDate());
		return entity;
	}

	
}
